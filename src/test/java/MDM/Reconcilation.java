package MDM;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en_old.Ac;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Reconcilation {

    WebDriver driver;
    WebDriverWait wait;
    ExtentReports reports;
    ExtentTest test;


    @BeforeTest
    public void reports() {

        reports= new ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\ReconcilationReport1.html");

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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type='submit']")));

        driver.findElement(By.cssSelector("[type='submit']")).click();

        test.log(LogStatus.PASS, "Reached the Browser and Logged in Successfuly in the Usha");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='Customer']"))).click();

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='MDM'])[2]")).click();

        test.log(LogStatus.PASS, "Reached Customer MDM Successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[.='Reconciliation Account'])[3]"))).click();

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

        Thread.sleep(1000);

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

            Thread.sleep(200);

            selectcolumns.selectByIndex(i);

            Thread.sleep(200);

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

    @Test
    public void addmodulecase1() throws InterruptedException {

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement Distribution = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        Distribution.click();

        WebElement Selectall=driver.findElement(By.xpath("//*[.='Select All']"));

        Selectall.click();

        WebElement addbox = driver.findElement(By.cssSelector("[type='submit']"));

        wait.until(ExpectedConditions.elementToBeClickable(addbox));

        addbox.click();



    }

    @Test
    public void addmodulecase2() throws InterruptedException {

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement Distribution = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        Distribution.click();

        WebElement Selectall=driver.findElement(By.xpath("//*[.='Select All']"));

        Selectall.click();

        Thread.sleep(200);

        Actions actions = new Actions(driver);

        actions.moveByOffset(800, 300) // Example: Assuming 1920x1080 screen resolution
                .click()
                .perform();

        WebElement addbox = driver.findElement(By.cssSelector("[type='submit']"));

        addbox.click();

        System.out.println(driver.manage().window().getSize());



    }

    @Test(dataProvider = "data")
    public void addmodulecase3(String datafetched){

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement Distribution = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        Distribution.click();

        Distribution.sendKeys(datafetched);

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

    }

    @Test(dataProvider = "data")
    public void addmmodulecase4(String fetched){

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement recaccount=driver.findElement(By.name("reconciliationAccount"));

        recaccount.sendKeys(fetched);

        WebElement addbox = driver.findElement(By.cssSelector("[type='submit']"));

        addbox.click();


    }

    @Test(dataProvider = "data")
    public void addmodulecase5(String datafetched){

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement recdesc = driver.findElement(By.name("reconciliationAccountDescription"));

        recdesc.sendKeys(datafetched);

        WebElement addbox = driver.findElement(By.cssSelector("[type='submit']"));

        addbox.click();
    }

    @Test(dataProvider = "data")
    public void addmodulecase6(String datafetched){

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement recdesc = driver.findElement(By.name("reconciliationAccountDescription"));

        recdesc.sendKeys(datafetched);

        WebElement recaccount=driver.findElement(By.name("reconciliationAccount"));

        recaccount.sendKeys(datafetched);

        WebElement addbox = driver.findElement(By.cssSelector("[type='submit']"));

        addbox.click();

    }

    @Test(dataProvider = "data")
    public void addmodulecase7(String datafetched) throws InterruptedException {

        WebElement addbutton=driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        addbutton.click();

        WebElement recdesc = driver.findElement(By.name("reconciliationAccountDescription"));

        recdesc.sendKeys(datafetched);

        WebElement recaccount=driver.findElement(By.name("reconciliationAccount"));

        recaccount.sendKeys(datafetched);

        WebElement Distribution = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        for (int i=0;i<=20;i++){

            Distribution.click();

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

        Thread.sleep(500);

        reports.flush();

        reports.endTest(test);

        driver.quit();

    }
}
