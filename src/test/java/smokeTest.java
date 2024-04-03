import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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

        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //Navigate to login form
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
//Check and validate searching(menu)
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
        //Room square meters
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[5]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul[2]/li[2]/label/span")).click();
        driver.findElement(By.xpath("/html/body/div/ul[3]/li[6]/label/span")).click();
        //State of property
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/div/ul/li[1]/a")).click();
        //Search
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul[3]/li[10]/a[2]")).click();

    }
    @Test
    public void webTest4() {
//Check searching and verify(search bar)
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //Interact with search bar
        driver.findElement(By.id("searchFiltersearch_text")).click();
        driver.findElement(By.id("search_text")).sendKeys("butas");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[2]/div/a")).click();
        driver.findElement(By.id("submit_search_button")).click();
        //Verify
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/h1/a/span[1]"));
        boolean displayed = message.isDisplayed();
        String text = message.getText();
        Assert.assertEquals(text, "Butai");
        Assert.assertEquals(displayed, true);

    }
    @Test
    public void webTest5() {
//Create add
        String url = "https://m.aruodas.lt/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //Navigate to the add creation tab
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/ul/li[1]/a/span[1]")).click();
        //Select data from menu
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/ul[1]/li[1]/a/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/ul[2]/li[1]/a/span[2]")).click();
        //Enter data for add
        //County
        driver.findElement(By.id("chooseRegionInput")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/div[6]/div/ul/li[1]")).click();
        //Area
        driver.findElement(By.id("chooseDistrictInput")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/div[7]/div/ul/li[1]")).click();
        //Quartal
        driver.findElement(By.id("chooseQuartalInput")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/div[8]/div/ul/li[2]")).click();
        //Street
        driver.findElement(By.id("chooseStreetInput")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/div[9]/div/ul/li[2]")).click();
        //Uncheck house number box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[1]/div[5]/div[1]/label/span")).click();
        //Uncheck flat number box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[1]/div[6]/div[1]/label/span")).click();
        //Uncheck map box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[1]/div[7]/div/label/span")).click();
        //Uncheck special number box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[2]/div/div[1]/label/span")).click();
        //Insert square meters
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[3]/div[1]/label[2]")).click();
        driver.findElement(By.id("FAreaOverAllValue")).sendKeys("55");
        //Select room count
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[3]/div[2]/div/div/div/div[2]")).click();
        //Insert floor
        driver.findElement(By.id("fieldFFloor")).sendKeys("1");
        driver.findElement(By.id("fieldFHouseHeight")).sendKeys("5");
        //House renovation check box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[3]/div[7]/label[2]")).sendKeys("1990");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[3]/div[8]/div/label/span")).click();
        driver.findElement(By.id("fieldFRenovatedYear")).sendKeys("2010");
        //Building type
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[4]/div[1]/div/div[2]/div/div[2]/div[2]")).click();
        //House furnishing
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/div[2]")).click();
        //House heating check box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[4]/div[4]/div[1]/div/label/span")).click();
        //Price

        driver.findElement(By.id("priceValue")).sendKeys("100000");
        //Phone number insert
        driver.findElement(By.id("fieldphone")).sendKeys("61457992");
        //Insert email
        driver.findElement(By.id("fieldemail")).sendKeys("mrHeisenberg@gmail.com");
        //check box
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[8]/div[4]/div/label/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[8]/div[5]/div/label/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/form/div[1]/div[8]/div[7]/div/label/span")).click();
        //Submit button
        driver.findElement(By.id("formSubmitButton")).click();

    }
    @Test
    public void webTest6() {
//Price calculator
        String url = "https://m.aruodas.lt/ivertinti-buto-kaina/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //Insert information for calculation
        //Address
        driver.findElement(By.id("address")).sendKeys("Rygos gatvė, Vilnius, Vilnius City Municipality");
        //House number
        driver.findElement(By.id("street_number")).sendKeys("46");
        //Building type
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[3]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[3]/span/ul/li[1]")).click();
        //House furnishing
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[4]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[4]/span/ul/li[1]")).click();
        //Square meters
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[5]/input")).sendKeys("55");
        //Number of rooms
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[6]/span/input")).sendKeys("2");
        //Floor
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[7]/span/input")).sendKeys("5");
        //Number of floors
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[8]/span/input")).sendKeys("6");
        //Year when building was finished
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[1]/div/div/div[9]/input")).sendKeys("2020");
        //House heating
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[3]/div[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[3]/div[2]/ul/li[2]/label/span")).click();
        //Email
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/form/div[5]/div[1]/div/input")).sendKeys("gedas3131@gmail.com");
        //Submit
        driver.findElement(By.id("submitEvaluateButton")).click();

    }
    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        // Close Browser
        driver.quit();
    }
}
