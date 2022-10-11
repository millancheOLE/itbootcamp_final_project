package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest{

    @Test
    public void verifySetLanguageToES(){
        String expectedResult = "Página de aterrizaje";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("ES");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifySetLanguageToEN(){
        String expectedResult = "Landing";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("EN");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifySetLanguageToFR(){
        String expectedResult = "Page d'atterrissage";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        homepagePage.changeLanguage("FR");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
