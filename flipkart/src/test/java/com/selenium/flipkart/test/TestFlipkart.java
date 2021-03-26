package com.selenium.flipkart.test;

import java.io.IOException;
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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
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
        public void ScriptTest() throws InterruptedException, IOException
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
                        DesiredCapabilities cap = DesiredCapabilities.firefox();
                        cap.setBrowserName("firefox");
                        cap.setPlatform(Platform.ANY);

                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                    }

                else if (browserToExecute.equalsIgnoreCase("edge"))
                    {
                        EdgeOptions options = new EdgeOptions();
                        options.setCapability("browserName", "edge");
                        options.setCapability("ignoreZoomSetting", true);
                        options.setCapability("browserVersion", "89.0.774.57");

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
            browser = resource.getString("browser");                                                        
        }
        
        
        public void VerifyDescription()
            {
                ResourceBundle objectResource = ResourceBundle.getBundle("object");
                WebElement block2 = driver.findElement(By.cssSelector(objectResource.getString("listBlock")));
                List<WebElement> count = block2.findElements(By.cssSelector(objectResource.getString("listBlockElements"))); // Description count

                System.out.println("x-----------------------------------------------------x");
                for (WebElement link : count)
                    {
                        System.out.println(link.getText());
                        secondList.add(link.getText());
                    }
            }
        

        public void VerifyContent(String productName, String productPrice) throws InterruptedException
            {
                productName = productName.substring(0,13);
                Thread.sleep(2000);
                productName2 = driver
                        .findElement(By.xpath("//a[contains(text(),'"+ productName +"')]"))
                            .getText();
                
                productPrice = productPrice.substring(1, productPrice.length()); //Removing the rupee symbol from price as it causes NoSuchElementException
                productPrice2 = driver
                        .findElement(By.xpath("//span[@Class='_2-ut7f _1WpvJ7'][contains(text(), '₹') or contains(text(), '"+ productPrice +"')]"))
                            .getText();

                productName2 = productName2.substring(0, 13);
                productPrice2 = productPrice2.substring(1, productPrice2.length());

                System.out.println("*----------------------------------*");
                System.out.println(productName2 + "; " + productPrice2);
                System.out.println(productName + "; " + productPrice);
                
                productNameO = productName;
                productPriceO = productPrice;
            }
    
        
          @Test(priority=2) 
          public void testAssertions() 
          { 
              //productNameO = productNameO.substring(0,13);
          
              System.out.println("TESTING1: " + productNameO + "****" + productName2); 
              System.out.println("TESTING2: " + productPriceO + "****" + productPrice2); 
              System.out.println("TESTING3: " + TestSearch.firstList + "****" + secondList);
              
              Assert.assertEquals(productNameO, productName2);
              Assert.assertEquals(productPriceO, productPrice2);
              Assert.assertEquals(TestSearch.firstList, secondList);         
          }
         
    } 
