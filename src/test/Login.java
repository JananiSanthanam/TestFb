package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void EmptyLoginTest() {

		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("#pass")).sendKeys("");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }
	
	@Test
	public void InvalidLoginTest() {

		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys("qa");
		driver.findElement(By.cssSelector("#pass")).sendKeys("qa");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }
	
	@Test
	public void searchTest() {
		PropertyConfig pc = new PropertyConfig();
		pc.readFile();
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys(pc.getUsername());
		driver.findElement(By.cssSelector("#pass")).sendKeys(pc.getPassword());
		driver.findElement(By.id("loginbutton")).submit();
		
		try{
			Thread.sleep(1000);
			System.out.println("Sleeping for some time");
			
		}catch(InterruptedException e){
			e.getStackTrace();
		}
		
		Assert.assertEquals("Tester Tester",driver.findElement(By.className("fbxWelcomeBoxName")).getText());
		
		//driver.findElement(By.className("menuPulldown")).click();
		//driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();
		//System.out.println("Page title is: " + driver.getTitle());
		  }
	
	@AfterClass
	public void afterClass(){
        //Close the browser
        driver.quit();
	}

}
