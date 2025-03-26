package PIPModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class CalculationVerification {

    WebDriver driver;

    JavascriptExecutor js;

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

        WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

        PurchaseType.sendKeys("Domestic");

        WebElement proption=driver.findElement(By.xpath("//*[.='Domestic']"));

        proption.click();

        WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

        SearchButton.click();

        WebElement Firstoption=driver.findElement(By.xpath("(//*[@title='SHRIRAM PISTON & RINGS LTD.'])[1]"));

        Firstoption.click();

        WebElement materialpagesearch=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

        materialpagesearch.click();

        WebElement materialcode1=driver.findElement(By.cssSelector("[title='5121022110']"));

        materialcode1.click();

        WebElement Singlematerial = driver.findElement(By.xpath("(//*[@type='button'])[4]"));

        Singlematerial.click();

    }

    @Test(dataProvider = "InvalidInputs")
    public void test1(String fetched){

        WebElement bpp=driver.findElement(By.name("proposedBasicPricePerUnit"));

        bpp.sendKeys(fetched);

        if (!(bpp.getAttribute("class").isEmpty())){

            System.out.println(bpp.getAttribute("value"));

        }
        WebElement td=driver.findElement(By.name("proposedTradeDiscount"));

        td.sendKeys(fetched);

        if (!(td.getAttribute("class").isEmpty())){

            System.out.println(td.getAttribute("value"));

        }
       WebElement qd=driver.findElement(By.name("Enter Quantity Discount"));

       qd.sendKeys(fetched);

        if (!(qd.getAttribute("class").isEmpty())){

            System.out.println(qd.getAttribute("value"));

        }
        WebElement dd=driver.findElement(By.name("proposedDepotDiscount"));

       dd.sendKeys(fetched);

       if (!(dd.getAttribute("class").isEmpty())){

           System.out.println(dd.getAttribute("value"));

       }


    }



        @DataProvider(name = "InvalidInputs")
        public Object[][] provideInvalidInputs() {
            return new Object[][]{

                    {""}, // Empty string
                    {null}, // Null value
                    {"12345678901234567890123456789012345678901234567890"}, // 50 characters
                    {" "}, // Single space
                    {"    "}, // Multiple spaces
                    {"!@#$%^&*()"}, // Special characters
                    {"<script>alert('XSS')</script>"}, // XSS attack input
                    {"\n"}, // Newline character
                    {"\t"}, // Tab character
                    {"abcdefg!@#$%^&*"}, // Alphanumeric with special characters
                    {"DROP TABLE users;"}, // SQL injection attempt
                    {"\u0000"}, // Null character
                    {"       "}, // Unicode spaces
                    {"12345"}, // Numeric input
                    {"ABCDE"}, // Uppercase letters only
                    {"abcd123"}, // Alphanumeric
                    {"-123"}, // Negative number
                    {"3.14159"}, // Floating-point number
                    {"user@example.com"}, // Email-like format
                    {"username!domain.com"}, // Invalid email format
                    {"<invalid>&"}, // HTML entities
                    {"{"}, // Open brace
                    {"}"}, // Close brace
                    {"["}, // Open bracket
                    {"]"}, // Close bracket
                    {"(123)456-7890"}, // Phone number-like format
                    {"+1234567890"}, // International phone number-like format
                    {"192.168.0.1"}, // IP address-like format
                    {"255.255.255.255"}, // Edge case IP address
                    {"https://example.com"}, // URL-like format
                    {"ftp://example.com"}, // FTP URL-like format
                    {"//comment"}, // Comment-like string
                    {"abcdefghij"}, // 10 characters
                    {"ABCDEFGHIJ"}, // Uppercase 10 characters
                    {"1234567890"}, // Numeric 10 characters
                    {"-"}, // Hyphen
                    {"."}, // Period
                    {":"}, // Colon
                    {";"}, // Semicolon
                    {"'"}, // Single quote
                    {"\""}, // Double quote
                    {"`"}, // Backtick
                    {"\\"}, // Backslash
                    {"/"}, // Forward slash
                    {"|"}, // Pipe
                    {"?"}, // Question mark
                    {"~"}, // Tilde
                    {"="}, // Equals sign
                    {"%"}, // Percentage
                    {"#"}, // Hash
                    {"_"}, // Underscore
                    {"@"}, // At sign
                    {"$"}, // Dollar sign
                    {"^"}, // Caret
                    {"&"}, // Ampersand
                    {"*"}, // Asterisk
                    {"("}, // Open parenthesis
                    {")"}, // Close parenthesis
                    {"<"}, // Less-than sign
                    {">"}, // Greater-than sign
                    {"example,,value"}, // Comma-separated string
                    {"example;;value"}, // Semicolon-separated string
                    {"example:value"}, // Colon-separated string
                    {"example\nvalue"}, // String with newline
                    {"example\tvalue"}, // String with tab
                    {"example=value"}, // String with equals sign
                    {"example+value"}, // String with plus sign
                    {"example-value"}, // String with hyphen
                    {"example_value"}, // String with underscore
                    {"example*value"}, // String with asterisk
                    {"example&value"}, // String with ampersand
                    {"example!value"}, // String with exclamation mark
                    {"example?value"}, // String with question mark
                    {"example~value"}, // String with tilde
                    {"example#value"}, // String with hash
                    {"example$value"}, // String with dollar sign
                    {"example%value"}, // String with percentage
                    {"\"example\""}, // Quoted string
                    {"\'example\'"}, // Single-quoted string
                    {"--example"}, // Double hyphen
                    {"invalid_input$@"}, // Mixed invalid characters
                    {"123abcDEF!@"}, // Mixed invalid alphanumeric
                    {"randomText!123"}, // Random alphanumeric with special
                    {"test_input_"}, // Underscore trailing
                    {"_test_input"}, // Underscore leading
                    {"test!input"}, // Exclamation in between
                    {"END;"}, // Termination-like input
                    {"**invalid**"}, // Asterisk wrapped
                    {"@@invalid@@"}, // At sign wrapped
                    {"%%invalid%%"} // Percentage wrapped

            };
        }



    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();

    }



}
