package com.selenium.flipkart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestLogin extends TestFlipkart
    {    
        public void LoginMethod()
            {
                WebElement popUp = TestFlipkart.driver.findElement(By.xpath("/html/body/div[2]/div/div")); // login popup
                if (popUp != null)
                    {
                        TestFlipkart.driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(TestFlipkart.username);
                        TestFlipkart.driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(TestFlipkart.password);
                        TestFlipkart.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
                    }
            }
    }
