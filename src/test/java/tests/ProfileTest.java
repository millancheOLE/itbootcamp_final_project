package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BaseTest {

    /*
    Signup with random Faker library data. Go to the "My profile" and add data to the empty fields and click "Save" button. Verify that message box
    appears with text "Profile saved successfuly" (there is a typo in the message on the website). Verify that all entered data has the same value from the
    "My profile" form before it was saved.
     */
    @Test
    public void createProfile() {

        homepagePage.getSignupButton().click();
        signUpPage.getNameField().sendKeys(FakerUtil.getRandomFirstName() + " " + FakerUtil.getRandomLastName());
        signUpPage.getEmailField().sendKeys(FakerUtil.getRandomFirstName().toLowerCase() + "." + FakerUtil.getRandomLastName().toLowerCase() + "@itbootcamp.rs");
        signUpPage.getPasswordField().sendKeys(FakerUtil.getRandomPassword());
        signUpPage.getConfirmPasswordField().sendKeys(FakerUtil.getConfirmPassword());
        String expectedResultName = signUpPage.getNameField().getAttribute("value");
        String expectedResultEmail = signUpPage.getEmailField().getAttribute("value");
        signUpPage.getSignMeUpButton().click();
        getWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        home.getCloseButton().click();
        home.getMyProfile().click();

        getWebDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[7]/span/div/div/div[1]/div/label"), "GitHub"));
        myProfile.getPhoneField().sendKeys(FakerUtil.getRandomPhoneNumber());
        myProfile.getCityField().sendKeys("Chicago" + Keys.ENTER);
        myProfile.getCountryField().sendKeys(FakerUtil.getRandomCountry());
        myProfile.getTwitterField().sendKeys("https://twitter.com/" + FakerUtil.getRandomFirstName().toLowerCase());
        myProfile.getGitHubField().sendKeys("https://github.com/" + FakerUtil.getRandomFirstName().toLowerCase());
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
        getDriver().navigate().refresh();
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")));
        Assert.assertEquals(myProfile.getEmailField().getAttribute("value"), expectedResultEmail);
        Assert.assertEquals(myProfile.getNameField().getAttribute("value"), expectedResultName);
        Assert.assertEquals(myProfile.getPhoneField().getAttribute("value"), expectedResultPhone);
        Assert.assertEquals(myProfile.getCityField().getAttribute("value"), expectedResultCity);
        Assert.assertEquals(myProfile.getCountryField().getAttribute("value"), expectedResultCountry);
        Assert.assertEquals(myProfile.getTwitterField().getAttribute("value"), expectedResultTwitter);
        Assert.assertEquals(myProfile.getGitHubField().getAttribute("value"), expectedResultGitHub);
    }
}
