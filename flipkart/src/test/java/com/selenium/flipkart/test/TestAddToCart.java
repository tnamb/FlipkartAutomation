package com.selenium.flipkart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestAddToCart extends TestSearch
    {
        public void Cart()
        {
            By button = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
            WebDriverWait wait = new WebDriverWait(TestFlipkart.driver, 5); // Explicit wait
            wait.until(ExpectedConditions
                    .presenceOfElementLocated(button)).click(); // go to cart                                                                                            
        }
    }
