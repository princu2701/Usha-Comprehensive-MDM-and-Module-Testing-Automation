package VendorCreationModule;

import java.sql.Driver;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardFunctionality {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	JavascriptExecutor jsExecutor;

	@BeforeMethod
	
	public void start() throws InterruptedException {
		
		driver= new ChromeDriver();
		
		driver.get("https://bizflowqa.usha.com/#/");
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 jsExecutor= (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
				
        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
		
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
				
	    Thread.sleep(500);
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Dashboard'])[3]"))).click();
	        
			Thread.sleep(500);
	}
	
	
	@Test
	
	public void scenario1() throws InterruptedException {
		
		// Assertion Passes of the URL Verification
				
				
		Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/dashboard");
		
		
	}
	
	@Test 
	
	public void scenario2() throws InterruptedException {
		         
        driver.findElement(By.xpath("//*[.='All Request']")).click();
        
        Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/vendor-data-list?status=All");
        Thread.sleep(2000);
        driver.navigate().back();
         
        driver.findElement(By.xpath("(//*[.='Pending Request'])[1]")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        
        driver.findElement(By.xpath("(//*[.='Approved Request'])[1]")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        
        driver.findElement(By.xpath("//*[.='Raise Query Request']")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        
        driver.findElement(By.xpath("(//*[.='Rejected Request'])[1]")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        
        driver.findElement(By.xpath("(//*[.='Draft Record'])[1]")).click();
        Thread.sleep(2000);

        driver.navigate().back();

        Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/dashboard");
        
	}
	
	@Test 
	
	public void scenario3() throws InterruptedException {
		
		//Validating the functionality of Columns
		         
        driver.findElement(By.xpath("//*[.='All Request']")).click();
        
        Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/vendor-data-list?status=All");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Select columns']"))).click();
        
        Thread.sleep(2000);
        
       List<WebElement> CheckBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));
       
      for (WebElement Checks : CheckBoxes) {
    	  
    	  Checks.click();
		
	}
      
      for (WebElement Checks : CheckBoxes) {
    	  
    	  Checks.click();
		
	}
        
        
		
	}
	
	@Test
	
	public void scenario4() throws InterruptedException {
		
		// Validating the Column Selection Options
		
       driver.findElement(By.xpath("(//*[.='Pending Request'])[1]")).click();
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Show filters']"))).click();
        
      WebElement Operator = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[5]"));
      
      Select select =new Select(Operator);
      
      select.selectByIndex(1);
      
      Thread.sleep(500);

      select.selectByIndex(2);

      Thread.sleep(500);

      select.selectByIndex(3);

      Thread.sleep(500);

      select.selectByIndex(4);

      Thread.sleep(500);

      select.selectByIndex(5);

      Thread.sleep(500);
      
      select.selectByIndex(6);
      
      Thread.sleep(500);
      
      select.selectByIndex(0);



	}
	
	
	@Test
	
	public void scenario5() throws InterruptedException {
		
		//Validating the Filter Section Data's inside the All requests
		
	    Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/dashboard");
	   
        driver.findElement(By.xpath("//*[.='All Request']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Show filters']"))).click();
 	    
	    WebElement ColumnsUnderFIlters = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[4]"));
	   
		Select select =new Select(ColumnsUnderFIlters);
		
		select.selectByIndex(1);
		
		select.selectByIndex(2);

		select.selectByIndex(3);

		select.selectByIndex(4);

		select.selectByIndex(5);

		select.selectByIndex(6);

		select.selectByIndex(7);

		select.selectByIndex(8);
		
		select.selectByIndex(0);

	    WebElement OperatorsUnderFIlters = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[5]"));
	    
	    Select operators= new Select(OperatorsUnderFIlters);
	    
	    operators.selectByIndex(1);
	    
	    operators.selectByIndex(2);
	    
	    operators.selectByIndex(3);
	    
	    operators.selectByIndex(4);
	    
	    operators.selectByIndex(5);
	    
	    operators.selectByIndex(6);
	    
	    WebElement ValueFiltration= driver.findElement(By.xpath("(//*[@aria-invalid='false'])[6]"));

	    ValueFiltration.sendKeys("wdwsds");	  
	    
        Thread.sleep(2000);
        
	    Actions actions = new Actions(driver);
	    
	    for (int i = 0; i < ValueFiltration.toString().length(); i++) {
	    	
		    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
	
		}
	    
	    
	    ValueFiltration.sendKeys("AAAAA");

        Thread.sleep(2000);
        
  for (int i = 0; i < ValueFiltration.toString().length(); i++) {
	    	
		    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
	
		}

        ValueFiltration.sendKeys("12213321");

        Thread.sleep(2000);
        
  for (int i = 0; i < ValueFiltration.toString().length(); i++) {
	    	
		    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
	
		}

        ValueFiltration.sendKeys("PLPLP1122");

        Thread.sleep(2000);
        
        for (int i = 0; i < ValueFiltration.toString().length(); i++) {
	    	
		    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
	
		}
        
        

        ValueFiltration.sendKeys("PLPLPL---121```asasas");
        
  for (int i = 0; i < ValueFiltration.toString().length(); i++) {
	    	
		    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
	
		}

        Thread.sleep(2000);

	}
	
	
	@Test  
	
	public void scenario6() throws InterruptedException {
		
		//Verifying Filtration under All Requests with multiple different Scenario
			         
	       driver.findElement(By.xpath("//*[.='All Request']")).click();
		
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Show filters']"))).click();

	       WebElement ColumnsUnderFIlters = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[4]"));
	 	   
		   Select select =new Select(ColumnsUnderFIlters);
			
		   select.selectByIndex(2);

		   WebElement OperatorsUnderFIlters = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[5]"));
			    
		   Select operators= new Select(OperatorsUnderFIlters);
			    
		   operators.selectByIndex(3);

		   WebElement ValueFiltration= driver.findElement(By.xpath("(//*[@aria-invalid='false'])[6]"));

		    ValueFiltration.sendKeys("Market");
		    
		    Thread.sleep(2000);
		    
		    Actions actions = new Actions(driver);
		    
		    for (int i = 0; i < ValueFiltration.toString().length(); i++) {
		    	
			    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
		
			}
		    
		    Thread.sleep(1000);

			select.selectByIndex(1);
  
			Thread.sleep(1000);
			
		    operators.selectByIndex(0);
		    
		    Thread.sleep(1000);
			   
			ValueFiltration.sendKeys("Ven");	  

		    Thread.sleep(1000);

			String OutputValid = driver.findElement(By.cssSelector("[href='#/dashboard-layout/m-vendor-details?pid=U000471 - 15367']")).getText();
			    
		    Assert.assertEquals(OutputValid, "U000471 - 15367");
		    
		    Thread.sleep(2000);
			   			
			select.selectByIndex(5);
			  
		    operators.selectByIndex(2);
		    
            for (int i = 0; i < ValueFiltration.toString().length(); i++) {
		    	
			    actions.keyDown(ValueFiltration,Keys.BACK_SPACE).keyUp(ValueFiltration,Keys.BACK_SPACE).build().perform();
		
			}
			   
			ValueFiltration.sendKeys("Ven");	
			
			String OutputValid2 = driver.findElement(By.cssSelector("[href='#/dashboard-layout/m-vendor-details?pid=U000471 - 15367']")).getText();
		    
		    Assert.assertEquals(OutputValid2, "U000471 - 15367");
		    
		    System.out.println("3 Scenarios Done");
			
			select.selectByIndex(4);
			
		    operators.selectByIndex(2);
		    
		     select.selectByIndex(0);
			
		    operators.selectByIndex(0);
		    
		    driver.navigate().refresh();
		    
		    Thread.sleep(2000);
			
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Show filters']"))).click();

		    
		}
	
	@Test
	
	public void scenario7() throws InterruptedException {
		
		// Verifying Density of the data shown inside the All Requests
		        
	       driver.findElement(By.xpath("//*[.='All Request']")).click();
		
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();
	       
	      driver.findElement(By.xpath("(//*[@role='menuitem'])[1]")).click();
	       
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();

	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[3]")).click();

	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();
	       
	      driver.findElement(By.xpath("(//*[@role='menuitem'])[1]")).click();
	       
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();

	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[3]")).click();
	      
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();
	       
	      driver.findElement(By.xpath("(//*[@role='menuitem'])[1]")).click();
	       
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();

	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[3]")).click();
	      		
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();
	       
	      driver.findElement(By.xpath("(//*[@role='menuitem'])[1]")).click();
	       
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[2]")).click();

	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Density']"))).click();

	      driver.findElement(By.xpath("(//*[@role='menuitem'])[3]")).click();
	      	       	       
	      String SerialNumberAssert = driver.findElement(By.xpath("(//*[.='S.No.'])[4]")).getText();
	      
	     String StatusAssert = driver.findElement(By.xpath("(//*[.='Status'])[4]")).getText();

	   String ProcessAssert=  driver.findElement(By.xpath("(//*[.='Process Type'])[4]")).getText();

	     String ReferenceAssert = driver.findElement(By.xpath("(//*[.='Reference Number'])[4]")).getText();

	     // Asserting the column Names
	     
	     Assert.assertEquals(SerialNumberAssert, "S.No.");
	     
	     Assert.assertEquals(StatusAssert, "Status");
	     
	     Assert.assertEquals(ProcessAssert, "Process Type");
	     
	     Assert.assertEquals(ReferenceAssert, "Reference Number");
	     
	     System.out.println("Column Names Asserted");
	     
	     
	  }
	
	@Test
	
	public void scenario8() throws InterruptedException {
		
		/* 
		 * Here We will assert that whatever sections on which we are clicking
		 *  the data shown are related to that only and 
		 * that doesn't show the data related with the other Configurations 
		*/
		
		
	    driver.findElement(By.xpath("//*[.='All Request']")).click();
	    
		Thread.sleep(1000);

	    jsExecutor.executeScript("window.scrollBy(0,1800)","");
		
		Thread.sleep(1000);

	    driver.findElement(By.cssSelector("[aria-haspopup='listbox']")).click();
		
		driver.findElement(By.cssSelector("[data-value='20']")).click();
		
		String PendingAssert = driver.findElement(By.xpath("(//*[.='Pending for Approval'])[3]")).getText();
		
		Assert.assertEquals(PendingAssert, "Pending for Approval");
		
		System.out.println("Assertion of Pending Done");
		
		String ApprovalAssert = driver.findElement(By.xpath("(//*[.='Approved'])[3]")).getText();
				        		
		Assert.assertEquals(ApprovalAssert, "Approved");
		
		System.out.println("Approved Word Asserted");		
		
		
	}
	
	
	@Test 
	public void scenario9() throws InterruptedException {
		
		// Checking Rest of Requests and Asserting them
		
		driver.findElement(By.xpath("(//*[.='Pending Request'])[1]")).click();
		
		Thread.sleep(500);

		String ApprovalAssert = driver.findElement(By.xpath("(//*[.='Pending for Approval'])[3]")).getText();		

		Assert.assertEquals(ApprovalAssert, "Pending for Approval");
		
		System.out.println("Pending for Approval Word Asserted");
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//*[.='Approved Request'])[1]")).click();
		
		Thread.sleep(200);

		String ApprovedInsideAssert = driver.findElement(By.xpath("(//*[.='Approved'])[3]")).getText();
		
		Assert.assertEquals(ApprovedInsideAssert, "Approved");
		
		System.out.println("Approval Word Asserted");
		
		driver.navigate().back();
		
		String RaisequeryAssert=driver.findElement(By.xpath("//*[.='Raise Query Request']")).getText();
		
		Assert.assertEquals(RaisequeryAssert, "Raise Query Request");
		
		System.out.println("Raise Query Request Asserted");
		
		driver.findElement(By.xpath("//*[.='Raise Query Request']")).click();	
		
	String queryAssertString=	driver.findElement(By.xpath("(//*[.='Raise Query'])[3]")).getText();
	
	Assert.assertEquals(queryAssertString, "Raise Query");
	
	Thread.sleep(200);
	
	driver.navigate().back();
	
	Thread.sleep(200);
	
	String RejectionDashboardAssert=driver.findElement(By.xpath("(//*[.='Rejected Request'])[1]")).getText();
	
	Assert.assertEquals(RejectionDashboardAssert, "Rejected Request");
		
	Thread.sleep(200);

	driver.findElement(By.xpath("(//*[.='Rejected Request'])[1]")).click();
	
	Thread.sleep(200);

	String RejectedRequestAssert=driver.findElement(By.xpath("(//*[.='Rejected Request'])[3]")).getText();
	
	Assert.assertEquals(RejectedRequestAssert, "Rejected Request");
	
	Thread.sleep(200);

	driver.navigate().back();
	
	Thread.sleep(200);

	String draftAssert=  driver.findElement(By.xpath("//*[.='Draft Record']")).getText();
	
	Assert.assertEquals(draftAssert, "Draft Record");
	
	System.out.println("(Draft Record Asserted}");
	
	Thread.sleep(200);
	
	driver.findElement(By.xpath("//*[.='Draft Record']")).click();
	
	Thread.sleep(200);
	
	String draftRecordAssert=driver.findElement(By.xpath("(//*[.='Draft Record'])[3]")).getText();
	
	Assert.assertEquals(draftRecordAssert, "Draft Record");
	
	System.out.println("Draft Box Checked");
	
		}
	
	
	@Test
	
	public void scenario10() {
		
		// Verification of Dashboard Homepage
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/dashboard");
		
		System.out.println("Dashboard Page URL Asserted");
		
		
		//Pie Colour Asserrtions
		
		String pendingblueAssert=driver.findElement(By.xpath("(//*[@stroke='#ffffff'])[1]")).getText();
		
		Assert.assertEquals(pendingblueAssert, "");
		
		String QueryRaiseYellow = driver.findElement(By.xpath("(//*[@stroke='#ffffff'])[3]")).getText();
		
		Assert.assertEquals(QueryRaiseYellow, "");
		
		
		
	}
	
	
	
	
	
	
	@AfterMethod
	
	public void teardown() throws InterruptedException {
		
	     Thread.sleep(2000);
		
		driver.close();
		
		
	}
	
}
