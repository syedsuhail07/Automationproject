package Tests;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class UI_Home extends BaseTest {

    @Test
    public void verifyProductButtonFunctionality() {
        driver.get("https://automationexercise.com/");
        WebElement productBtn = driver.findElement(By.xpath("//a[@href='/products']"));
        productBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/products"), "Product page not opened!");
    }

    @Test
    public void verifyContactUsRedirect() {
        driver.get("https://automationexercise.com/");
        WebElement contactBtn = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/contact_us"), "Contact Us page not opened!");
    }

    @Test
    public void verifyRightHandScrollBar() {
        driver.get("https://automationexercise.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScroll = (Long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollBy(0, 1000);");
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(afterScroll > initialScroll, "Scroll bar did not work!");
    }

    @Test
    public void verifyScrollUpButton() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000); // let the scroll complete
        WebElement scrollUpBtn = driver.findElement(By.id("scrollUp"));
        scrollUpBtn.click();
        Thread.sleep(2000);
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertEquals(afterScroll.longValue(), 0L, "Scroll up button did not work!");
    }

    @Test
    public void verifyLogoRedirectsHome() {
        driver.get("https://automationexercise.com/products");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']//a"));
        logo.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"), "Logo did not redirect to Home!");
    }
}
