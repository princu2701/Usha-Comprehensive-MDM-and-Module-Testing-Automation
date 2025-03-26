package CRAccountTestings;

import java.awt.dnd.DragGestureEvent;
import java.time.Duration;

import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.id.Ketika;

public class DealerPage {
	
	WebDriverWait wait;
	WebDriver driver;
	
	@BeforeClass
	
	public void startup() {
		
		 driver = new ChromeDriver();
		
		driver.get("https://bizflowqa.usha.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}
	
	@Test(priority = 1)
	
	public void login() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("CCM");
		
		driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("System123#");
		
		Thread.sleep(8000);
		
	    driver.findElement(By.xpath("//*[.='Login to Continue']")).click();
	
	    System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test(dependsOnMethods = "login",dataProvider = "data")
	
	public void firstpage(String dealer1,String dealer2) {
		
		
		driver.findElement(By.xpath("(//*[.='Customer Credit'])"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Customer Credit'])"))).click();
		
		driver.findElement(By.xpath("(//*[.='Credit Creation'])[1]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Credit Creation'])[1]"))).click();
		
		
		WebElement gstElement=driver.findElement(By.name("gstin"));
		
		if(!gstElement.getText().isEmpty()) {
			
			gstElement.sendKeys(Keys.CONTROL +"a");
			
			gstElement.sendKeys(Keys.DELETE);
		}
		
		gstElement.sendKeys(dealer1);
		
		WebElement dealercodElement=driver.findElement(By.name("dealerCode"));
		
		if (!dealercodElement.getAttribute("value").isEmpty()) {
			
			dealercodElement.sendKeys(Keys.CONTROL+"a");
			
			dealercodElement.sendKeys(Keys.DELETE);
		}
		
		
		driver.findElement(By.name("dealerCode")).sendKeys(dealer2);
		
	    driver.findElement(By.name("[type=\"submit\"]")).click();	
	    
	    
		
		
	}
	
	
	
	
	
	@DataProvider(name = "data")
	public Object[][] data(){
		
		return new Object[][] {
			
			{"wkefd","wegtf"},{"wqertfg","!@#$#@@#ERT$EDCVGP__+"},{"#$WRTGFH#)$%RTER><>","       "}
			
		};
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
	}

}
