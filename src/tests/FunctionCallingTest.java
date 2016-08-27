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

import functions.HotelAppBusinessFunctions;


public class FunctionCallingTest extends HotelAppBusinessFunctions
{
	//public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	//public Properties prop;
	
	
	
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
