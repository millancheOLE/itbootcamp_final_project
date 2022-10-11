package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @Test
    public void verifyCitiesURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();
        adminCitiesPage.navigateToAdminCities();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }

    @Test (dependsOnMethods = "verifyCitiesURL")
    public void verifyCreateNewCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getNewItemButton().click();
        adminCitiesPage.getNameTextPlaceholder().sendKeys(faker.address().city());
        adminCitiesPage.getSaveButton().click();

        boolean savedSuccessfullyMessage = getDriver().findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Saved successfully");

        Assert.assertTrue(savedSuccessfullyMessage);
    }

    @Test (dependsOnMethods = "verifyCitiesURL")
    public void verifyEditCreatedCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getNameTextPlaceholder().sendKeys(adminCitiesPage.getNameTextPlaceholder().getText() + " - edited");
        adminCitiesPage.getSaveButton().click();

        getWebDriverWait().until(ExpectedConditions.textToBe
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully\nCLOSE"));

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(" - edited"));
        boolean savedSuccessfullyMessage = getDriver().findElement
                (By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Saved successfully");
        Assert.assertTrue(savedSuccessfullyMessage);
    }

    @Test (dependsOnMethods = "verifyEditCreatedCity")
    public void verifySearchCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getSearchBar().sendKeys(adminCitiesPage.getCityName().getText());
        adminCitiesPage.getSearchBar().sendKeys(Keys.ENTER);

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(" - edited"));
    }

    @Test (dependsOnMethods = "verifyCitiesURL")
    public void verifyDeleteCity() {

        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getSearchBar().sendKeys(adminCitiesPage.getCityName().getText());

        Assert.assertTrue(adminCitiesPage.getCityName().isDisplayed());
        getWebDriverWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr"),1));
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