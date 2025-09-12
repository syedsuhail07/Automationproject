package Tests;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import com.automationproj.utilities.ScreenshotUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Login_5 extends BaseTest {

    @Test
    public void testApiTestingIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'API Testing' icon.");
        WebElement apiTestingIcon = driver.findElement(By.xpath("//a[contains(text(),'API Testing')]"));
        
        test.log(Status.PASS, "Clicking the 'API Testing' icon.");
        apiTestingIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'api_list'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("api_list"), "API Testing icon did not redirect correctly.");
        
        test.log(Status.PASS, "API Testing icon redirected to the correct page successfully.");
    }

    @Test
    public void testVideoTutorialsIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Video Tutorials' icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),'Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the 'Video Tutorials' icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube.com'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"), "Video Tutorials icon did not redirect to YouTube.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to YouTube successfully.");
    }

    @Test
    public void testContactUsIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Contact us' icon.");
        WebElement contactUsIcon = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
        
        test.log(Status.PASS, "Clicking the 'Contact us' icon.");
        contactUsIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'contact_us'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Contact Us icon did not redirect correctly.");
        
        test.log(Status.PASS, "Contact us icon redirected to the correct page successfully.");
    }

    @Test
    public void testAutomationExerciseLogoOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the Automation Exercise logo.");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']/a/img"));
        
        test.log(Status.PASS, "Clicking the logo.");
        logo.click();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Logo did not redirect to Home page.");
        
        test.log(Status.PASS, "Automation Exercise logo redirected to the homepage successfully.");
    }

    @Test
    public void testSubscriptionEmailEntryFieldOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the subscription email field.");
        WebElement emailField = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Entering a test email address.");
        emailField.sendKeys("venkat@gmail.com");
        
        test.log(Status.PASS, "Clicking the 'Subscribe' button.");
        driver.findElement(By.id("subscribe")).click();
        
        test.log(Status.PASS, "Finding the subscription success message.");
        WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not displayed.");
        
        test.log(Status.PASS, "Subscription functionality on the login page is working correctly.");
    }
    

}