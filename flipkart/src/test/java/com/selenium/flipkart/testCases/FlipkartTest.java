package com.selenium.flipkart.testCases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.selenium.flipkart.testBase.TestBase;
import com.selenium.flipkart.testPages.*;

import junit.framework.Assert;

public class FlipkartTest extends TestBase
    {

        @Test(priority = 1) 
              public void ScriptTest() throws InterruptedException, IOException 
                  { 
                      //TestBase obj = new TestBase(); 
                      
                      TestLogin logIn = new TestLogin(); 
                      TestSearch search = new TestSearch(); 
                      TestLogout logOut = new TestLogout(); 
                      TestAddToCart atc = new TestAddToCart();
                      StoreListDetails verify = new StoreListDetails();

                      
                      logIn.LoginMethod(); 
                      search.SearchFlipkart(); 
                      verify.VerifyDescription(); //manual check 
                      atc.Cart(); 
                      verify.VerifyContent(search.productName, search.productPrice); // manual check logOut.LogoutFromFlipkart();
              
                      search.productName = search.productName.substring(0,13); // cutting the string to 13 letters (product name can be very long otherwise which isn't shown completely in product page) 
                      logOut.LogoutFromFlipkart();
                  }
        
        @SuppressWarnings("deprecation")
        @Test(priority = 2) 
        public void testAssertions() 
        { 
            //for console check        
            System.out.println("TESTING1: " + productNameO + "****" + productName2); 
            System.out.println("TESTING2: " + productPriceO + "****" + productPrice2); 
            System.out.println("TESTING3: " + firstList + "****" + secondList);
            
            Assert.assertEquals(productNameO, productName2);
            Assert.assertEquals(productPriceO, productPrice2);
            Assert.assertEquals(TestSearch.firstList, secondList);         
        }

    }
