package MDM;

import java.awt.MediaTracker;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.sequence.DeleteCommand;
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
import org.testng.asserts.SoftAssert;

public class DealerFunctioning {
	
	WebDriverWait wait;
	
	WebDriver driver;
	
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Dealer Function'])[3]")));
		
		Thread.sleep(500);

		driver.findElement(By.xpath("(//*[.='Dealer Function'])[3]")).click();
		
		
		
		
	}
	
	@Test
	public void case1() {
		
		
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

		Assert.assertEquals(MDMName, "Dealer Function");
		
		}
	
	
	@Test(dataProvider = "dealerdata")
	public void addNewModule(String codes) throws InterruptedException {
	   
	        // Locate and click the 'Add New' button
	        WebElement addNewButton = driver.findElement(By.xpath("(//*[@type='button'])[4]"));
	        
	        addNewButton.click();
	        
	        Thread.sleep(800);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        WebElement dealerFunctionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[2]")));
	        
	        dealerFunctionInput.click();
	        
	        dealerFunctionInput.sendKeys(codes);

	        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[3]")));
	        
	        descriptionInput.click();
	        
	        descriptionInput.sendKeys(codes);

	        driver.findElement(By.cssSelector("[type='submit']")).click();
	        
	        Thread.sleep(1000);
	        
	       WebElement Deletedata = driver.findElement(By.xpath("(//*[@data-testid='DeleteIcon'])[1]"));
	       
	       Deletedata.click();
	       
	       WebElement realdelete=driver.findElement(By.cssSelector("[type='submit']"));
	       
	       Thread.sleep(600);
	       
	       realdelete.click();

	    
	}

	
	
	@Test
	public void scenario1() {

		try {
			
			WebElement columnField = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
		    columnField.click();

		    WebElement hideButton = driver.findElement(By.xpath("//*[.='Hide all']"));
		    hideButton.click();
		    
		    WebElement showbutton=driver.findElement(By.xpath("(//*[.='Show all'])"));
		    
		    showbutton.click();
		    
		    hideButton.click();
		    
		    columnField.click();
		    
		    WebElement descriptionButton= driver.findElement(By.xpath("(//*[@role='presentation'])[19]"));

			 if (descriptionButton.isDisplayed()) {
			    	
			    	System.out.println("Visible");
					
				}
		    
		   
		} catch (Exception e) {
			
			System.out.println("Not Visible");				
		}
	    	    
	    

	}
	
	@Test
	public void Scenario2() {
		
         WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
		 
		 Columnfield.click();
		 
		 WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));
			
			filterbutton.click();
			
			WebElement densityoption=driver.findElement(By.cssSelector("[aria-label='Density']"));
			
			densityoption.click();
			
			List<WebElement> densitysizes=driver.findElements(By.cssSelector("[role='menuitem']"));
			
			for (WebElement size : densitysizes) {
				
				size.click();
				
			}
			
			WebElement exportoption = driver.findElement(By.cssSelector("[aria-label='Export']"));
			
			exportoption.click();

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
	
	@DataProvider(name="dealerdata")
	public Object[][] deals(){
		
		return new Object[][] {
			
			{"uefdjefjisfj"},{"rgrjeeieiieieieieieieejefjsiofsjf"},{"1019220193932-"},{"!@#$%^&*()-[=]';"},{"120239sqiwjdjs!!@32"},{"hh 00 00 00 !!!"},{"didjjidjii"},{"  okokok   "}
		};
		
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
				
		Thread.sleep(500);
		
		driver.quit();
	}


	

}
