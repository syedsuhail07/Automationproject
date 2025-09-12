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

public class UI_Home extends BaseTest {

    @Test
    public void verifyProductButtonFunctionality() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'Products' button.");
        WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
        
        test.log(Status.PASS, "Clicking the 'Products' button.");
        productBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/products'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"), "Product page not opened!");
        
        test.log(Status.PASS, "Products button redirected to the correct page successfully.");
    }

    @Test
    public void verifyContactUsRedirect() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'Contact Us' button.");
        WebElement contactBtn = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        
        test.log(Status.PASS, "Clicking the 'Contact Us' button.");
        contactBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/contact_us'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"), "Contact Us page not opened!");
        
        test.log(Status.PASS, "Contact Us button redirected to the correct page successfully.");
    }

    @Test
    public void verifyRightHandScrollBar() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Getting the initial scroll position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Scrolling down by 1000 pixels.");
        js.executeScript("window.scrollBy(0, 1000);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled down.");
        Assert.assertTrue(afterScroll > initialScroll, "Scroll bar did not work!");
        
        test.log(Status.PASS, "Right-hand scroll bar is working properly.");
    }

    @Test
    public void verifyScrollUpButton() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        test.log(Status.PASS, "Waiting for the scroll to complete.");
        Thread.sleep(2000);
        
        test.log(Status.PASS, "Finding and clicking the 'Scroll Up' button.");
        WebElement scrollUpBtn = driver.findElement(By.id("scrollUp"));
        scrollUpBtn.click();
        
        test.log(Status.PASS, "Waiting for the scroll to complete.");
        Thread.sleep(2000);
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled back to the top.");
        Assert.assertEquals(afterScroll.longValue(), 0L, "Scroll up button did not work!");
        
        test.log(Status.PASS, "'Scroll Up' button is working correctly.");
    }

    @Test
    public void verifyLogoRedirectsHome() {
        test.log(Status.PASS, "Navigating to the products page to test the logo.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Finding the website logo.");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']//a"));
        
        test.log(Status.PASS, "Clicking the logo.");
        logo.click();
        
        test.log(Status.PASS, "Asserting the URL redirects to the homepage.");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"), "Logo did not redirect to Home!");
        
        test.log(Status.PASS, "Logo redirects to the homepage successfully.");
    }
    

}