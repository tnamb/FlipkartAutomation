package com.selenium.flipkart.testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
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
        
        //static WebElement block;
        public static RemoteWebDriver driver;
        protected static WebDriverWait wait;
        protected static List<String> secondList = new ArrayList<String>();
        protected static List<String> firstList = new ArrayList<String>();
        
        protected static ResourceBundle configFile;
        public static ResourceBundle objectFile;

        @BeforeSuite
        public void setup() throws MalformedURLException
        {
            configFile = ResourceBundle.getBundle("config");
            objectFile = ResourceBundle.getBundle("object");
            
            /*
             * Browser related configuration
             */
            
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
                    DesiredCapabilities cap = DesiredCapabilities.opera();
                    cap.setBrowserName("opera");
                    cap.setPlatform(Platform.ANY);

                    driver = new RemoteWebDriver(new URL(configFile.getString("gridUrl")), cap);
                }
            
            
            /*
             * credentials related configuration
             */
            
            username = configFile.getString("username");
            password = configFile.getString("password");
            url = configFile.getString("url");
            searchParameter = configFile.getString("searchParameter");
            //browser = configFile.getString("browser");   
        
            /*
             * driver related configuration
             */
            
            driver.get(url); 
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(configFile.getString("implicitWait")),TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 5); 
        }
        
        @AfterTest()
        public void quitDriver()
        {
            if (driver != null)
                driver.quit();
        }
    } 