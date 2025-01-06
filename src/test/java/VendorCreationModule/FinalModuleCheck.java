package VendorCreationModule;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FinalModuleCheck {
	
	ExtentReports reports;
	
	ExtentTest test;
	
	WebDriverWait wait;
	
	WebDriver driver;
	
	@BeforeTest
	
	public void reporting() {
		
		reports = new ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\UshaAddNewModuleReport.html");
		
		test=reports.startTest("Add New Module Testings");
		
		
	}
	
	@BeforeClass
	
	public void startup() throws InterruptedException {
		
		  driver=new ChromeDriver();
			
			driver.get("https://bizflowqa.usha.com/#/");
			
			driver.manage().window().maximize();
						
			wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			
	        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
			
			driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
			
			Thread.sleep(5000);
								
			driver.findElement(By.cssSelector("[type='submit']")).click();
			
			test.log(LogStatus.PASS, "Entered the Browser and Logged in Successfully");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Vendor Creation'])[3]")));
			
			driver.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Add New'])[2]")));
			
			Thread.sleep(500);
			
			driver.findElement(By.xpath("(//*[.='Add New'])[2]")).click();
			
			test.log(LogStatus.PASS, "Reached Add New Module Successfully");
	}
	
	
	@Test
	
	public void case1() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#nameTwo")).sendKeys("PRINCE RAJ");
				
		driver.findElement(By.cssSelector("#nameOne")).sendKeys("PRINCE RAJ");
		
		test.log(LogStatus.FAIL, "We should not be able to enter same name inside both name boxes successfully");
				
		driver.findElement(By.cssSelector("#nameOne")).sendKeys("PRINCE RAJ");
		
		driver.findElement(By.cssSelector("#nameTwo")).sendKeys("PRINCE RAJ");
		
		test.log(LogStatus.PASS, "We are not able to enter same name inside both name box successfully");

		

		}
	
	
	@Test
	
	public void case2() throws InterruptedException {
				
		  Thread.sleep(500);

	  WebElement AccountSelection  =	driver.findElement(By.cssSelector("#accountGroup"));
	  
	  Select regional = new Select(AccountSelection);
	  
	  regional.selectByIndex(1);
	  
	  Thread.sleep(500);

	WebElement Stateselect = driver.findElement(By.cssSelector("#state"));
	  
	  Select States = new Select(Stateselect);
	  
	  States.selectByIndex(5);
	  
	  Thread.sleep(500);
	  
	  driver.findElement(By.cssSelector("#postalCode")).sendKeys("800014");
	  
	  Thread.sleep(500);

	  regional.selectByIndex(2);
	  
	  Thread.sleep(500);
	  
	  test.log(LogStatus.FAIL, "Pincode has not been removed even after changing the account group to Foreign Groups");
	  
	  
	  
	}
	
	
	@Test 
	
	public void case3() throws InterruptedException {
		

	     driver.findElement(By.cssSelector("#telephone")).sendKeys("0000000000");

	     test.log(LogStatus.FAIL, "Landline Number should not show invalid number as correct");
	}
	
	
	@Test
	public void case4() {
		
		
		driver.findElement(By.cssSelector("#emailAddress")).sendKeys("princeraj1222@gaming.............com");
		
		test.log(LogStatus.FAIL, "Emailid format should be correct to get successfully verified");
	}
	
	@Test 
	
	public void case5() throws InterruptedException {
		
		  WebElement AccountSelection  =	driver.findElement(By.cssSelector("#accountGroup"));
		  
		  Select regional = new Select(AccountSelection);
		  
		  regional.selectByIndex(1);
		  
		  Thread.sleep(500);
		  
		  driver.findElement(By.cssSelector("#GSTIN")).sendKeys("36DJIPS7922F1ZT");

		  Thread.sleep(500);

		  regional.selectByIndex(0);
		  
		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("(//*[.='Ok'])[2]")).click();
		  
		  test.log(LogStatus.FAIL, "After moving to default account group every data is cleared except pincode");
	}
	
	
	
	@Test(dataProvider = "data")
	
	public void case6(String gst) throws InterruptedException {
		
	  WebElement AccountSelection  =	driver.findElement(By.cssSelector("#accountGroup"));
		  
		  Select regional = new Select(AccountSelection);
		  
		  regional.selectByIndex(4);
		  
		  Thread.sleep(500);
		  
		  WebElement GSTIN= driver.findElement(By.cssSelector("#GSTIN"));
		  
		    GSTIN.sendKeys(gst);

		  Thread.sleep(500);
		  
		  GSTIN.clear();
		  
		  regional.selectByIndex(0);

		
	}
	
	
	@Test(dataProvider = "data")
	
	public void case7(String gst) throws InterruptedException {
		
		
		for (int i = 0; i < 5; i++) {
			
			 WebElement AccountSelection  =	driver.findElement(By.cssSelector("#accountGroup"));
			  
			  Select regional = new Select(AccountSelection);
			  
				Thread.sleep(500);
				
				regional.selectByIndex(1);

			  WebElement GSTIN= driver.findElement(By.cssSelector("#GSTIN"));
			  		 
				Thread.sleep(500);

				  GSTIN.sendKeys(gst);
				  
					Thread.sleep(500);

				  GSTIN.clear();
		}
		
        

		}
		  
	
	
	
	@DataProvider
	
	public Object[][] data(){
		
		return new Object[][] {
			
			{"36DJIPS7922F1"},
			{"36DJIPS7922"},
			{"36DJIPS7922F1990"},
			{"3=======22F1ZT"},
			{"090909IPS7922F1ZT"},
			{"ppoppoppoppo"},
			{"1271836DJIPS7922F1ZT"},
			{"--------------"},
			{"77877877907"},
			{"1928391288128"},
			{"36DJIPS7922F1Z"},
			{"182812836DJIPS7922F1ZT"},
			{"aswnsddwdfnvcdeopiekdsc"},
			{"wsdfheudeyhweui"},
			{"36DJIPS7922F1ZT"}
			
			
		};
	}
	
	
	@AfterTest
	
	public void endreport() {
		
		reports.flush();
		
		reports.endTest(test);
	}
	
	
	@AfterClass
	
	public void teardown() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
