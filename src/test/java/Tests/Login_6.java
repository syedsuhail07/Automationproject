package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_6 extends Base.BaseTest {

    @Test
    public void testScrollDownUsingMouseScrollOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1000).perform();
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using mouse scroll.");
    }

    @Test
    public void testScrollUpUsingMouseScrollOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 1000).perform();
        actions.scrollByAmount(0, -1000).perform();
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using mouse scroll.");
    }

    @Test
    public void testScrollDownUsingKeyboardOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using keyboard.");
    }

    @Test
    public void testScrollUpUsingKeyboardOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using keyboard.");
    }

    @Test
    public void testScrollDownUsingMouseClickOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.isDisplayed(), "Failed to scroll down using mouse click (JS).");
    }

    @Test
    public void testScrollUpUsingMouseClickOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
        js.executeScript("window.scrollBy(0, -1000)");
        WebElement header = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(header.isDisplayed(), "Failed to scroll up using mouse click (JS).");
    }
}
