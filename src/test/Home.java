package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Home {
	
	@Test
	public void HomeTest() throws IOException, InterruptedException {
		
		BaseFB bf = new BaseFB();
		bf.Login();
		
		JavascriptExecutor js = (JavascriptExecutor)BaseFB.driver;
		System.out.println("i am home");
		js.executeScript("window.scroll(0,2050)");
		
		for (int second = 0;; second++) {
	        if (second >= 50) {
	        	Assert.fail("timeout");
	        	break;
	        }
	        try { 
	            if (IsElementActive(By.xpath(".//*[@class='friendBrowserCheckboxContentGrid']/ul[3]"), BaseFB.driver)) {
	                System.out.println("found it");
	                Assert.assertTrue(true);
	            	break; }
	            } catch (Exception e) {}
	        Thread.sleep(1000);
	    }
	}
	
	@Test
	public void statusEmpty() {
		BaseFB.driver.findElement(By.cssSelector(".navLink.bigPadding")).click();
		BaseFB.driver.findElement(By.xpath(".//textarea[@*]")).sendKeys("");
		BaseFB.driver.findElement(By.cssSelector("._42ft._42fu._11b.selected._42g-")).submit();
		
	      String parentWindowHandle = BaseFB.driver.getWindowHandle(); // save the current window handle.
	      WebDriver popup = null;
	      Set<String> windowIterator = BaseFB.driver.getWindowHandles();
	      Iterator<String> iterator = windowIterator.iterator();
	      while(iterator.hasNext()) { 
	        String windowHandle = iterator.next(); 
	        popup = BaseFB.driver.switchTo().window(windowHandle);
	        if (popup.getTitle().equals("Status Is Empty")) {
	          break;
	        }
	      }
		popup.findElement(By.cssSelector("._42ft._4jy0._4jy3._4jy1.selected.layerCancel>span")).click();
	//	browser.close(); // close the popup.
		BaseFB.driver.switchTo().window(parentWindowHandle);
		
	}
	
	private static boolean IsElementActive(By xpath, WebDriver driver) {
	    WebElement we =  driver.findElement(xpath);        
	    return we.isEnabled();

	}

}
