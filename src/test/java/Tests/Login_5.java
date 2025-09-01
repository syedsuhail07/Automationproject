package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_5 extends Base.BaseTest {

    @Test
    public void testApiTestingIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement apiTestingIcon = driver.findElement(By.xpath("//a[contains(text(),'API Testing')]"));
        apiTestingIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("api_list"), "API Testing icon did not redirect correctly.");
    }

    @Test
    public void testVideoTutorialsIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),'Video Tutorials')]"));
        videoTutorialsIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"), "Video Tutorials icon did not redirect to YouTube.");
    }

    @Test
    public void testContactUsIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement contactUsIcon = driver.findElement(By.xpath("//a[contains(text(),'Contact us')]"));
        contactUsIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Contact Us icon did not redirect correctly.");
    }

    @Test
    public void testAutomationExerciseLogoOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']/a/img"));
        logo.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Logo did not redirect to Home page.");
    }

    @Test
    public void testSubscriptionEmailEntryFieldOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement emailField = driver.findElement(By.id("susbscribe_email"));
        emailField.sendKeys("venkat@gmail.com");
        driver.findElement(By.id("subscribe")).click();
        WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(),'You have been successfully subscribed!')]"));
        Assert.assertTrue(successMsg.isDisplayed(), "Subscription success message not displayed.");
    }
}
