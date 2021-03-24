package com.selenium.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login
    {    
        public void LoginMethod()
            {
                WebElement popUp = Flipkart.driver.findElement(By.xpath("/html/body/div[2]/div/div")); // login popup
                if (popUp != null)
                    {
                        Flipkart.driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(Flipkart.username);
                        Flipkart.driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(Flipkart.password);
                        Flipkart.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
                    }
            }
    }
