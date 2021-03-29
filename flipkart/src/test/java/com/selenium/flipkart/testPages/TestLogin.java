package com.selenium.flipkart.testPages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.flipkart.testBase.TestBase;

public class TestLogin extends TestBase
    {    
        public void LoginMethod() throws IOException
            {             
                WebElement popUp = driver.findElement(By.xpath(objectFile.getString("loginPopup"))); // login popup
                if (popUp != null)
                    {
                        driver.findElement(By.xpath(objectFile.getString("usernameTextBox"))).sendKeys(username);
                        driver.findElement(By.xpath(objectFile.getString("passwordTextBox"))).sendKeys(password);
                        driver.findElement(By.xpath(objectFile.getString("loginPopupButton"))).click();
                    }
            }
    }
