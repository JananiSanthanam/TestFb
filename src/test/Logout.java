package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebElement;

@Listeners({ test.ScreenShotOnFailure.class })
public class Logout {

	@Test(description="Logout")
	public void logoutTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		
		driver.findElement(By.className("menuPulldown")).click();
		driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Welcome to Facebook - Log In, Sign Up or Learn More");
	}
	
/*	@Test(description="Logout")
	public void logoutTest() throws Exception {
		WebDriver driver = DriverManager.getDriverInstance();

		Actions act = new Actions(driver);
		WebElement dmenu = driver.findElement(By.className("menuPulldown"));
		act.moveToElement(dmenu).perform();
		act.click();
		driver.findElement(By.cssSelector(".uiLinkButtonInput")).submit();

		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Welcome to Facebook - Log In, Sign Up or Learn More");
	}
	*/
	@AfterClass
	public void afterClass(){
        //Close the browser
		DriverManager.stopDriver();
	}
}
