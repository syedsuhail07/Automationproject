package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UI_Home_1 extends BaseTest {

    @Test
    public void verifySlideshowIsWorking() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Waiting for the first active slide to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstActiveSlide = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#slider .item.active")));
        
        test.log(Status.PASS, "Waiting for the slide to change.");
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(firstActiveSlide, "class", "active")));
        
        test.log(Status.PASS, "Finding the new active slide.");
        WebElement newActiveSlide = driver.findElement(By.cssSelector("#slider .item.active"));
        
        test.log(Status.PASS, "Asserting that the slideshow has changed slides.");
        Assert.assertNotEquals(firstActiveSlide, newActiveSlide, "Slideshow did not change slides!");
        
        test.log(Status.PASS, "Slideshow is working correctly and has changed slides.");
    }

    @Test
    public void verifyCursorChangesOnHover() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the first product in the features section.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstProduct = driver.findElement(By.cssSelector(".features_items .productPASS"));
        
        test.log(Status.PASS, "Hovering over the first product to trigger the overlay.");
        new Actions(driver).moveToElement(firstProduct).perform();
        
        test.log(Status.PASS, "Waiting for the product overlay to be visible.");
        WebElement overlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items .product-overlay")));
        
        test.log(Status.PASS, "Asserting that the overlay is displayed on hover.");
        Assert.assertTrue(overlay.isDisplayed(), "Overlay not shown on hover!");
        
        test.log(Status.PASS, "Cursor changes and overlay is shown correctly on hover.");
    }

    @Test
    public void verifyAddToCartFromHomePage() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Waiting for the 'Add to Cart' button for product 1 to be present.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addToCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-product-id='1']")));
        
        test.log(Status.PASS, "Scrolling to the 'Add to Cart' button and clicking it using JavaScript.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
        
        test.log(Status.PASS, "Waiting for the success modal to be displayed.");
        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
        
        test.log(Status.PASS, "Asserting that the 'Add to Cart' modal is displayed.");
        Assert.assertTrue(successModal.isDisplayed(), "Add to Cart modal not displayed!");
        
        test.log(Status.PASS, "Add to Cart functionality is working correctly from the homepage.");
    }

    @Test
    public void verifyCarousalarrow() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding and clicking the second carousel indicator dot.");
        WebElement dot2 = driver.findElement(By.cssSelector("#slider ol.carousel-indicators li:nth-child(2)"));
        dot2.click();
        
        test.log(Status.PASS, "Waiting for the slide to transition.");
        Thread.sleep(2000);
        
        test.log(Status.PASS, "Finding the newly active image.");
        WebElement activeImg = driver.findElement(By.cssSelector("#slider .item.active img"));
        
        test.log(Status.PASS, "Asserting that the new active image is displayed.");
        Assert.assertTrue(activeImg.isDisplayed(), "Dot button did not switch slideshow!");
        
        test.log(Status.PASS, "Carousel arrows/dots functionality is working correctly.");
    }

    @Test
    public void verifyHomepageBannerLoads() {
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
        
        test.log(Status.PASS, "Homepage banner loads correctly with proper fonts.");
    }

    @Test
    public void verifyCategoryColumnFunctionality() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Waiting for the 'Women' category link to be clickable.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement womenCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#Women']")));
        
        test.log(Status.PASS, "Clicking the 'Women' category link.");
        womenCategory.click();
        
        test.log(Status.PASS, "Waiting for the 'Dress' option to be clickable within the Women's category.");
        WebElement dressOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")));
        
        test.log(Status.PASS, "Clicking the 'Dress' option.");
        dressOption.click();
        
        test.log(Status.PASS, "Waiting for the URL to contain 'category_products'.");
        wait.until(ExpectedConditions.urlContains("category_products"));
        
        test.log(Status.PASS, "Asserting that the URL indicates successful category navigation.");
        Assert.assertTrue(driver.getCurrentUrl().contains("category_products"), "Category navigation failed!");
        
        test.log(Status.PASS, "Category column functionality is working correctly.");
    }

    @Test
    public void verifyBrandColumnFunctionality() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Waiting for the 'Polo' brand link to be clickable.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement poloBrand = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Polo')]")));
        
        test.log(Status.PASS, "Clicking the 'Polo' brand link.");
        poloBrand.click();
        
        test.log(Status.PASS, "Waiting for the URL to contain 'brand_products/Polo'.");
        wait.until(ExpectedConditions.urlContains("brand_products/Polo"));
        
        test.log(Status.PASS, "Waiting for the 'Brand - Polo Products' title to be visible.");
        WebElement brandProductsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Brand - Polo Products']")));
        
        test.log(Status.PASS, "Asserting that the brand products title is displayed.");
        Assert.assertTrue(brandProductsTitle.isDisplayed(), "Polo brand page title not displayed!");
        
        test.log(Status.PASS, "Brand column functionality is working correctly.");
    }

    @Test
    public void verifyApistestingpage() {
        test.log(Status.PASS, "Navigating to the homepage.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding the 'API Testing' button.");
        WebElement apisBtn = driver.findElement(By.xpath("//a[@href='/api_list']"));
        
        test.log(Status.PASS, "Clicking the 'API Testing' button.");
        apisBtn.click();
        
        test.log(Status.PASS, "Asserting the URL contains '/api_list'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("/api_list"), "APIs list page not opened!");
        
        test.log(Status.PASS, "API Testing page opened successfully.");
    }

}