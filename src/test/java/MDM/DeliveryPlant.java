package MDM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import java.time.Duration;
import java.util.List;

public class DeliveryPlant {

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

        driver= new ChromeDriver();

        driver.get("https://bizflowqa.usha.com/#/login");

        driver.manage().window().maximize();

        wait= new WebDriverWait(driver, Duration.ofSeconds(10));

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Delivery Plant'])[3]")));

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='Delivery Plant'])[3]")).click();


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

        Assert.assertEquals(MDMName, "Delivery Plant");

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

    @Test(dataProvider = "data")
    public void search(String searchData) {
        try {

            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));

            searchInput.clear();


            //We can use if condition when clear don't works.
            if (!searchInput.getAttribute("placeholder").isEmpty()) {

                searchInput.sendKeys(Keys.CONTROL+"a");

                searchInput.sendKeys(Keys.DELETE);

            }


            // Enter new search data
            searchInput.sendKeys(searchData);

            // Wait for potential auto-suggestions or results
            wait.until(ExpectedConditions.textToBePresentInElementValue(searchInput, searchData));

            System.out.println("Search input contains: " + searchInput.getAttribute("value"));

        } catch (Exception e) {

            System.err.println("Error occurred during search: " + e.getMessage());

        }


    }

    @Test
    public void addmodulecase1() throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        WebElement plantname= driver.findElement(By.cssSelector("[name='deliveryPlant']"));

        plantname.click();

        plantname.sendKeys("Valid Here");

       WebElement desc=driver.findElement(By.cssSelector("[name='deliveryPlantDescription']"));

       desc.click();

       desc.sendKeys("ValidDescription");

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        Thread.sleep(1000);

        WebElement deleteentereddata = driver.findElement(By.xpath("(//*[@data-testid='DeleteIcon'])[1]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-testid='DeleteIcon'])[1]")));

        deleteentereddata.click();

        WebElement finaldeletion = driver.findElement(By.cssSelector("[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(finaldeletion));

        finaldeletion.click();




    }

    @Test(dataProvider = "data")
    public void addnewmodulecase2(String data) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        WebElement plantname= driver.findElement(By.cssSelector("[name='deliveryPlant']"));

        plantname.click();

        plantname.sendKeys(data);

        WebElement desc=driver.findElement(By.cssSelector("[name='deliveryPlantDescription']"));

        desc.click();

        desc.sendKeys(data);

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        Thread.sleep(1000);

        WebElement deleteentereddata = driver.findElement(By.xpath("(//*[@data-testid='DeleteIcon'])[1]"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-testid='DeleteIcon'])[1]")));

        deleteentereddata.click();

        WebElement finaldeletion = driver.findElement(By.cssSelector("[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(finaldeletion));

        finaldeletion.click();


    }

    @Test(dataProvider = "data")
    public void addmodulecase3(String data) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        WebElement plantname= driver.findElement(By.cssSelector("[name='deliveryPlant']"));

        plantname.click();

        plantname.sendKeys(data);

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        Thread.sleep(1000);

//        WebElement deleteentereddata = driver.findElement(By.xpath("(//*[@data-testid='DeleteIcon'])[1]"));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-testid='DeleteIcon'])[1]")));
//
//        deleteentereddata.click();

//        WebElement finaldeletion = driver.findElement(By.cssSelector("[type='submit']"));
//
//        wait.until(ExpectedConditions.visibilityOf(finaldeletion));
//
//        finaldeletion.click();

    }

    @Test(dataProvider = "data")
    public void addmodulecase4(String data) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        WebElement desc=driver.findElement(By.cssSelector("[name='deliveryPlantDescription']"));

        desc.click();

        desc.sendKeys(data);

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        Thread.sleep(1000);

//        WebElement deleteentereddata = driver.findElement(By.xpath("(//*[@data-testid='DeleteIcon'])[1]"));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-testid='DeleteIcon'])[1]")));
//
//        deleteentereddata.click();

//        WebElement finaldeletion = driver.findElement(By.cssSelector("[type='submit']"));
//
//        wait.until(ExpectedConditions.visibilityOf(finaldeletion));
//
//        finaldeletion.click();
    }

    @Test
    public void addmodulecase5() throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement SalesOffice = driver.findElement(By.cssSelector("[aria-autocomplete='list']"));

        SalesOffice.click();

        WebElement gurgaonoption=driver.findElement(By.xpath("(//*[.='UHRG - Gurgaon'])[2]"));

        gurgaonoption.click();

        Thread.sleep(500);

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

        WebElement dataaddbtton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbtton.click();

        WebElement plantname= driver.findElement(By.cssSelector("[name='deliveryPlant']"));

        plantname.click();

        plantname.sendKeys("Valid Here");

        WebElement desc=driver.findElement(By.cssSelector("[name='deliveryPlantDescription']"));

        desc.click();

        desc.sendKeys("ValidDescription");

        WebElement dataaddbtton2 = driver.findElement(By.cssSelector("[type='submit']"));

        Thread.sleep(1000);

        dataaddbtton2.click();

         System.out.println("Add button has been pressed");

        // Add button is not working here
        //messagge is not displayed here



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

    @DataProvider(name="data2")
    public Object[][] delndesdata() {

        return new Object[][]{

                {"fjfdfsjfi", "wijdoijdoj"},
                {"1002-1201", "192391jdnds"},
                {"923992fffsdf", "IQIAIQJWI"},
                {"HWIQEUDJ     WIIDJJ", "1122aaaaaa!!!!!"},
                {"111111111111111111111111111111111111111", "NVSMCSKDOKKSDKDDKAKDAODKAOPDKWOPQKODSKAPOSDKOPAKDPOKPOWAKDOPSKPD"},
                {"WIEIIRIWODJDJ", "@@@@@@@@@@@@@@@@"},
                {"VVVVVVVVV      111111111", "<><>00001111ASWaaa111!!!!!1***"},
                {"GF GGGFG FGFG GFDEED SWSS ", "   NVNNFF     DMCMMDD     DKKDCKC"},
                {"1         1", "FOKDKOEPDKFOOKESDOP"},
                {"RII93R 3E 23E02JEW", "FKDKFOEPDSKOESDOK"},
                {";';;[;[]][[]!!!", "SFIDIFESDIIESDKKDS"}

        };



    }



    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(1000);

        driver.quit();

    }


}
