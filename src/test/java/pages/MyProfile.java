package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile extends BasePage {

    private By emailField = By.id("email");
    private By nameField = By.id("name");
    private By phoneField = By.id("phone");
    private By cityField = By.id("city");
    private By countryField = By.id("country");
    private By twitterField = By.id("urlTwitter");
    private By gitHubField = By.id("urlGitHub");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    public MyProfile(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCountryField() {
        return getDriver().findElement(countryField);
    }

    public WebElement getTwitterField() {
        return getDriver().findElement(twitterField);
    }

    public WebElement getGitHubField() {
        return getDriver().findElement(gitHubField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }
}
