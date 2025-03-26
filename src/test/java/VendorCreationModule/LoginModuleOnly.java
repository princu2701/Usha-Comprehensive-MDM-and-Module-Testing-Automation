package VendorCreationModule;
<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
=======

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

>>>>>>> 884b86364575fa0615863e590eb0d10b208b787e
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginModuleOnly {
    
    WebDriver driver;
    
    WebDriverWait wait;

    @BeforeMethod
    public void startup() {
    	
        driver = new FirefoxDriver();
        
        driver.get("https://bizflowqa.usha.com/");
        
        driver.manage().window().maximize();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void cases() throws EncryptedDocumentException, IOException, InterruptedException {

    	FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\Book1.xlsx");
    	
        Workbook excel = WorkbookFactory.create(fis);
        
        
        // Loop through each row (users and passwords)
        for (int rowIndex = 2; rowIndex <= 10; rowIndex++) {
        	
            login(excel, rowIndex);
        }
        
        fis.close(); 
    }

    private void login(Workbook excel, int rowIndex) throws InterruptedException {
    	
        WebElement userElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[placeholder='User id']")));
        
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));

        userElement.clear();
        
        Thread.sleep(500);

        userElement.sendKeys(excel.getSheet("Sheet2").getRow(rowIndex).getCell(0).getStringCellValue());
        
        Thread.sleep(500);
        
        passwordElement.clear();
        
        passwordElement.sendKeys(excel.getSheet("Sheet2").getRow(rowIndex).getCell(1).getStringCellValue());
        
        Thread.sleep(1000);


        driver.findElement(By.cssSelector("[type='submit']")).click();

          }

    @AfterMethod
    public void teardown() throws InterruptedException {
    	
    	Thread.sleep(1000);
    	
        driver.quit(); 
    }
}
