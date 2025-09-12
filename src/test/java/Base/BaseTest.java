//package Base;
//
//import java.io.IOException;
//import java.lang.reflect.Method;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import com.automationproj.utilities.ScreenshotUtils;
//import com.automationproj.utilities.ExtentReportManager;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseTest {
//    protected WebDriver driver;
//    protected static ExtentReports report = ExtentReportManager.getReportInstance(null);
//    protected ExtentTest test;
//
//    @BeforeMethod
//    @Parameters("browser")
//    public void setUp(String browser, Method method) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("safari")) {
//            driver = new SafariDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().avoidBrowserDetection().setup();
//            driver = new EdgeDriver();
//        }
//
//        driver.manage().window().maximize();
//
//        // Create test log in Extent Report
//        test = report.createTest(method.getName() + " on " + browser);
//    }
//
//    @AfterMethod
//    public void tearDown(ITestResult result) throws IOException {
//        // Always capture screenshot
//        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            test.fail("Test Failed").addScreenCaptureFromPath(screenshotPath);
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
//        } else if (result.getStatus() == ITestResult.SKIP) {
//            test.skip("Test Skipped").addScreenCaptureFromPath(screenshotPath);
//        }
//
//        if (driver != null) {
//            driver.quit();
//        }
//        report.flush();
//    }
//}


package Base;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.automationproj.utilities.ScreenshotUtils;
import com.automationproj.utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports report;
    protected ExtentTest test;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, Method method) {
        // Initialize ExtentReport with current class name
        String className = this.getClass().getSimpleName();
        report = ExtentReportManager.getReportInstance(className);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().avoidBrowserDetection().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        // Create test log in Extent Report
        test = report.createTest(method.getName() + " on " + browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed").addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped").addScreenCaptureFromPath(screenshotPath);
        }

        if (driver != null) {
            driver.quit();
        }
        report.flush();
    }
}
