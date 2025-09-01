 
package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_4 extends Base.BaseTest {

    String validEmail = "qwertyuiopasdf@gmail.com";  
    String validPassword = "abc@123";                

    @Test
    public void testHomeIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homeIcon.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Home icon did not redirect correctly.");
    }

    @Test
    public void testLoginIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement loginIcon = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        loginIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login icon did not redirect to login page.");
    }

    @Test
    public void testProductIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement productIcon = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Product icon did not redirect to Products page.");
    }

    @Test
    public void testCartIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(text(),'Cart')]"));
        cartIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart icon did not redirect to Cart page.");
    }

    @Test
    public void testTestCasesIconOnLoginPage() {
        driver.get("https://automationexercise.com/login");
        WebElement testCasesIcon = driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]"));
        testCasesIcon.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "Test Cases icon did not redirect to Test Cases page.");
    }
}
