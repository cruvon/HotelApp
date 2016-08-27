package tests;


import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SharedUIMap
{
	public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public Properties prop;
	
	public void enterUsername(WebDriver driver, String username)
	{
		this.username= driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username")));
		this.username.sendKeys(username);
				
	}
	
	
	public void enterPassword(WebDriver driver, String password)
	{
		this.password= driver.findElement(By.xpath(prop.getProperty("Txt_Login_Pasword")));
		this.password.sendKeys(password);
		
	}
	
	public void clickLogin(WebDriver driver)
	{
		login= driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login")));
		login.click();
		
	}
	
	
	@Before
	public void startup() throws Exception
	{
		prop=new Properties();
		prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
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
