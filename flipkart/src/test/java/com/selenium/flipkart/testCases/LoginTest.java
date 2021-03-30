package com.selenium.flipkart.testCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.flipkart.testBase.TestBase;

public class LoginTest extends TestBase
    {    
        @Test(priority = 1)
        public void LoginMethod() throws IOException
            {             
                WebElement popUp = driver.findElement(By.xpath(objectFile.getString("loginPopup")));
                if (popUp != null)
                    {
                        driver.findElement(By.xpath(objectFile.getString("usernameTextBox"))).sendKeys(username);
                        driver.findElement(By.xpath(objectFile.getString("passwordTextBox"))).sendKeys(password);
                        driver.findElement(By.xpath(objectFile.getString("loginPopupButton"))).click();
                    }
            }
    }
