package test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Photos {

	@Test
	public void PhotoTest() {
		WebDriver driver = DriverManager.getDriverInstance();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('#navItem_app_2305272732 .linkWrap').click();");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//for first photo display
		js.executeScript("document.querySelector('#pic_1378352529102540').click();");
		//BaseFB.driver.findElement(By.cssSelector("pic_1378352529102540")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //for second photo display
	    js.executeScript("document.querySelector('#pic_1378352525769207').click();");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //for third photo display
	    js.executeScript("document.querySelector('#pic_1378352522435874').click();");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //for album display
	    js.executeScript("document.querySelector('._51sx').click();");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }

}
