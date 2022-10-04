package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomepagePage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {

    private String baseURL = "https://vue-demo.daniel-avellaneda.com";
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    protected HomepagePage homepagePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milla\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        homepagePage = new HomepagePage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
    }

    public BaseTest() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
