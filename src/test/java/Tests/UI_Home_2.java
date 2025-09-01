package Tests;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;

import java.time.Duration;

public class UI_Home_2 extends BaseTest {

    @Test
    public void verifyVideoTutorialFunctionality() {
        driver.get("https://automationexercise.com/");
        WebElement video = driver.findElement(By.id("video"));
        Assert.assertTrue(video.isDisplayed(), "Video tutorial is not visible!");
        ((JavascriptExecutor) driver).executeScript("arguments[0].play()", video);
        Boolean isPlaying = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].paused === false;", video);
        Assert.assertTrue(isPlaying, "Video did not start playing!");
    }

    @Test
    public void verifySubscriptionWithValidEmail() {
        driver.get("https://automationexercise.com/");
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        emailBox.sendKeys("testuser" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("subscribe")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not shown!");
    }

    @Test
    public void verifyChatSupportArrowButton() {
        driver.get("https://automationexercise.com/");
        WebElement chatArrow = driver.findElement(By.cssSelector(".chat-support .arrow-button"));
        chatArrow.click();
        WebElement chatBox = driver.findElement(By.cssSelector(".chat-box"));
        Assert.assertTrue(chatBox.isDisplayed(), "Chat box did not open!");
    }

    @Test
    public void verifySignupLoginButton() {
        driver.get("https://automationexercise.com/");
        WebElement signupBtn = driver.findElement(By.xpath("//a[@href='/login']"));
        signupBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Signup/Login page not opened!");
    }

    @Test
    public void verifyRecommendationsNextButton() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement nextBtn = driver.findElement(By.cssSelector("#recommended-item-carousel a.right"));
        WebElement activeBefore = driver.findElement(By.cssSelector("#recommended-item-carousel .item.active"));
        String beforeId = activeBefore.getAttribute("class");
        nextBtn.click();
        Thread.sleep(3000);
        WebElement activeAfter = driver.findElement(By.cssSelector("#recommended-item-carousel .item.active"));
        String afterId = activeAfter.getAttribute("class");
        Assert.assertNotEquals(beforeId, afterId, "Next button did not scroll recommendations!");
    }

    @Test
    public void verifySlideShowDotButtons() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement dot2 = driver.findElement(By.cssSelector("#slider ol.carousel-indicators li:nth-child(2)"));
        dot2.click();
        Thread.sleep(2000);
        WebElement activeImg = driver.findElement(By.cssSelector("#slider .item.active img"));
        Assert.assertTrue(activeImg.isDisplayed(), "Dot button did not switch slideshow!");
    }

    @Test
    public void verifyHomepageFontStyleAndSize() {
        driver.get("https://automationexercise.com/");
        WebElement heading = driver.findElement(By.cssSelector("h2.title"));
        String fontFamily = heading.getCssValue("font-family");
        String fontSize = heading.getCssValue("font-size");
        Assert.assertNotNull(fontFamily, "Font family is not set!");
        Assert.assertTrue(fontSize.contains("px"), "Font size not applied properly!");
    }

    @Test
    public void verifyTestCaseButtonInCarousel() {
        driver.get("https://automationexercise.com/");
        WebElement testCaseBtn = driver.findElement(By.xpath("//a[@href='/test_cases']"));
        testCaseBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/test_cases"), "Test Case page not opened!");
    }

    @Test
    public void verifyApisListButtonInCarousel() {
        driver.get("https://automationexercise.com/");
        WebElement apisBtn = driver.findElement(By.xpath("//a[@href='/api_list']"));
        apisBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/api_list"), "APIs list page not opened!");
    }

    @Test
    public void verifyViewProductRedirectsToDetailPage() {
        driver.get("https://automationexercise.com/");
        WebElement viewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        viewProduct.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/product_details"), "View Product did not navigate to details page!");
    }
}
