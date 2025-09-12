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

public class Login_4 extends BaseTest {

    String validEmail = "qwertyuiopasdf@gmail.com";  
    String validPassword = "abc@123";                

    @Test
    public void testHomeIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the Home icon.");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        
        test.log(Status.PASS, "Clicking the Home icon.");
        homeIcon.click();
        
        test.log(Status.PASS, "Asserting the URL redirects to the homepage.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Home icon did not redirect correctly.");
        
        test.log(Status.PASS, "Home icon redirected to the homepage successfully.");
    }

    @Test
    public void testLoginIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Signup / Login' icon.");
        WebElement loginIcon = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        
        test.log(Status.PASS, "Clicking the 'Signup / Login' icon.");
        loginIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'login'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login icon did not redirect to login page.");
        
        test.log(Status.PASS, "Login icon redirected to the login page successfully.");
    }

    @Test
    public void testProductIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Products' icon.");
        WebElement productIcon = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        
        test.log(Status.PASS, "Clicking the 'Products' icon.");
        productIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'products'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Product icon did not redirect to Products page.");
        
        test.log(Status.PASS, "Product icon redirected to the Products page successfully.");
    }

    @Test
    public void testCartIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Cart' icon.");
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
        
        test.log(Status.PASS, "Clicking the 'Cart' icon.");
        cartIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'view_cart'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart icon did not redirect to Cart page.");
        
        test.log(Status.PASS, "Cart icon redirected to the Cart page successfully.");
    }

    @Test
    public void testTestCasesIconOnLoginPage() {
        test.log(Status.PASS, "Navigating to the login page.");
        driver.get("https://automationexercise.com/login");
        
        test.log(Status.PASS, "Finding the 'Test Cases' icon.");
        WebElement testCasesIcon = driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
        
        test.log(Status.PASS, "Clicking the 'Test Cases' icon.");
        testCasesIcon.click();
        
        test.log(Status.PASS, "Asserting the URL contains 'test_cases'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "Test Cases icon did not redirect to Test Cases page.");
        
        test.log(Status.PASS, "Test Cases icon redirected to the Test Cases page successfully.");
    }

}