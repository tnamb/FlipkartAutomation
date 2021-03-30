package com.selenium.flipkart.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.selenium.flipkart.testBase.TestBase;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FlipkartTest extends TestBase
    {
        
              public void ScriptTest() throws InterruptedException, IOException 
                  { 
                      //TestBase obj = new TestBase(); 
                      
                
                /*
                 * LoginTest logIn = new LoginTest(); SearchTest search = new SearchTest();
                 * LogoutTest logOut = new LogoutTest(); AddToCartTest atc = new
                 * AddToCartTest();
                 */ //StoreListDetails verify = new StoreListDetails();
                  
                 // logIn.LoginMethod(); 
                 // search.SearchFlipkart(); 
                  
                  //manual check 
                 // atc.Cart(); 
                  
                 // TestBase.VerifyContent(search.productName, search.productPrice); //manual check 
                   // cutting the string to 13 letters(product name can be very long otherwise which isn't shown completely inproduct page) 
                  //logOut.LogoutFromFlipkart();
                 System.out.println("Entered here for some reason");
                  }
        
        @Test(priority = 5) 
        public void testAssertions() 
        { 
            //for console check        
            System.out.println("TESTING1: " + productNameO + "****" + productName2); 
            System.out.println("TESTING2: " + productPriceO + "****" + productPrice2); 
            System.out.println("TESTING3: " + firstList + "****" + secondList);
            
            Assert.assertEquals(productNameO, productName2);
            Assert.assertEquals(productPriceO, productPrice2);
            Assert.assertEquals(SearchTest.firstList, secondList);         
        }

    }
