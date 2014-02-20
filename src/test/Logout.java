package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

@Listeners({ test.ScreenShotOnFailure.class })
public class Logout {

	@Test
	public void logoutTest() throws IOException {
	@Test(description="Logout")
	public void logoutTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		
		BaseFB.driver.findElement(By.className("menuPulldown")).click();
		BaseFB.driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();
		testScreenShot();
		System.out.println("Page title is: " + BaseFB.driver.getTitle());
		Assert.assertEquals(BaseFB.driver.getTitle(),"Welcome to Facebook - Log In, Sign Up or Learn More");
		driver.findElement(By.className("menuPulldown")).click();
		driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Welcome to Facebook - Log In, Sign Up or Learn More");
	}
	
	public void testScreenShot() {
		
		File screenshot = ((TakesScreenshot)BaseFB.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(screenshot, new File("/users/administrator/richa/data/screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	
	@AfterClass
	public void afterClass(){
        //Close the browser
		BaseFB.driver.quit();
		DriverManager.stopDriver();
	}
}
