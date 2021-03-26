package com.selenium.flipkart.test;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestLogout extends TestAddToCart
    {
        public void LogoutFromFlipkart()
            {     
                ResourceBundle objectResource = ResourceBundle.getBundle("object");
                
                WebElement element = TestFlipkart.driver.findElement(By.cssSelector(objectResource.getString("hoverOverMyAccount")));
                Actions action = new Actions(TestFlipkart.driver);
                action.moveToElement(element).build().perform();

                TestFlipkart.driver.findElement(By.linkText(objectResource.getString("logoutLink"))).click();
                TestFlipkart.driver.quit();
            }
    }
