package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    /*
    Visit login page and verify that current webpage URL is on the "/login" route.
     */
    @Test
    public void verifyLoginURL() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    /*
    Verify that input fields type attributes are "email" and "password".
     */
    @Test
    public void verifyInputFieldValues() {
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";

        homepagePage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"), expectedResultEmail);
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"), expectedResultPassword);
    }

    /*
    Use randomly generated Faker library email and password and verify that message box appears. Verify that
    message text is "User does not exist. Verify that the current webpage URL is still on the "/login" route.
     */
    @Test
    public void verifyLoginErrorInvalidData() {
        String expectedResultMessage = "User does not exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(FakerUtil.getRandomEmail());
        loginPage.getPasswordInputField().sendKeys(FakerUtil.getRandomPassword());
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    /*
    Use admin account credentials email "admin@admin.com" and randomly generated Faker library password for login. Verify that message box
    appears. Verify that displayed message text is "Wrong password". Also verify that the current webpage URL is still on the "/login" route.
     */
    @Test
    public void verifyLoginErrorInvalidPassword() {
        String expectedResultMessage = "Wrong password";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/login";

        homepagePage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys("admin@admin.com");
        loginPage.getPasswordInputField().sendKeys(FakerUtil.getRandomPassword());
        loginPage.getLoginButton().click();

        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedResultMessage);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    /*
    Use admin account credentials email "admin@admin.com" and password "12345" for valid login. Verify that current page URL
    after successful admin login is redirected to the "/home" route.
     */
    @Test
    public void verifyLoginValidData() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();

        getWebDriverWait().until(ExpectedConditions.urlMatches(expectedResult));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);

        loginPage.logoutFromPage();
    }

    /*
    After successful admin login, verify that logout button is visible. Click on the logout button. Verify that
    the current webpage URL after logout is on the "/login" route. Verify that after trying to get to the "/home" route (home page), while
    not logged in, user remains on the "/login" route (login page).
     */
    @Test(dependsOnMethods = "verifyLoginValidData")
    public void verifyLogout() {
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
