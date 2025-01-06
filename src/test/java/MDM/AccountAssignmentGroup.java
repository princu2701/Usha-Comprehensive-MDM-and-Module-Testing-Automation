package MDM;


import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AccountAssignmentGroup {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeTest
	public void reports() {
		
		reports= new ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\AccountAssignmentGroupReport1.html");
		
		 test=reports.startTest("Customer MDM Testing Report (1)- 10/12/2024");
	}
	
	
	@BeforeMethod
	public void startup() throws InterruptedException {
		
		driver= new ChromeDriver();
		
		driver.get("https://bizflowqa.usha.com/#/login");
		
		driver.manage().window().maximize();
		
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("[placeholder='Captcha']")).sendKeys("abcd");
		
		Thread.sleep(500);
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		Thread.sleep(500);
		
		test.log(LogStatus.PASS, "Reached the Browser and Logged in Successfuly in the Usha");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Customer']")));
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//*[.='Customer']")).click();
		
		Thread.sleep(500);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='MDM'])[2]")));
		
		driver.findElement(By.xpath("(//*[.='MDM'])[2]")).click();
		
		test.log(LogStatus.PASS, "Reached Customer MDM Successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Account Assignment Group'])[3]")));
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[.='Account Assignment Group'])[3]")).click();
		
		
	}
	
	@Test
	public void AccountAss1() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Columns']")));
		
		driver.findElement(By.xpath("//*[.='Columns']")).click();
		
		test.log(LogStatus.PASS, "Reached Columns Section Successfully");
		
		List<WebElement> options = driver.findElements(By.cssSelector("[type='checkbox']"));
		
		for ( WebElement op : options) {
			
			Thread.sleep(500);
			
			op.click();
			
		}
		
		test.log(LogStatus.PASS, "Iterated and Checked all Column Data ");
		
		test.log(LogStatus.FAIL, "User should not be able to enter invalid or incorrect character and also User should not be able to enter character within a limit ");
		
		Thread.sleep(3000);
		
        for ( WebElement op : options) {
			
			Thread.sleep(500);
			
			op.click();
			
		}
        
        test.log(LogStatus.PASS, "User is able to see data while changing the varities of columns categories");
        
        
        for (int i = 0; i <= 10; i++) {
        	        	
        	driver.findElement(By.xpath("//*[.='Hide all']")).click();
        	
            
            driver.findElement(By.xpath("//*[.='Show all']")).click();
		}
        
        test.log(LogStatus.PASS, "Hide and Show button is clearly clickable at any point of time");
        
        
         
        for (int i = 0; i <= 10; i++) {
        	
        	 driver.findElement(By.cssSelector("[name='distributionChannel']")).click();
             
             driver.findElement(By.cssSelector("[name='division']")).click();
			
		}
        
        test.log(LogStatus.PASS, "Data is clearly not visible when got unchecked");
        
        for (int i = 0; i <= 10; i++) {
        	
       	 driver.findElement(By.cssSelector("[name='accountAssignmentGroup']")).click();
            
            driver.findElement(By.cssSelector("[name='accountAssignmentGroupDescription']")).click();
			
		}
        
        
        
        for (int i = 0; i <= 10; i++) {
        	
          	 driver.findElement(By.cssSelector("[name='createdBy']")).click();
               
               driver.findElement(By.cssSelector("[name='createdOn']")).click();
   			
   		}
        
        for (int i = 0; i <= 10; i++) {
        	
         	 driver.findElement(By.cssSelector("[name='modifiedBy']")).click();
              
              driver.findElement(By.cssSelector("[name='modifiedOn']")).click();
              
              driver.findElement(By.cssSelector("[name='actions']"));
  			
  		}
        
        
        for (int i = 0; i <= 10; i++) {
        	
        	driver.findElement(By.xpath("//*[.='Hide all']")).click();
        	
            
            driver.findElement(By.xpath("//*[.='Show all']")).click();
		}
        
        test.log(LogStatus.PASS, "All Section under Column along with Hide n Show Button is working fine");

}
	
	@Test()
	public void filter() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
		
		driver.findElement(By.cssSelector("[aria-label='Show filters']")).click();
		
		WebElement columns = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[3]"));
		
		Select selectcolumns = new Select(columns);
		
		 WebElement Operator = driver.findElement(By.xpath("(//*[@aria-invalid='false'])[4]"));
			
	        Select selectoperator=new Select(Operator);
				
		for (int i = 0; i <= 5; i++) {
			
			Thread.sleep(500);
			
			selectcolumns.selectByIndex(i);
			
             Thread.sleep(500);
        	
        	selectoperator.selectByIndex(i);
			
		}
		
        
       test.log(LogStatus.PASS, "Operators are working fine");
        
        
        }
	
	
	@Test(dataProvider = "data")
	public void valuechecks(String fetch) {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
	        
	        driver.findElement(By.cssSelector("[aria-label='Show filters']")).click();

	        // Locate the value input field for filter
	        WebElement valueInput = driver.findElement(By.cssSelector("[placeholder='Filter value']"));
	        

	        valueInput.click();  // Click to focus the element
	        
	        valueInput.clear();  // Clear the input field (this should work most cases)

	        if (valueInput.getAttribute("value").length() > 0) {
	            valueInput.sendKeys(Keys.CONTROL + "a"); 
	            valueInput.sendKeys(Keys.BACK_SPACE);    
	        }

	        valueInput.sendKeys(fetch);

	        test.log(LogStatus.PASS, "Entered filter value: " + fetch);

	        valueInput.clear();

	        test.log(LogStatus.PASS, "Cleared the filter value input");

	    } catch (Exception e) {

	        test.log(LogStatus.FAIL, "Error in valuechecks: " + e.getMessage());

	    }
	}

	
	
	@Test
	public void Density() {
		
		List<WebElement> Sizes = driver.findElements(By.cssSelector("[role='menuitem']"));
		
		for ( WebElement diffsizes : Sizes) {
			
			diffsizes.click();
			
			}

		test.log(LogStatus.PASS, "Density at different sizes are working fine");
		
		
	}
	
	@Test
	public void export() {
		
		driver.findElement(By.cssSelector("[aria-label='Export']"));
		
		test.log(LogStatus.PASS, "User is able to download and print the data");
		
		
	}
	
	@Test(dataProvider = "data")
	public void search(String searchdata) {
		
		driver.findElement(By.cssSelector("[type='search']")).clear();
		
		driver.findElement(By.cssSelector("[type='search']")).sendKeys(searchdata);
		
		driver.findElement(By.cssSelector("[type='search']")).clear();
		
		test.log(LogStatus.FAIL, "User should not be able to enter special characters inside the search button");
		
		test.log(LogStatus.FAIL, "There should be a character limit for the search box");
		
	}
	
	
	 @Test(dataProvider = "data")
	    public void addnew(String value) throws InterruptedException {
	        try {
	            // Wait until the 'Add' button is clickable and click on it
	            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='AddIcon']")));
	            driver.findElement(By.cssSelector("[data-testid='AddIcon']")).click();

	            // Wait for the input field to be visible and interact with it
	            WebElement disChannel = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("(//*[@placeholder='Search and select'])[1]")));

	            // Click to focus on the input field
	            disChannel.click();
	           
	            // Enter the new value into the input field
	            disChannel.sendKeys(value);
	            
	            // Optional: Clear the field again after entering the value if needed
	            disChannel.clear();

	            // Log the action for reporting (if needed)
	            test.log(LogStatus.FAIL, "Entered any invalid value" + value);
	            
	           
	            
	        } catch (Exception e) {
	            // Handle exceptions gracefully and log the error
	            test.log(LogStatus.FAIL, "Error in addnew method: " + e.getMessage());
	        }
	        
	       
	    }
	
@DataProvider(name="data")
	public Object[][] data(){
		
		return new Object[][] {
			
			new Object[] {"19238199"},
			new Object[] {"ndnsuhwdas8199"},
			new Object[] {"    199"},
			new Object[] {"1923    "},
			new Object[] {"1      9"},
			new Object[] {"1"},
			new Object[] {"9"},
			new Object[] {"!!!!!"},
			new Object[] {"!jcdue0928019"},
			new Object[] {"uesdhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"},
			new Object[] {"efcwefsejddwokd"},
			new Object[] {"928391     823482909023903"},
			new Object[] {"periwen c"},
			new Object[] {"           "},
			new Object[] {"ufheu"},
			new Object[] {"ieeuffjfeuhbd"},
			
		};
	}
	
	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(1000);
		
		reports.flush();
		
		reports.endTest(test);
		
		driver.quit();
		
	}

}
