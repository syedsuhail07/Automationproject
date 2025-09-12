package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class APIUI_2 extends BaseTest {

    private void verifyAPIDropdown(int apiNumber) {
        test.log(Status.PASS, "Navigating to the API List page.");
        driver.get("https://automationexercise.com/api_list");

        test.log(Status.PASS, "Finding the API " + apiNumber + " title link.");
        WebElement apiTitle = driver.findElement(By.xpath("//a[@href='#collapse" + apiNumber + "']"));

        test.log(Status.PASS, "Finding the API " + apiNumber + " panel.");
        WebElement apiPanel = driver.findElement(By.id("collapse" + apiNumber));

        test.log(Status.PASS, "Verifying the panel is initially collapsed (not displayed).");
        Assert.assertFalse(apiPanel.isDisplayed(),
            "API " + apiNumber + " panel is already displayed before click.");

        test.log(Status.PASS, "Clicking the title to expand the panel.");
        apiTitle.click();

        test.log(Status.PASS, "Waiting for the panel to become visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(apiPanel));

        test.log(Status.PASS, "Verifying the panel is now expanded (displayed).");
        Assert.assertTrue(apiPanel.isDisplayed(),
            "API " + apiNumber + " panel did not open as a dropdown.");
            
        test.log(Status.PASS, "API " + apiNumber + " dropdown functionality verified successfully.");
    }
    
    @Test
    public void verifyAPIDropdown1() {
        verifyAPIDropdown(1);
    }
    
    @Test
    public void verifyAPIDropdown2() {
        verifyAPIDropdown(2);
    }
    
    @Test
    public void verifyAPIDropdown3() {
        verifyAPIDropdown(3);
    }
    
    @Test
    public void verifyAPIDropdown4() {
        verifyAPIDropdown(4);
    }
    
    @Test
    public void verifyAPIDropdown5() {
        verifyAPIDropdown(5);
    }
    
    @Test
    public void verifyAPIDropdown6() {
        verifyAPIDropdown(6);
    }
    
    @Test
    public void verifyAPIDropdown7() {
        verifyAPIDropdown(7);
    }
    
    @Test
    public void verifyAPIDropdown8() {
        verifyAPIDropdown(8);
    }
    
    @Test
    public void verifyAPIDropdown9() {
        verifyAPIDropdown(9);
    }

    @Test
    public void verifyAPIDropdown10() {
        verifyAPIDropdown(10);
    }

    @Test
    public void verifyAPIDropdown11() {
        verifyAPIDropdown(11);
    }

    @Test
    public void verifyAPIDropdown12() {
        verifyAPIDropdown(12);
    }

    @Test
    public void verifyAPIDropdown13() {
        verifyAPIDropdown(13);
    }
    
    @Test
    public void verifyAPIDropdown14() {
        verifyAPIDropdown(14);
    }
    

}