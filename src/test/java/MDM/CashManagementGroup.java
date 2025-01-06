package MDM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.beans.Transient;
import java.time.Duration;
import java.util.List;

public class CashManagementGroup {

    WebDriverWait wait;
    WebDriver driver;


    //    @BeforeTest
//    public void reports() {
//
//        reports= new ExtentReports("C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.25.0.RELEASE\\UshaProject\\Report1.html");
//
//        test=reports.startTest("Customer MDM Testing Report (1)- 10/12/2024");
//    }


    @BeforeMethod
    public void startup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://bizflowqa.usha.com/#/login");

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("[placeholder='User id']")).sendKeys("admin");

        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("admin");

        driver.findElement(By.cssSelector("[placeholder='Captcha']")).sendKeys("abcd");

        driver.findElement(By.cssSelector("[type='submit']")).click();

        Thread.sleep(500);

        //test.log(LogStatus.PASS, "Reached the Browser and Logged in Successfuly in the Usha");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Customer']")));

        Thread.sleep(300);

        driver.findElement(By.xpath("//*[.='Customer']")).click();

        Thread.sleep(300);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='MDM'])[2]")));

        driver.findElement(By.xpath("(//*[.='MDM'])[2]")).click();

        //  test.log(LogStatus.PASS, "Reached Customer MDM Successfully");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Cash Management Group'])[3]")));

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='Cash Management Group'])[3]")).click();


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

        Select columnSelect = new Select(ColumnsSelection);

        WebElement OperatorSelect = driver.findElement(By.xpath("(//*[@class='MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-gtqybt'])[2]"));

        Select operatorselect = new Select(OperatorSelect);

        for (int i = 0; i <= 6; i++) {

            columnSelect.selectByIndex(i);

            operatorselect.selectByIndex(i);


        }

        String MDMName = driver.findElement(By.xpath("(//*[@class='MuiTypography-root MuiTypography-body1 css-9l3uo3'])")).getText();

        Assert.assertEquals(MDMName, "Cash Management Group");

    }

    @Test
    public void scenario1() {

        try {

            WebElement columnField = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
            columnField.click();

            WebElement hideButton = driver.findElement(By.xpath("//*[.='Hide all']"));
            hideButton.click();

            WebElement showbutton = driver.findElement(By.xpath("(//*[.='Show all'])"));

            showbutton.click();

            hideButton.click();

            columnField.click();

            WebElement descriptionButton = driver.findElement(By.xpath("(//*[@role='presentation'])[19]"));

            if (descriptionButton.isDisplayed()) {

                System.out.println("Visible");

            }


        } catch (Exception e) {

            System.out.println("Not Visible");
        }


    }

    @Test
    public void Scenario2() {

        // Open the "Select Columns" field
        WebElement columnField = driver.findElement(By.cssSelector("[aria-label='Select columns']"));
        columnField.click();
        System.out.println("Clicked on 'Select Columns'");

        // Open the "Show Filters" menu
        WebElement filterButton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));
        wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        filterButton.click();
        System.out.println("Clicked on 'Show Filters'");

        // Open the "Density" options menu
        WebElement densityOption = driver.findElement(By.cssSelector("[aria-label='Density']"));


        // Loop through density options and select each one
        for (int i = 0; i < 3; i++) { // Adjust the iteration limit based on available density options  }

            try {

                // Reopen the Density menu to ensure elements are in DOM
                densityOption.click();

                System.out.println("Reopened 'Density' menu");

                // Re-fetch density options
                List<WebElement> diffDensities = driver.findElements(By.cssSelector("[role='menuitem']"));

                System.out.println("Density options found: " + diffDensities.size());

                // Select the current density option
                WebElement densityItem = diffDensities.get(i);

                wait.until(ExpectedConditions.visibilityOf(densityItem));

                System.out.println("Clicking on density option: " + densityItem.getText());

                densityItem.click();

                // Add a short wait to simulate user interaction
                Thread.sleep(1000);

            } catch (StaleElementReferenceException | InterruptedException e) {

                System.out.println("Encountered StaleElementReferenceException, retrying...");
                i--; // Retry the current iteration

            }

            // Open the "Export" option
            WebElement exportOption = driver.findElement(By.cssSelector("[aria-label='Export']"));

            wait.until(ExpectedConditions.elementToBeClickable(exportOption));

            exportOption.click();

            System.out.println("Clicked on 'Export' option");
        }
    }



    @Test(dataProvider = "data")
    public void search(String searchData) {
        try {

            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));

            searchInput.clear();


            //We can use if condition when clear don't works.
            if (!searchInput.getAttribute("placeholder").isEmpty()) {

                searchInput.sendKeys(Keys.CONTROL + "a");

                searchInput.sendKeys(Keys.DELETE);

            }


            // Enter new search data
            searchInput.sendKeys(searchData);

            // Wait for potential auto-suggestions or results
            wait.until(ExpectedConditions.textToBePresentInElementValue(searchInput, searchData));

            System.out.println("Search input contains: " + searchInput.getAttribute("value"));

        } catch (Exception e) {

            System.out.println("Error occurred during search: " + e.getMessage());

        }


    }


    @Test(dataProvider = "data2")
    public void addmodulecase1(String d1,String d2) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffices = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        SalesOffices.click();

        Thread.sleep(500);

        WebElement officeloc1 = driver.findElement(By.xpath("(//*[.='UAPS - Secunderabad'])[2]"));

        officeloc1.click();

        SalesOffices.click();

        Thread.sleep(500);

        WebElement CashD=driver.findElement(By.cssSelector("[name='cashManagement']"));

        CashD.click();

        CashD.sendKeys(d1);

        WebElement Desc=driver.findElement(By.cssSelector("[name='cashManagementDescription']"));

        Desc.click();

        Desc.sendKeys(d2);

        WebElement dataadd = driver.findElement(By.cssSelector("[type='submit']"));

        dataadd.click();



    }


    @Test
    public void addmodulecase2() throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffices = driver.findElement(By.cssSelector("[placeholder='Search and select']"));

        SalesOffices.click();

        WebElement officeloc1=driver.findElement(By.xpath("(//*[.='UBHP - Patna'])[2]"));

        officeloc1.click();

        WebElement dataadd = driver.findElement(By.cssSelector("[type='submit']"));

        dataadd.click();

        SalesOffices.click();

        WebElement Officeloc2=driver.findElement(By.xpath("(//*[.='UTNC - Chennai'])[2]"));

        Officeloc2.click();

        dataadd.click();

        SalesOffices.click();

        WebElement Officeloc3=driver.findElement(By.xpath("(//*[.='UASG - Guwahati'])[2]"));

        Officeloc3.click();

        dataadd.click();



    }

    @Test(dataProvider = "data")
    public void addmodulecase3(String d1) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement CashD=driver.findElement(By.cssSelector("[name='cashManagement']"));

        CashD.click();

        CashD.sendKeys(d1);

        WebElement dataadd = driver.findElement(By.cssSelector("[type='submit']"));

        dataadd.click();



    }

    @Test(dataProvider = "data")
    public void addmodulecase4(String d1) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement Desc=driver.findElement(By.cssSelector("[name='cashManagementDescription']"));

        Desc.click();

        Desc.sendKeys(d1);

        WebElement dataadd = driver.findElement(By.cssSelector("[type='submit']"));

        dataadd.click();

 }



    @DataProvider(name = "data")
    public Object[][] data() throws InterruptedException {

        return new Object[][]{

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

    @DataProvider(name="data2")
    public Object[][] delndesdata() {

        return new Object[][]{

                {"fjfdfsjfi", "wijdoijdoj"},
                {"a002-1201", "192391jdnds"},
                {"b23992fffsdf", "IQIAIQJWI"},
                {"dWIQEUDJ     WIIDJJ", "1122aaaaaa!!!!!"},
                {"911111111111111111111111111111111111111", "NVSMCSKDOKKSDKDDKAKDAODKAOPDKWOPQKODSKAPOSDKOPAKDPOKPOWAKDOPSKPD"},
                {"9IEIIRIWODJDJ", "@@@@@@@@@@@@@@@@"},
                {"9VVVVVVVV      111111111", "<><>00001111ASWaaa111!!!!!1***"},
                {"F GGGFG FGFG GFDEED SWSS ", "   NVNNFF     DMCMMDD     DKKDCKC"},
                {"{         1", "FOKDKOEPDKFOOKESDOP"},
                {"dII93R 3E 23E02JEW", "FKDKFOEPDSKOESDOK"},
                {";';;[;[]][[]!!!", "SFIDIFESDIIESDKKDS"}

        };



    }

    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();
    }
}
