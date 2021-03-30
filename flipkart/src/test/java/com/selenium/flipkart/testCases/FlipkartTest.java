package com.selenium.flipkart.testCases;

import org.testng.annotations.Test;
import com.selenium.flipkart.testBase.TestBase;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FlipkartTest extends TestBase
    {
        @Test(priority = 5) 
        public void testAssertions() 
        {       
            System.out.println("TESTING1: " + productNameO + "****" + productName2); 
            System.out.println("TESTING2: " + productPriceO + "****" + productPrice2); 
            System.out.println("TESTING3: " + firstList + "****" + secondList);
            
            Assert.assertEquals(productNameO, productName2);
            Assert.assertEquals(productPriceO, productPrice2);
            Assert.assertEquals(SearchTest.firstList, secondList);         
        }
    }
