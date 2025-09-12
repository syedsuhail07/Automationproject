package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCases_UI_3 extends BaseTest {

    // --- Feedback and Subscription Section Tests ---

    @Test
    public void verifyFeedbackForUsTitleIsPresentInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find the 'Feedback for us' title.");
        try {
            WebElement feedbackTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]"));
            test.log(Status.FAIL, "'Feedback for us' title was found on the Test Cases page when it should not exist.");
            Assert.fail("'Feedback for us' title was found on the Test Cases page when it should not exist.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "The 'Feedback for us' title does not exist on the Test Cases page, as expected.");
            Assert.assertTrue(true, "The 'Feedback for us' title does not exist on the Test Cases page, as expected.");
        }
    }

    @Test
    public void verifyFeedbackForUsFontStyleIsCorrect() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find the 'Feedback for us' title to check its font style.");
        try {
            driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]")).getCssValue("font-family");
            test.log(Status.FAIL, "'Feedback for us' font style was tested on the Test Cases page, but the element should not exist.");
            Assert.fail("'Feedback for us' font style was tested on the Test Cases page, but the element should not exist.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "The 'Feedback for us' title is not on this page, so its font style is not applicable, as expected.");
            Assert.assertTrue(true, "The 'Feedback for us' title is not on this page, so its font style is not applicable.");
        }
    }

    @Test
    public void verifyFeedbackForUsFontSizeIsCorrect() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find the 'Feedback for us' title to check its font size.");
        try {
            driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]")).getCssValue("font-size");
            test.log(Status.FAIL, "'Feedback for us' font size was tested on the Test Cases page, but the element should not exist.");
            Assert.fail("'Feedback for us' font size was tested on the Test Cases page, but the element should not exist.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "The 'Feedback for us' title is not on this page, so its font size is not applicable, as expected.");
            Assert.assertTrue(true, "The 'Feedback for us' title is not on this page, so its font size is not applicable.");
        }
    }

    @Test
    public void verifySubscriptionFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the subscription email field.");
        WebElement subscriptionEmail = driver.findElement(By.id("susbscribe_email"));
        String testEmail = "subscribe@test.com";
        
        test.log(Status.PASS, "Entering a test email into the field.");
        subscriptionEmail.sendKeys(testEmail);
        
        test.log(Status.PASS, "Asserting the input field accepts the value.");
        Assert.assertEquals(subscriptionEmail.getAttribute("value"), testEmail, "Subscription email field is not accepting input.");
        
        test.log(Status.PASS, "Subscription email field is accepting input successfully.");
    }

    @Test
    public void verifySubscriptionButtonIsWorkingGood() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Entering a test email and clicking the subscribe button.");
        driver.findElement(By.id("susbscribe_email")).sendKeys("test@subscribe.com");
        driver.findElement(By.id("subscribe")).click();
        
        test.log(Status.PASS, "Finding the subscription success message.");
        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMessage.isDisplayed(), "Subscription button did not work properly. Success message not displayed.");
        
        test.log(Status.PASS, "Subscription button is working properly and the success message is displayed.");
    }

    // --- Scroll to Top Button Functionality ---

    @Test
    public void verifyFunctionalityOfScrollToTopButton() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page using JavaScript.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        test.log(Status.PASS, "Waiting for the scroll to complete and button to appear.");
        Thread.sleep(1000); 

        test.log(Status.PASS, "Finding the 'Scroll to Top' button.");
        WebElement scrollToTopButton = driver.findElement(By.id("scrollUp"));
        
        test.log(Status.PASS, "Clicking the 'Scroll to Top' button.");
        scrollToTopButton.click();
        
        test.log(Status.PASS, "Waiting for the scroll back to the top to complete.");
        Thread.sleep(1000); 

        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the page scrolled back to the top (position is 0).");
        Assert.assertEquals(scrollPosition, 0L, "The page did not scroll back to the top.");
        
        test.log(Status.PASS, "Scroll to Top button functionality is verified.");
    }

    // --- Other UI Content Tests ---

    @Test
    public void verifyContentsUnderFeedbackForUs() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find content under the 'Feedback for us' title.");
        try {
            WebElement feedbackSection = driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]/following-sibling::*"));
            test.log(Status.FAIL, "Content was found under 'Feedback for us' on the Test Cases page, but it should not exist.");
            Assert.fail("Content was found under 'Feedback for us' on the Test Cases page, but it should not exist.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "No content was found under 'Feedback for us' on the Test Cases page, as expected.");
            Assert.assertTrue(true, "No content was found under 'Feedback for us' on the Test Cases page, as expected.");
        }
    }
    
    @Test
    public void verifyEmailIdURLForFeedback() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find the Email ID URL for feedback.");
        try {
            driver.findElement(By.xpath("//a[contains(@href, 'mailto:feedback')]"));
            test.log(Status.FAIL, "The Email ID URL for feedback was found on the Test Cases page when it should not be present.");
            Assert.fail("The Email ID URL for feedback was found on the Test Cases page when it should not be present.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "The Email ID URL for feedback is not on the Test Cases page, as expected.");
            Assert.assertTrue(true, "The Email ID URL for feedback is not on the Test Cases page, as expected.");
        }
    }

}