package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

	}
	
	@Test(description="Login with no value")
	public void EmptyLoginTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys("");
		driver.findElement(By.cssSelector("#pass")).sendKeys("");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }
	
	@Test(description="Login with invalid value")
	public void InvalidLoginTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Facebook", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys("qa");
		driver.findElement(By.cssSelector("#pass")).sendKeys("qa");
		driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }

}
