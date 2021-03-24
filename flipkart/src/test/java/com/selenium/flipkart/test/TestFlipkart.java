package com.selenium.flipkart.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class TestFlipkart
    {        
        static String productNameO = "";
        static String productPriceO = "";
        static String productName2 = "";
        static String productPrice2 = "";
        
        static String username = "";
        static String password = "";
        String url = "";
        String browser = "";
        public String searchParameter = "";
        
        static WebElement block;
        static RemoteWebDriver driver;
        static List<String> secondList = new ArrayList<String>();
        static Properties config;
        
        @Test(priority=1)
        public void ScriptTest() throws MalformedURLException, InterruptedException
        {
            TestFlipkart obj = new TestFlipkart();
            TestLogin logIn = new TestLogin();
            TestSearch search = new TestSearch();
            TestLogout logOut = new TestLogout();
            TestAddToCart atc = new TestAddToCart();
            
            obj.InitializeCredentials(); //Getting the data from the config file
            ChooseBrowser(obj.browser);  //Choosing the browser
            
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(obj.url);
            
            logIn.LoginMethod();           
            search.SearchFlipkart();            
            obj.VerifyDescription();    //manual check       
            atc.Cart();           
            obj.VerifyContent(search.productName, search.productPrice); // manual check
            logOut.LogoutFromFlipkart();
            
            search.productName = search.productName.substring(0,13); // cutting the string to 13 letters (product name can be very long otherwise which isn't shown completely in product page)
           

            
        }
        
        public static RemoteWebDriver ChooseBrowser(String browserToExecute) throws MalformedURLException

            {
                if (browserToExecute.equalsIgnoreCase("chrome"))
                    {
                        DesiredCapabilities cap = DesiredCapabilities.chrome();
                        cap.setBrowserName("chrome");
                        cap.setPlatform(Platform.ANY);

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                    }

                else if (browserToExecute.equalsIgnoreCase("firefox"))
                    {

                        File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
                        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

                        DesiredCapabilities cap = DesiredCapabilities.firefox();
                        cap.setBrowserName("firefox");
                        cap.setPlatform(Platform.ANY);

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                    }

                else if (browserToExecute.equalsIgnoreCase("edge"))
                    {
                        /*
                         * WebDriverManager.edgedriver().setup(); driver = new EdgeDriver();
                         */
                        EdgeOptions options = new EdgeOptions();
                        options.setCapability("browserName", "edge");
                        options.setCapability("ignoreZoomSetting", true);
                        options.setCapability("browserVersion", "89.0.774.57");

                        /*
                         * DesiredCapabilities cap = DesiredCapabilities.edge();
                         * cap.setBrowserName("edge"); cap.setPlatform(Platform.WIN10);
                         */
                        // cap.setVersion("89.0.774.57");

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

                    }

                else if (browserToExecute.equalsIgnoreCase("opera"))
                    {
                        DesiredCapabilities cap = DesiredCapabilities.opera();
                        cap.setBrowserName("opera");
                        cap.setPlatform(Platform.ANY);

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                    }

                return driver;
            }
        
        public void InitializeCredentials()
        {                        
            config = new Properties();
            ResourceBundle resource = ResourceBundle.getBundle("config");
            
            username = resource.getString("username");
            password = resource.getString("password");
            url = resource.getString("url");
            searchParameter = resource.getString("searchParameter");
            browser = "chrome";                                                        
        }
        
        public void VerifyDescription()
            {
                WebElement block2 = driver.findElement(By.cssSelector("div._2418kt"));
                List<WebElement> count = block2.findElements(By.cssSelector("li._21Ahn-")); // Description count

                System.out.println("x-----------------------------------------------------x");
                for (WebElement link : count)
                    {
                        System.out.println(link.getText());
                        secondList.add(link.getText());
                    }
            }
        
        public void VerifyContent(String productName, String productPrice) throws InterruptedException
            {

                Thread.sleep(2000);
                productName2 = driver
                        .findElement(By.xpath(
                                "//*[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/a"))
                        .getText();
                productPrice2 = driver
                        .findElement(By.xpath(
                                "//*[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]"))
                        .getText();

                productName2 = productName2.substring(0, 13);

                System.out.println("*----------------------------------*");
                System.out.println(productName2 + "; " + productPrice2);
                System.out.println(productName + "; " + productPrice);
                
                productNameO = productName;
                productPriceO = productPrice;
            }
    
        
          @SuppressWarnings("deprecation")
          @Test(priority=2) 
          public void testAssertions() 
          { 
                           
              SoftAssert sa = new SoftAssert();
              productNameO = productNameO.substring(0,13);
          
              System.out.println("TESTING1: " + productNameO + "****" + productName2); 
              System.out.println("TESTING2: " + productPriceO + "****" + productPrice2); 
              System.out.println("TESTING3: " + TestSearch.firstList + "****" + secondList);
          
              sa.assertEquals(productNameO, productName2);
              sa.assertEquals(productPriceO, productPrice2);
              sa.assertEquals(TestSearch.firstList, secondList); // description
              

              Assert.assertEquals(productNameO, productName2);
              Assert.assertEquals(productPriceO, productPrice2);
              Assert.assertEquals(TestSearch.firstList, secondList);
              
          }
         
    } 
