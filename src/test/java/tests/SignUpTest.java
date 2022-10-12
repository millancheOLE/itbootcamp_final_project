package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    /*
    Visit login page and verify that current webpage URL is on the "/signup" route (signup page).
     */
    @Test
    public void verifySignUpURL() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        homepagePage.getSignupButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    /*
    Verify that input fields type attributes are values Name = "text", Email = "email", Password = "password" and Confirm Password = "password".
     */
    @Test
    public void verifyInputFieldValues() {
        String expectedResultName = "text";
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        String expectedResultConfirmPassword = "password";

        homepagePage.getSignupButton().click();

        Assert.assertEquals(signUpPage.getNameField().getAttribute("type"), expectedResultName);
        Assert.assertEquals(signUpPage.getEmailField().getAttribute("type"), expectedResultEmail);
        Assert.assertEquals(signUpPage.getPasswordField().getAttribute("type"), expectedResultPassword);
        Assert.assertEquals(signUpPage.getConfirmPasswordField().getAttribute("type"), expectedResultConfirmPassword);
    }

    /*
    Verify that user can't register with already registred admin email "admin@admin.com". Verify that message text
    appears "E-mail already exists". Verify that the current webpage URL is still on the "/signup" route (signup page).
     */
    @Test
    public void verifyUserCantSignupWithRegistredEmail() {
        String expectedResultUserExists = "E-mail already exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/signup";

        homepagePage.getSignupButton().click();
        signUpPage.getNameField().sendKeys(FakerUtil.getRandomFullName());
        signUpPage.getEmailField().sendKeys("admin@admin.com");
        signUpPage.getPasswordField().sendKeys(FakerUtil.getRandomPassword());
        signUpPage.getConfirmPasswordField().sendKeys(FakerUtil.getConfirmPassword());
        signUpPage.getSignMeUpButton().click();

        Assert.assertEquals(signUpPage.getErrorMessageUserExists().getText(), expectedResultUserExists);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    /*
    Input data:
    Name: IT Bootcamp randomly generated Faker library student full name
    Email: format = studentFirstName.studentLastName@itbootcamp.rs
    Password: randomly generated Faker library password
    Confirm password: same as the password
    Verify that the user is redirected to the next webpage with message box containing text "IMPORTANT: Verify your account".
     */
    @Test
    public void verifyValidSignUp() {
        String expectedResult = "IMPORTANT: Verify your account";

        homepagePage.getSignupButton().click();
        signUpPage.getNameField().sendKeys(FakerUtil.getRandomFirstName() + " " + FakerUtil.getRandomLastName());
        signUpPage.getEmailField().sendKeys(FakerUtil.getRandomEmailFaker());
        signUpPage.getPasswordField().sendKeys(FakerUtil.getRandomPassword());
        signUpPage.getConfirmPasswordField().sendKeys(FakerUtil.getConfirmPassword());
        signUpPage.getSignMeUpButton().click();

        getWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

        Assert.assertEquals(signUpPage.getImportantVerifyAccountMessage().getText(), expectedResult);
    }
}
