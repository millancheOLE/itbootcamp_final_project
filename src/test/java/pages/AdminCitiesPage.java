package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    private By searchBar = By.xpath("//*[@id=\"search\"]");
    private By editButton = By.xpath("//*[@id=\"edit\"]");
    private By nameTextPlaceholder = By.xpath("//*[@id=\"name\"]");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By saveButton = By.className("btnSave");
    private By saveMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By cityName = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteButton = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/button[2]");
    private By deleteButtonWarning = By.xpath("/html/body/div/div[4]/div/div/div[2]/button[2]");

    public AdminCitiesPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getSearchBar() {
        return getDriver().findElement(searchBar);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public WebElement getNameTextPlaceholder() {
        return getDriver().findElement(nameTextPlaceholder);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getNewItemButton() {
        return getDriver().findElement(newItemButton);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSaveMessage() {
        return getDriver().findElement(saveMessage);
    }

    public WebElement getCityName() {
        return getDriver().findElement(cityName);
    }

    public WebElement getDeleteButton() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement getDeleteButtonWarning() {
        return getDriver().findElement(deleteButtonWarning);
    }

    public void navigateToAdminCities() {
        Actions action = new Actions(getDriver());

        WebElement adminCategory = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]"));
        action.moveToElement(adminCategory).click().build().perform();

        WebElement citiesItem = getDriver().findElement(By.className("btnAdminCities"));
        action.moveToElement(citiesItem).click().build().perform();
    }
}
