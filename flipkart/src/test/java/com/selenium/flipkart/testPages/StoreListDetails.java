package com.selenium.flipkart.testPages;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.flipkart.testBase.TestBase;

/*
 * Supporting class
 */

public class StoreListDetails extends TestBase
    {
        public void VerifyDescription()
            {
                WebElement block2 = driver.findElement(By.cssSelector(objectFile.getString("listBlock")));
                List<WebElement> count = block2.findElements(By.cssSelector(objectFile.getString("listBlockElements"))); // Description count

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
    }
