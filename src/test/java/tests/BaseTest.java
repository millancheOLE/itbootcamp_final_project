package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;
import java.time.Duration;

public abstract class BaseTest {

    private String baseURL = "https://vue-demo.daniel-avellaneda.com";
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    protected HomepagePage homepagePage;
    protected LoginPage loginPage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCitiesPage;
    protected HomePage home;
    protected MyProfile myProfile;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milla\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homepagePage = new HomepagePage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        signUpPage = new SignUpPage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
        home = new HomePage(driver, webDriverWait);
        myProfile = new MyProfile(driver, webDriverWait);
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
    public void beforeMethod() {
        driver.get(baseURL);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
