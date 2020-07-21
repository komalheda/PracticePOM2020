package com.qa.hubspot.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
  
	WebDriver driver;
	Properties Prop;
	
	public WebDriver init_driver(String BrowserName)
	{
		System.out.println("Browser Name is"+BrowserName);
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("You are opening Chrome Driver");
		}
		else if(BrowserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("You are Opening FireFox Driver");
		}
		else
		{
			System.out.println("You Entered wrong Browser name");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		return driver;
	}
	
	public Properties init_prop()
	{
		Prop=new Properties();
		String Path="C:\\Users\\Komal Heda\\eclipse-workspace\\PracticePOM2020\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
		try {
			FileInputStream ip=new FileInputStream(Path);
			Prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Prop;
	}
	
}
