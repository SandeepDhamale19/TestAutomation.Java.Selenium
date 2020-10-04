package Functional;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Framework.UIFramework;
import UI.LoginPage;

public class BookStoreApp_POM extends UIFramework {
	
	static LoginPage loginPage;
	
	public BookStoreApp_POM() {
		loginPage = new LoginPage();
	}

	@Test
	public static void BookStoreApp_VerifyLogin_Annotations()
	{
		//Navigate to a URL
	
		driver.get("https://demoqa.com/books");
	    
	    // Login
	    driver.findElement(By.id("login")).click();
	    
	    driver.findElement(By.id("userName")).sendKeys("Captain America");
	    driver.findElement(By.id("password")).sendKeys("MyP@ss123");
	    driver.findElement(By.id("login")).click();
	
	    // Asertion
	    String userName = driver.findElement(By.id("userName-value")).getText();
	    Assert.assertEquals(userName, "Captain America");
    
	}
	
	@Test
	public static void BookStoreApp_VerifyLogin_POM()
	{
		//Navigate to a URL
	
		driver.get("https://demoqa.com/books");
	    
	    // Login
		loginPage.LoginButton.Click();
		
	    //driver.findElement(By.id("login")).click();
	    
	    driver.findElement(By.id("userName")).sendKeys("Captain America");
	    driver.findElement(By.id("password")).sendKeys("MyP@ss123");
	    driver.findElement(By.id("login")).click();
	
	    // Asertion
	    String userName = driver.findElement(By.id("userName-value")).getText();
	    Assert.assertEquals(userName, "Captain America");
    
	}
}
