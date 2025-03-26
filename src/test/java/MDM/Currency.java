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

public class Currency {

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[.='Currency'])[3]")));

        Thread.sleep(300);

        driver.findElement(By.xpath("(//*[.='Currency'])[3]")).click();


    }


    @Test
    public void addmodulecase1() throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement DistributionChannel=driver.findElement(By.xpath("(//*[@placeholder='Search and select'])[1]"));

        DistributionChannel.click();

        WebElement selectall=driver.findElement(By.xpath("//*[.='Select All']"));

        selectall.click();

        WebElement dataaddbutton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbutton.click();
    }

    @Test(dataProvider = "data2")
    public void addmodulecase2(String d1 , String d2) throws InterruptedException {

        WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

        AddButton.click();

        Thread.sleep(500);

        WebElement Currency = driver.findElement(By.name("currency"));

        Currency.click();

        Currency.sendKeys(d1);

        WebElement desc = driver.findElement(By.name("currencyDescription"));

        desc.click();

        desc.sendKeys(d2);

        WebElement dataaddbutton = driver.findElement(By.cssSelector("[type='submit']"));

        dataaddbutton.click();

}



      @Test(dataProvider = "data")
      public void addmodulecase4(String d1) throws InterruptedException {

          WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

          AddButton.click();

          Thread.sleep(500);

          WebElement Currency = driver.findElement(By.name("currency"));

          Currency.click();

          Currency.sendKeys(d1);

          WebElement dataaddbutton = driver.findElement(By.cssSelector("[type='submit']"));

          dataaddbutton.click();


      }

      @Test
      public void addmodulecase5() throws InterruptedException {

          WebElement AddButton = driver.findElement(By.cssSelector("[data-testid='AddIcon']"));

          AddButton.click();

          Thread.sleep(500);

          WebElement dataaddbutton = driver.findElement(By.cssSelector("[type='submit']"));

          dataaddbutton.click();

          WebElement Currency = driver.findElement(By.name("currency"));

          Currency.click();

          Currency.sendKeys("asasaha");

          WebElement desc = driver.findElement(By.name("currencyDescription"));

          desc.click();

          desc.sendKeys("asasukasjdajdasd");

          dataaddbutton.click();

          Thread.sleep(500);


          if (!(Currency.getAttribute("id").isEmpty())){

              Currency.sendKeys(Keys.CONTROL+"a");

              Currency.sendKeys(Keys.DELETE);

          }

          dataaddbutton.click();

          Thread.sleep(500);

          dataaddbutton.click();

          Thread.sleep(500);

          if (!(desc.getAttribute("id").isEmpty())){

              desc.sendKeys(Keys.CONTROL+"a");

              desc.sendKeys(Keys.DELETE);

          }

          Thread.sleep(500);

          dataaddbutton.click();


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

        Thread.sleep(500);

        driver.quit();

    }



}
