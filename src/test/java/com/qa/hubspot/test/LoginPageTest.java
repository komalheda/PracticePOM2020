package com.qa.hubspot.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	  WebDriver driver;
      BasePage basepage;
      LoginPage loginpage;
	
	    @BeforeTest
	     public void setup()
	     {
	    	 basepage=new BasePage();
	    	 driver=basepage.init_driver("chrome");
	    	 loginpage=new LoginPage(driver);
	     }
	    
	    @Test(priority=1)
	    public void verifyisSignUpLinkExistTest()
	    {
	    	loginpage.isSignUpLinkExist();
	    	Assert.assertEquals(loginpage.isSignUpLinkExist(), true);
	    }
        @Test(priority=2)
        public void verifygetLoginPageTitleTest()
        {
        	String title=loginpage.getLoginPageTitle();
        	System.out.println("Login page Title is"+title);
        	Assert.assertEquals(title, "HubSpot Login");
        }
	    
        @Test(priority=3)
        public void verifydologinTest()
        {
        	loginpage.doLogin("naveenanimation30@gmail.com","Test@12345678");
        }
	    @AfterTest
	    public void tear_down()
	    {
	    	driver.quit();
	    }
}
