package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage{

    private By homeButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]");
    private By aboutButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signupButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By themeButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/div[1]");
    private By languageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");

    public Homepage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
    }

    public WebElement getAboutButton() {
        return getDriver().findElement(aboutButton);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getSignupButton() {
        return getDriver().findElement(signupButton);
    }

    public WebElement getThemeButton() {
        return getDriver().findElement(themeButton);
    }

    public WebElement getLanguageButton() {
        return getDriver().findElement(languageButton);
    }
}
