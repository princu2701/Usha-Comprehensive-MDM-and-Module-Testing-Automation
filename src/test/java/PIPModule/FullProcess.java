package PIPModule;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class FullProcess {

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

    }

    @Test(dataProvider = "datacheckings")
    public void case1(String pt){

        WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

        PurchaseType.sendKeys(pt);
        }

        @Test
        public void case2(){

            WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

            PurchaseType.sendKeys("Domestic");

            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();
        }

        @Test
        public void case3(){

            WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

            PurchaseType.sendKeys("Domestic");

            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();

           WebElement AllOPtionsCheck=driver.findElement(By.cssSelector("[aria-label='Select all rows']"));

           AllOPtionsCheck.click();


        }

        @Test
        public void case4() throws InterruptedException {

           Thread.sleep(2000);

            WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

            PurchaseType.sendKeys("Imported");

            Thread.sleep(1000);
            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();

            Thread.sleep(1000);

            WebElement PurchaseType2= driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

            PurchaseType2.sendKeys("Imported - 2");

            Thread.sleep(1000);

            WebElement SearchButton2=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton2.click();

            Thread.sleep(1000);

        }

        @Test(dataProvider = "datacheckings")
        public void case5(String Invalid) throws InterruptedException {

            WebElement PurchaseType = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[1]"));

            PurchaseType.sendKeys(Invalid);

            Thread.sleep(500);

            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();
        }

        @Test(dataProvider = "data2")
        public void case6(String data1,String data2) throws InterruptedException {

            WebElement VendorCode = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[2]"));

            VendorCode.sendKeys(data1);

            Thread.sleep(500);

            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();

            WebElement VendorName = driver.findElement(By.xpath("(//*[@placeholder='Enter'])[3]"));

            VendorName.sendKeys(data2);

            Thread.sleep(500);

            SearchButton.click();


        }

        @Test
        public void case7(){

            WebElement SearchButton=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

            SearchButton.click();

          WebElement Firstoption=driver.findElement(By.xpath("(//*[@title='SHRIRAM PISTON & RINGS LTD.'])[1]"));

          Firstoption.click();

          WebElement materialpagesearch=driver.findElement(By.xpath("(//*[@type='submit'])[3]"));

          materialpagesearch.click();

          WebElement materialselection=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));

          materialselection.click();

          for (int i=0;i<=20;i++){

              materialpagesearch.click();
 }

          WebElement singleelement=driver.findElement(By.cssSelector("[title='5121022110']"));

          singleelement.click();

}

        @Test
        public void case8() throws InterruptedException {

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

    @Test
    public void case9() throws InterruptedException {

        case8();

        WebElement singlec = driver.findElement(By.xpath("(//*[@aria-haspopup='listbox'])[1]"));

        singlec.click();

        Thread.sleep(1000);

        List<WebElement> Currencycheck = driver.findElements(By.cssSelector("[role='option']"));

        for (WebElement Currency:Currencycheck){

            Thread.sleep(1000);

            Currency.click();

        }

    }



        @Test(dataProvider = "datacheckings")
        public void case10(String fetcher) throws InterruptedException {

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

            WebElement specifications=driver.findElement(By.cssSelector("[placeholder='Enter Specifications']"));

            specifications.sendKeys(fetcher);

            WebElement draws=driver.findElement(By.cssSelector("[placeholder='Enter Drawing No']"));

            draws.sendKeys(fetcher);

            WebElement product=driver.findElement(By.cssSelector("[placeholder='Enter Product Model']"));

            product.sendKeys(fetcher);


        }



    @DataProvider(name = "datacheckings")
    public Object[][] purchasedata(){

        return new Object[][]{

                {"1211o010"},
                {"awdsjiadsijwdi"},
                {"912901291002"},
                {"ijeijds!!!!!"},
                {"lsd!!;;;122"},
                {"   vvv   vvvv   "},
                {" 7v 0 022 203920"}

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
    @AfterMethod
    public void teardown() throws InterruptedException {

        Thread.sleep(1500);
        driver.quit();

    }


}
