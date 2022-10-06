package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test(priority = 1)
    public void test1_verifySignUpURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        homepagePage.getSignupButton().click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
    }

    @Test (priority = 2)
    public void test2_verifyInputFieldValues(){
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

    @Test (priority = 3)
    public void test3_verifyUserCantSignupWithRegistredEmail(){
        String expectedResultUserExists = "E-mail already exists";
        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/signup";

        homepagePage.getSignupButton().click();
        signUpPage.verifyUserCantSignUpWithRegistredEmail();
        signUpPage.getSignMeUpButton().click();

        Assert.assertEquals(signUpPage.getErrorMessageUserExists().getText(), expectedResultUserExists);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test (priority = 4)
    public void test4_verifyValidSignUp(){
        String expectedResult = "IMPORTANT: Verify your account";

        homepagePage.getSignupButton().click();
        signUpPage.verifySignUpWithValidCredentials();
        signUpPage.getSignMeUpButton().click();

        getWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

        Assert.assertEquals(signUpPage.getImportantVerifyAccountMessage().getText(), expectedResult);
    }
}
