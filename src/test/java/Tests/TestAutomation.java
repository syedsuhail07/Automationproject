package Tests;

import Base.BaseTest;

import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAutomation extends BaseTest {

    String url = "https://automationexercise.com/";

    @Test(priority = 1)
    public void verifyUrlLoads() {
        test.log(Status.PASS, "Navigating to URL: " + url);
        driver.get(url);
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Verifying if the URL contains 'automationexercise.com'.");
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), "URL did not load correctly!");
        
        test.log(Status.PASS, "URL verification passed successfully.");
    }

    @Test(priority = 2)
    public void verifyHomeButton() {
        test.log(Status.PASS, "Navigating to the base URL.");
        driver.get(url);
        
        test.log(Status.PASS, "Finding the 'Home' button.");
        WebElement homeButton = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        
        test.log(Status.PASS, "Clicking the 'Home' button.");
        homeButton.click();

        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'automationexercise.com'.");
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), "Home button did not redirect correctly!");
        
        test.log(Status.PASS, "Home button functionality verified successfully.");
    }

}