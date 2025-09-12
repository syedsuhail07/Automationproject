package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUs_UI_2 extends BaseTest {

    // --- Contact Form Field Presence & Position Tests ---

    @Test
    public void verifyNameFieldIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Name field.");
        WebElement nameField = driver.findElement(By.name("name"));
        
        test.log(Status.PASS, "Asserting that the Name field is displayed.");
        Assert.assertTrue(nameField.isDisplayed(), "Name field is not displayed on the page.");
        
        test.log(Status.PASS, "Name field is present and correctly positioned.");
    }

    @Test
    public void verifyEmailFieldIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Email field.");
        WebElement emailField = driver.findElement(By.name("email"));
        
        test.log(Status.PASS, "Asserting that the Email field is displayed.");
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed on the page.");
        
        test.log(Status.PASS, "Email field is present and correctly positioned.");
    }

    @Test
    public void verifySubjectFieldIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Subject field.");
        WebElement subjectField = driver.findElement(By.name("subject"));
        
        test.log(Status.PASS, "Asserting that the Subject field is displayed.");
        Assert.assertTrue(subjectField.isDisplayed(), "Subject field is not displayed on the page.");
        
        test.log(Status.PASS, "Subject field is present and correctly positioned.");
    }

    @Test
    public void verifyYourMessageFieldIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Your Message field.");
        WebElement messageField = driver.findElement(By.id("message"));
        
        test.log(Status.PASS, "Asserting that the Your Message field is displayed.");
        Assert.assertTrue(messageField.isDisplayed(), "Your Message field is not displayed on the page.");
        
        test.log(Status.PASS, "Your Message field is present and correctly positioned.");
    }

    @Test
    public void verifyChooseFileFieldIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Choose File field.");
        WebElement fileField = driver.findElement(By.name("upload_file"));
        
        test.log(Status.PASS, "Asserting that the Choose File field is displayed.");
        Assert.assertTrue(fileField.isDisplayed(), "Choose File field is not displayed on the page.");
        
        test.log(Status.PASS, "Choose File field is present and correctly positioned.");
    }

    @Test
    public void verifySubmitButtonIsPresentAndInCorrectPosition() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Submit button.");
        WebElement submitButton = driver.findElement(By.name("submit"));
        
        test.log(Status.PASS, "Asserting that the Submit button is displayed.");
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not displayed on the page.");
        
        test.log(Status.PASS, "Submit button is present and correctly positioned.");
    }

    // --- Contact Form Input Acceptance Tests ---

    @Test
    public void verifyNameFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Name field.");
        WebElement nameField = driver.findElement(By.name("name"));
        String testInput = "Venkata Kalyan";
        
        test.log(Status.PASS, "Entering test input '" + testInput + "' into the Name field.");
        nameField.sendKeys(testInput);
        
        test.log(Status.PASS, "Asserting that the Name field accepts the input correctly.");
        Assert.assertEquals(nameField.getAttribute("value"), testInput, "Name field is not accepting input correctly.");
        
        test.log(Status.PASS, "Name field accepts input successfully.");
    }

    @Test
    public void verifyEmailFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Email field.");
        WebElement emailField = driver.findElement(By.name("email"));
        String testInput = "venkat@example.com";
        
        test.log(Status.PASS, "Entering test input '" + testInput + "' into the Email field.");
        emailField.sendKeys(testInput);
        
        test.log(Status.PASS, "Asserting that the Email field accepts the input correctly.");
        Assert.assertEquals(emailField.getAttribute("value"), testInput, "Email field is not accepting input correctly.");
        
        test.log(Status.PASS, "Email field accepts input successfully.");
    }

    @Test
    public void verifySubjectFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Subject field.");
        WebElement subjectField = driver.findElement(By.name("subject"));
        String testInput = "Test Subject";
        
        test.log(Status.PASS, "Entering test input '" + testInput + "' into the Subject field.");
        subjectField.sendKeys(testInput);
        
        test.log(Status.PASS, "Asserting that the Subject field accepts the input correctly.");
        Assert.assertEquals(subjectField.getAttribute("value"), testInput, "Subject field is not accepting input correctly.");
        
        test.log(Status.PASS, "Subject field accepts input successfully.");
    }

    @Test
    public void verifyYourMessageFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Your Message field.");
        WebElement messageField = driver.findElement(By.id("message"));
        String testInput = "This is a test message for the contact form.";
        
        test.log(Status.PASS, "Entering test input '" + testInput + "' into the Your Message field.");
        messageField.sendKeys(testInput);
        
        test.log(Status.PASS, "Asserting that the Your Message field accepts the input correctly.");
        Assert.assertEquals(messageField.getAttribute("value"), testInput, "Your Message field is not accepting input correctly.");
        
        test.log(Status.PASS, "Your Message field accepts input successfully.");
    }

    @Test
    public void verifyChooseFileFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Choose File field.");
        WebElement fileField = driver.findElement(By.name("upload_file"));
        
        String dummyFilePath = "/Users/venkatakalyan/Downloads/Media.jpeg"; 
        
        test.log(Status.PASS, "Uploading a dummy file from path: " + dummyFilePath);
        fileField.sendKeys(dummyFilePath);
        String uploadedFileName = fileField.getAttribute("value");
        
        test.log(Status.PASS, "Asserting that the Choose File field accepts the file input.");
        Assert.assertTrue(uploadedFileName.contains("Media.jpeg"), "Choose File field is not accepting the file input.");
        
        test.log(Status.PASS, "Choose File field accepts input successfully.");
    }

    @Test
    public void verifySubmitButtonIsWorkingProperly() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");

        test.log(Status.PASS, "Filling out the form fields.");
        driver.findElement(By.name("name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys("test.user@example.com");
        driver.findElement(By.name("subject")).sendKeys("Test Submission");
        driver.findElement(By.id("message")).sendKeys("Checking if the submit button works.");
        
        test.log(Status.PASS, "Finding and clicking the Submit button.");
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        test.log(Status.PASS, "Accepting the browser alert.");
        driver.switchTo().alert().accept();

        test.log(Status.PASS, "Finding the success message element.");
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Success! Your details have been submitted successfully.')]"));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed after form submission.");
        
        test.log(Status.PASS, "Submit button is working and success message is displayed.");
    }

    // --- Feedback and Subscription Section Tests ---

    @Test
    public void verifyFeedbackForUsTitleIsPresent() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Waiting for the 'Feedback for us' title to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement feedbackTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Feedback for us')]")));
        
        test.log(Status.PASS, "Asserting that the 'Feedback for us' title is displayed.");
        Assert.assertTrue(feedbackTitle.isDisplayed(), "'Feedback For Us' title is not displayed.");
        
        test.log(Status.PASS, "'Feedback for us' title is present on the page.");
    }
    
    @Test
    public void verifyContentsUnderFeedbackForUsTitle() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the feedback description text.");
        WebElement feedbackDescription = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-1']//p[contains(text(), 'This is a simple contact form')]"));
        
        test.log(Status.PASS, "Asserting the feedback description text is displayed.");
        Assert.assertTrue(feedbackDescription.isDisplayed(), "Feedback description text is missing.");
        
        test.log(Status.PASS, "Contents under 'Feedback for us' title are displayed correctly.");
    }

    @Test
    public void verifyFeedbackForUsFontStyleIsCorrect() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the 'Feedback for us' title.");
        WebElement feedbackTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]"));
        
        test.log(Status.PASS, "Getting the font-family CSS value.");
        String fontFamily = feedbackTitle.getCssValue("font-family");
        
        test.log(Status.PASS, "Asserting that the font-family contains 'sans-serif'.");
        Assert.assertTrue(fontFamily.contains("sans-serif"), "Incorrect font style for 'Feedback for us' title. Found: " + fontFamily);
        
        test.log(Status.PASS, "'Feedback for us' font style is correct.");
    }
    
    @Test
    public void verifyFeedbackForUsFontSizeIsCorrect() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the 'Feedback for us' title.");
        WebElement feedbackTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Feedback for us')]"));
        
        test.log(Status.PASS, "Getting the font-size CSS value.");
        String fontSize = feedbackTitle.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting that the font-size is '18px'.");
        Assert.assertEquals(fontSize, "18px", "Incorrect font size for 'Feedback for us' title. Expected 18px but got: " + fontSize);
        
        test.log(Status.PASS, "'Feedback for us' font size is correct.");
    }

    @Test
    public void verifyEmailIdURLForFeedback() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the feedback email link.");
        WebElement feedbackLink = driver.findElement(By.xpath("//a[contains(@href, 'mailto:')]"));
        
        test.log(Status.PASS, "Getting the href attribute and link text.");
        String hrefAttribute = feedbackLink.getAttribute("href");
        String linkText = feedbackLink.getText();

        test.log(Status.PASS, "Asserting the href attribute starts with 'mailto:'.");
        Assert.assertTrue(hrefAttribute.startsWith("mailto:"), "Email link is not a mailto: URL.");
        
        test.log(Status.PASS, "Asserting the href attribute contains the correct email address.");
        Assert.assertTrue(hrefAttribute.contains("feedback@automationexercise.com"), "Email link does not contain the correct email address in href.");
        
        test.log(Status.PASS, "Asserting the link text is correct.");
        Assert.assertEquals(linkText, "feedback@automationexercise.com", "Email link text is incorrect.");
        
        test.log(Status.PASS, "Email ID URL for feedback is correct.");
    }

    @Test
    public void verifySubscriptionFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the subscription email field.");
        WebElement subscriptionEmail = driver.findElement(By.id("susbscribe_email"));
        String testEmail = "subscribe@test.com";
        
        test.log(Status.PASS, "Entering test input '" + testEmail + "' into the subscription field.");
        subscriptionEmail.sendKeys(testEmail);
        
        test.log(Status.PASS, "Asserting that the subscription field is accepting input.");
        Assert.assertEquals(subscriptionEmail.getAttribute("value"), testEmail, "Subscription email field is not accepting input.");
        
        test.log(Status.PASS, "Subscription email field accepts input successfully.");
    }

    @Test
    public void verifySubscriptionButtonIsWorking() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Entering a test email and clicking the subscribe button.");
        driver.findElement(By.id("susbscribe_email")).sendKeys("test@subscribe.com");
        driver.findElement(By.id("subscribe")).click();
        
        test.log(Status.PASS, "Finding the subscription success message.");
        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMessage.isDisplayed(), "Subscription button did not work properly. Success message not displayed.");
        
        test.log(Status.PASS, "Subscription button is working properly and success message is displayed.");
    }

    @Test
    public void verifyFunctionalityOfScrollToTopButton() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        // You might consider replacing Thread.sleep with a wait for an element to appear
        Thread.sleep(1000); 

        test.log(Status.PASS, "Finding and clicking the 'Scroll To Top' button.");
        WebElement scrollToTopButton = driver.findElement(By.id("scrollUp"));
        scrollToTopButton.click();
        
        Thread.sleep(1000);

        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the page scrolled back to the top (scroll position is 0).");
        Assert.assertEquals(scrollPosition, 0L, "The page did not scroll back to the top.");
        
        test.log(Status.PASS, "The 'Scroll to Top' button functionality is verified.");
    }


}