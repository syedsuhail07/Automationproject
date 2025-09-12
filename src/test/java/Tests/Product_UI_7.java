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

public class Product_UI_7 extends BaseTest {

    @Test
    public void verifyCursorChangeOnMastAndHarbor() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Mast & Harbor' brand link.");
        WebElement mastHarborLink = driver.findElement(By.xpath("//a[normalize-space()='Mast & Harbor']"));

        test.log(Status.PASS, "Getting the initial cursor style of the link.");
        String beforeCursor = mastHarborLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Mast & Harbor' link.");
        new Actions(driver).moveToElement(mastHarborLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = mastHarborLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Mast & Harbor']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on MAST & HARBOR hover.");
        
        test.log(Status.PASS, "Hovering over 'Mast & Harbor' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnBabyhug() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Babyhug' brand link.");
        WebElement babyhugLink = driver.findElement(By.xpath("//a[normalize-space()='Babyhug']"));

        test.log(Status.PASS, "Getting the initial cursor style of the link.");
        String beforeCursor = babyhugLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Babyhug' link.");
        new Actions(driver).moveToElement(babyhugLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = babyhugLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Babyhug']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on BABYHUG hover.");
        
        test.log(Status.PASS, "Hovering over 'Babyhug' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnAllenSollyJunior() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Allen Solly Junior' brand link.");
        WebElement allenSollyJuniorLink = driver.findElement(By.xpath("//a[normalize-space()='Allen Solly Junior']"));

        test.log(Status.PASS, "Getting the initial cursor style of the link.");
        String beforeCursor = allenSollyJuniorLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Allen Solly Junior' link.");
        new Actions(driver).moveToElement(allenSollyJuniorLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = allenSollyJuniorLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Allen Solly Junior']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on ALLEN SOLLY JUNIOR hover.");
        
        test.log(Status.PASS, "Hovering over 'Allen Solly Junior' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnKookieKids() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Kookie Kids' brand link.");
        WebElement kookieKidsLink = driver.findElement(By.xpath("//a[normalize-space()='Kookie Kids']"));

        test.log(Status.PASS, "Getting the initial cursor style of the link.");
        String beforeCursor = kookieKidsLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Kookie Kids' link.");
        new Actions(driver).moveToElement(kookieKidsLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = kookieKidsLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Kookie Kids']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on KOOKIE KIDS hover.");
        
        test.log(Status.PASS, "Hovering over 'Kookie Kids' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnBiba() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Biba' brand link.");
        WebElement bibaLink = driver.findElement(By.xpath("//a[normalize-space()='Biba']"));

        test.log(Status.PASS, "Getting the initial cursor style of the link.");
        String beforeCursor = bibaLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Biba' link.");
        new Actions(driver).moveToElement(bibaLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = bibaLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Biba']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on BIBA hover.");
        
        test.log(Status.PASS, "Hovering over 'Biba' link triggered the expected visual change.");
    }

}