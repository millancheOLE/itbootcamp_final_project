package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By emailInputField = By.xpath("//*[@id=\"email\"]");
    private By passwordInputField = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By forgotPassword = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[4]/a");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    private By errorMessageText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

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

    public WebElement getErrorMessage() {
        return getDriver().findElement(errorMessage);
    }

    public WebElement getErrorMessageText() {
        return getDriver().findElement(errorMessageText);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public void logoutFromPage(){
        getLogoutButton().click();
    }

    public void createFakerCredentialsRandom() {
        String email = faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com";
        String password = email + "123@";

        getEmailInputField().sendKeys(email);
        getPasswordInputField().sendKeys(password);
    }

    public void createFakerCredentialsWrongPassword(){
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(loginButton));

        String email = "admin@admin.com";
        String password = faker.color().name() + faker.cat().name() + faker.number().digit();

        getEmailInputField().sendKeys(email);
        getPasswordInputField().sendKeys(password);
    }

    public void validAdminLogin(){
        String email = "admin@admin.com";
        String password = "12345";

        getEmailInputField().sendKeys(email);
        getPasswordInputField().sendKeys(password);
    }
}
