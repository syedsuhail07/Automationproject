package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Product_UI_1 extends BaseTest {

    @Test
    public void verifyHomeIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the Home icon.");
        driver.findElement(By.xpath("//a[@href='/']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'automationexercise.com'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"), 
                "Home icon navigation failed!");
        
        test.log(Status.PASS, "Home icon redirected to the homepage successfully.");
    }

    @Test
    public void verifyLoginIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Signup / Login' icon.");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'login'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), 
                "Login icon navigation failed!");
        
        test.log(Status.PASS, "Login icon redirected to the login page successfully.");
    }

    @Test
    public void verifyProductIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Products' icon.");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'products'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), 
                "Product icon navigation failed!");
        
        test.log(Status.PASS, "Product icon stayed on the products page successfully.");
    }

    @Test
    public void verifyCartIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Cart' icon.");
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'cart'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), 
                "Cart icon navigation failed!");
        
        test.log(Status.PASS, "Cart icon redirected to the cart page successfully.");
    }

    @Test
    public void verifyTestCasesIconOnProductsPage() {
        test.log(Status.PASS, "Navigating to the products page.");
        driver.get("https://automationexercise.com/products");
        
        test.log(Status.PASS, "Clicking the 'Test Cases' icon.");
        driver.findElement(By.xpath("//a[@href='/test_cases']")).click();
        
        test.log(Status.PASS, "Asserting the URL contains 'test_cases'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"), 
                "Test cases icon navigation failed!");
        
        test.log(Status.PASS, "Test Cases icon redirected to the test cases page successfully.");
    }


}