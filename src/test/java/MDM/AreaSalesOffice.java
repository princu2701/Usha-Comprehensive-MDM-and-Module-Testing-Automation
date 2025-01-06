package MDM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AreaSalesOffice {
	
	WebDriverWait wait;
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
//	@BeforeClass
//	public void reports() {
//		
//		reports= new ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\Report1.html");
//		
//	    test=reports.startTest("Customer MDM Testing Report (1)- 10/12/2024");
//		
//	}
	
	
	@BeforeMethod
	
	public void setup() throws InterruptedException {
		
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
		
	//	test.log(LogStatus.PASS, "Reached the Browser and Logged in Successfuly in the Usha");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Customer']")));
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//*[.='Customer']")).click();
		
		Thread.sleep(500);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='MDM'])[2]")));
		
		driver.findElement(By.xpath("(//*[.='MDM'])[2]")).click();
		
	//	test.log(LogStatus.PASS, "Reached Customer MDM Successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Area Sales Office']")));
		
		Thread.sleep(800);

		driver.findElement(By.cssSelector("[aria-label='Area Sales Office']")).click();
		
		
	}
	
	
	
	@Test
	public void functionality1() throws InterruptedException {
		
		//Passing the Assertion so that we can know that whether we are on right place
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://bizflowqa.usha.com/#/customer-services/Area-Sales-Office");
		
		
		 WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
		 
		 Columnfield.click();
		
		List<WebElement> columns = driver.findElements(By.cssSelector("[type='checkbox']"));
		
		for (WebElement column : columns) {
			
			column.click();
			
			
		}
		
	}	
		
		
		@Test(dataProvider = "data")
		public void columninputs(String values) throws InterruptedException {
			
			
			 WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
			 
			 Columnfield.click();
			 
	            WebElement columninput = driver.findElement(By.cssSelector("[placeholder='Column title']"));
			 
 			columninput.sendKeys(values);

			 
			}
		
		
		@Test 
		public void filters() throws InterruptedException {
			
			WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
			
			filterbutton.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]")));
			
			WebElement ColumnsSelection = driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]"));
			
			Select columnSelect=new Select(ColumnsSelection);
			
			WebElement OperatorSelect=driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[2]"));
			
			Select operatorselect=new Select(OperatorSelect);
						
			for (int i = 0; i <=6; i++) {
								
				columnSelect.selectByIndex(i);
				
				operatorselect.selectByIndex(i);
				

                 }
			
			String MDMName=driver.findElement(By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3'])")).getText();

			Assert.assertEquals(MDMName, "Area Sales Office SAP");
			
			}
		
		@Test(dataProvider = "data")
		public void filtervalues(String value) throws InterruptedException {
			

			WebElement filterbutton1 = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
			
			filterbutton1.click();
			
			WebElement filtervalue = driver.findElement(By.cssSelector("[placeholder='Filter value']"));
			
			Thread.sleep(500);
			
			filtervalue.sendKeys(value);
			
			
			
			
		}
		
		
		@Test(dataProvider = "data")
		public void AreaSaleasSearch(String searchdata) throws InterruptedException {
			
			WebElement Searches = driver.findElement(By.cssSelector("[placeholder='Search…']"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Search…']")));
			
			Searches.sendKeys(searchdata);
			
			
			
			
		}
		
		
		
		@Test 
		
		public void cominedscenarios1() throws InterruptedException {
			
			 WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
			 
			 Columnfield.click();
			 
			 List<WebElement> columns = driver.findElements(By.cssSelector("[type='checkbox']"));
				
				for (WebElement column : columns) {
					
					column.click();
					
					
				}
				
		    WebElement columninput = driver.findElement(By.cssSelector("[placeholder='Column title']"));
			 
			columninput.sendKeys("");
			
            WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
			
			filterbutton.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]")));
			
			WebElement ColumnsSelection = driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]"));
			
			Select columnSelect=new Select(ColumnsSelection);
			
			WebElement OperatorSelect=driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[2]"));
			
			Select operatorselect=new Select(OperatorSelect);
						
			for (int i = 0; i <=6; i++) {
								
				columnSelect.selectByIndex(i);
				
				operatorselect.selectByIndex(i);
				

                 }
			
			
			WebElement filtervalue = driver.findElement(By.cssSelector("[placeholder='Filter value']"));
			
			Thread.sleep(500);
			
			filtervalue.sendKeys("");
			

			WebElement Searches = driver.findElement(By.cssSelector("[placeholder='Search…']"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Search…']")));
			
			Searches.sendKeys("");
			
		}
		
         @Test 
		
		public void cominedscenarios2() throws InterruptedException {
	
             WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
			 
			 Columnfield.click();
			 
			 List<WebElement> columns = driver.findElements(By.cssSelector("[type='checkbox']"));
				
				for (WebElement column : columns) {
					
					column.click();
					
					
				}
				
		    WebElement columninput = driver.findElement(By.cssSelector("[placeholder='Column title']"));
			 
			columninput.sendKeys("{}{}{}{}{}{}{}{}{}{}{}{");
			
            WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
			
			filterbutton.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]")));
			
			WebElement ColumnsSelection = driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[1]"));
			
			Select columnSelect=new Select(ColumnsSelection);
			
			WebElement OperatorSelect=driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[2]"));
			
			Select operatorselect=new Select(OperatorSelect);
						
			for (int i = 0; i <=6; i++) {
								
				columnSelect.selectByIndex(i);
				
				operatorselect.selectByIndex(i);
				

                 }
			
			Thread.sleep(500);

			
            WebElement filtervalue = driver.findElement(By.cssSelector("[placeholder='Filter value']"));
			
            filtervalue.click();
			
			filtervalue.sendKeys("{}{}{}{!!!!!ukhldmfi36349");
			
			
         }
         
         
         @Test
         public void combinedscenarios3() throws InterruptedException {
        	 
        	 //Only data filling 
        	 
             WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
			 
			 Columnfield.click();
			 
			 WebElement columninput = driver.findElement(By.cssSelector("[placeholder='Column title']"));
				 
		     columninput.sendKeys(" PPPPPPP!     000000000 )_)=0-=0");
		     
		     WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
				
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
				
				filterbutton.click();
		     
		     WebElement filtervalue = driver.findElement(By.cssSelector("[placeholder='Filter value']"));
				
			Thread.sleep(500);
				
			filtervalue.sendKeys("><><><>;;;;;;;;             qqqqaqaq ");

			WebElement Searches = driver.findElement(By.cssSelector("[placeholder='Search…']"));
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Search…']")));
				
			Searches.sendKeys("     rrdrd1!!!!!sd%%%% dd            dkws");
				
				
        	 
        	 
         }
	         

		
		
			
	@DataProvider(name="data")
	public Object[][] data(){
		
		return new Object[][] {
				
			{"fjfdfsjfi"},
			{"1002-1201"},
			{"923992fffsdf"},
			{"HWIQEUDJ     WIIDJJ"},
			{"111111111111111111111111111111111111111"},
			{"WIEIIRIWODJDJ"},
			{"VVVVVVVVV      111111111"},
			{"GF GGGFG FGFG GFDEED SWSS "},
			{"1         1"},
			{"RII93R 3E 23E02JEW"},
			{";';;[;[]][[]!!!"}     
				
		};
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	
	}


