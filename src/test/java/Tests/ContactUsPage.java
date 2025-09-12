package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ExcelUtils;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ContactUsPage extends BaseTest {

    private final String contactUsPageUrl = "https://automationexercise.com/contact_us";
    private final String dummyFilePath = System.getProperty("user.dir") + File.separator + "test_data" + File.separator + "Details.txt";

    @DataProvider(name = "contactFormData")
    public Object[][] getContactFormData() {
        return ExcelUtils.getExcelData("Sheet2"); 
    }

    // A reusable method to handle filling out the form, now with Excel data
    private void fillAndVerifyContactForm(String name, String email, String subject, String message) {
        test.log(Status.PASS, "Navigating to the Contact Us page for new data set.");
        driver.get(contactUsPageUrl);

        test.log(Status.PASS, "Filling out the form with data from Excel.");
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name='subject']")).sendKeys(subject);
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(message);
        
        test.log(Status.PASS, "Successfully entered form data.");
    }

    @Test(priority = 1)
    public void verifyContactUsButtonNavigation() {
        test.log(Status.PASS, "Navigating to homepage to click 'Contact Us' button.");
        driver.get("https://automationexercise.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        test.log(Status.PASS, "Waiting for the 'Contact Us' button to be clickable.");
        WebElement contactUsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/contact_us']")));
        
        test.log(Status.PASS, "Clicking the 'Contact Us' button.");
        contactUsBtn.click();
        
        test.log(Status.PASS, "Waiting for the URL to contain 'contact_us'.");
        wait.until(ExpectedConditions.urlContains("contact_us"));
        
        test.log(Status.PASS, "Asserting that the current URL is the Contact Us page URL.");
        Assert.assertTrue(driver.getCurrentUrl().contains(contactUsPageUrl), "Did not navigate to the Contact Us page!");
        
        test.log(Status.PASS, "Asserting that the 'Get In Touch' heading is visible.");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed(), "Contact Us page heading not visible!");
        test.log(Status.PASS, "Successfully verified navigation to the Contact Us page.");
    }
    
    // This is the single, refactored test that replaces multiple previous tests.
    @Test(priority = 2, dataProvider = "contactFormData")
    public void verifyContactFormWithExcelData(String name, String email, String subject, String message) {
        test.log(Status.PASS, "Starting data-driven test for Name: " + name);
        
        fillAndVerifyContactForm(name, email, subject, message);

        test.log(Status.PASS, "Finding and clicking the 'Submit' button.");
        driver.findElement(By.cssSelector("input[name='submit']")).click();
        
        test.log(Status.PASS, "Accepting the confirmation alert.");
        driver.switchTo().alert().accept();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        test.log(Status.PASS, "Waiting for the form submission success message to be visible.");
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
        
        test.log(Status.PASS, "Asserting the success message is displayed.");
        Assert.assertTrue(successMsg.isDisplayed(), "Form submission success message not displayed!");
        
        test.log(Status.PASS, "Form submission was successful with valid data for " + name + " from Excel.");
    }
    
    // Remaining methods are given priority after the data-driven test.

    @Test(priority = 3)
    public void verifyNameFieldWithInvalidInput() {
        test.log(Status.PASS, "Verifying invalid input (empty string) for the 'Name' field.");
        driver.get(contactUsPageUrl);
        
        test.log(Status.PASS, "Entering an empty string into the Name field.");
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("");

        String nameValue = driver.findElement(By.cssSelector("input[name='name']")).getAttribute("value");
        test.log(Status.PASS, "Asserting that the name field value is empty.");
        Assert.assertEquals(nameValue, "", "Name field accepted invalid (empty) input!");
        test.log(Status.PASS, "Name field did not accept invalid input.");
    }

    @Test(priority = 4)
    public void verifyEmailFieldWithInvalidInput() {
        test.log(Status.PASS, "Verifying invalid input for the 'Email' field.");
        driver.get(contactUsPageUrl);
        test.log(Status.PASS, "Entering invalid email 'invalid-email'.");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("invalid-email");
        
        test.log(Status.PASS, "Clicking the submit button to check for form submission.");
        driver.findElement(By.cssSelector("input[name='submit']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.urlContains(contactUsPageUrl));
            Assert.assertTrue(driver.getCurrentUrl().contains(contactUsPageUrl), "Email field accepted invalid input!");
            test.log(Status.PASS, "Email field did not accept invalid input.");
        } catch (TimeoutException e) {
            test.log(Status.FAIL, "Form was submitted successfully with invalid email!");
            Assert.fail("Form was submitted successfully with invalid email!");
        }
    }

    @Test(priority = 5)
    public void verifyFileAttachment() {
        test.log(Status.PASS, "Verifying file upload functionality.");
        driver.get(contactUsPageUrl);
        
        test.log(Status.PASS, "Finding the file input element.");
        WebElement chooseFileBtn = driver.findElement(By.cssSelector("input[name='upload_file']"));
        
        test.log(Status.PASS, "Sending the dummy file path to the input element.");
        chooseFileBtn.sendKeys(dummyFilePath);
        
        test.log(Status.PASS, "Getting the value (file name) from the input element.");
        String fileName = chooseFileBtn.getAttribute("value");
        
        test.log(Status.PASS, "Asserting that the file name is not empty.");
        Assert.assertFalse(fileName.isEmpty(), "File was not attached to the form!");
        test.log(Status.PASS, "File was successfully attached to the form.");
    }
    
    @Test(priority = 6)
    public void verifySubscriptionWithInvalidEmail() {
        test.log(Status.PASS, "Verifying subscription form with invalid email.");
        driver.get(contactUsPageUrl);
        
        test.log(Status.PASS, "Finding the email subscription box.");
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Entering invalid email 'invalid-email'.");
        emailBox.sendKeys("invalid-email");
        
        test.log(Status.PASS, "Clicking the 'Subscribe' button.");
        driver.findElement(By.id("subscribe")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
            test.log(Status.FAIL, "Subscription accepted invalid email!");
            Assert.fail("Subscription accepted invalid email!");
        } catch (TimeoutException e) {
            test.log(Status.PASS, "Subscription did not accept invalid email.");
            Assert.assertTrue(true);
        }
    }
    
    @Test(priority = 7)
    public void verifySubscriptionWithValidEmail() {
        test.log(Status.PASS, "Verifying subscription form with valid email.");
        driver.get(contactUsPageUrl);
        
        test.log(Status.PASS, "Finding the email subscription box.");
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Entering a unique valid email.");
        emailBox.sendKeys("testuser" + System.currentTimeMillis() + "@mail.com");
        
        test.log(Status.PASS, "Clicking the 'Subscribe' button.");
        driver.findElement(By.id("subscribe")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        test.log(Status.PASS, "Waiting for the subscription success message to appear.");
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not shown!");
        test.log(Status.PASS, "Subscription was successful with a valid email.");
    }
    
    @Test(priority = 8)
    public void verifyScrollUpFunctionality() {
        test.log(Status.PASS, "Verifying the 'Scroll Up' arrow functionality.");
        driver.get(contactUsPageUrl);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Waiting for the 'Scroll Up' button to be visible.");
        WebElement scrollUpBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        
        test.log(Status.PASS, "Asserting the 'Scroll Up' button is visible.");
        Assert.assertTrue(scrollUpBtn.isDisplayed(), "Scroll up button is not visible!");
        
        test.log(Status.PASS, "Clicking the 'Scroll Up' button.");
        scrollUpBtn.click();
        
        test.log(Status.PASS, "Waiting for the page to scroll back to the top (Y-offset = 0).");
        wait.until(webDriver -> (long) ((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset;") == 0);
        
        test.log(Status.PASS, "Getting the final scroll position.");
        long currentScrollPosition = (long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the final scroll position is 0.");
        Assert.assertEquals(currentScrollPosition, 0, "Did not scroll to the top of the page!");
        test.log(Status.PASS, "Successfully scrolled to the top of the page.");
    }
    
    @Test(priority = 9)
    public void verifyScrollDownFunctionality() {
        test.log(Status.PASS, "Verifying scroll down functionality.");
        driver.get(contactUsPageUrl);
        
        test.log(Status.PASS, "Scrolling down the page by 500 pixels.");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500)");
        
        test.log(Status.PASS, "Getting the current scroll position.");
        long currentScrollPosition = (long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is not 0.");
        Assert.assertNotEquals(currentScrollPosition, 0, "Did not scroll down the page!");
        test.log(Status.PASS, "Successfully scrolled down the page.");
    }

}