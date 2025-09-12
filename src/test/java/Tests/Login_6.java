package Tests;

import Base.BaseTest;

import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Login_6 extends BaseTest {

    @Test
    public void testScrollDownUsingMouseScrollOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page using Actions class (mouse scroll).");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1000).perform();
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.id("footer"));
        
        test.log(Status.PASS, "Asserting the footer is displayed after scrolling down.");
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using mouse scroll.");
        
        test.log(Status.PASS, "Successfully scrolled down using mouse scroll.");
    }

    @Test
    public void testScrollUpUsingMouseScrollOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page by 1000 pixels to prepare for scroll up.");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1000).perform();
        
        test.log(Status.PASS, "Scrolling back up the page by 1000 pixels.");
        actions.scrollByAmount(0, -1000).perform();
        
        test.log(Status.PASS, "Finding the header element.");
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Asserting the header is displayed after scrolling up.");
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using mouse scroll.");
        
        test.log(Status.PASS, "Successfully scrolled up using mouse scroll.");
    }

    @Test
    public void testScrollDownUsingKeyboardOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page using the 'PAGE_DOWN' key.");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.id("footer"));
        
        test.log(Status.PASS, "Asserting the footer is displayed after scrolling down.");
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using keyboard.");
        
        test.log(Status.PASS, "Successfully scrolled down using the keyboard.");
    }

    @Test
    public void testScrollUpUsingKeyboardOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page using the 'PAGE_DOWN' key to prepare.");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        
        test.log(Status.PASS, "Scrolling back up using the 'PAGE_UP' key.");
        actions.sendKeys(Keys.PAGE_UP).perform();
        
        test.log(Status.PASS, "Finding the header element.");
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Asserting the header is displayed after scrolling up.");
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using keyboard.");
        
        test.log(Status.PASS, "Successfully scrolled up using the keyboard.");
    }

    @Test
    public void testScrollDownUsingMouseClickOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page by 1000 pixels using JavaScript.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.id("footer"));
        
        test.log(Status.PASS, "Asserting the footer is displayed after scrolling down.");
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using JavaScript.");
        
        test.log(Status.PASS, "Successfully scrolled down using JavaScript.");
    }

    @Test
    public void testScrollUpUsingMouseClickOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Scrolling down the page by 1000 pixels to prepare for scroll up.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
        
        test.log(Status.PASS, "Scrolling back up the page by 1000 pixels using JavaScript.");
        js.executeScript("window.scrollBy(0, -1000)");
        
        test.log(Status.PASS, "Finding the header element.");
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Asserting the header is displayed after scrolling up.");
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using JavaScript.");
        
        test.log(Status.PASS, "Successfully scrolled up using JavaScript.");
    }
    

}