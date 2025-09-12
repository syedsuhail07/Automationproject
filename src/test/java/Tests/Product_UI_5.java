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

public class Product_UI_5 extends BaseTest {

    @Test
    public void verifyCursorChangeOnWomen() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Women' category link.");
        WebElement womenLink = driver.findElement(By.xpath("//a[normalize-space()='Women']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'Women' link.");
        String beforeCursor = womenLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Women' link to trigger a cursor change.");
        new Actions(driver).moveToElement(womenLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = womenLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Women']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on WOMEN hover.");
        
        test.log(Status.PASS, "Hovering over 'Women' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnMen() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Men' category link.");
        WebElement menLink = driver.findElement(By.xpath("//a[normalize-space()='Men']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'Men' link.");
        String beforeCursor = menLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Men' link to trigger a cursor change.");
        new Actions(driver).moveToElement(menLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = menLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Men']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on MEN hover.");
        
        test.log(Status.PASS, "Hovering over 'Men' link triggered the expected visual change.");
    }

    @Test
    public void verifyCursorChangeOnKids() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Kids' category link.");
        WebElement kidsLink = driver.findElement(By.xpath("//a[normalize-space()='Kids']"));

        test.log(Status.PASS, "Getting the initial cursor style of the 'Kids' link.");
        String beforeCursor = kidsLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Kids' link to trigger a cursor change.");
        new Actions(driver).moveToElement(kidsLink).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = kidsLink.getCssValue("cursor");

        boolean cursorChanged = !beforeCursor.equals(afterCursor);
        test.log(Status.PASS, "Cursor changed: " + cursorChanged);

        boolean plusVisible = false;
        try {
            test.log(Status.PASS, "Checking for the visibility of the plus-icon.");
            WebElement plusIcon = driver.findElement(By.xpath(
                "//a[normalize-space()='Kids']/span//i[contains(@class,'fa-plus')]"
            ));
            plusVisible = plusIcon.isDisplayed();
            test.log(Status.PASS, "Plus-icon visible: " + plusVisible);
        } catch (NoSuchElementException ignored) {}

        test.log(Status.PASS, "Asserting that either the cursor changed or the plus-icon became visible.");
        Assert.assertTrue(cursorChanged || plusVisible,
            "Neither cursor changed nor plus-icon visible on KIDS hover.");
        
        test.log(Status.PASS, "Hovering over 'Kids' link triggered the expected visual change.");
    }

    @Test
    public void verifyBrandsTitle() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Brands' title in the left sidebar.");
        WebElement brandsTitle = driver.findElement(By.xpath(
            "//h2[normalize-space()='Brands' or normalize-space()='BRANDS']"
        ));

        test.log(Status.PASS, "Asserting that the 'Brands' title is displayed.");
        Assert.assertTrue(brandsTitle.isDisplayed(), "BRANDS title is not displayed in left sidebar!");
        
        test.log(Status.PASS, "Brands title is displayed correctly in the left sidebar.");
    }

    @Test
    public void verifyAllProductsTitle() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'All Products' title.");
        WebElement allProductsTitle = driver.findElement(By.xpath(
            "//h2[normalize-space()='All Products' or normalize-space()='ALL PRODUCTS']"
        ));

        test.log(Status.PASS, "Asserting that the 'All Products' title is visible.");
        Assert.assertTrue(allProductsTitle.isDisplayed(), "ALL PRODUCTS title is not visible!");
        
        test.log(Status.PASS, "All Products title is visible on the page.");
    }


}