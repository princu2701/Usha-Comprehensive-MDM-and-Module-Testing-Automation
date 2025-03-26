package VendorCreationModule;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CompatibitlyValidations {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://bizflowqa.usha.com/#/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
		
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
				
	    Thread.sleep(500);
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath("(//*[.='Vendor Creation'])[4]")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[text()='Vendor'])")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[text()='Vendor'])")).click();

		Thread.sleep(500);

		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		Thread.sleep(500);

		driver.manage().window().maximize();
		
		Thread.sleep(500);

		driver.manage().window().minimize();

		Thread.sleep(500);

		driver.manage().window().maximize();
		
		Thread.sleep(500);

        String dashUrl=driver.getCurrentUrl();
        
		Thread.sleep(500);

		Assert.assertEquals(dashUrl, "https://bizflowqa.usha.com/#/dashboard");
		
		Thread.sleep(500);

	    driver.manage().window().minimize();
		  
		Thread.sleep(500);

		driver.close();
			
		Thread.sleep(500);

        WebDriver dr= new FirefoxDriver();
		
		dr.get("https://bizflowqa.usha.com/#/");
		
		Thread.sleep(500);

        dr.manage().window().maximize();
			
		Thread.sleep(500);

        dr.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
		
		Thread.sleep(500);

		dr.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
				
	    Thread.sleep(500);
		
		dr.findElement(By.cssSelector("[type='submit']")).click();
		
		Thread.sleep(800);
		
		dr.findElement(By.xpath("(//*[.='Vendor Creation'])[4]")).click();
		
		Thread.sleep(500);

		dr.findElement(By.xpath("(//*[text()='Vendor'])")).click();
		
		Thread.sleep(500);

		dr.findElement(By.xpath("(//*[text()='Vendor'])")).click();

		Thread.sleep(500);

		dr.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		Thread.sleep(500);

		dr.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();
		
		Thread.sleep(500);

		dr.findElement(By.xpath("//span[text()='Dashboard']")).click();
		
		Thread.sleep(500);

		dr.manage().window().maximize();
		
		Thread.sleep(500);

		dr.manage().window().minimize();

		Thread.sleep(500);

		dr.manage().window().maximize();
		
		Thread.sleep(500);

		dr.manage().window().minimize();
		
		Thread.sleep(500);
		
		dr.close();

        WebDriver dri = new EdgeDriver();
		
		dri.get("https://bizflowqa.usha.com/#/");
		
		Thread.sleep(500);

		dri.manage().window().maximize();
				
		Thread.sleep(500);

        dri.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
		
		Thread.sleep(500);

		dri.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
				
	    Thread.sleep(500);
		
		dri.findElement(By.cssSelector("[type='submit']")).click();
					
		Thread.sleep(2000);
		
		dri.findElement(By.xpath("(//*[.='Vendor Creation'])[4]")).click();
		
		Thread.sleep(500);

		dri.findElement(By.xpath("(//*[text()='Vendor'])")).click();
		
		Thread.sleep(500);

		dri.findElement(By.xpath("(//*[text()='Vendor'])")).click();

		Thread.sleep(500);

		dri.findElement(By.xpath("//span[text()='Dashboard']")).click();

		Thread.sleep(500);

		dri.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();

		Thread.sleep(500);

		dri.findElement(By.xpath("//span[text()='Dashboard']")).click();

		Thread.sleep(500);

		dri.manage().window().maximize();
		
		Thread.sleep(500);

		dri.manage().window().minimize();

		Thread.sleep(500);

		dri.manage().window().maximize();
		
		Thread.sleep(500);

		dri.close();
		

	}
			

}
