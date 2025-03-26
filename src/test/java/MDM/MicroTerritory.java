package MDM;

import io.cucumber.java.en_old.Ac;
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

public class MicroTerritory {


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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Micro Territory'])[3]")));

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='Micro Territory'])[3]")).click();


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

        Assert.assertEquals(MDMName, "Micro Territory SAP");

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
    public void Scenario2() throws InterruptedException {

        WebElement Columnfield = driver.findElement(By.cssSelector("[aria-label='Select columns']"));

        Columnfield.click();

        WebElement filterbutton = driver.findElement(By.cssSelector("[aria-label='Show filters']"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-label='Show filters']")));

        filterbutton.click();

        WebElement densityoption = driver.findElement(By.cssSelector("[aria-label='Density']"));

        densityoption.click();

        List<WebElement> densitysizes = driver.findElements(By.cssSelector("[role='menuitem']"));

        for (WebElement size : densitysizes) {

            Thread.sleep(500);

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
    public void optionscase1(){

        Actions actions = new Actions(driver);

        WebElement target=driver.findElement(By.xpath("(//*[@class='MuiDataGrid-columnHeaderTitle css-mh3zap'])[1]"));

        actions.moveToElement(target).build().perform();

        WebElement opt=driver.findElement(By.xpath("(//*[@data-testid='TripleDotsVerticalIcon'])[1]"));

        opt.click();

        WebElement ascending=driver.findElement(By.xpath("(//*[.='Sort by ASC'])[2]"));

        ascending.click();

        actions.moveToElement(target).build().perform();

        opt.click();

        WebElement descending=driver.findElement(By.xpath("(//*[.='Sort by DESC'])[2]"));

        descending.click();

        actions.moveToElement(target).build().perform();

        opt.click();

        WebElement unsortbutton=driver.findElement(By.xpath("(//*[.='Unsort'])[2]"));

        unsortbutton.click();

        String defaultassertion=driver.findElement(By.cssSelector("[title='9707810178']")).getText();

        Assert.assertEquals(defaultassertion,"9707810178");

    }

    @Test
    public void optionscase2(){

        WebElement microtext=driver.findElement(By.xpath("(//*[@class='MuiDataGrid-columnHeaderTitle css-mh3zap'])[2]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(microtext).build().perform();

        WebElement opt=driver.findElement(By.xpath("(//*[@data-testid='TripleDotsVerticalIcon'])[2]"));

        opt.click();

        WebElement ascending=driver.findElement(By.xpath("(//*[.='Sort by ASC'])[2]"));

        ascending.click();

        actions.moveToElement(microtext).build().perform();

        opt.click();

        WebElement descending=driver.findElement(By.xpath("(//*[.='Sort by DESC'])[2]"));

        descending.click();

        actions.moveToElement(microtext).build().perform();

        opt.click();

        WebElement unsortbutton=driver.findElement(By.xpath("(//*[.='Unsort'])[2]"));

        unsortbutton.click();

        String defaultassertion=driver.findElement(By.cssSelector("[title='9707810178']")).getText();

        Assert.assertEquals(defaultassertion,"9707810178");

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

        Thread.sleep(1000);

        driver.quit();

    }
}
