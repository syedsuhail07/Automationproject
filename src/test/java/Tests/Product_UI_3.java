package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Product_UI_3 extends BaseTest {

    @Test
    public void verifyScrollUpUsingMouseScroll() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Scrolling down to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll up using mouse scroll failed!");
        
        test.log(Status.PASS, "Successfully scrolled up using mouse scroll.");
    }

    @Test
    public void verifyScrollDownUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll down using keyboard scroll failed!");
        
        test.log(Status.PASS, "Successfully scrolled down using the keyboard.");
    }

    @Test
    public void verifyScrollUpUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll up using keyboard scroll failed!");
        
        test.log(Status.PASS, "Successfully scrolled up using the keyboard.");
    }

    @Test
    public void verifyScrollDownUsingMouseClick() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll down scroll failed!");
        
        test.log(Status.PASS, "Successfully scrolled down using mouse click.");
    }

    @Test
    public void verifyScrollUpUsingMouseClick() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Finding the header element.");
        WebElement header = driver.findElement(By.xpath("//header"));
        
        test.log(Status.PASS, "Clicking the header element to scroll up.");
        header.click();
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long scrollTop = (Long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll up using mouse click failed!");
        
        test.log(Status.PASS, "Successfully scrolled up using a mouse click.");
    }

}