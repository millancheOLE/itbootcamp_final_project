package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{

    @Test (priority = 1)
    public void test1_createProfile(){

        homepagePage.getSignupButton().click();
        signUpPage.verifySignUpWithValidCredentials();
        String expectedResultName = signUpPage.getNameField().getAttribute("value");
        String expectedResultEmail = signUpPage.getEmailField().getAttribute("value");
        signUpPage.getSignMeUpButton().click();
        getWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        home.getCloseButton().click();
        home.getMyProfile().click();

        myProfile.fillMyProfileFormFaker();
        String expectedResultPhone = myProfile.getPhoneField().getAttribute("value");
        String expectedResultCity = myProfile.getCityField().getAttribute("value");
        String expectedResultCountry = myProfile.getCountryField().getAttribute("value");
        String expectedResultTwitter = myProfile.getTwitterField().getAttribute("value");
        String expectedResultGitHub = myProfile.getGitHubField().getAttribute("value");

        myProfile.getSaveButton().click();

        getWebDriverWait().until(ExpectedConditions.textToBe
                (By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"), "Profile saved successfuly\nCLOSE"));

        boolean profileSavedSuccessfullyMessage = getDriver().findElement
                (By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText().contains("Profile saved successfuly");

        Assert.assertTrue(profileSavedSuccessfullyMessage);
        Assert.assertEquals(myProfile.getEmailField().getAttribute("value"), expectedResultEmail);
        Assert.assertEquals(myProfile.getNameField().getAttribute("value"), expectedResultName);
        Assert.assertEquals(myProfile.getPhoneField().getAttribute("value"), expectedResultPhone);
        Assert.assertEquals(myProfile.getCityField().getAttribute("value"), expectedResultCity);
        Assert.assertEquals(myProfile.getCountryField().getAttribute("value"), expectedResultCountry);
        Assert.assertEquals(myProfile.getTwitterField().getAttribute("value"), expectedResultTwitter);
        Assert.assertEquals(myProfile.getGitHubField().getAttribute("value"), expectedResultGitHub);



    }

}
