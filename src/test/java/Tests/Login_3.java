
package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_3 extends Base.BaseTest {

    String validEmail = "qwertyuiopasdf@gmail.com";   // update this
    String validPassword = "abc@123";                // update this
    String invalidEmail = "invaliduser@example.com";
    String invalidPassword = "wrongpass123";

    @Test
    public void testLogoutAfterLogin() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        Assert.assertTrue(logoutBtn.isDisplayed(), "Logout button not displayed after login.");
        logoutBtn.click();

        WebElement loginBtn = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        Assert.assertTrue(loginBtn.isDisplayed(), "User not redirected to login page after logout.");
    }

    @Test
    public void testUserIconOrUsernameDisplayedAfterLogin() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "User icon/username not displayed after login.");
    }

    @Test
    public void testCaseSensitivityInCredentials() {
        driver.get("https://automationexercise.com/login");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail.toUpperCase());
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword.toUpperCase());
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Case sensitivity not enforced in login credentials.");
    }

    @Test
    public void testMaxCharacterLimitForUserIdAndPassword() {
        driver.get("https://automationexercise.com/login");
        String longText = "a".repeat(300);   // 300 chars

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(longText);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(longText);

        String enteredEmail = driver.findElement(By.cssSelector("input[data-qa='login-email']")).getAttribute("value");
        String enteredPassword = driver.findElement(By.cssSelector("input[data-qa='login-password']")).getAttribute("value");

        Assert.assertTrue(enteredEmail.length() <= 255, "Email field accepts more than max characters.");
        Assert.assertTrue(enteredPassword.length() <= 255, "Password field accepts more than max characters.");
    }

    @Test
    public void testSubscriptionFieldDisplayedOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement subscriptionField = driver.findElement(By.cssSelector("input#susbscribe_email, input[type='email'][name='email']"));
        Assert.assertTrue(subscriptionField.isDisplayed(), "Subscription field not displayed on login page.");
    }
}
