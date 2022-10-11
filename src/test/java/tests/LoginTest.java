package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test
    public void verifyInputFieldValues(){
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), expectedResultEmail);
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), expectedResultPassword);
    }

    @Test
    public void verifyLoginErrorInvalidData(){
        String expectedResultMessage = "User does not exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.createFakerCredentialsRandom();
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test
    public void verifyLoginErrorInvalidPassword() {
        String expectedResultMessage = "Wrong password";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.createFakerCredentialsWrongPassword();
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test
    public void verifyLoginValidData(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();

        getWebDriverWait().until(ExpectedConditions.urlMatches(expectedResult));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);

        loginPage.logoutFromPage();
    }

    @Test (dependsOnMethods = "verifyLoginValidData")
    public void verifyLogout(){
        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";
        String setURL = "https://vue-demo.daniel-avellaneda.com/home";

        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());

        loginPage.logoutFromPage();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);

        getDriver().get(setURL);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }
}
