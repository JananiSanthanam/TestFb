package test;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;

public class Login {
	private final static WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void beforeTest(){
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void searchTest() {
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys("qatrain14@gmail.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("qatrain14");
		driver.findElement(By.id("loginbutton")).submit();
		
		try{
			Thread.sleep(1000);
			System.out.println("Sleeping for some time");
			
		}catch(InterruptedException e){
			e.getStackTrace();
		}
		
		Assert.assertEquals("Tester Tester",driver.findElement(By.className("fbxWelcomeBoxName")).getText());
		
		driver.findElement(By.className("menuPulldown")).click();
	//	Alert alert = driver.switchTo().alert();
		driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		
		        
		  }
	
	@AfterClass
	public void afterClass(){
        //Close the browser
        driver.quit();
	}

}
