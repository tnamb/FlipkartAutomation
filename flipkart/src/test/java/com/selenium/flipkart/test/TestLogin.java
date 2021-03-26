package com.selenium.flipkart.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestLogin extends TestFlipkart
    {    
        public void LoginMethod() throws IOException
            {
                Properties obj = new Properties();
                FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\object.properties");
                obj.load(objfile);

                WebElement popUp = TestFlipkart.driver.findElement(By.xpath(obj.getProperty("loginPopup"))); // login popup
                if (popUp != null)
                    {
                        TestFlipkart.driver.findElement(By.xpath("usernameTextBox']")).sendKeys(TestFlipkart.username);
                        TestFlipkart.driver.findElement(By.xpath("passwordTextBox")).sendKeys(TestFlipkart.password);
                        TestFlipkart.driver.findElement(By.xpath("loginPopupCloseButton")).click();
                    }
            }
    }
