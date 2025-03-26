package PIPModule;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FullProcess2 {

    WebDriver driver;

    JavascriptExecutor js;

    WebDriverWait wait;

    @BeforeMethod
    public void startup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://bizflowqa.usha.com/#/login");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        js=(JavascriptExecutor) driver;

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("initiator1");

        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("System123#");

        driver.findElement(By.cssSelector("[placeholder='Captcha']")).sendKeys("abcd");

        driver.findElement(By.cssSelector("[type='submit']")).click();

        driver.findElement(By.xpath("(//*[.='Purchase Increase'])")).click();

        driver.findElement(By.xpath("(//*[.='Increase Price'])[3]")).click();

    }

    @Test
    public void retestcase1() {

        // Locate the PurchaseType element
        WebElement purchaseType = driver.findElement(By.cssSelector("[id='size-small-filled']"));

        // Click on the PurchaseType element
        purchaseType.click();

        if (purchaseType.getText().isEmpty()){

            purchaseType.sendKeys("Domestic");

            System.out.println("Purchase Type Selected is - " + purchaseType.getAttribute("value"));
        }

        WebElement search=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

        if (search.isDisplayed()){

            search.click();
        }

        WebElement result1=driver.findElement(By.xpath("(//*[.='SHRIRAM PISTON & RINGS LTD.'])[1]"));

        if (result1.isDisplayed()){

            result1.click();

        }



}

    @Test
    public void retestcase2(){

        WebElement search=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

        for (int i =0 ; i<=25 ; i++){

            if (search.isDisplayed()){

                search.click();
            }

        }

        System.out.println("Search Button No Issues in Direct using cases");



    }

    @Test
    public void retestcase3() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select Purchase Type
        WebElement purchaseType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='size-small-filled']")));
        purchaseType.click();
        if (purchaseType.getText().isEmpty()) {
            purchaseType.sendKeys("Domestic");
            System.out.println("Purchase Type Selected is - " + purchaseType.getAttribute("value"));
        }

        // Click Search Button
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@type='submit'])[3]")));
        search.click();

        // Click on result1
        WebElement result1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='SHRIRAM PISTON & RINGS LTD.'])[1]")));
        result1.click();

        // Navigate back
        driver.navigate().back();

        // Click on "Increase Price"
        WebElement increasePrice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Increase Price'])[3]")));
        increasePrice.click();

        // Click on Second Search
        WebElement search2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Search'])[2]")));
        search2.click();

        // Go to Next Page
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Go to next page']"))).click();

        // Interact with results
        List<WebElement> rows = driver.findElements(By.cssSelector("[role='presentation']"));
        for (WebElement result2 : rows) {
            if (result2.getText().equals("SHRIRAM ALPINE SALES P. LTD.")) {
                result2.click();
                break; // Exit loop after finding the desired element
            }
        }
    }


    @Test
    public void retestcase4() throws InterruptedException {

            WebElement purchaseType = driver.findElement(By.cssSelector("[id='size-small-filled']"));

            Thread.sleep(300);

            purchaseType.click();

        System.out.println("This line Executed Successfully - 0");

            if (purchaseType.getText().isEmpty()) {

                purchaseType.sendKeys("Domestic");

                System.out.println("Purchase Type Selected is - " + purchaseType.getAttribute("value"));
            }

        System.out.println("This line Executed Successfully - 1");

        // Click Search Button
            WebElement search = driver.findElement(By.xpath("(//*[@type='submit'])[3]"));
            Thread.sleep(300);

            search.click();

        System.out.println("This line Executed Successfully - 3");

        // Click on result1
            WebElement result1 = driver.findElement(By.xpath("(//*[.='SHRIRAM PISTON & RINGS LTD.'])[1]"));

            Thread.sleep(300);

            result1.click();

        System.out.println("This line Executed Successfully - 4");

        WebElement materialsearch = driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            Thread.sleep(300);

            materialsearch.click();

        System.out.println("This line Executed Successfully - 5");

        WebElement materialvalue = driver.findElement(By.xpath("(//*[.='5121012270'])[2]"));

            Thread.sleep(3000);

            materialvalue.click();

        System.out.println("This line Executed Successfully - 6");

        WebElement vendorbackbutton = driver.findElement(By.xpath("(//*[@type='submit'])[1]"));

            Thread.sleep(300);

            vendorbackbutton.click();

        System.out.println("This line Executed Successfully - 7");

        Thread.sleep(300);

            WebElement purchaseType2 = driver.findElement(By.id("size-small-filled"));

            WebElement vendorcode = driver.findElement(By.cssSelector("[name='vendorCode']"));

        System.out.println("This line Executed Successfully - 8");

        Thread.sleep(300);

            vendorcode.click();

            Thread.sleep(300);
        System.out.println("This line Executed Successfully - 9");

            if (!(vendorcode.getAttribute("class").isEmpty())) {

                vendorcode.sendKeys(Keys.CONTROL + "a");

                vendorcode.sendKeys(Keys.DELETE);
            }

        System.out.println("This line Executed Successfully - 10");

            Thread.sleep(300);

        if (purchaseType2.getText().isEmpty()) {

            Thread.sleep(300);

            purchaseType2.click();

            purchaseType2.sendKeys("Imported");
        }

        System.out.println("This line Executed Successfully - 11 (Part - 1)");

        Thread.sleep(1000);

        if (purchaseType2.getText().isEmpty()) {

            Thread.sleep(300);

            purchaseType2.click();

            purchaseType2.sendKeys("Imported");
        }

        System.out.println("This line Executed Successfully - 11(Part - 2)");


        Thread.sleep(300);

        search.click();

            if (result1.getText().equals("MIDEA ELECTRIC FAN MANUFACTURING")) {

                Thread.sleep(300);

                result1.click();

            }

        System.out.println("This line Executed Successfully -12");

    }


    public void teardown() throws InterruptedException {

        Thread.sleep(1000);

        driver.close();

    }
}
