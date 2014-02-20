package test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Listeners({ test.ScreenShotOnFailure.class })
public class Home {
	
	@Test
	@Test(description="load elements and check for the element")
	public void HomeTest() throws IOException, InterruptedException {
		WebDriver driver = DriverManager.getDriverInstance();
		
		BaseFB bf = new BaseFB();
		bf.Login();
		
		JavascriptExecutor js = (JavascriptExecutor)BaseFB.driver;

		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("i am home");
		js.executeScript("window.scroll(0,2050)");
		

		for (int second = 0;; second++) {
	        if (second >= 50) {
	        	Assert.fail("timeout");
	        	break;
	        }
	        try { 
	            if (IsElementActive(By.xpath(".//*[@class='friendBrowserCheckboxContentGrid']/ul[3]"), BaseFB.driver)) {
	            if (IsElementActive(By.xpath(".//*[@class='friendBrowserCheckboxContentGrid']/ul[3]"), driver)) {
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
	@Test(description="handle pop-up for empty status")
	public void statusEmpty() throws InterruptedException {
		WebDriver driver = DriverManager.getDriverInstance();
		
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
		driver.findElement(By.cssSelector(".navLink.bigPadding")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('DOMControl_placeholder uiTextareaAutogrow')[0].click();");
		driver.findElement(By.xpath(".//button[@value='1']")).submit();
		driver.findElement(By.xpath(".//div[@role='dialog']/descendant::span[text()='Okay']")).click();
		
	}
	
	@Test(description="update happy status")
	public void statusHappy() throws InterruptedException {
		WebDriver driver = DriverManager.getDriverInstance();
		
			driver.findElement(By.cssSelector(".navLink.bigPadding")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".DOMControl_placeholder.uiTextareaAutogrow.input.autofocus.mentionsTextarea.textInput"))
			.sendKeys("I am happy"+driver.getCurrentUrl());
			driver.findElement(By.cssSelector("._42ft._42fu._11b.selected._42g-")).submit();	
	}
	
	@Test(description="Find the tool tip")
	public void toolTip() {
		WebDriver driver = DriverManager.getDriverInstance();
		
			WebElement onElement = driver.findElement(By.linkText("English (US)"));
			Assert.assertEquals("Use Facebook in another language.", onElement.getAttribute("title"));
	}
	
	@Test(description="Drop Down element")
	public void dropDown() throws InterruptedException {
		WebDriver driver = DriverManager.getDriverInstance();
		
		driver.findElement(By.cssSelector(".navLink.bigPadding")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("rhcFooterSelectorButton")).click();
		driver.findElement(By.xpath(".//*[@class='_54ng']/ul/li[3]/a/span/span")).click();
    	Thread.sleep(1000);
    	Assert.assertEquals(driver.getTitle(),"Facebook Careers");
	}
	
	private static boolean IsElementActive(By xpath, WebDriver driver) {
	    WebElement we =  driver.findElement(xpath);        
	    return we.isEnabled();

	}
	

}
