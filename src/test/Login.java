package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({ test.ScreenShotOnFailure.class })
public class Login {
	
	@BeforeClass
	@Parameters ("browser_type")
	public void BeforeClass(String browser_type) {
		DriverManager.startDriver(browser_type);

	@BeforeTest
	public void BeforeTest() {
		BaseFB.driver.get("https://www.facebook.com");
		BaseFB.driver.manage().deleteAllCookies();
		BaseFB.driver.manage().window().maximize();
	}
	
	@Test
	@Test(description="Login with no value")
	public void EmptyLoginTest() {
	
		System.out.println("Page title is: " + BaseFB.driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", BaseFB.driver.getTitle());
		WebDriver driver = DriverManager.getDriverInstance();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		BaseFB.driver.findElement(By.cssSelector("#email")).sendKeys("");
		BaseFB.driver.findElement(By.cssSelector("#pass")).sendKeys("");
		BaseFB.driver.findElement(By.id("loginbutton")).submit();
		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("#pass")).sendKeys("");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",BaseFB.driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }
	
	@Test
	@Test(description="Login with invalid value")
	public void InvalidLoginTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Facebook", driver.getTitle());

		System.out.println("Page title is: " + BaseFB.driver.getTitle());
		Assert.assertEquals("Facebook", BaseFB.driver.getTitle());

		BaseFB.driver.findElement(By.cssSelector("#email")).sendKeys("qa");
		BaseFB.driver.findElement(By.cssSelector("#pass")).sendKeys("qa");
		BaseFB.driver.findElement(By.id("loginbutton")).submit();
		driver.findElement(By.cssSelector("#email")).sendKeys("qa");
		driver.findElement(By.cssSelector("#pass")).sendKeys("qa");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",BaseFB.driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }

}
