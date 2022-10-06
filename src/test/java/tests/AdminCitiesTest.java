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

        navigateToAdminCities();

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

        navigateToAdminCities();

        WebElement editButton = getDriver().findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/button[1]"));
        editButton.click();

        WebElement nameTextPlaceholder = getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement cityName = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));

        String currentCityName = cityName.getText();
        String changeCityName = nameTextPlaceholder.getText() + " - edited";
        String editedCityName = currentCityName + " - edited";

        nameTextPlaceholder.sendKeys(changeCityName);

        WebElement saveButton = getDriver().findElement(By.className("btnSave"));
        saveButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(cityName.getText(), editedCityName);

        WebElement dialogMessage = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(dialogMessage.isDisplayed());
    }

    @Test (priority = 4, dependsOnMethods = "test3_editCreatedCity")
    public void test4_searchCity(){

        navigateToAdminCities();

        WebElement cityName = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
        WebElement searchBar = getDriver().findElement(By.xpath("//*[@id=\"search\"]"));
        searchBar.sendKeys(cityName.getText());
        searchBar.sendKeys(Keys.ENTER);
        WebElement cityNameAfterEdit = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));

        Assert.assertEquals(cityNameAfterEdit.getText(), cityName.getText());
    }


}
