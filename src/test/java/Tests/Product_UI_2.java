package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Product_UI_2 extends BaseTest {

    @Test
    public void verifyApiTestingIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'API Testing' icon.");
        driver.findElement(By.xpath("//a[@href='/api_list']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'api_list'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("api_list"),
                "API Testing icon navigation failed!");
        
        test.log(Status.PASS, "API Testing icon redirected to the correct page successfully.");
    }

    @Test
    public void verifyVideoTutorialsIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Video Tutorials' icon.");
        driver.findElement(By.xpath("//a[contains(text(),'Video Tutorials')]")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube'.");
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("youtube"),
                "Video Tutorials icon navigation failed!");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to the YouTube page successfully.");
    }

    @Test
    public void verifyContactUsIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Contact Us' icon.");
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'contact_us'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"),
                "Contact Us icon navigation failed!");
        
        test.log(Status.PASS, "Contact Us icon redirected to the correct page successfully.");
    }

    @Test
    public void verifyAutomationExerciseLogoOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the Automation Exercise logo.");
        driver.findElement(By.xpath("//div[@class='logo pull-left']//a")).click();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"),
                "Automation Exercise logo navigation failed!");
        
        test.log(Status.PASS, "Automation Exercise logo redirected to the homepage successfully.");
    }

    @Test
    public void verifyScrollDownFeatureOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Scrolling down to the bottom of the page using JavaScript.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Getting the current scroll position.");
        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page has scrolled down (scroll position is greater than 0).");
        Assert.assertTrue(scrollPosition > 0, "Scroll down feature failed!");
        
        test.log(Status.PASS, "Scroll down feature is working properly on the products page.");
    }

}