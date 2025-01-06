package VendorCreationModule;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.opentelemetry.semconv.SemanticAttributes.FaasTriggerValues;

public class VendorCreationMduleCovergae {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void loggingprocess() throws InterruptedException {
		
	     driver=new ChromeDriver();
		
		driver.get("https://bizflowqa.usha.com/#/");
		
		driver.manage().window().maximize();
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("15367");
		
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("System123#");
				
//	    Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Vendor Creation'])[3]")));
			
			driver.findElement(By.xpath("(//*[.='Vendor Creation'])[3]")).click();

	}
	
	@Test(priority = 1)
	public void case1() throws InterruptedException {
		
		
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("dasffsfewefdf");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("dfedddef");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("11212312129883928392891891");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("FDOPR0253J");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("kqwdijscnvnfj293820912938e");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();

		
 	}
	
	
	@Test(priority = 2)
	
	public void case2() throws InterruptedException {
				
		
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
		
		
		
	}
	
	
	@Test(priority = 3)
	
	public void case3() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("000000000000000000");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("00000000000000000000");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("0000000000000000000");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("00000000000000000000");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("000000000000000000000");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
		
		
	}
	
	
	@Test(priority = 4)
	
	public void case4() throws InterruptedException {
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaa");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaa");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("aaaaaaaaaaaaaaaaaaa");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaa");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaa");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
	   
	}
	
	
    @Test(priority = 5)
    
    public void case5() throws InterruptedException {
    	
       
		
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("AAAAAAAAAAAA");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("AAAAAAAAAAAA");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("AAAAAAAAAAA");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("AAAAAAAAAAAAAAA");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("AAAAAAAAAAAAAAAAA");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
    }
    
    
    @Test (priority = 6)
    
    public void case6() throws InterruptedException {
    	
        
		
		
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("[]");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys("[]");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("[]");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("[]");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("[]");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
	   
	   driver.navigate().refresh();
    }
    
    
    
    
    @Test(priority = 7)
    
    public void case7() throws InterruptedException {
    	
       
		
		
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("..................");
		
//		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).clear();
		
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Code here...']")).sendKeys(".................");
		
       driver.findElement(By.cssSelector("[placeholder='Enter Business Area']")).sendKeys("................");
       
	   driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("......................");
	   
	   driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("...................");
	   
	   driver.findElement(By.cssSelector("[type='submit']")).click();
    }
    
    
    @Test(priority = 8)
    
    public void case8() throws InterruptedException {
    	
    	//Trying Re-entries of the Vendor Name,Pan Number and GSTIN
    	
       
		
		WebElement Gst=driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']"));
		
		Gst.sendKeys("32REWGFGBGR43EDF");
		   
	    driver.findElement(By.cssSelector("[type='submit']")).click();
		   
       Actions actions = new Actions(driver);
       
       actions.keyDown(Gst,Keys.BACK_SPACE).keyUp(Gst, Keys.BACK_SPACE).build().perform();
	    
		driver.findElement(By.cssSelector("[placeholder='Enter GSTIN here']")).sendKeys("36DJIPS7922F1ZT");
		
	    driver.findElement(By.cssSelector("[type='submit']")).click();
	                           
	    driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("FR4EWFD3RWE");

	    driver.findElement(By.cssSelector("[type='submit']")).click();

	    WebElement Pan  = driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']"));

	    actions.keyDown(Pan,Keys.BACK_SPACE).keyUp(Pan, Keys.BACK_SPACE).build().perform();
		
	    driver.findElement(By.cssSelector("[placeholder='Enter Pan Number here']")).sendKeys("DJIPS7922F");

	    driver.findElement(By.cssSelector("[type='submit']")).click();
	    
		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("2e3wdfv3ewds3ewds");

		WebElement VendorNameElement=driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here'"));
		
	    actions.keyDown(VendorNameElement,Keys.BACK_SPACE).keyUp(VendorNameElement, Keys.BACK_SPACE).build().perform();

		driver.findElement(By.cssSelector("[placeholder='Enter Vendor Name here']")).sendKeys("RICHA MARKETINGS");
		
	    driver.findElement(By.cssSelector("[type='submit']")).click();

	    Thread.sleep(2000);
	    
        driver.findElement(By.xpath("(//*[.='Clear'])[2]")).click();

		 
    	}
    
    
    @Test(priority = 9)
    
    public void case9() throws InterruptedException {
    	
    	driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
    	
    	Thread.sleep(2000);
    	
    	 WebElement	AccountSelection=driver.findElement(By.cssSelector("#accountGroup"));
    	 
    	 Select select = new Select(AccountSelection);
    	 
    	 select.selectByValue("ZSER");
    	 
    	 driver.findElement(By.cssSelector("#customer")).sendKeys("");
    	 
    	 driver.findElement(By.cssSelector("#GSTIN")).sendKeys("36DGQPS3279Q1Z3");
    	 
       driver.findElement(By.cssSelector("#nameOne")).sendKeys("BPAASES");
    	 
    	 driver.findElement(By.cssSelector("#nameTwo")).sendKeys("BNOTPASSES");
    	 
    	 driver.findElement(By.cssSelector("#address1")).sendKeys("Bailey Road");
    	 
    	 driver.findElement(By.cssSelector("#address2")).sendKeys("RPS More ");
    	 
    	 driver.findElement(By.cssSelector("#address3")).sendKeys("Boring ROad");
    	 
    	 WebElement countryElement=driver.findElement(By.cssSelector("#country"));
    	 
    	 Select select2=new Select(countryElement);
    	 
    	 select2.selectByValue("IN");
    	 
    	WebElement stateElement= driver.findElement(By.cssSelector("#state"));
    	
    	Select select3 = new Select(stateElement);
    	
    	select3.selectByValue("Bihar");
    	
    	Thread.sleep(1000);
    	
        driver.findElement(By.cssSelector("#city")).sendKeys("Patna");
        
        driver.findElement(By.cssSelector("#postalCode")).sendKeys("800014");
        
        WebElement SelectCurrency = driver.findElement(By.cssSelector("#currency"));
        
        Select select4 = new Select(SelectCurrency);
        
           select4.selectByValue("INR");
        
           driver.findElement(By.cssSelector("#phone")).sendKeys("7070707070");
           
           driver.findElement(By.cssSelector("#telephone")).sendKeys("0234932944");
           
           driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.com");
           
           driver.findElement(By.cssSelector("#contactPerson")).sendKeys("Prince Raj");
           
           Thread.sleep(2000);
         
           driver.findElement(By.xpath("(//*[@class='button-black'])[1]")).click();
           
    }
    
    
    @Test(priority = 10)
    
    public void case10() throws InterruptedException {
    	
    	
    	//Test for only Selectable Items and Proceed
    	
    	driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

    	Thread.sleep(1000);
    	
    	WebElement	AccountSelection=driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccountSelection);
		 
		 select.selectByValue("ZSER"); 
		 
		 WebElement countryElement=driver.findElement(By.cssSelector("#country"));
		 
		 Select select2=new Select(countryElement);
		 
		 select2.selectByValue("IN");
		 
		WebElement stateElement= driver.findElement(By.cssSelector("#state"));
		
		Select select3 = new Select(stateElement);
		
		select3.selectByValue("Bihar");
	    
	    WebElement SelectCurrency = driver.findElement(By.cssSelector("#currency"));
	    
	    Select select4 = new Select(SelectCurrency);
	    
	       select4.selectByValue("INR");
	    
	       
	       
	       
	}
    
    
    @Test(priority = 11)
    
    public void case11() throws InterruptedException {
    	
    	//Change Country as per Verification
    	
    	driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

    	Thread.sleep(1000);
    	
    	WebElement	AccountSelection=driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select = new Select(AccountSelection);
		 
		 select.selectByValue("ZSER"); 
		 
		 WebElement countryElement=driver.findElement(By.cssSelector("#country"));
		 
		 Select select2=new Select(countryElement);
		 
		 select2.selectByValue("IN");
		 
		WebElement stateElement= driver.findElement(By.cssSelector("#state"));
		
		Select select3 = new Select(stateElement);
		
		select3.selectByValue("Assam");
		
    	Thread.sleep(1000);
		
		select3.selectByValue("Bihar");
		
    	Thread.sleep(1000);

		select3.selectByValue("Goa");
		
    	Thread.sleep(1000);

		select3.selectByValue("Delhi");
		
    	Thread.sleep(1000);

		select3.selectByValue("Punjab");

		Thread.sleep(1000);
		
		 select.selectByValue("ZFRG"); 
		 
		   select2.selectByValue("AS");
	       
			Thread.sleep(1000);

	       select2.selectByValue("AQ");
	       
			Thread.sleep(1000);

	       select2.selectByValue("AR");
	       
			Thread.sleep(1000);

	       select2.selectByValue("AS");

			Thread.sleep(1000);

	       select2.selectByValue("KM");

			Thread.sleep(1000);

		  WebElement SelectCurrency = driver.findElement(By.cssSelector("#currency"));
	    
	    Select select4 = new Select(SelectCurrency);
	    
	    }
    
    
   @Test(priority = 12)
   
   public void case12() throws InterruptedException {
	   
	   
	   //Try to proceed with only required data
	   
	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

   	    Thread.sleep(1000);
	   
	   driver.findElement(By.cssSelector("#nameOne")).sendKeys("BPAASES");

		 driver.findElement(By.cssSelector("#address1")).sendKeys("Bailey Road");
		 
		 driver.findElement(By.cssSelector("#city")).sendKeys("Patna");
		    
		    driver.findElement(By.cssSelector("#postalCode")).sendKeys("800014");
		    
		    driver.findElement(By.cssSelector("#phone")).sendKeys("7070707070");
		       
		       driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.com");

	           driver.findElement(By.xpath("(//*[@class='button-black'])[1]")).click();

	    
   }
   
   
   @Test(priority = 13)
   
   public void case13() throws InterruptedException {
	   
	   
	   //Proceed without selecting Accounts Group
	   
	   //THis test must always go fail
	   
	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

  	    Thread.sleep(1000);
	   
	   WebElement	AccountSelection3=driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select0 = new Select(AccountSelection3);
		 
		 select0.selectByIndex(0); 
		 
		 WebElement countryElement=driver.findElement(By.cssSelector("#country"));
		 
		 Select select2=new Select(countryElement);
		 
		 select2.selectByValue("IN");
		 
		WebElement stateElement= driver.findElement(By.cssSelector("#state"));
		
		Select select3 = new Select(stateElement);
		
		select3.selectByValue("Bihar");
	    
	    WebElement SelectCurrency = driver.findElement(By.cssSelector("#currency"));
	    
	    Select select4 = new Select(SelectCurrency);
	    
	       select4.selectByValue("INR");
	       
	       driver.findElement(By.cssSelector("#nameOne")).sendKeys("BPAASES");

		   driver.findElement(By.cssSelector("#address1")).sendKeys("Patna , Bihar-0014");
			 
		   driver.findElement(By.cssSelector("#city")).sendKeys("Patna");
			    
		   driver.findElement(By.cssSelector("#postalCode")).sendKeys("800014");
			    
		   driver.findElement(By.cssSelector("#phone")).sendKeys("7070707070");
			       
		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.com");
   }
   
   
   
   @Test(priority = 14)
   
   public void case14() throws InterruptedException {
	   
	   
	   //Validating whether we can select different countries regularly with also Changing the accounts as well
	   
	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

 	    Thread.sleep(1000);
	   
	   WebElement	AccountSelection3=driver.findElement(By.cssSelector("#accountGroup"));
		 
		 Select select0 = new Select(AccountSelection3);
		 
		 select0.selectByIndex(1); 
		 
	 	    Thread.sleep(1000);
		 
		 select0.selectByIndex(2); 

	 	    Thread.sleep(1000);

		 select0.selectByIndex(3); 
		 
	 	    Thread.sleep(1000);

		 select0.selectByIndex(4); 
		 
	 	    Thread.sleep(1000);

		 select0.selectByIndex(5); 
		 
	 	    Thread.sleep(1000);
		 
		 select0.selectByIndex(5); 

	 	    Thread.sleep(1000);

	     select0.selectByIndex(0); 
	     
	 	    Thread.sleep(1000);

		 select0.selectByIndex(2); 
		 

	   
   }
   
   
   @Test (priority = 15)
   
   public void case15() throws InterruptedException {
	   
	   //Entering different telephone number every time and trying to proceed
	   
	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

	    Thread.sleep(1000);
	    
	 WebElement Change  = driver.findElement(By.cssSelector("#telephone"));
	   
       driver.findElement(By.cssSelector("#telephone")).sendKeys("0234932944");
	    Thread.sleep(1000);
	    
	    Actions actions=new Actions(driver);
	    
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();

       driver.findElement(By.cssSelector("#telephone")).sendKeys("0234aaaaa");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(1000);


       driver.findElement(By.cssSelector("#telephone")).sendKeys("0234-----");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("0234KKKKKKK");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("02341111111111111111111111111111111111111111111111111111111111111111111111111");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("0234gtignefnf");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("02349339293--wedfeds");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("02349bbbb");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("bbbbb0234932944");
	    actions.keyDown(Change,Keys.BACK_SPACE).keyUp(Change, Keys.BACK_SPACE).build().perform();
	    Thread.sleep(3000);

       driver.findElement(By.cssSelector("#telephone")).sendKeys("wdddddddddd0234932944feeeeeeee");


	   
   }
   
   @Test(priority = 16)
   
   public void case16() throws InterruptedException {
	   
	   
	   //In this case I will try out with different types of email validations
	   
	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();

	    Thread.sleep(1000);
	    
		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.dvcdfc");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.sdvcsadcx");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.cofsdvcfdsvm");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.c432om");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.dvfsdcx");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.fdsvdascx");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.cesfdbdedom");
		   Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.QAQAQAQAQAQAQAQAA");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.433DE");
		    Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		   driver.findElement(By.cssSelector("#emailAddress")).sendKeys("prince@gmail.NNNNN----QQQ111aqaqaqaqaqaqa");
		   Thread.sleep(3000);

		   driver.findElement(By.cssSelector("#emailAddress")).clear();
		    Thread.sleep(1000);

		    driver.findElement(By.cssSelector("#emailAddress")).sendKeys("QUORA@GMIAL.WEFESDFVCGFRERWEFDV");
			   Thread.sleep(3000);

			   driver.findElement(By.cssSelector("#emailAddress")).clear();
		   
		   

   }
   
   @Test( priority = 17)
   
   public void case17() throws InterruptedException {
	   
	    Thread.sleep(1000);

	   driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
	    
	    driver.navigate().back();
	    
	    Thread.sleep(1000);
   
	    driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
	    Thread.sleep(1000);

	    driver.navigate().back();
	    
	    Thread.sleep(1000);

	    driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
	    Thread.sleep(1000);

	    driver.navigate().back();
	    
	    Thread.sleep(1000);

	    driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
	    Thread.sleep(1000);

	    driver.navigate().back();
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//*[.='Customer To Vendor'])[2]")).click();
	    Thread.sleep(1000);

	    Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/dashboard-layout/vendor-all-details?customerToVendor=yes");

	    
   }
   
   
    
    
	
	@AfterMethod 
	
	public void teardown() throws InterruptedException {
		
		Thread.sleep(1000);
		
		driver.quit();
		
	}

}
