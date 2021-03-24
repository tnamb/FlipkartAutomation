package com.selenium.flipkart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestLogout extends TestAddToCart
    {
        public void LogoutFromFlipkart()
            {                               
                WebElement element = TestFlipkart.driver.findElement(By.cssSelector("div.exehdJ"));
                Actions action = new Actions(TestFlipkart.driver);
                action.moveToElement(element).build().perform();

                TestFlipkart.driver.findElement(By.linkText("Logout")).click();
                TestFlipkart.driver.quit();
            }
    }
