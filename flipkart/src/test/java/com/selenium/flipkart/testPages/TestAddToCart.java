package com.selenium.flipkart.testPages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.selenium.flipkart.testBase.TestBase;

public class TestAddToCart extends TestBase
    {
        public void Cart()
        {
            objectFile = ResourceBundle.getBundle("object");
            By button = By.xpath(objectFile.getString("addToCartButton"));
            
            wait.until(ExpectedConditions.presenceOfElementLocated(button)).click();                                                                              
        }
    }
