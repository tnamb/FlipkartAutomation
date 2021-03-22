package com.selenium.practice.Artifact1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.ini4j.Wini;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart
    {
        //static WebDriver driver = null;
        static String username = "";
        static String password = "";
        static String productName = "";
        static String productName2 = "";
        static String productPrice = "";
        static String productPrice2 = "";
        static WebElement block;
        static RemoteWebDriver driver;

        static List<String> firstList = new ArrayList<String>();
        static List<String> secondList = new ArrayList<String>();

        @Test
        public void setup() throws InterruptedException, MalformedURLException
            {
                String browName = "";
                String url = "";
                String searchParameter = "";

                // INI file to read data from
                try
                    {
                        Wini ini = new Wini(new File("F:\\Selenium\\Browser.ini"));
                        username = ini.get("credentials", "username");
                        password = ini.get("credentials", "password");

                        browName = ini.get("data", "browserName");
                        url = ini.get("data", "url");
                        searchParameter = ini.get("data", "searchParameter");
                    }

                catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                driver = ChooseBrowser(browName);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.get(url);

                Login();

                Thread.sleep(2000); //Not working without sleep
                WebDriverWait wait = new WebDriverWait(driver, 5); // Explicit wait
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='_3704LK']")))
                        .sendKeys(searchParameter);

                driver.findElement(By.cssSelector("button.L0Z3Pu")).click();

                List<WebElement> numberOfElements = driver.findElements(By.className("_13oc-S")); // Finding the number
                                                                                                  // of search elements
                                                                                                  // on the search
                                                                                                  // results page
                int number = RandomNumberGenerator(numberOfElements.size()); // Calling random method

                block = driver.findElement(
                        By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[" + (number - 1) + "]/div")); // Select
                                                                                                                    // random
                                                                                                                    // element
                                                                                                                    // from
                                                                                                                    // the
                                                                                                                    // search
                                                                                                                    // results

                List<WebElement> numberOfLi = block.findElements(By.cssSelector("li.rgWa7D")); // Description count

                productName = block.findElement(By.className("_4rR01T")).getText();
                System.out.println("ProductName: " + productName);

                productPrice = block.findElement(By.cssSelector("div._30jeq3._1_WHN1")).getText();
                System.out.println("ProductPrice" + productPrice);

                StoreDataInList(numberOfLi); // Storing product description onto a List

                block.click();
                List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(newTab.get(1));

                VerifyDescription();

                wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"))).click(); // go
                                                                                                                    // to
                                                                                                                    // cart
                /*
                 * TESTING
                 */
                
                VerifyContent(productName, productPrice);
                productName = productName.substring(0,13);
                assertEquals(productName, productName2); //Testing for the same product name
                assertEquals(productPrice, productPrice2); //Testing for the same product price
                assertEquals(firstList, secondList); //Testing for the same product description
                
                /*
                 * TESTING Ends
                 */

                Logout();
            }
        
        public static void Login()
            {
                WebElement popUp = driver.findElement(By.xpath("/html/body/div[2]/div/div")); // login popup
                if (popUp != null)
                    {
                        driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(username);
                        driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(password);
                        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button"))
                                .click();
                    }
            }
   
        public static int RandomNumberGenerator(int randomNumber)
            {
                // Create randomize method
                int number = 2;
                int minimum = 2;
                int range = randomNumber - minimum + 1;

                for (int i = 2; i < randomNumber; i++)
                    {
                        number = (int) (Math.random() * range) + minimum;
                    }

                return number;
            }
   
        public static RemoteWebDriver ChooseBrowser(String browserToExecute) throws MalformedURLException

            {
                if (browserToExecute.equalsIgnoreCase("chrome"))
                    {
                        /*
                         * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
                         */

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
                        /*WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();*/
                        
                        DesiredCapabilities cap = DesiredCapabilities.edge();
                        cap.setBrowserName("edge");
                        cap.setPlatform(Platform.ANY);
                        
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
                        
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
    
        public static void Logout()
            {
                // driver.findElement(By.cssSelector("a._3SkBxJ")).click();

                WebElement element = driver.findElement(By.cssSelector("div.exehdJ"));
                Actions action = new Actions(driver);
                action.moveToElement(element).build().perform();

                driver.findElement(By.linkText("Logout")).click();
                
                driver.quit();
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
                WebElement block2 = driver.findElement(By.cssSelector("div._2418kt"));
                List<WebElement> count = block2.findElements(By.cssSelector("li._21Ahn-")); // Description count

                System.out.println("x-----------------------------------------------------x");
                for (WebElement link : count)
                    {
                        System.out.println(link.getText());
                        secondList.add(link.getText());
                    }
            }

        public static void VerifyContent(String productName, String productPrice) throws InterruptedException
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
                
                
                productName2 = productName2.substring(0,13);
                

                System.out.println("*----------------------------------*");
                System.out.println(productName2 + "; " + productPrice2);
                System.out.println(productName + "; " + productPrice);
            }  
        

        public void TestData()
            {
               
                try
                    {
                        /*
                         * Wini ini = new Wini(new File("F:\\Selenium\\Test.ini")); productName =
                         * ini.get("test", "productName"); productPrice = ini.get("test",
                         * "productPrice");
                         * 
                         * productName2 = ini.get("test2", "productName2"); productPrice2 =
                         * ini.get("test2", "productPrice2");
                         */

                        assertEquals(productName, productName2);
                        assertEquals(productPrice, productPrice2);
                        assertEquals(firstList, secondList);
                        
                        
                    }
                
                catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                

            }
    
    }
