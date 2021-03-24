package com.selenium.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Logout
    {
        public void LogoutFromFlipkart()
            {                               
                WebElement element = Flipkart.driver.findElement(By.cssSelector("div.exehdJ"));
                Actions action = new Actions(Flipkart.driver);
                action.moveToElement(element).build().perform();

                Flipkart.driver.findElement(By.linkText("Logout")).click();
                Flipkart.driver.quit();
            }
    }
