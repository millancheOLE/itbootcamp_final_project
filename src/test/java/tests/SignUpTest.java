package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest{

    @Test(priority = 1)
    public void test1_verifySignUpURL(){

        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        homepagePage.getSignupButton().click();
        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 2)
    public void test2_verifyInputFieldValues(){

        String expectedResultName = "text";
        String expectedResultEmail = "email";
        String expectedResultPassword = "password";
        String expectedResultConfirmPassword = "password";

        homepagePage.getSignupButton().click();

        WebElement attributeName = getDriver().findElement(By.id("name"));
        String actualResultName = attributeName.getAttribute("type");

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        String actualResultEmail = attributeEmail.getAttribute("type");

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        String actualResultPassword = attributePassword.getAttribute("type");

        WebElement attributeConfirmPassword = getDriver().findElement(By.id("password"));
        String actualResultConfirmPassword = attributeConfirmPassword.getAttribute("type");

        Assert.assertEquals(actualResultName, expectedResultName);
        Assert.assertEquals(actualResultEmail, expectedResultEmail);
        Assert.assertEquals(actualResultPassword, expectedResultPassword);
        Assert.assertEquals(actualResultConfirmPassword, expectedResultConfirmPassword);
    }

    @Test (priority = 3)
    public void test3_verifyUserCantSignupWithRegistredEmail(){

        String expectedResultUserExists = "E-mail already exists";

        String expectedResultURL = "https://vue-demo.daniel-avellaneda.com/signup";
        String name = faker.name().fullName();
        String email = "admin@admin.com";
        String password = faker.dog().name() + faker.number();
        String confirmPassword = password;

        homepagePage.getSignupButton().click();

        WebElement attributeName = getDriver().findElement(By.id("name"));
        attributeName.sendKeys(name);

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        WebElement attributeConfirmPassword = getDriver().findElement(By.id("confirmPassword"));
        attributeConfirmPassword.sendKeys(confirmPassword);

        WebElement signMeUpButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"));
        signMeUpButton.click();

        WebElement actualResultUserExists = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));

        Assert.assertEquals(actualResultUserExists.getText(), expectedResultUserExists);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultURL);
    }

    @Test (priority = 4)
    public void test4_verifyValidSignUp(){

        String expectedResult = "IMPORTANT: Verify your account";

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@itbootcamp.rs";
        String password = faker.number().digits(10);
        String confirmPassword = password;

        homepagePage.getSignupButton().click();

        WebElement attributeName = getDriver().findElement(By.id("name"));
        attributeName.sendKeys(fullName);

        WebElement attributeEmail = getDriver().findElement(By.id("email"));
        attributeEmail.sendKeys(email);

        WebElement attributePassword = getDriver().findElement(By.id("password"));
        attributePassword.sendKeys(password);

        WebElement attributeConfirmPassword = getDriver().findElement(By.id("confirmPassword"));
        attributeConfirmPassword.sendKeys(confirmPassword);

        WebElement signMeUpButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"));
        signMeUpButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"));

        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
}
