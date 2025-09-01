package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

import java.time.Duration;
import java.util.List;

public class UI_Home_1 extends BaseTest {

    @Test
    public void verifySlideshowIsWorking() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement firstSlide = driver.findElement(By.cssSelector("#slider .item.active img"));
        String firstSrc = firstSlide.getAttribute("src");
        Thread.sleep(6000); // wait for slideshow
        WebElement secondSlide = driver.findElement(By.cssSelector("#slider .item.active img"));
        String secondSrc = secondSlide.getAttribute("src");
        Assert.assertNotEquals(firstSrc, secondSrc, "Slideshow did not change images!");
    }

    @Test
    public void verifyCursorChangesOnHover() {
        driver.get("https://automationexercise.com/");
        WebElement product = driver.findElement(By.cssSelector(".features_items .product-image-wrapper"));
        new Actions(driver).moveToElement(product).perform();
        WebElement overlay = driver.findElement(By.cssSelector(".features_items .product-overlay"));
        Assert.assertTrue(overlay.isDisplayed(), "Overlay not shown on hover!");
    }

    @Test
    public void verifyAddToCartFromHomePage() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement product = driver.findElement(By.cssSelector(".features_items .product-image-wrapper"));
        new Actions(driver).moveToElement(product).perform();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".features_items .add-to-cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
        Assert.assertTrue(successModal.isDisplayed(), "Add to Cart modal not displayed!");
    }

    @Test
    public void verifyCarouselArrows() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement rightArrow = driver.findElement(By.cssSelector("a.right.carousel-control"));
        WebElement activeImg = driver.findElement(By.cssSelector("#slider .item.active img"));
        String firstSrc = activeImg.getAttribute("src");

        rightArrow.click();
        Thread.sleep(3000);
        WebElement newActiveImg = driver.findElement(By.cssSelector("#slider .item.active img"));
        String secondSrc = newActiveImg.getAttribute("src");

        Assert.assertNotEquals(firstSrc, secondSrc, "Right arrow did not change carousel image!");
    }

    @Test
    public void verifyHomepageBannersLoad() {
        driver.get("https://automationexercise.com/");
        List<WebElement> banners = driver.findElements(By.cssSelector(".advertisement img"));
        Assert.assertFalse(banners.isEmpty(), "No banners found on homepage!");
        for (WebElement banner : banners) {
            Assert.assertTrue(banner.isDisplayed(), "Banner not displayed!");
        }
    }

    @Test
    public void verifyCategoryColumnFunctionality() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        WebElement womenCategory = driver.findElement(By.xpath("//a[@href='#Women']"));
        womenCategory.click();
        Thread.sleep(1000);
        WebElement dressOption = driver.findElement(By.xpath("//a[contains(text(),'Dress')]"));
        dressOption.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("category_products"), "Category navigation failed!");
    }

    @Test
    public void verifyBrandColumnFunctionality() {
        driver.get("https://automationexercise.com/");
        WebElement poloBrand = driver.findElement(By.xpath("//a[contains(text(),'Polo')]"));
        poloBrand.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("brand_products/Polo"));

        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products/Polo"), "Polo brand filter not applied!");
    }

    @Test
    public void verifyApiTestingPage() {
        driver.get("https://automationexercise.com/");
        WebElement apiBtn = driver.findElement(By.xpath("//a[@href='/api_list']"));
        apiBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/api_list"), "API testing page not opened!");
        Assert.assertTrue(driver.findElement(By.cssSelector(".api-list")).isDisplayed(), "API list not visible!");
    }
}
