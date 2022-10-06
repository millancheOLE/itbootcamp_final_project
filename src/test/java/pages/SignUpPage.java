package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By errorMessageUserExists = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By importantVerifyAccountMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");

    public SignUpPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getSignMeUpButton() {
        return getDriver().findElement(signMeUpButton);
    }

    public WebElement getErrorMessageUserExists() {
        return getDriver().findElement(errorMessageUserExists);
    }

    public WebElement getImportantVerifyAccountMessage() {
        return getDriver().findElement(importantVerifyAccountMessage);
    }

    public void verifyUserCantSignUpWithRegistredEmail(){
        String name = faker.name().fullName();
        String email = "admin@admin.com";
        String password = faker.dog().name() + faker.number();
        String confirmPassword = password;

        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
    }

    public void verifySignUpWithValidCredentials(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@itbootcamp.rs";
        String password = faker.number().digits(10);
        String confirmPassword = password;

        getNameField().sendKeys(fullName);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);
    }
}
