package com.selenium.flipkart.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.selenium.flipkart.testBase.TestBase;

public class LogoutTest extends TestBase
    {
        @Test(priority = 4)
        public void LogoutFromFlipkart()
            {                    
                WebElement element = driver.findElement(By.cssSelector(objectFile.getString("hoverOverMyAccount")));
                Actions action = new Actions(driver);
                action.moveToElement(element).build().perform();

                driver.findElement(By.linkText(objectFile.getString("logoutLink"))).click();   
            }
    }
