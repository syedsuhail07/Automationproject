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

public class Login_1 extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Test(priority = 1)
    public void verifyLoginInputAcceptsUserInput() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);
        
        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        test.log(Status.INFO, "Finding the email and password input fields.");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));

        test.log(Status.INFO, "Entering a test email and password.");
        email.sendKeys("testuser@example.com");
        password.sendKeys("dummyPassword");
        
        test.log(Status.INFO, "Verifying the email input field accepts the value.");
        Assert.assertEquals(email.getAttribute("value"), "testuser@example.com");
        
        test.log(Status.PASS, "Login input fields are accepting user input as expected.");
    }

    @Test(priority = 2)
    public void verifySuccessfulLogin() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);
        
        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        test.log(Status.INFO, "Entering valid email and password.");
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("validuser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("validpassword");
        
        test.log(Status.INFO, "Clicking the 'Login' button.");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        test.log(Status.INFO, "Verifying if the 'Logout' button is displayed after login.");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed(),
                "Login failed with valid credentials");
        
        test.log(Status.PASS, "Login was successful with valid credentials.");
    }

    @Test(priority = 3)
    public void verifyLoginWithValidUserInvalidPassword() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);
        
        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        test.log(Status.INFO, "Entering valid email and invalid password.");
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("validuser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("wrongPassword");
        
        test.log(Status.INFO, "Clicking the 'Login' button.");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        test.log(Status.INFO, "Verifying the error message for invalid password is displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid password");
        
        test.log(Status.PASS, "Login failed as expected with invalid password.");
    }

    @Test(priority = 4)
    public void verifyLoginWithInvalidUserValidPassword() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);
        
        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        test.log(Status.INFO, "Entering invalid email and valid password.");
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("invaliduser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("validpassword");
        
        test.log(Status.INFO, "Clicking the 'Login' button.");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        test.log(Status.INFO, "Verifying the error message for invalid username is displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid username");
        
        test.log(Status.PASS, "Login failed as expected with invalid username.");
    }

    @Test(priority = 5)
    public void verifyLoginWithInvalidUserInvalidPassword() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);
        
        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        
        test.log(Status.INFO, "Entering invalid email and invalid password.");
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("invaliduser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("invalidpassword");
        
        test.log(Status.INFO, "Clicking the 'Login' button.");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        test.log(Status.INFO, "Verifying the error message for invalid credentials is displayed.");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid credentials");
        
        test.log(Status.PASS, "Login failed as expected with invalid credentials.");
    }
    
  
}