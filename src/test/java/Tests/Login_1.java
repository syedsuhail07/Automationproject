package Tests;

 

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_1 extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Test(priority = 1)
    public void verifyLoginInputAcceptsUserInput() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));

        email.sendKeys("testuser@example.com");
        password.sendKeys("dummyPassword");
        Assert.assertEquals(email.getAttribute("value"), "testuser@example.com");
    }

    @Test(priority = 2)
    public void verifySuccessfulLogin() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("validuser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("validpassword");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed(),
                "Login failed with valid credentials");
    }

    @Test(priority = 3)
    public void verifyLoginWithValidUserInvalidPassword() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("validuser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("wrongPassword");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid password");
    }

    @Test(priority = 4)
    public void verifyLoginWithInvalidUserValidPassword() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("invaliduser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("validpassword");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid username");
    }

    @Test(priority = 5)
    public void verifyLoginWithInvalidUserInvalidPassword() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("invaliduser@example.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("invalidpassword");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).isDisplayed(),
                "Error message not displayed for invalid credentials");
    }
}
