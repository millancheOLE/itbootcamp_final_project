package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By emailInputField = By.xpath("//*[@id=\"email\"]");
    private By passwordInputField = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By forgotPassword = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[4]/a");

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getEmailInputField() {
        return getDriver().findElement(emailInputField);
    }

    public WebElement getPasswordInputField() {
        return getDriver().findElement(passwordInputField);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getForgotPassword() {
        return getDriver().findElement(forgotPassword);
    }
}
