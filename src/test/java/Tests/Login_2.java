package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ExtentReportManager;
import com.automationproj.utilities.ExcelUtils;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_2 extends BaseTest {

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() {
        return ExcelUtils.getExcelData("Sheet1");
    }

    @Test(priority=2)
    public void testLoginWithoutUsernameAndPassword() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Clicking the login button without entering any credentials.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding the error message element.");
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        
        test.log(Status.PASS, "Asserting that the error message is displayed.");
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed for empty credentials.");
        
        test.log(Status.PASS, "Error message for empty credentials is shown correctly.");
    }

    @Test(priority=3)
    public void testLoginWithUsernameWithoutPassword() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a username.");
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("testuser@example.com");
        
        test.log(Status.PASS, "Clicking the login button without entering a password.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding the error message element.");
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        
        test.log(Status.PASS, "Asserting that the error message is displayed.");
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed when password is missing.");
        
        test.log(Status.PASS, "Error message for missing password is shown correctly.");
    }

    @Test(priority=4)
    public void testLoginWithoutUsernameWithPassword() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a password without a username.");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("dummyPassword");
        
        test.log(Status.PASS, "Clicking the login button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding the error message element.");
        WebElement errorMsg = driver.findElement(By.cssSelector("p[style='color: red;']"));
        
        test.log(Status.PASS, "Asserting that the error message is displayed.");
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed when username is missing.");
        
        test.log(Status.PASS, "Error message for missing username is shown correctly.");
    }

    @Test(priority=1,dataProvider = "loginCredentials")
    public void testLoginUsingLoginButtonWithValidCredentials(String email, String password) {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a valid email from Excel: " + email);
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
        
        test.log(Status.PASS, "Entering a valid password from Excel.");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);
        
        test.log(Status.PASS, "Clicking the 'Login' button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
        
        test.log(Status.PASS, "Finding the login");
        WebElement deeBt = driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]"));        

        test.log(Status.PASS, "Login was successful with valid credentials from Excel.");
    }

    @Test(priority=5,dataProvider = "loginCredentials")
    public void testDeleteAccountAfterLogin(String email, String password) {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Entering a valid email from Excel: " + email);
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
        
        test.log(Status.PASS, "Entering a valid password from Excel.");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);
        
        test.log(Status.PASS, "Clicking the 'Login' button.");
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        test.log(Status.PASS, "Finding the 'Delete Account' button.");
        WebElement deleteBtn = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
        
        test.log(Status.PASS, "Clicking the 'Delete Account' button.");
        deleteBtn.click();

        test.log(Status.PASS, "Finding the 'Account Deleted!' confirmation message.");
        WebElement deleteConfirm = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        
        test.log(Status.PASS, "Asserting that the delete confirmation message is displayed.");
        Assert.assertTrue(deleteConfirm.isDisplayed(), "Delete account confirmation not displayed.");
        
        test.log(Status.PASS, "Account was deleted successfully.");
    }
 
}