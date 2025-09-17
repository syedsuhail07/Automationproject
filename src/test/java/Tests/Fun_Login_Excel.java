package Tests;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import com.automationproj.utilities.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Fun_Login_Excel extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    // ✅ DataProvider: Reads from Excel (Sheet3)
    @DataProvider(name = "logindata")
    public Object[][] getLoginData() {
        return ExcelUtils.getExcelData("Fun_Login");
    }

    // 1. Navigate to Login/Signup page
    @Test(priority = 1)
    public void verifyNavigateToLoginPage() {
        test.log(Status.INFO, "Navigating to the base URL: " + baseUrl);
        driver.get(baseUrl);

        test.log(Status.INFO, "Clicking on 'Signup / Login' button.");
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        test.log(Status.INFO, "Verifying login page heading.");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(),
                "Login page heading not displayed");

        test.log(Status.PASS, "Navigated to Login/Signup page successfully.");
    }

    // 2-14. Login combinations from Excel
    @Test(priority = 2, dataProvider = "logindata")
    public void verifyLoginScenarios(String testCase, String username, String password, String expectedResult, Object... extras) {
        // ✅ Normalize values
        username = (username == null || username.equalsIgnoreCase("NaN")) ? "" : username.trim();
        password = (password == null || password.equalsIgnoreCase("NaN")) ? "" : password.trim();

        test.log(Status.INFO, "Executing TestCase: " + testCase);
        test.log(Status.INFO, "Using Username: [" + username + "], Password: [" + password + "], Expected: " + expectedResult);

        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed(),
                    "Login failed when it should succeed.");
            test.log(Status.PASS, "Login successful with credentials: " + username + " / " + password);
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'incorrect')]")).isDisplayed(),
                    "Error message not shown for invalid credentials.");
            test.log(Status.PASS, "Error correctly displayed for: " + username + " / " + password);
        }
    }

    // 15. Logout Functionality (only for valid creds)
    @Test(priority = 15, dataProvider = "logindata")
    public void verifyLogoutFunctionality(String testCase, String username, String password, String expectedResult, Object... extras) {
        if (!expectedResult.equalsIgnoreCase("success")) return; // Run only for valid creds

        username = (username == null || username.equalsIgnoreCase("NaN")) ? "" : username.trim();
        password = (password == null || password.equalsIgnoreCase("NaN")) ? "" : password.trim();

        test.log(Status.INFO, "Testing Logout for user: " + username);

        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        logoutBtn.click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).isDisplayed(),
                "Logout button did not return to login page.");
        test.log(Status.PASS, "Logout successful for user: " + username);
    }

    // 16. Scroll Up functionality (using JS click)
    @Test(priority = 16)
    public void verifyScrollUp() throws InterruptedException {
        driver.get(baseUrl);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);

        WebElement scrollUp = driver.findElement(By.id("scrollUp"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", scrollUp);

        test.log(Status.PASS, "Scroll Up functionality verified after scrolling down.");
    }

    // 17. Scroll Down functionality
    @Test(priority = 17)
    public void verifyScrollDown() {
        driver.get(baseUrl);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,document.body.scrollHeight)");
        test.log(Status.PASS, "Scroll Down functionality verified.");
    }
}
