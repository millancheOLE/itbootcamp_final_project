package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test (priority = 1)
    public void test1_verifyLoginURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 2)
    public void test2_verifyInputFieldValues(){
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        String actualResultEmail = attributeEmail.getAttribute("type");
        WebElement attributePassword = getDriver().findElement(By.id("password"));
        String actualResultPassword = attributePassword.getAttribute("type");

        Assert.assertEquals(actualResultEmail, expectedResultEmail);
        Assert.assertEquals(actualResultPassword, expectedResultPassword);
    }

    @Test (priority = 3)
    public void test3_verifyLoginErrorInvalidData(){
        String expectedResultMessage = "User does not exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        String email = faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com";
        String password = email + "123@";

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        loginPage.getLoginButton().click();

        WebElement errorBox = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));

        Assert.assertTrue(errorBox.isDisplayed());

        WebElement actualResultMessage = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul"));

        Assert.assertEquals(actualResultMessage.getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test (priority = 4)
    public void test4_verifyLoginErrorInvalidPassword() {
        String expectedResultMessage = "Wrong password";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        String email = "admin@admin.com";
        String password = faker.color().name() + faker.cat().name() + faker.number().digit();

        getDriver().manage().deleteAllCookies();

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        loginPage.getLoginButton().click();

        WebElement errorBox = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        Assert.assertTrue(errorBox.isDisplayed());

        WebElement errorMessage = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(errorMessage.getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test
    public void test5_verifyLoginValidData(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        String email = "admin@admin.com";
        String password = "12345";

        getDriver().manage().deleteAllCookies();

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        loginPage.getLoginButton().click();
        getWebDriverWait().until(ExpectedConditions.urlMatches(expectedResult));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }
}
