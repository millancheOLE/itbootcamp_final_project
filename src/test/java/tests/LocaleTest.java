package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    /*
    On the homepage, user changes the language to "ES". Verify that the website language changes to spanish and
    that header text displays text "Página de aterrizaje".
     */
    @Test
    public void verifySetLanguageToES() {
        String expectedResult = "Página de aterrizaje";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("ES");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
    On the homepage, user changes the language to "EN". Verify that the website language changes to english and
    that header text displays text "Landing".
     */
    @Test
    public void verifySetLanguageToEN() {
        String expectedResult = "Landing";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("EN");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /*
    On the homepage, user changes the language to "FR". Verify that the website language changes to french and
    that header text displays text "Page d'atterrissage".
     */
    @Test
    public void verifySetLanguageToFR() {
        String expectedResult = "Page d'atterrissage";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("FR");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
