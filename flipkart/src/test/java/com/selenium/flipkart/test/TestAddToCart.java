package com.selenium.flipkart.test;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestAddToCart extends TestSearch
    {
        public void Cart()
        {
            ResourceBundle ObjectResource = ResourceBundle.getBundle("object");
            
            By button = By.xpath(ObjectResource.getString("addToCartButton"));
            WebDriverWait wait = new WebDriverWait(TestFlipkart.driver, 5); // Explicit wait
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(button)).click(); // go to cart                                                                                            
        }
    }
