package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LocaleTest extends BaseTest{

    @Test(priority = 1)
    public void test1_verifySetLanguageToES(){
        String expectedResult = "Página de aterrizaje";

        homepagePage.getLanguageButton().click();

        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]")));

        /*List<WebElement> languageList = getDriver().findElements(By.xpath("//*[@id=\"app\"]/div[2]/div"));

        for (int i = 0; i < languageList.size(); i++) {
            System.out.println(languageList.get(i).getText());
        }*/

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        homepagePage.changeLanguage("ES");

        String actualResult = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

}
