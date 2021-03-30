package com.selenium.flipkart.testPages;

import java.util.List;

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
                //store for verification and console check
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
                //store for verification and console check
                productName = productName.substring(0,13);
                Thread.sleep(2000);
                productName2 = driver
                        .findElement(By.xpath(objectFile.getString("listProductName1") + productName + objectFile.getString("listProductName2")))
                            .getText();
                
                productPrice = productPrice.substring(1, productPrice.length()); //Removing the Rupee symbol from price as it causes NoSuchElementException
                
                productPrice2 = driver
                        .findElement(By.xpath(objectFile.getString("listProductPrice1") + productPrice + objectFile.getString("listProductPrice2")))
                            .getText();

                productName2 = productName2.substring(0, 13);
                productPrice2 = productPrice2.substring(1, productPrice2.length()); //Removing the Rupee symbol from the price to be compared to

                System.out.println("*----------------------------------*");
                System.out.println(productName2 + "; " + productPrice2);
                System.out.println(productName + "; " + productPrice);
                productNameO = productName;
                productPriceO = productPrice;
            }
    }