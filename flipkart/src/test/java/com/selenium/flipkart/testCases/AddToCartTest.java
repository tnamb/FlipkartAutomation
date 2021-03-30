package com.selenium.flipkart.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.selenium.flipkart.testBase.TestBase;

public class AddToCartTest extends TestBase
    {
        
        
        @Test(priority = 3)
        public void Cart() throws InterruptedException
        {
            By button = By.xpath(objectFile.getString("addToCartButton"));
            wait.until(ExpectedConditions.presenceOfElementLocated(button)).click();   
            
            TestBase.VerifyContent(SearchTest.productName, SearchTest.productPrice);
            SearchTest.productName = SearchTest.productName.substring(0,13);
        }
    }
