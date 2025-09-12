package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Product_UI_8 extends BaseTest {

    @Test
    public void verifyDisplayOfProductsInCatalogue() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the products catalogue container.");
        WebElement catalogue = driver.findElement(By.xpath("//div[@class='features_items']"));
        
        test.log(Status.PASS, "Asserting that the product catalogue is displayed.");
        Assert.assertTrue(catalogue.isDisplayed(),
            "Products are not displayed in the catalogue on Products page.");
            
        test.log(Status.PASS, "Products are displayed in the catalogue.");
    }

    @Test
    public void verifyFlowDownAnimationOnHoverProducts() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the first product in the catalogue.");
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='productPASS text-center'])[1]"));
        
        test.log(Status.PASS, "Hovering over the first product to trigger the flow down animation.");
        new Actions(driver).moveToElement(firstProduct).perform();

        test.log(Status.PASS, "Finding the overlay element that appears on hover.");
        WebElement overlay = driver.findElement(By.xpath("(//div[@class='overlay-content'])[1]"));
        
        test.log(Status.PASS, "Asserting that the overlay is displayed.");
        Assert.assertTrue(overlay.isDisplayed(),
            "Flow down animation not visible when hovering over product.");
            
        test.log(Status.PASS, "Flow down animation is visible on product hover.");
    }

    @Test
    public void verifyDeclarationAtEndOfProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the footer element at the end of the page.");
        WebElement footer = driver.findElement(By.xpath("//div[@class='footer-bottom']"));
        
        test.log(Status.PASS, "Asserting that the footer is displayed.");
        Assert.assertTrue(footer.isDisplayed(),
            "Declaration/footer not displayed at the end of Products page.");
            
        test.log(Status.PASS, "The footer is displayed correctly.");
    }

    @Test
    public void verifyCursorChangeOnAddToCart() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'Add to cart' button of the first product.");
        WebElement addToCartBtn = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));

        test.log(Status.PASS, "Getting the initial cursor style of the button.");
        String beforeCursor = addToCartBtn.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'Add to cart' button.");
        new Actions(driver).moveToElement(addToCartBtn).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = addToCartBtn.getCssValue("cursor");

        test.log(Status.PASS, "Asserting that the cursor style has changed.");
        Assert.assertNotEquals(beforeCursor, afterCursor,
            "Cursor did not change when hovering over Add to Cart.");
            
        test.log(Status.PASS, "Cursor changed on 'Add to cart' hover successfully.");
    }

    @Test
    public void verifyCursorChangeOnViewProductIcon() throws InterruptedException {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the 'View Product' icon of the first product.");
        WebElement viewProductIcon = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));

        test.log(Status.PASS, "Getting the initial cursor style of the icon.");
        String beforeCursor = viewProductIcon.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the 'View Product' icon.");
        new Actions(driver).moveToElement(viewProductIcon).perform();
        Thread.sleep(400);
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = viewProductIcon.getCssValue("cursor");

        test.log(Status.PASS, "Asserting that the cursor style has changed.");
        Assert.assertNotEquals(beforeCursor, afterCursor,
            "Cursor did not change when hovering over View Product icon.");
            
        test.log(Status.PASS, "Cursor changed on 'View Product' hover successfully.");
    }

    @Test
    public void verifyImageAlignmentOfProducts() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding the first and second product images.");
        WebElement firstImage = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[1]"));
        WebElement secondImage = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[2]"));

        test.log(Status.PASS, "Getting the Y-coordinate of both images to check vertical alignment.");
        int firstY = firstImage.getLocation().getY();
        int secondY = secondImage.getLocation().getY();

        test.log(Status.PASS, "Asserting that the Y-coordinates are equal.");
        Assert.assertEquals(firstY, secondY,
            "Product images are not properly aligned.");
            
        test.log(Status.PASS, "Product images are properly aligned.");
    }

    @Test
    public void verifyFontSizeOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding a product title to check its font size.");
        WebElement productTitle = driver.findElement(By.xpath("(//div[@class='productPASS text-center']/p)[1]"));
        
        test.log(Status.PASS, "Getting the font size CSS value.");
        String fontSize = productTitle.getCssValue("font-size");

        test.log(Status.PASS, "Asserting that the font size is '14px'.");
        Assert.assertEquals(fontSize, "14px",
            "Unexpected font size found on Products page. Expected 14px but got: " + fontSize);
            
        test.log(Status.PASS, "Font size on the products page is correct.");
    }

    @Test
    public void verifyFontStyleOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");

        test.log(Status.PASS, "Finding a product title to check its font style.");
        WebElement productTitle = driver.findElement(By.xpath("(//div[@class='productPASS text-center']/p)[1]"));
        
        test.log(Status.PASS, "Getting the font-family CSS value.");
        String fontFamily = productTitle.getCssValue("font-family");

        test.log(Status.PASS, "Asserting that the font-family contains 'sans-serif'.");
        Assert.assertTrue(fontFamily.contains("sans-serif"),
            "Unexpected font style on Products page. Found: " + fontFamily);
            
        test.log(Status.PASS, "Font style on the products page is correct.");
    }

}