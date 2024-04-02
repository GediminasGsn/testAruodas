import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class smokeTest {
    private WebDriver driver;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser) {
        // Create driver
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            default:
                System.out.println("Do not know how to start " + browser + ", starting chrome instead");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        System.out.println("Page is opened");
    }
    @Test
    public void webTest0() {
//Open the web site (cookies)
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    @Test
    public void webTest1() {
//Create new profile
        //Navigate to the sign up form
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/ul/li[5]/a/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/a[2]")).click();
        //Input sign up data
        driver.findElement(By.id("userName")).sendKeys("Marmadukas@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Marmaduka5");
        //Submit
        driver.findElement(By.id("registerButton")).click();
        //Verify button
        driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();

    }
    @Test
    public void webTest2() {
//Log in with new profile information
        //Navigate to log in form
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/ul/li[5]/a/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/ul[1]/li[2]/a")).click();
        //Insert log in data
        driver.findElement(By.id("userName")).sendKeys("Marmadukas@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Marmaduka5");
        //Submit
        driver.findElement(By.id("loginAruodas")).click();

    }
    @Test
    public void webTest3() {
//Check and validate searching(search bar)
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //interact with searching menu
        //City
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("searchFilterFRegion")).click();
        driver.findElement(By.xpath("/html/body/div/ul[1]/li[4]/a")).click();
        //City region
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul/li[7]")).click();
        //Apply
        driver.findElement(By.id("selectSaveButton")).click();
        //Select street
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul/li[7]")).click();
        //Apply
        driver.findElement(By.id("selectSaveButton")).click();
        //Room quantity
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul[1]/li[3]/label/span")).click();
        driver.findElement(By.xpath("/html/body/div/ul[2]/li[5]/label/span")).click();
        //Room area
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[5]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul[2]/li[2]/label/span")).click();
        driver.findElement(By.xpath("/html/body/div/ul[3]/li[6]/label/span")).click();
        //State of property
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul/li[1]/a")).click();
        //Search
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[10]/a[2]")).click();





    }
}
