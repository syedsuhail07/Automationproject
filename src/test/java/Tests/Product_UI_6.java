package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Product_UI_6 extends BaseTest {

    @Test
    public void verifySearchProductFunctionality() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the search box and entering 'dress'.");
        WebElement searchBox = driver.findElement(By.id("search_product"));
        searchBox.sendKeys("dress");
        
        test.log(Status.PASS, "Clicking the search button.");
        driver.findElement(By.id("submit_search")).click();

        test.log(Status.PASS, "Finding the 'Searched Products' title.");
        WebElement searchedTitle = driver.findElement(By.xpath("//h2[normalize-space()='Searched Products']"));

        test.log(Status.PASS, "Asserting that the 'Searched Products' title is displayed.");
        Assert.assertTrue(searchedTitle.isDisplayed(), "Searched Products title is not displayed!");
        
        test.log(Status.PASS, "Search functionality worked correctly and displayed the 'Searched Products' title.");
    }

    @Test
    public void verifySubscriptionWithValidEmail() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the subscription email field.");
        WebElement emailField = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Entering a valid email address.");
        emailField.sendKeys("testemail12345@gmail.com");
        
        test.log(Status.PASS, "Clicking the subscribe button.");
        driver.findElement(By.id("subscribe")).click();

        test.log(Status.PASS, "Finding the subscription success message.");
        WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));

        test.log(Status.PASS, "Asserting that the subscription success message is displayed.");
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not displayed!");
        
        test.log(Status.PASS, "Subscription was successful with a valid email.");
    }

    @Test
    public void verifyCursorChangeOnPolo() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Polo' brand link.");
        WebElement poloLink = driver.findElement(By.xpath("//a[normalize-space()='Polo']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'Polo' link.");
        String beforeCursor = poloLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Polo' link.");
        new Actions(driver).moveToElement(poloLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = poloLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Polo']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on POLO hover.");
        
        test.log(Status.PASS, "Hovering over 'Polo' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnHM() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'H&M' brand link.");
        WebElement hmLink = driver.findElement(By.xpath("//a[normalize-space()='H&M']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'H&M' link.");
        String beforeCursor = hmLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'H&M' link.");
        new Actions(driver).moveToElement(hmLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = hmLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='H&M']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on H&M hover.");
        
        test.log(Status.PASS, "Hovering over 'H&M' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnMadame() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Madame' brand link.");
        WebElement madameLink = driver.findElement(By.xpath("//a[normalize-space()='Madame']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'Madame' link.");
        String beforeCursor = madameLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Madame' link.");
        new Actions(driver).moveToElement(madameLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = madameLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Madame']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on MADAME hover.");
        
        test.log(Status.PASS, "Hovering over 'Madame' link triggered the expected visual change.");
    }

}