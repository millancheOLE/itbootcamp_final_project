package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomepagePage extends BasePage{

    private By homeButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]");
    private By aboutButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signupButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By themeButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/div[1]");
    private By languageButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button");

    public HomepagePage(WebDriver driver, WebDriverWait webDriverWait) {
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

    public void changeLanguage(String languageID) {
        List<WebElement> languageList = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div[2]/div"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < languageList.size(); i++) {
            if (languageList.get(i).getText().contains(languageID.toUpperCase())) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                languageList.get(i).click();
                System.out.println("Usao u IF");
            }
        }
    }
}
