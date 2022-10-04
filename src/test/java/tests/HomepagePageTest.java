package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomepagePageTest extends BaseTest {

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
}
