package tests;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HotelLogin1
{
	public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	
	public void enterUsername(WebDriver driver, String username)
	{
		this.username= driver.findElement(By.id("username"));
		this.username.sendKeys(username);
				
	}
	
	
	public void enterPassword(WebDriver driver, String password)
	{
		this.password= driver.findElement(By.id("password"));
		this.password.sendKeys(password);
		
	}
	
	public void clickLogin(WebDriver driver)
	{
		login= driver.findElement(By.id("login"));
		login.click();
		
	}
	
	
	@Before
	public void startup()
	{
		driver= new FirefoxDriver();
		driver.get("http://www.adactin.com/HotelApp/");
		
	}
	
	@Test
	public void test() throws Exception
	{
		enterUsername(driver,"sanjaycolaco");
		enterPassword(driver,"8HM4T1");
		clickLogin(driver);
	}
	
	
	@After
	public void closeDriver()
	{
		driver.close();
	}
}
