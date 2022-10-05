package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @Test (priority = 1)
    public void test1_verifyCitiesURL(){

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        String email = "admin@admin.com";
        String password = "12345";

        homepagePage.getLoginButton().click();

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        loginPage.getLoginButton().click();
        Actions action = new Actions(getDriver());

        WebElement adminCategory = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        action.moveToElement(adminCategory).click().build().perform();

        WebElement citiesItem = getDriver().findElement(By.xpath("/html/body/div/div[3]/div/a[1]/div[2]"));
        action.moveToElement(citiesItem).click().build().perform();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);

        WebElement logoutButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));

        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
