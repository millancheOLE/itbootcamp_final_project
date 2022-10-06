package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{

    private By searchBar = By.xpath("//*[@id=\"search\"]");
    private By editButton = By.xpath("//*[@id=\"edit\"]");
    private By nameTextPlaceholder = By.xpath("//*[@id=\"name\"]");

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
}
