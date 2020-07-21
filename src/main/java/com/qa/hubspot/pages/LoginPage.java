package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.BasePage.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	By EmailId=By.id("username");
	By Password=By.id("password");
	By LoginButton=By.id("loginBtn");
	By Signup=By.linkText("Sign up");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isSignUpLinkExist()
	{
		return driver.findElement(Signup).isDisplayed();
	}
	
	public void doLogin(String username,String password)
	{
		driver.findElement(EmailId).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(LoginButton).click();
	}
	
}
