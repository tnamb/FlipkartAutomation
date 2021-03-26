package com.selenium.flipkart.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLogin extends TestFlipkart
    {    
        public void LoginMethod() throws IOException
            {             
                ResourceBundle objectResource = ResourceBundle.getBundle("object");

                WebElement popUp = TestFlipkart.driver.findElement(By.xpath(objectResource.getString("loginPopup"))); // login popup
                if (popUp != null)
                    {
                        TestFlipkart.driver.findElement(By.xpath(objectResource.getString("usernameTextBox"))).sendKeys(TestFlipkart.username);
                        TestFlipkart.driver.findElement(By.xpath(objectResource.getString("passwordTextBox"))).sendKeys(TestFlipkart.password);
                        TestFlipkart.driver.findElement(By.xpath(objectResource.getString("loginPopupButton"))).click();
                    }
            }
    }
