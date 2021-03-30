package com.selenium.flipkart.testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestBase
    {        
        protected static String productNameO = "";
        protected static String productPriceO = "";
        protected static String productName2 = "";
        protected static String productPrice2 = "";
        
        protected static String username = "";
        protected static String password = "";
        protected String url = "";
        String browser = "";
        public static String searchParameter = "";
        
        public static RemoteWebDriver driver;
        protected static WebDriverWait wait, popUpWait;
        protected static List<String> secondList = new ArrayList<String>();
        protected static List<String> firstList = new ArrayList<String>();
        
        protected static ResourceBundle configFile;
        public static ResourceBundle objectFile;

        @BeforeSuite
        public void setup() throws MalformedURLException
        {
            configFile = ResourceBundle.getBundle("config");
            objectFile = ResourceBundle.getBundle("object");
      
            if (configFile.getString("browser").equals("chrome"))
                {
                    DesiredCapabilities cap = DesiredCapabilities.chrome();
                    cap.setBrowserName("chrome");
                    cap.setPlatform(Platform.ANY);

                    driver = new RemoteWebDriver(new URL(configFile.getString("gridUrl")), cap);
                }

            else if (configFile.getString("browser").equals("firefox"))
                {
                    DesiredCapabilities cap = DesiredCapabilities.firefox();
                    cap.setBrowserName("firefox");
                    cap.setPlatform(Platform.ANY);

                    driver = new RemoteWebDriver(new URL(configFile.getString("gridUrl")), cap);
                }

            else if (configFile.getString("browser").equals("edge"))
                {
                    EdgeOptions options = new EdgeOptions();
                    options.setCapability("browserName", "edge");
                    options.setCapability("ignoreZoomSetting", true);
                    driver = new RemoteWebDriver(new URL(configFile.getString("gridUrl")), options);

                }

            else if (configFile.getString("browser").equals("opera"))
                {
                    @SuppressWarnings("deprecation")
                    DesiredCapabilities cap = DesiredCapabilities.opera();
                    cap.setBrowserName("opera");
                    cap.setPlatform(Platform.ANY);

                    driver = new RemoteWebDriver(new URL(configFile.getString("gridUrl")), cap);
                }

            username = configFile.getString("username");
            password = configFile.getString("password");
            url = configFile.getString("url");
            searchParameter = configFile.getString("searchParameter");
            
            driver.get(url); 
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(configFile.getString("implicitWait")), TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, Integer.parseInt(configFile.getString("explicitWait"))); 
            popUpWait = new WebDriverWait(driver, Integer.parseInt(configFile.getString("explicitWait")));
        }
        
        
        public static int RandomNumberGenerator(int randomNumber)

            {
                int number = 2;
                int minimum = 2;
                int range = randomNumber - minimum + 1;

                for (int i = 2; i < randomNumber; i++)
                    {
                        number = (int) (Math.random() * range) + minimum;
                    }

                return number;
            }

        public static void StoreDataInList(List<WebElement> numberOfLi)
            {
                for (WebElement link : numberOfLi)
                    {
                        System.out.println(link.getText());
                        firstList.add(link.getText());
                    }
                firstList.remove(firstList.size() - 1); 
            }
  
        public static void VerifyDescription()
            {
                WebElement block2 = driver.findElement(By.cssSelector(objectFile.getString("listBlock")));
                List<WebElement> count = block2.findElements(By.cssSelector(objectFile.getString("listBlockElements")));

                System.out.println("x--------------------------------------------x");
                for (WebElement link : count)
                    {
                        System.out.println(link.getText());
                        secondList.add(link.getText());
                    }
            }
        
        public static void VerifyContent(String productName, String productPrice) throws InterruptedException
            {
                productName = productName.substring(0,13);
                Thread.sleep(2000);
                productName2 = driver
                        .findElement(By.xpath(objectFile.getString("listProductName1") + productName + objectFile.getString("listProductName2")))
                            .getText();
                
                productPrice = productPrice.substring(1, productPrice.length());
                
                productPrice2 = driver
                        .findElement(By.xpath(objectFile.getString("listProductPrice1") + productPrice + objectFile.getString("listProductPrice2")))
                            .getText();

                productName2 = productName2.substring(0, 13);
                productPrice2 = productPrice2.substring(1, productPrice2.length()); 

                System.out.println("**----------------------------------**");
                System.out.println(productName2 + "; " + productPrice2);
                System.out.println(productName + "; " + productPrice);
                productNameO = productName;
                productPriceO = productPrice;
            }

        @AfterTest()
        public void quitDriver()
        {
            if (driver != null)
                driver.quit();
        }
    } 