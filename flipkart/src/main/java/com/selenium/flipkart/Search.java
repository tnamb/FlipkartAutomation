package com.selenium.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search
    {
        Flipkart object = new Flipkart();
        static WebElement block;
        String productName = "";
        String productPrice = "";
        List<String> firstList = new ArrayList<String>();
        
        public void SearchFlipkart() throws InterruptedException
        {
            Flipkart.config = new Properties();
            ResourceBundle resource = ResourceBundle.getBundle("config");
            object.searchParameter = resource.getString("searchParameter");
            Thread.sleep(2000); 
            
            WebDriverWait wait = new WebDriverWait(Flipkart.driver, 5); // Explicit wait
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='_3704LK']")))
                    .sendKeys(object.searchParameter);
            Flipkart.driver.findElement(By.cssSelector("button.L0Z3Pu")).click();
            
            List<WebElement> numberOfElements = Flipkart.driver.findElements(By.className("_13oc-S")); // Finding the number of search elements                                                                                  
            int number = RandomNumberGenerator(numberOfElements.size()); // Calling random method            
            By div = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[" + (number - 1) + "]/div");
            block = Flipkart.driver.findElement(div);                    // Selecting a random element
            List<WebElement> numberOfLi = block.findElements(By.cssSelector("li.rgWa7D")); 

            productName = block.findElement(By.className("_4rR01T")).getText();
            System.out.println("ProductName: " + productName);

            productPrice = block.findElement(By.cssSelector("div._30jeq3._1_WHN1")).getText();
            System.out.println("ProductPrice: " + productPrice);

            StoreDataInList(numberOfLi); // Storing randomly selected product description into a List

            block.click();
            List<String> newTab = new ArrayList<String>(Flipkart.driver.getWindowHandles());
            Flipkart.driver.switchTo().window(newTab.get(1));
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
