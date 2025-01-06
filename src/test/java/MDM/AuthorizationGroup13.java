package MDM;

import io.cucumber.java.bs.A;
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

import java.time.Duration;
import java.util.List;

public class AuthorizationGroup13 {

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Authorization'])[3]")));

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='Authorization'])[3]")).click();


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

        Assert.assertEquals(MDMName, "Authorization");

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

        WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));

        Columnfield.click();

        WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));

        filterbutton.click();

        WebElement densityoption = driver.findElement(By.cssSelector("[aria-label='Density']"));

        densityoption.click();

        List<WebElement> densitysizes = driver.findElements(By.cssSelector("[role='menuitem']"));

        for (WebElement size : densitysizes) {

            size.click();

        }

        WebElement exportoption = driver.findElement(By.cssSelector("[aria-label='Export']"));

        exportoption.click();

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

    @Test
    public void adddatacase1() throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        Thread.sleep(500);

        WebElement desc=driver.findElement(By.cssSelector("[name='authorizationDescription']"));

        desc.click();

        desc.sendKeys("ValidDescription");

        WebElement removearea = driver.findElement(By.xpath("(//*[@data-testid='CancelIcon'])"));

        removearea.click();

        Thread.sleep(1000);

        SalesOffice.click();

        WebElement Vjay=driver.findElement(By.xpath("(//*[.='UAPV - Vijayawada'])[2]"));

        Thread.sleep(500);

        Vjay.click();

        Thread.sleep(500);

        WebElement removearea2 = driver.findElement(By.xpath("(//*[@data-testid='CancelIcon'])"));

        removearea2.click();

        Thread.sleep(300);

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        Thread.sleep(1000);

    }




    @Test(dataProvider = "salesOfficeData")
    public void addAndRemoveSalesOffice(String salesOfficeName) throws InterruptedException {

        // Click on the Add button
        WebElement addButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));
        addButton.click();
        Thread.sleep(2000);

        WebElement addbutton1=driver.findElement(By.cssSelector("[type='submit']"));
        addbutton1.click();
        Thread.sleep(2000);

        // Click on the Sales Office dropdown
        WebElement salesOfficeDropdown = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));
        salesOfficeDropdown.click();

        Thread.sleep(500);
        // Select the specified Sales Office
        WebElement salesOfficeOption = driver.findElement(By.xpath("(//*[.='" + salesOfficeName + "'])[2]"));
        salesOfficeOption.click();
        Thread.sleep(500);

        addbutton1.click();
        Thread.sleep(500);

        // Click on the remove icon
        WebElement removeIcon = driver.findElement(By.xpath("(//*[@data-testid='CancelIcon'])"));
        removeIcon.click();
        Thread.sleep(500);

        addbutton1.click();
        Thread.sleep(500);

        // If user is not able to proceed without selecting the sales office then it should be marked as mandatory
        // If User has not selected the sales office then they should the error in the box of it as well , not in the authorization box only

    }

    @Test(dataProvider = "data2")
    public void authorndescriptiontest(String checkingdata, String checkingdata2) throws InterruptedException {

        WebElement addButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));
        addButton.click();
        Thread.sleep(500);

        WebElement AuthorizationBox = driver.findElement(By.cssSelector("[name='authorization']"));
        AuthorizationBox.sendKeys(checkingdata);

        WebElement description= driver.findElement(By.name("authorizationDescription"));
         description.sendKeys(checkingdata2);

        Thread.sleep(500);

        WebElement addbutton1=driver.findElement(By.cssSelector("[type='submit']"));
        addbutton1.click();

        Thread.sleep(200);

        Actions actions= new Actions(driver);

        WebElement salesalert=driver.findElement(By.xpath("(//*[.='Sales Office not found.'])[3]"));

         actions.moveToElement(salesalert).perform();

        WebElement closenotice = driver.findElement(By.cssSelector("[aria-label='close']"));

        closenotice.click();

        // Authorization and description boxes should not accept the invalid/incorrect data
        // Both must have a character limit
        //Error of **Required** text should be shown for all boxes if a user can't proceed without filling all boxes
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

    @DataProvider(name = "data2")
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

    @DataProvider(name = "salesOfficeData")
    public Object[][] provideSalesOfficeData() {
        return new Object[][]{
                {"UHRG - Gurgaon"},
                {"UAPV - Vijayawada"},
                {"UAPS - Secunderabad"},
                {"UDEL - Delhi, Alipur"},
                {"UBHP - Patna"},
                {"UASG - Guwahati"},
                {"UGJA - Aslali, Gomtipur"},
                {"UJHR"}
        };
    }

    @AfterMethod
    public void teardown() throws InterruptedException {



        Thread.sleep(1000);

        driver.quit();

    }
}
