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

public class TestCasesUI_2 extends BaseTest {

    /**
     * Reusable helper method to verify the dropdown functionality for a specific test case number.
     * @param testCaseNumber The number of the test case to verify.
     */
    private void verifyTestCaseDropdown(int testCaseNumber) throws InterruptedException {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");

        test.log(Status.PASS, "Finding the Test Case " + testCaseNumber + " title link.");
        WebElement testCaseTitle = driver.findElement(By.xpath("//a[@href='#collapse" + testCaseNumber + "']"));

        test.log(Status.PASS, "Finding the collapsible panel for Test Case " + testCaseNumber + ".");
        WebElement testCasePanel = driver.findElement(By.id("collapse" + testCaseNumber));

        test.log(Status.PASS, "Verifying the panel is initially collapsed.");
        Assert.assertFalse(testCasePanel.isDisplayed(),
            "Test Case " + testCaseNumber + " panel is already displayed before click.");

        test.log(Status.PASS, "Clicking the title to expand the panel.");
        testCaseTitle.click();
        Thread.sleep(500); // Wait for the dropdown animation

        test.log(Status.PASS, "Verifying the panel is now expanded.");
        Assert.assertTrue(testCasePanel.isDisplayed(),
            "Test Case " + testCaseNumber + " panel did not open as a dropdown.");
            
        test.log(Status.PASS, "Test Case " + testCaseNumber + " dropdown functionality verified successfully.");
    }

    @Test
    public void verifyTestCase1OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(1);
    }
    
    @Test
    public void verifyTestCase2OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(2);
    }
    
    @Test
    public void verifyTestCase3OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(3);
    }
    
    @Test
    public void verifyTestCase4OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(4);
    }
    
    @Test
    public void verifyTestCase5OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(5);
    }
    
    @Test
    public void verifyTestCase6OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(6);
    }
    
    @Test
    public void verifyTestCase7OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(7);
    }
    
    @Test
    public void verifyTestCase8OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(8);
    }
    
    @Test
    public void verifyTestCase9OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(9);
    }

    @Test
    public void verifyTestCase10OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(10);
    }

    @Test
    public void verifyTestCase11OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(11);
    }

    @Test
    public void verifyTestCase12OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(12);
    }

    @Test
    public void verifyTestCase13OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(13);
    }

    @Test
    public void verifyTestCase14OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(14);
    }

    @Test
    public void verifyTestCase15OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(15);
    }

    @Test
    public void verifyTestCase16OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(16);
    }

    @Test
    public void verifyTestCase17OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(17);
    }

    @Test
    public void verifyTestCase18OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(18);
    }

    @Test
    public void verifyTestCase19OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(19);
    }

    @Test
    public void verifyTestCase20OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(20);
    }

    @Test
    public void verifyTestCase21OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(21);
    }

    @Test
    public void verifyTestCase22OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(22);
    }
    
    @Test
    public void verifyTestCase23OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(23);
    }
    
    @Test
    public void verifyTestCase24OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(24);
    }
    
    @Test
    public void verifyTestCase25OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(25);
    }
    
    @Test
    public void verifyTestCase26OpensAsDropdown() throws InterruptedException {
        verifyTestCaseDropdown(26);
    }
    

}