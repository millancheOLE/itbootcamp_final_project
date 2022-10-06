package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTest extends BaseTest {

    @Test (priority = 1)
    public void test1_verifyCitiesURL(){

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        validLogin();

        Actions action = new Actions(getDriver());

        WebElement adminCategory = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        action.moveToElement(adminCategory).click().build().perform();

        WebElement citiesItem = getDriver().findElement(By.className("btnAdminCities"));
        action.moveToElement(citiesItem).click().build().perform();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);

        WebElement logoutButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));

        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Test (priority = 2, dependsOnMethods = "test1_verifyCitiesURL")
    public void test2_createNewCity(){

        Actions action = new Actions(getDriver());

        WebElement adminCategory = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        action.moveToElement(adminCategory).click().build().perform();

        WebElement citiesItem = getDriver().findElement(By.className("btnAdminCities"));
        action.moveToElement(citiesItem).click().build().perform();

        WebElement newItemButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button"));
        newItemButton.click();

        WebElement nameTextPlaceholder = getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        nameTextPlaceholder.sendKeys(faker.address().city());

        WebElement saveButton = getDriver().findElement(By.className("btnSave"));
        saveButton.click();

        WebElement saveMessage = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(saveMessage.isDisplayed());
    }

    @Test (priority = 3, dependsOnMethods = "test1_verifyCitiesURL")
    public void test3_editCreatedCity(){

        Actions action = new Actions(getDriver());

        WebElement adminCategory = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        action.moveToElement(adminCategory).click().build().perform();

        WebElement citiesItem = getDriver().findElement(By.className("btnAdminCities"));
        action.moveToElement(citiesItem).click().build().perform();

        WebElement editButton = getDriver().findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/button[1]"));
        editButton.click();

        WebElement nameTextPlaceholder = getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nameTextPlaceholder.sendKeys(nameTextPlaceholder.getText() + " - edited");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement saveButton = getDriver().findElement(By.className("btnSave"));
        saveButton.click();


    }
}
