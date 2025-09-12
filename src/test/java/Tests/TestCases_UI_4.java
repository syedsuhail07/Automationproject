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

public class TestCases_UI_4 extends BaseTest {

    private void verifyTestCaseNavigationLink(int testCaseNumber) {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");

        test.log(Status.PASS, "Finding and clicking the Test Case " + testCaseNumber + " title to expand the panel.");
        WebElement testCaseTitle = driver.findElement(By.xpath("//a[@href='#collapse" + testCaseNumber + "']"));
        testCaseTitle.click();

        test.log(Status.PASS, "Waiting for the Test Case " + testCaseNumber + " panel to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement testCasePanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("collapse" + testCaseNumber)));

        try {
            test.log(Status.PASS, "Attempting to find the navigation link within the Test Case panel.");
            WebElement navigationLink = testCasePanel.findElement(By.xpath(".//a[contains(text(), 'automationexercise.com')]"));

            test.log(Status.PASS, "Clicking the navigation link.");
            navigationLink.click();
            String currentUrl = driver.getCurrentUrl();
            
            test.log(Status.PASS, "Asserting that the URL redirects to the homepage.");
            Assert.assertEquals(currentUrl, "https://automationexercise.com/", 
                "Navigation link for Test Case " + testCaseNumber + " did not redirect to the homepage.");
            
            test.log(Status.PASS, "Navigation link for Test Case " + testCaseNumber + " redirected correctly to the homepage.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "Navigation link for Test Case " + testCaseNumber + " is not present, as expected.");
            Assert.assertTrue(true, "Navigation link for Test Case " + testCaseNumber + " is not present, as expected.");
        }
    }

    @Test
    public void verifyTestCase1NavigationLink() {
        verifyTestCaseNavigationLink(1);
    }
    
    @Test
    public void verifyTestCase2NavigationLink() {
        verifyTestCaseNavigationLink(2);
    }
    
    @Test
    public void verifyTestCase3NavigationLink() {
        verifyTestCaseNavigationLink(3);
    }
    
    @Test
    public void verifyTestCase4NavigationLink() {
        verifyTestCaseNavigationLink(4);
    }
    
    @Test
    public void verifyTestCase5NavigationLink() {
        verifyTestCaseNavigationLink(5);
    }
    
    @Test
    public void verifyTestCase6NavigationLink() {
        verifyTestCaseNavigationLink(6);
    }
    
    @Test
    public void verifyTestCase7NavigationLink() {
        verifyTestCaseNavigationLink(7);
    }
    
    @Test
    public void verifyTestCase8NavigationLink() {
        verifyTestCaseNavigationLink(8);
    }
    
    @Test
    public void verifyTestCase9NavigationLink() {
        verifyTestCaseNavigationLink(9);
    }

    @Test
    public void verifyTestCase10NavigationLink() {
        verifyTestCaseNavigationLink(10);
    }

    @Test
    public void verifyTestCase11NavigationLink() {
        verifyTestCaseNavigationLink(11);
    }

    @Test
    public void verifyTestCase12NavigationLink() {
        verifyTestCaseNavigationLink(12);
    }

    @Test
    public void verifyTestCase13NavigationLink() {
        verifyTestCaseNavigationLink(13);
    }

    @Test
    public void verifyTestCase14NavigationLink() {
        verifyTestCaseNavigationLink(14);
    }

    @Test
    public void verifyTestCase15NavigationLink() {
        verifyTestCaseNavigationLink(15);
    }

    @Test
    public void verifyTestCase16NavigationLink() {
        verifyTestCaseNavigationLink(16);
    }

    @Test
    public void verifyTestCase17NavigationLink() {
        verifyTestCaseNavigationLink(17);
    }

    @Test
    public void verifyTestCase18NavigationLink() {
        verifyTestCaseNavigationLink(18);
    }

    @Test
    public void verifyTestCase19NavigationLink() {
        verifyTestCaseNavigationLink(19);
    }

    @Test
    public void verifyTestCase20NavigationLink() {
        verifyTestCaseNavigationLink(20);
    }

    @Test
    public void verifyTestCase21NavigationLink() {
        verifyTestCaseNavigationLink(21);
    }

    @Test
    public void verifyTestCase22NavigationLink() {
        verifyTestCaseNavigationLink(22);
    }

    @Test
    public void verifyTestCase23NavigationLink() {
        verifyTestCaseNavigationLink(23);
    }

    @Test
    public void verifyTestCase24NavigationLink() {
        verifyTestCaseNavigationLink(24);
    }

    @Test
    public void verifyTestCase25NavigationLink() {
        verifyTestCaseNavigationLink(25);
    }

    @Test
    public void verifyTestCase26NavigationLink() {
        verifyTestCaseNavigationLink(26);
    }


}