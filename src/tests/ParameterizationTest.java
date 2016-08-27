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
import org.openqa.selenium.support.ui.Select;

import functions.HotelAppBusinessFunctions;


public class ParameterizationTest extends HotelAppBusinessFunctions
{
	//public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	//public Properties prop;
	public String strlocation;
	public String strFilePath="./DataPool/HA_HotelSearch.xls";
	//int rowcount=0;
	
	
	
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
		//wait(8);
		strlocation= HA_GF_readXL(2,"Location",strFilePath);
		//wait(8);
		System.out.println(strlocation);
		
		new Select(driver.findElement(By.id(prop.getProperty("Drp_Search_Location")))).selectByVisibleText(strlocation);
		driver.findElement(By.id(prop.getProperty("Btn_Search_Search"))).click();
		
	}
	
	
	@After
	public void closeDriver()
	{
		driver.close();
	}
}
