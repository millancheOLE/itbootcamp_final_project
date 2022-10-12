package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    /*
    After valid admin login, navigate to button Admin in navigation menu, and then click on it's submenu named
    "Cities". Verify that the current webpage URL is on the "/admin/cities/" route (cities page). Verify that logout button is visible.
     */
    @Test
    public void verifyCitiesURL() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();
        adminCitiesPage.navigateToAdminCities();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }

    /*
    After valid admin login, navigate to button Admin in navigation menu, and then click on it's submenu named
    "Cities". Create new randomly generated city using Faker library. Verify that message box appears containing text "Saved successfully".
     */
    @Test(dependsOnMethods = "verifyCitiesURL")
    public void verifyCreateNewCity() {
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getNewItemButton().click();
        adminCitiesPage.getNameTextPlaceholder().sendKeys(FakerUtil.getRandomCity());
        adminCitiesPage.getSaveButton().click();

        boolean savedSuccessfullyMessage = getDriver().findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Saved successfully");

        Assert.assertTrue(savedSuccessfullyMessage);
    }

    /*
    After valid admin login, navigate to button Admin in navigation menu, and then click on it's submenu named "Cities".
    Locate previously created city and edit it with adding the text " - edited" after city name.
    Verify that message box appears containing text "Saved successfully".
     */
    @Test(dependsOnMethods = "verifyCitiesURL")
    public void verifyEditCreatedCity() {
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getNameTextPlaceholder().sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        adminCitiesPage.getNameTextPlaceholder().sendKeys(FakerUtil.getEditedCity());
        adminCitiesPage.getSaveButton().click();

        getWebDriverWait().until(ExpectedConditions.textToBe
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully\nCLOSE"));

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(" - edited"));
        boolean savedSuccessfullyMessage = getDriver().findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Saved successfully");
        Assert.assertTrue(savedSuccessfullyMessage);
    }

    /*
    After valid admin login, navigate to button Admin in navigation menu, and then click on it's submenu named "Cities".
    Locate previously created and edited city. Enter the edited city name in the search bar.
    Verify that in the "Name" column in the first row there is the name of the searched edited city.
     */
    @Test(dependsOnMethods = "verifyEditCreatedCity")
    public void verifySearchCity() {
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getSearchBar().sendKeys(FakerUtil.getEditedCity());
        adminCitiesPage.getSearchBar().sendKeys(Keys.ENTER);

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(FakerUtil.getEditedCity()));
    }

    /*
    After valid admin login, navigate to button Admin in navigation menu, and then click on it's submenu "Cities".
    Locate previously created and edited city. Search the edited city by it's nama. Verify that the edited city is visible. Click on the delete button.
    Wait for the dialog box to appear, and then click on the delete. Verify that the message box appears and that it displays the message "Deleted successfully".
     */
    @Test(dependsOnMethods = "verifySearchCity")
    public void verifyDeleteCity() {

        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getSearchBar().sendKeys(adminCitiesPage.getCityName().getText());

        Assert.assertTrue(adminCitiesPage.getCityName().isDisplayed());
        getWebDriverWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr"), 1));
        adminCitiesPage.getDeleteButton().click();

        getWebDriverWait().until(ExpectedConditions.attributeContains(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]"), "type", "button"));
        adminCitiesPage.getDeleteButtonWarning().click();

        getWebDriverWait().until(ExpectedConditions.textToBe
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));

        boolean deletedSuccessfullyMessage = getDriver().findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Deleted successfully");

        Assert.assertTrue(deletedSuccessfullyMessage);
    }
}