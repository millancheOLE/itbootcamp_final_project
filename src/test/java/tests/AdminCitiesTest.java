package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @Test (priority = 1)
    public void test1_verifyCitiesURL(){
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        homepagePage.getLoginButton().click();
        loginPage.validAdminLogin();
        loginPage.getLoginButton().click();
        adminCitiesPage.navigateToAdminCities();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);
        Assert.assertTrue(adminCitiesPage.getLogoutButton().isDisplayed());
    }

    @Test (priority = 2, dependsOnMethods = "test1_verifyCitiesURL")
    public void test2_createNewCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getNewItemButton().click();
        adminCitiesPage.getNameTextPlaceholder().sendKeys(faker.address().city());
        adminCitiesPage.getSaveButton().click();

        Assert.assertTrue(adminCitiesPage.getSaveMessage().isDisplayed());
    }

    @Test (priority = 3, dependsOnMethods = "test1_verifyCitiesURL")
    public void test3_editCreatedCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getNameTextPlaceholder().sendKeys(adminCitiesPage.getNameTextPlaceholder().getText() + " - edited");
        adminCitiesPage.getSaveButton().click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(" - edited"));
        Assert.assertTrue(adminCitiesPage.getSaveMessage().isDisplayed());
    }

    @Test (priority = 4, dependsOnMethods = "test3_editCreatedCity")
    public void test4_searchCity(){
        adminCitiesPage.navigateToAdminCities();
        adminCitiesPage.getSearchBar().sendKeys(adminCitiesPage.getCityName().getText());
        adminCitiesPage.getSearchBar().sendKeys(Keys.ENTER);

        Assert.assertTrue(adminCitiesPage.getCityName().getText().contains(" - edited"));
    }
}