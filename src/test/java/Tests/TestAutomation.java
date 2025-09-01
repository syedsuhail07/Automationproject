package Tests;

import com.automationproj.base.*;

import Base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomation extends BaseTest {

    String url = "https://automationexercise.com/";

    @Test(priority = 1)
    public void verifyUrlLoads() {
        driver.get(url);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), "URL did not load correctly!");
    }

    @Test(priority = 2)
    public void verifyHomeButton() {
        driver.get(url);
        WebElement homeButton = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        homeButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), "Home button did not redirect correctly!");
    }
}
