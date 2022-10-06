package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test (priority = 1)
    public void test1_verifyLoginURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 2)
    public void test2_verifyInputFieldValues(){
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), expectedResultEmail);
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), expectedResultPassword);
    }

    @Test (priority = 3)
    public void test3_verifyLoginErrorInvalidData(){
        String expectedResultMessage = "User does not exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.createFakerCredentialsRandom();
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test (priority = 4)
    public void test4_verifyLoginErrorInvalidPassword() {
        String expectedResultMessage = "Wrong password";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.createFakerCredentialsWrongPassword();
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test (priority = 5)
    public void test5_verifyLoginValidData(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();

        getWebDriverWait().until(ExpectedConditions.urlMatches(expectedResult));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 6, dependsOnMethods = "test5_verifyLoginValidData")
    public void test6_verifyLogout(){
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String setURL = "https://vue-demo.daniel-avellaneda.com/home";

        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());

        loginPage.getLogoutButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);

        getDriver().get(setURL);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }
}
