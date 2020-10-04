package Functional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DriverFactory.DriverInstance;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookStoreApp {
	
	@Test
	public static void BookStoreApp_VerifyLogin_Linear()
	{
		//setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
 
        //Create driver object for Chrome
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
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
        //quit the browser
        driver.quit();
	}
	
	@Test
	public static void BookStoreApp_VerifyLogin_ReusableDriver()
	{
		WebDriver driver = DriverInstance.Driver();
		//setup the chromedriver using WebDriverManager
        //WebDriverManager.chromedriver().setup();
 
        //Create driver object for Chrome
        // WebDriver driver = new ChromeDriver();
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        
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
        //quit the browser
        driver.quit();
	}

}
