package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UI_Home_2 extends BaseTest {

    @Test
    public void verifyFunctionalityOfVideoTutorialsIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Video Tutorials' icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the 'Video Tutorials' icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube'.");
        Assert.assertTrue(currentUrl.contains("youtube"), 
            "Video Tutorials icon did not redirect to a YouTube page.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to the YouTube page successfully.");
    }

    @Test
    public void verifySubscriptionWithValidEmail() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the subscription email input box.");
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Entering a unique test email address.");
        emailBox.sendKeys("testuser" + System.currentTimeMillis() + "@mail.com");
        
        test.log(Status.PASS, "Clicking the 'Subscribe' button.");
        driver.findElement(By.id("subscribe")).click();

        test.log(Status.PASS, "Waiting for the subscription success message to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
        
        test.log(Status.PASS, "Asserting that the success message is displayed.");
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not shown!");
        
        test.log(Status.PASS, "Subscription was successful with a valid email.");
    }

    @Test
    public void verifyChatSupportArrowButton() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the chat support arrow button.");
        WebElement chatArrow = driver.findElement(By.cssSelector(".chat-support .arrow-button"));
        
        test.log(Status.PASS, "Clicking the arrow button to open the chat box.");
        chatArrow.click();
        
        test.log(Status.PASS, "Finding the chat box element.");
        WebElement chatBox = driver.findElement(By.cssSelector(".chat-box"));
        
        test.log(Status.PASS, "Asserting that the chat box is displayed.");
        Assert.assertTrue(chatBox.isDisplayed(), "Chat box did not open!");
        
        test.log(Status.PASS, "Chat support box opens correctly.");
    }

    @Test
    public void verifySignupLoginButton() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'Signup / Login' button.");
        WebElement signupBtn = driver.findElement(By.xpath("//a[@href='/login']"));
        
        test.log(Status.PASS, "Clicking the 'Signup / Login' button.");
        signupBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/login'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Signup/Login page not opened!");
        
        test.log(Status.PASS, "Signup / Login button redirects to the correct page.");
    }

    @Test
    public void verifyRecommendationsNextButton() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'Next' button for the recommendations carousel.");
        WebElement nextBtn = driver.findElement(By.cssSelector("#recommended-item-carousel a.right"));
        
        test.log(Status.PASS, "Getting the class attribute of the initially active item.");
        WebElement activeBefore = driver.findElement(By.cssSelector("#recommended-item-carousel .item.active"));
        String beforeId = activeBefore.getAttribute("class");
        
        test.log(Status.PASS, "Clicking the 'Next' button.");
        nextBtn.click();
        
        test.log(Status.PASS, "Waiting for the carousel to transition.");
        Thread.sleep(3000);
        
        test.log(Status.PASS, "Finding the new active item.");
        WebElement activeAfter = driver.findElement(By.cssSelector("#recommended-item-carousel .item.active"));
        String afterId = activeAfter.getAttribute("class");
        
        test.log(Status.PASS, "Asserting that the active item has changed.");
        Assert.assertNotEquals(beforeId, afterId, "Next button did not scroll recommendations!");
        
        test.log(Status.PASS, "Recommendations carousel 'Next' button is working correctly.");
    }

    @Test
    public void verifySlideShowDotButtons() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the second slideshow dot button.");
        WebElement dot2 = driver.findElement(By.cssSelector("#slider ol.carousel-indicators li:nth-child(2)"));
        
        test.log(Status.PASS, "Clicking the dot button.");
        dot2.click();
        
        test.log(Status.PASS, "Waiting for the slideshow to transition.");
        Thread.sleep(2000);
        
        test.log(Status.PASS, "Finding the newly active image element.");
        WebElement activeImg = driver.findElement(By.cssSelector("#slider .item.active img"));
        
        test.log(Status.PASS, "Asserting that the new active image is displayed.");
        Assert.assertTrue(activeImg.isDisplayed(), "Dot button did not switch slideshow!");
        
        test.log(Status.PASS, "Slideshow dot buttons are working correctly.");
    }

    @Test
    public void verifyHomepageFontStyleAndSize() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the main heading of the banner.");
        WebElement heading = driver.findElement(By.cssSelector("h2.title"));
        
        test.log(Status.PASS, "Getting the font-family and font-size CSS values.");
        String fontFamily = heading.getCssValue("font-family");
        String fontSize = heading.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting that font family is not null.");
        Assert.assertNotNull(fontFamily, "Font family is not set!");
        
        test.log(Status.PASS, "Asserting that font size is in pixels.");
        Assert.assertTrue(fontSize.contains("px"), "Font size not applied properly!");
        
        test.log(Status.PASS, "Homepage font style and size are correct.");
    }

    @Test
    public void verifyTestCaseButtonInCarousel() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'Test Cases' button.");
        WebElement testCaseBtn = driver.findElement(By.xpath("//a[@href='/test_cases']"));
        
        test.log(Status.PASS, "Clicking the 'Test Cases' button.");
        testCaseBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/test_cases'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/test_cases"), "Test Case page not opened!");
        
        test.log(Status.PASS, "Test Case button redirects to the correct page.");
    }

    @Test
    public void verifyApisListButtonInCarousel() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'APIs List' button.");
        WebElement apisBtn = driver.findElement(By.xpath("//a[@href='/api_list']"));
        
        test.log(Status.PASS, "Clicking the 'APIs List' button.");
        apisBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/api_list'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/api_list"), "APIs list page not opened!");
        
        test.log(Status.PASS, "APIs List button redirects to the correct page.");
    }

    @Test
    public void verifyViewProductRedirectsToDetailPage() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'View Product' link for the first product.");
        WebElement viewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        
        test.log(Status.PASS, "Clicking the 'View Product' link.");
        viewProduct.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/product_details'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/product_details"), "View Product did not navigate to details page!");
        
        test.log(Status.PASS, "View Product redirects to the product details page.");
    }

}