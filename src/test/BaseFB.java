package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class BaseFB {
	public final static WebDriver driver = new FirefoxDriver();
	
	public void Login() {
		PropertyConfig pc = new PropertyConfig();
		WebDriver driver = DriverManager.getDriverInstance();
		PropertyConfig pc = new PropertyConfig(driver);
		
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals("Facebook", driver.getTitle());

		driver.findElement(By.cssSelector("#email")).sendKeys(pc.getUsername());
		driver.findElement(By.cssSelector("#pass")).sendKeys(pc.getPassword());
		driver.findElement(By.id("loginbutton")).submit();
		
		try{
			Thread.sleep(1000);
			System.out.println("Sleeping for some time");
			
		}catch(InterruptedException e){
			e.getStackTrace();
		}
		
		System.out.println(driver.findElement(By.className("fbxWelcomeBoxName")).getText());
		Assert.assertEquals("Tester Tester",driver.findElement(By.className("fbxWelcomeBoxName")).getText());

		  }

}
