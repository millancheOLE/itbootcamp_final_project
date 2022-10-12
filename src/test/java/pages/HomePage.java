package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By closeButton = By.className("btnClose");
    private By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getCloseButton() {
        return getDriver().findElement(closeButton);
    }

    public WebElement getMyProfile() {
        return getDriver().findElement(myProfile);
    }
}
