package com.selenium.flipkart.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSearch extends TestLogin
    {
        TestFlipkart object = new TestFlipkart();
        static WebElement block;
        String productName = "";
        String productPrice = "";
        static List<String> firstList = new ArrayList<String>();
        
        public void SearchFlipkart() throws InterruptedException
        {
            TestFlipkart.config = new Properties();
            ResourceBundle resource = ResourceBundle.getBundle("config");
            ResourceBundle objectResource = ResourceBundle.getBundle("object");
            object.searchParameter = resource.getString("searchParameter");
            Thread.sleep(5000); 
            
            WebDriverWait wait = new WebDriverWait(TestFlipkart.driver, 5); // Explicit wait
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectResource.getString("searchBar"))))
                    .sendKeys(object.searchParameter);
            TestFlipkart.driver.findElement(By.cssSelector(objectResource.getString("searchButton"))).click();
            
            List<WebElement> numberOfElements = TestFlipkart.driver.findElements(By.className(objectResource.getString("searchListNumberOfElements"))); // Finding the number of search elements                                                                                  
            int number = RandomNumberGenerator(numberOfElements.size()); // Calling random method            
            By div = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[" + (number - 1) + "]/div"); //Relative XPath
            block = TestFlipkart.driver.findElement(div);                    // Selecting a random element
            List<WebElement> numberOfLi = block.findElements(By.cssSelector(objectResource.getString("numberOfListElements"))); 

            productName = block.findElement(By.className(objectResource.getString("productName"))).getText();
            System.out.println("ProductName: " + productName);

            productPrice = block.findElement(By.cssSelector(objectResource.getString("productPrice"))).getText();
            System.out.println("ProductPrice: " + productPrice);

            StoreDataInList(numberOfLi); // Storing randomly selected product description into a List

            block.click();
            List<String> newTab = new ArrayList<String>(TestFlipkart.driver.getWindowHandles());
            TestFlipkart.driver.switchTo().window(newTab.get(1));
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
        
        public void StoreDataInList(List<WebElement> numberOfLi)
            {
                for (WebElement link : numberOfLi)
                    {
                        System.out.println(link.getText());
                        firstList.add(link.getText());
                    }
                firstList.remove(firstList.size() - 1);
            }

    }
