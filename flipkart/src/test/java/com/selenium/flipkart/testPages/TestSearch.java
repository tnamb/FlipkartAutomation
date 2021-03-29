package com.selenium.flipkart.testPages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.flipkart.testBase.TestBase;

public class TestSearch extends TestBase
    {
        TestBase object = new TestBase();
        static WebElement block;
        public String productName = "";
        public String productPrice = "";

        public void SearchFlipkart() throws InterruptedException
            {
                searchParameter = configFile.getString("searchParameter");

                WebDriverWait popUpWait = new WebDriverWait(driver, 5); // Explicit wait
                popUpWait.until(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath(objectFile.getString("loginPopup"))));

                wait = new WebDriverWait(driver, 1); // Explicit wait
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectFile.getString("searchBar"))))
                        .sendKeys(searchParameter);
                
                driver.findElement(By.cssSelector(objectFile.getString("searchButton"))).click();

                List<WebElement> numberOfElements = driver
                        .findElements(By.className(objectFile.getString("searchListNumberOfElements"))); // Finding the number of search elements
                                                                                                             
                int number = RandomNumberGenerator(numberOfElements.size()); // Calling random method
                By div = By.xpath(objectFile.getString("productLocator1") + (number - 1) + objectFile.getString("productLocator2")); 
                
                block = driver.findElement(div); // Selecting a random element
                List<WebElement> numberOfLi = block
                        .findElements(By.cssSelector(objectFile.getString("numberOfListElements")));

                productName = block.findElement(By.className(objectFile.getString("productName"))).getText();
                System.out.println("ProductName: " + productName);

                productPrice = block.findElement(By.cssSelector(objectFile.getString("productPrice"))).getText();
                System.out.println("ProductPrice: " + productPrice);

                StoreDataInList(numberOfLi); // Storing randomly selected product description into a List
                    block.click();
                
                List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(newTab.get(1));
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
