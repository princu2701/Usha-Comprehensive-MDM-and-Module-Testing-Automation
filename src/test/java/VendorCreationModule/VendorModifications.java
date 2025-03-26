package VendorCreationModule;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VendorModifications {
	
	WebDriver driver;
	
	
	@BeforeMethod
	
	public void loginwork() throws InterruptedException {
		
		
	        driver = new EdgeDriver();
		
			driver.get("https://bizflowqa.usha.com/#/");
			
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
	        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
			
			driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
					
		    Thread.sleep(500);
			
			driver.findElement(By.cssSelector("[type='submit']")).click();
			
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Vendor Creation'])[3]")));
				
			driver.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();
	}
	
	@Test 
	
	public void scenario1() throws InterruptedException {
		
		//Find a Valid Vendor and Work on its data by Modifications
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//*[.='Add New'])[2]")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.cssSelector("[name='vendorName']")).sendKeys("RICHA MARKETINGS");
		
		List<WebElement> Clicks = driver.findElements(By.cssSelector("[type='submit']"));
		
		if (!Clicks.isEmpty()) {
			
			for(int i=0;i<=10;i++) {
				
				
				Clicks.get(0).click();
			}
			
		}
		
		

	}
	
	
	@Test
	
	public void scenario2() throws InterruptedException {
		
        Thread.sleep(2000);
		
		WebElement rich = driver.findElement(By.cssSelector("[name='vendorName']"));
		
		rich.sendKeys("RICHA MARKETINGS");
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("(//*[.='RICHA MARKETINGS'])[2]")).click();
		
		Actions actions = new Actions(driver);
		
		
		for (int i = 0; i <= 16; i++) {
			
			actions.keyDown(rich,Keys.BACK_SPACE).keyUp(rich, Keys.BACK_SPACE).build().perform();

			}
		

		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		rich.sendKeys("RIC");
		
		driver.findElement(By.cssSelector("[type='submit']")).click();

		
	}
	
	
	@Test
	
	public void scenario3() throws InterruptedException {
		
		//Regularly Entering the data and CLearing it Using the Clear Button
		
		WebElement rich = driver.findElement(By.cssSelector("[name='vendorName']"));	
		
		rich.sendKeys("RIHCA MARKETINGS");
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        
        Thread.sleep(2000);
        
        rich.sendKeys("VAMSHI AQUA ENGINEERS");
        
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        Thread.sleep(2000);

        rich.sendKeys("MODAL ENTERPRISE");
        
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        Thread.sleep(2000);

        rich.sendKeys("SAI CHARAN ENTERPRISES");
        
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        Thread.sleep(2000);

        rich.sendKeys("BALAJI ENGINEERING WORKS");
        
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        Thread.sleep(2000);

        rich.sendKeys("S S S ENTERPRISES");
        
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        
        
        rich.sendKeys("RELIANCE RETAIL LIMITED");
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        
        rich.sendKeys("RELIANCE RETAIL LIMITED");
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        
        rich.sendKeys("SHREE MAHADEV ELECTRICALS");
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
        
        rich.sendKeys("PETALS ENGINEERING AND");
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(500);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
		
        rich.sendKeys("MAINTENANCE SERVICES");
        driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(800);

        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();
	}
	
	@Test
	
	public void scenario4() {
		
		
	}
	
	
	
	@AfterMethod
	
	public void teardown() throws InterruptedException {
		
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
