package com.selenium.flipkart;

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

public class Flipkart
    {        
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
        
        public static void main(String[] args) throws MalformedURLException, InterruptedException
        {
            Flipkart obj = new Flipkart();
            Login logIn = new Login();
            Search search = new Search();
            Logout logOut = new Logout();
            AddToCart atc = new AddToCart();
            
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
            browser = resource.getString("browser");                                                            
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
            }
    }
