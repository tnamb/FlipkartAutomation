package com.selenium.flipkart.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.selenium.flipkart.testBase.TestBase;

public class TestAddToCart extends TestBase
    {
        public void Cart()
        {
            By button = By.xpath(objectFile.getString("addToCartButton"));
            wait.until(ExpectedConditions.presenceOfElementLocated(button)).click();                                                                              
        }
    }
