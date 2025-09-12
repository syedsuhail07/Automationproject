package Tests;

import Base.BaseTest;

import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Login_3 extends BaseTest {

    String validEmail = "asdffdsa@gmail.com";
    String validPassword = "apple";
    String invalidEmail = "invaliduser@example.com";
    String invalidPassword = "wrongpass123";

    @Test
    public void testLogoutAfterLogin() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a valid email and password.");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        
        test.log(Status.PASS, "Clicking the login button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding and asserting that the Logout button is displayed.");
        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        Assert.assertTrue(logoutBtn.isDisplayed(), "Logout button not displayed after login.");
        
        test.log(Status.PASS, "Clicking the Logout button.");
        logoutBtn.click();
        
        test.log(Status.PASS, "Finding and asserting that the Login button is displayed on the redirected page.");
        WebElement loginBtn = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        Assert.assertTrue(loginBtn.isDisplayed(), "User not redirected to login page after logout.");
        
        test.log(Status.PASS, "Logout functionality is working correctly.");
    }

    @Test
    public void testUserIconOrUsernameDisplayedAfterLogin() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a valid email and password.");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword);
        
        test.log(Status.PASS, "Clicking the login button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding and asserting that the 'Logged in as' text is displayed.");
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInText.isDisplayed(), "User icon/username not displayed after login.");
        
        test.log(Status.PASS, "User icon/username is displayed after successful login.");
    }

    @Test
    public void testCaseSensitivityInCredentials() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering credentials in uppercase to test case sensitivity.");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(validEmail.toUpperCase());
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(validPassword.toUpperCase());
        
        test.log(Status.PASS, "Clicking the login button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding and asserting that an error message is displayed.");
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Case sensitivity not enforced in login credentials.");
        
        test.log(Status.PASS, "Login failed as expected due to case sensitivity.");
    }

    @Test
    public void testMaxCharacterLimitForUserIdAndPassword() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Creating a long string of 300 characters.");
        String longText = "a".repeat(300);
        
        test.log(Status.PASS, "Entering the long string into the email and password fields.");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(longText);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(longText);
        
        test.log(Status.PASS, "Getting the value of the email and password fields.");
        String enteredEmail = driver.findElement(By.cssSelector("input[data-qa='login-email']")).getAttribute("value");
        String enteredPassword = driver.findElement(By.cssSelector("input[data-qa='login-password']")).getAttribute("value");
        
        test.log(Status.PASS, "Asserting that the email field does not exceed the character limit.");
        Assert.assertTrue(enteredEmail.length() <= 255, "Email field accepts more than max characters.");
        
        test.log(Status.PASS, "Asserting that the password field does not exceed the character limit.");
        Assert.assertTrue(enteredPassword.length() <= 255, "Password field accepts more than max characters.");
        
        test.log(Status.PASS, "Both email and password fields respect the character limit.");
    }

    @Test
    public void testSubscriptionFieldDisplayedOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the subscription field.");
        WebElement subscriptionField = driver.findElement(By.cssSelector("input#susbscribe_email, input[type='email'][name='email']"));
        
        test.log(Status.PASS, "Asserting that the subscription field is displayed.");
        Assert.assertTrue(subscriptionField.isDisplayed(), "Subscription field not displayed on login page.");
        
        test.log(Status.PASS, "Subscription field is correctly displayed on the login page.");
    }

}