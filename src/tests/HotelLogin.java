package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HotelLogin {
	public WebDriver driver;
	public WebElement username;
	public WebElement password;
	public WebElement login;
	public String actualTitle;
	public String expectedTitle="AdactIn.com - Search Hotel1";

	public void enterUsername(WebDriver driver, String username){
		this.username=driver.findElement(By.id("username"));
		this.username.sendKeys(username);
	}
	
	public void enterPassword(WebDriver driver, String password){
		//this.password = driver.findElement(By.id("password"));
		
		this.password= driver.findElement(By.xpath(".//*[@id='password']"));
		this.password.sendKeys(password);
	}
	
	public void clickLogin(WebDriver driver){
		//login = driver.findElement(By.id("login"));
		login = driver.findElement(By.cssSelector("#login"));
		
		
		login.click();
	}
	
	@Before
	public void startUp() {
		
		driver = new FirefoxDriver();
		driver.get("http://www.adactin.com/HotelApp/");

	}

	@Test
	public void test() throws Exception {
		enterUsername(driver, "sanjaycolaco");
		enterPassword(driver, "8HM4T1");
		clickLogin(driver);

		actualTitle= driver.getTitle();
		
		//assertEquals(actualTitle,expectedTitle);
		
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title is correct, is"+actualTitle);
		else
			System.out.println("Title is incorrect, is"+actualTitle);
			
		
		
		
		
	}
	
	@After
	public void closeDriver(){
		driver.close();
	}
	

}
