package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    protected Faker faker;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milla\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homepagePage = new HomepagePage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        faker = new Faker();
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

    public void validLogin(){
        String email = "admin@admin.com";
        String password = "12345";

        getDriver().manage().deleteAllCookies();

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        loginPage.getLoginButton().click();
    }

}
