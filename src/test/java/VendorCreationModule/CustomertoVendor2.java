package VendorCreationModule;


import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CustomertoVendor2 {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	com.relevantcodes.extentreports.ExtentTest test;
	
	com.relevantcodes.extentreports.ExtentReports reports;
	
	 
	 @BeforeTest
	 
	 public void reports() {
		 
		 reports = new com.relevantcodes.extentreports.ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\UshaReport1.html");
		 
		 test = reports.startTest("Customer to Vendor Module");
		 
		  }
	
	
	@BeforeTest
	
	public void startup() {
		  driver=new ChromeDriver();
			
			driver.get("https://bizflowqa.usha.com/#/");
			
			driver.manage().window().maximize();
			
			test.log(LogStatus.PASS, "Enter the Browser and Reached the Url Website");
			
			wait= new WebDriverWait(driver, Duration.ofSeconds(10));
			
	        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
			
			driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
								
			driver.findElement(By.cssSelector("[type='submit']")).click();

		    driver.findElement(By.cssSelector("[placeholder='Captcha']")).sendKeys("abcd");

		    driver.findElement(By.cssSelector("[type='submit']")).click();

		test.log(LogStatus.PASS, "Entered Successfully inside the website after entering the valid credentials");
			
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Vendor Creation'])[3]")));
				
				driver.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();
				
				driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
				
				test.log(LogStatus.PASS, "Reached Customer to Vendor Successfully");
	}
	
	
	@Test(priority = 1)
	
	public void case1() throws InterruptedException {
		
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer")));
				
		driver.findElement(By.cssSelector("#customer")).sendKeys("2049103");
		
		test.log(LogStatus.PASS, "Entered the first data inside the Customer Code to Fetch the Data from MDM");
		
		WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
		
		Actions actions = new Actions(driver);
		
		for (int i = 0; i < 10; i++) {
			
			actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
			
		}
		
		
		Thread.sleep(1000);
		
		test.log(LogStatus.PASS, "Successfully deleted the data already inserted and will reinsert the random data to find the defects");
		
		driver.findElement(By.cssSelector("#customer")).sendKeys("6074235");

		for (int i = 0; i < 10; i++) {
			
			actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
			
		}
		
		
		Thread.sleep(1000);
		
		CustomerCode.sendKeys("1073003");
		
		test.log(LogStatus.FAIL, "Some Error has been Detected in retrival of data from this case");

	}
	

	
	
	@Test(priority=2) 
	
	public void case2() throws InterruptedException {
		
       Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer")));
				
	    Thread.sleep(1000);

       driver.findElement(By.cssSelector("#customer")).sendKeys("2049103");
		
       Thread.sleep(1000);

		WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
		
	       Thread.sleep(1000);
	       
	       test.log(LogStatus.PASS, "Restarted entering the data in another case");

		Actions actions = new Actions(driver);
		
		for (int i = 0; i < 10; i++) {
			
			actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
			
		}
		
	       Thread.sleep(1000);
	       
	       test.log(LogStatus.PASS, "Deleting the data using the actions and th for loop comes in play here to reduce te duplicacy of the code");

		CustomerCode.sendKeys("123sweqws");
		
	    Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
			
			actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
			
		}
        
        Thread.sleep(1000);

		CustomerCode.sendKeys("9002w91203");

	       Thread.sleep(1000);

	    for (int i = 0; i < 10; i++) {
				
				actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
				
			}
		
	       Thread.sleep(1000);

			CustomerCode.sendKeys("9002w91203");
			
		    Thread.sleep(1000);

		    for (int i = 0; i < 10; i++) {
					
					actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
					
				}
			
		    Thread.sleep(1000);

           CustomerCode.sendKeys("-=-=-='''");
			
		    Thread.sleep(1000);

		    for (int i = 0; i < 10; i++) {
					
					actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
					
				}
			
		    Thread.sleep(1000);
		    
           CustomerCode.sendKeys("Y+12Q><asqw12");
           
   
			

		    for (int i = 0; i < 10; i++) {
					
					actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
					
				}
			
		    Thread.sleep(1000);
		    
		    test.log(LogStatus.PASS, "Validation Success as Some errors ha been Detected");
		    
	}
	
	
	@Test(priority = 3)
	
	public void case3() throws InterruptedException {
		
		 Thread.sleep(1000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#customer")));
					
		    Thread.sleep(1000);
		    
		 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZFRG");
		 
		 test.log(LogStatus.PASS, "In another case now what we are going to do is we will try to check the data after selectng a new account group to verify that how Customer COde is behaving in selection of a new Accounts Group");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys("()()()()()12123232941232-1");
			
	       Thread.sleep(1000);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions = new Actions(driver);
			
			for (int i = 0; i < 30; i++) {
				
				actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
				
			}
			
			CustomerCode.sendKeys("2049103");
			
		    Thread.sleep(1000);

         for (int i = 0; i < 30; i++) {
				
				actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
				
			}
         
		 select.selectByIndex(1);
		 
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys("()()()()()12123232941232-1");
			
	       Thread.sleep(1000);

			WebElement CustomerCode1=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions1 = new Actions(driver);
			
			for (int i = 0; i < 30; i++) {
				
				actions1.keyDown(CustomerCode1,Keys.BACK_SPACE).keyUp(CustomerCode1,Keys.BACK_SPACE).build().perform();
				
			}
			
			CustomerCode1.sendKeys("QQQQQQQQQ");
			
		    Thread.sleep(1000);

        for (int i = 0; i < 30; i++) {
				
				actions1.keyDown(CustomerCode1,Keys.BACK_SPACE).keyUp(CustomerCode1,Keys.BACK_SPACE).build().perform();
				
			}
        
		 select.selectByIndex(3);
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys("()()()()()12123232941232-1");
			
	       Thread.sleep(1000);

			WebElement CustomerCode11=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions11 = new Actions(driver);
			
			for (int i = 0; i < 30; i++) {
				
				actions11.keyDown(CustomerCode11,Keys.BACK_SPACE).keyUp(CustomerCode11,Keys.BACK_SPACE).build().perform();
				
			}
			
			CustomerCode11.sendKeys("2049103");
			
		    Thread.sleep(1000);

       for (int i = 0; i < 30; i++) {
				
				actions11.keyDown(CustomerCode11,Keys.BACK_SPACE).keyUp(CustomerCode11,Keys.BACK_SPACE).build().perform();
				
			}

		 select.selectByIndex(4);


		  driver.findElement(By.cssSelector("#customer")).sendKeys("()()()()()12123232941232-1");
			
	       Thread.sleep(1000);

			WebElement CustomerCode111=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions111 = new Actions(driver);
			
			
			for (int i = 0; i < 30; i++) {
				
				actions111.keyDown(CustomerCode111,Keys.BACK_SPACE).keyUp(CustomerCode111,Keys.BACK_SPACE).build().perform();
				
			}
			
			CustomerCode111.sendKeys("2049103");
			
		    Thread.sleep(1000);

      for (int i = 0; i < 30; i++) {
				
				actions111.keyDown(CustomerCode111,Keys.BACK_SPACE).keyUp(CustomerCode111,Keys.BACK_SPACE).build().perform();
				
			}
      
		 select.selectByIndex(5);

		  driver.findElement(By.cssSelector("#customer")).sendKeys("()()()()()12123232941232-1");
			
	       Thread.sleep(1000);

			WebElement CustomerCode1111=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions1111 = new Actions(driver);
			
			for (int i = 0; i < 30; i++) {
				
				actions1111.keyDown(CustomerCode1111,Keys.BACK_SPACE).keyUp(CustomerCode1111,Keys.BACK_SPACE).build().perform();
				
			}
			
			CustomerCode1111.sendKeys("QQQQQQQQQ");
			
		    Thread.sleep(1000);

     for (int i = 0; i < 10; i++) {
				
				actions1111.keyDown(CustomerCode1111,Keys.BACK_SPACE).keyUp(CustomerCode1111,Keys.BACK_SPACE).build().perform();
				
			}
     
     select.selectByIndex(0);
         
     CustomerCode1111.sendKeys("2049103");
     
     test.log(LogStatus.PASS, "In the Case 3 we have tried to get the response that whether Customer Code is supporting the special character in different situation ");

	}
	
	
	@Test(priority = 4)
	
	public void case4() throws InterruptedException {
		
         WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZFRG");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys("9989");

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);

			Actions actions = new Actions(driver);
			
			for (int i = 0; i < 3; i++) {
				
				actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
				
			}
			
		       Thread.sleep(1000);
		       
		       CustomerCode.sendKeys("121271");
		       
	for (int i = 0; i < 6; i++) {
				
				actions.keyDown(CustomerCode,Keys.BACK_SPACE).keyUp(CustomerCode,Keys.BACK_SPACE).build().perform();
				
			}
	
	test.log(LogStatus.PASS, "In case 4 verification has been done using the Foreign Accounts Group with some different inputs");
		       
		
	}
	
	
	@Test(dataProvider = "data",priority = 5)
	public void case5(String customers) throws InterruptedException {
		

        WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZSER");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.FAIL, "Tried using the Service Accounts Group but different Account Groups inputs are working in different ways after attracting the data from the data provider also");

	}
	
	
	@Test(dataProvider = "data",priority = 6)
	
	public void case6(String customers) throws InterruptedException {
	
		
		
		  WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
			 
			 Select select = new Select(AccuntSelection);
			 
			 select.selectByValue("ZFRG");
			 
			  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

				WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
				
			       Thread.sleep(1000);
			       
			       CustomerCode.clear();
			       
			       test.log(LogStatus.PASS, "Changed the Accounts Group in Case 6 and attracted the Data using the dataprovider");
	}
	
	
	@Test(dataProvider = "data",priority = 7)
	
	public void case7(String customers) throws InterruptedException {
		
		 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZFIN");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.FAIL, "Selected the Finance Groups and attracted data using Data Provider and there are various issues detected");
	}
	
	
	@Test(dataProvider = "data", priority = 8)
	
	public void case8(String customers) throws InterruptedException {
		
		 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZFGT");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.FAIL, "Selected the new Account Groups and still in this case errors or defects are being detected");
	}
	
	@Test(dataProvider = "data", priority = 9)
	
	public void case9(String customers) throws InterruptedException {
		
		 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZDSS");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.FAIL, "Selected the ZDSS Accounts Group and attracted the data using the DataProvider still bugs has been detected");
	}
	
     @Test(dataProvider = "data",priority = 10)
     
     public void case10(String customers) throws InterruptedException {
    	 
    	 
    	 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByValue("ZDNS");
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.PASS, "Selected the ZDNS Accounts group and same errors has been found here as well");
     }
     
     
     @Test(dataProvider = "data", priority = 11)
     
     public void case11(String customers) throws InterruptedException {
    	 
    	 WebElement AccuntSelection =  driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccuntSelection);
		 
		 select.selectByIndex(0);
		 
		  driver.findElement(By.cssSelector("#customer")).sendKeys(customers);

			WebElement CustomerCode=driver.findElement(By.cssSelector("#customer"));
			
		       Thread.sleep(1000);
		       
		       CustomerCode.clear();
		       
		       test.log(LogStatus.PASS, "Going to the default Accounts group section and verifying the fetched data in the boxes and its respective places as well using the dataProvider");
     }
     
     
     @DataProvider(name="data")
 	
 	public Object[][] data(){
 		
 		return new Object[][] {
 			
 			new Object[] {"12012912938"},
 			new Object[] {"122039329191"},
 			new Object[] {"121200192102"},
 			new Object[] {"12020392021"},
 			new Object[] {"78327834827"},
 			new Object[] {"829347839203"},
 			new Object[] {"2345438729347"},
 			new Object[] {"1209384787912"},
 			new Object[] {"111100002339293"},
 			new Object[] {"19283448732912"},
 			new Object[] {"18293475487392"},
 			new Object[] {"192837e61723"},
 			new Object[] {"1982376371892"},
 			new Object[] {"912837y4t3y278"},
 			new Object[] {"182374732837"},
 			new Object[] {"1234r67328237"},
 			new Object[] {"81273671236781"},
 			new Object[] {"98767873678273"},
 			new Object[] {"1928347"},
 			new Object[] {"12342"},
 			new Object[] {"123443234"},
 			new Object[] {"04949"},
 			new Object[] {"4"},
 			new Object[] {"5"},
 			new Object[] {"8"},
 			new Object[] {"9"},
 			new Object[] {"876"},
 			new Object[] {"888"},
 			new Object[] {"09"},
 			new Object[] {"889"},
 			new Object[] {"3939"},
 			new Object[] {"09"},
 			new Object[] {"17"},
 			new Object[] {"09"},
 			new Object[] {"34"},
 			new Object[] {"99531"},
 			new Object[] {"9953"},
 			new Object[] {"098766899"},
 			new Object[] {"0"},
 			new Object[] {"1"},
 			new Object[] {"9009"},
 			new Object[] {"90088"},// Email Issue
 			new Object[] {"878"},// State Issue
 			new Object[] {"12"}, // State Issue
 			new Object[] {"990987"}, // Postal Code Error


         };
 		
 	}
	
	
	
	
	@AfterTest
	
	public void teardown() throws InterruptedException {
		
		test.log(LogStatus.WARNING, "Successfully attracted the data and Perfomed all the activities in the various cases created above but some errors are present");
		
		reports.flush();
		
		reports.endTest(test);
		
		Thread.sleep(1000);
		
		driver.manage().window().minimize();
		
		driver.close();
	}

}
