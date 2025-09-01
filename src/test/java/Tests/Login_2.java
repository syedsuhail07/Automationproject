package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_2 extends Base.BaseTest {

    String validEmail = "qwertyuiopasdf@gmail.com";   // update this
    String validPassword = "abc@123";         // update this
    String invalidEmail = "invaliduser@example.com";
    String invalidPassword = "wrongpass123";

    @Test
    public void testLoginWithoutUsernameAndPassword() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for empty credentials.");
    }

    @Test
    public void testLoginWithUsernameWithoutPassword() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed when password is missing.");
    }

    @Test
    public void testLoginWithoutUsernameWithPassword() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed when username is missing.");
    }

    @Test
    public void testLoginUsingLoginButtonWithValidCredentials() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "Login not successful with valid credentials.");
    }

    @Test
    public void testDeleteAccountAfterLogin() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        WebElement deleteBtn = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
        deleteBtn.click();

        WebElement deleteConfirm = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        Assert.assertTrue(deleteConfirm.isDisplayed(), "Delete account confirmation not displayed.");
    }
}
