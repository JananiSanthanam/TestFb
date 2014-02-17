package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	@BeforeTest
	public void BeforeTest() {
		BaseFB.driver.get("https://www.facebook.com");
		BaseFB.driver.manage().deleteAllCookies();
		BaseFB.driver.manage().window().maximize();
	}
	
	@Test
	public void EmptyLoginTest() {
	
		System.out.println("Page title is: " + BaseFB.driver.getTitle());
		Assert.assertEquals("Welcome to Facebook - Log In, Sign Up or Learn More", BaseFB.driver.getTitle());

		BaseFB.driver.findElement(By.cssSelector("#email")).sendKeys("");
		BaseFB.driver.findElement(By.cssSelector("#pass")).sendKeys("");
		BaseFB.driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",BaseFB.driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }
	
	@Test
	public void InvalidLoginTest() {

		System.out.println("Page title is: " + BaseFB.driver.getTitle());
		Assert.assertEquals("Facebook", BaseFB.driver.getTitle());

		BaseFB.driver.findElement(By.cssSelector("#email")).sendKeys("qa");
		BaseFB.driver.findElement(By.cssSelector("#pass")).sendKeys("qa");
		BaseFB.driver.findElement(By.id("loginbutton")).submit();
   
		Assert.assertEquals("Incorrect Email",BaseFB.driver.findElement(By.cssSelector(".fsl.fwb.fcb")).getText());
		  }

}
