package CRAccountTestings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class UUFIAccountWorks {
        WebDriver driver;

        WebDriverWait wait;

        @BeforeMethod
        public void initialprocess() throws InterruptedException {

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://bizflowqa.usha.com/#/login");

            wait = new WebDriverWait(driver,Duration.ofSeconds(10));

            WebElement username=driver.findElement(By.cssSelector("[placeholder='User id']"));

            username.sendKeys("PIPUUFI");

            WebElement pass=driver.findElement(By.cssSelector("input[placeholder='Password']"));

            pass.sendKeys("System123#");

            WebElement loginbutton=driver.findElement(By.xpath("(//button[normalize-space()='Login to Continue'])[1]"));

            Thread.sleep(20000);

            loginbutton.click();

//        if((driver.getCurrentUrl().equals("https://bizflowqa.usha.com/#/login"))){
//
//            WebElement refreshcaptcha=driver.findElement(By.xpath("(//span[@type='button'])[1]"));
//
//            refreshcaptcha.click();
//
//            Thread.sleep(5000);
//
//            loginbutton.click();
//        }else{
//            Thread.sleep(1000);
//
//        }


            WebElement PIPOptionsprovider=driver.findElement(By.xpath("(//span[contains(@class,'MuiTypography-root MuiTypography-body2 MuiListItemText-primary css-16ogg9d')])[1]"));

            wait.until(ExpectedConditions.visibilityOf(PIPOptionsprovider));

            PIPOptionsprovider.click();
        }

        @Test
        public void simplescenario1() throws InterruptedException {



            WebElement PIPbutton=driver.findElement(By.xpath("//span[normalize-space()='PIP']"));

            wait.until(ExpectedConditions.visibilityOf(PIPbutton));

            PIPbutton.click();

            WebElement purchasetype=driver.findElement(By.xpath("(//input[@id='size-small-filled'])[1]"));

            purchasetype.click();

            WebElement domestic=driver.findElement(By.xpath("//li[@id='size-small-filled-option-2']"));

            domestic.click();

            WebElement searchbutton=driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));

            searchbutton.click();

            WebElement vendorname=driver.findElement(By.xpath("(//div[contains(@role,'cell')])[2]"));

            wait.until(ExpectedConditions.visibilityOf(vendorname));

            vendorname.click();

            WebElement materialsearchbutton=driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));

            wait.until(ExpectedConditions.visibilityOf(materialsearchbutton));

            materialsearchbutton.click();

            WebElement materialname=driver.findElement(By.xpath("(//div[contains(@role,'cell')])[2]"));

            wait.until(ExpectedConditions.visibilityOf(materialname));

            materialname.click();

            WebElement singelmaterial=driver.findElement(By.xpath("(//button[normalize-space()='Single Material Code'])[1]"));

            Thread.sleep(500);

            singelmaterial.click();

            String requesttype=driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).getText();

            Assert.assertTrue(requesttype.contains("Request Type: Imported"));

            System.out.println("Request Type Length is : "+ requesttype.length());

            WebElement Plantname=driver.findElement(By.cssSelector("[value='UUFI']"));

            if (Plantname.getAttribute("value").equals("UUFI")){

                System.out.println("Value is : "+Plantname.getAttribute("value"));
            }

        }






        @AfterMethod
        public void teardown() throws InterruptedException {

            Thread.sleep(2000);

            driver.quit();

        }


    }


