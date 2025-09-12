package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationproj.pages.TestCasesPage;
import com.automationproj.utilities.ScreenshotUtils;

import Base.BaseTest;

public class TCpageTest extends BaseTest {

    String baseUrl = "https://www.automationexercise.com/";

    // 1. Verify and validate the Test Cases button
    @Test(priority = 1)
    public void verifyTestCasesButton() {
        driver.get(baseUrl);
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.clickTestCasesButton();

        Assert.assertTrue(testCasesPage.isOnTestCasesPage(), "Not on Test Cases page");
        ScreenshotUtils.takeScreenshot(driver, "TestCases_Page");
    }

    // 2. Expand all 26 panels and take screenshots
    @Test(priority = 2)
    public void expandAllPanelsAndTakeScreenshots() {
        driver.get(baseUrl);
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.clickTestCasesButton();

        int panelCount = testCasesPage.getPanelCount();
        Assert.assertTrue(panelCount >= 26, "Expected at least 26 panels");

        for (int i = 1; i <= 26; i++) {
            WebElement header = testCasesPage.getPanelHeader(i);
            WebElement body = testCasesPage.getPanelBody(i);

            testCasesPage.scrollToElement(header);
            header.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOf(body));
            
            Assert.assertTrue(body.isDisplayed(), "Panel " + i + " did not expand");
            ScreenshotUtils.takeScreenshot(driver, "Panel_Expanded_" + i);

            header.click(); // collapse
        }
    }

    //  3. Navigate all URLs in all panels and take screenshot after navigation
    @Test(priority = 3)
    public void navigateUrlsAndTakeScreenshots() {
        driver.get(baseUrl);
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        testCasesPage.clickTestCasesButton();

        for (int i = 1; i <= 26; i++) {
            WebElement header = testCasesPage.getPanelHeader(i);
            testCasesPage.scrollToElement(header);
            header.click();

            List<WebElement> urls = testCasesPage.getPanelUrls(i);

            for (int j = 0; j < urls.size(); j++) {
                WebElement url = urls.get(j);
                String link = url.getAttribute("href");
                Assert.assertNotNull(link, "No URL found in Test Case " + i);

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", url);

                String expected = link.replace("http://", "https://");
                Assert.assertTrue(driver.getCurrentUrl().contains(expected),
                        "Navigation failed for Test Case " + i);

                ScreenshotUtils.takeScreenshot(driver, "Panel_" + i + "_URL" + (j + 1) + "_Navigation");

                driver.navigate().back(); // go back
                testCasesPage.clickTestCasesButton();
                header = testCasesPage.getPanelHeader(i); // re-locate
                header.click();
            }
        }
    }

    // 4. Verify scroll down and scroll up functionality
    @Test(priority = 4)
    public void verifyScrollDownAndUp() {
        driver.get(baseUrl);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        // Scroll down
        testCasesPage.scrollToBottom();
        ScreenshotUtils.takeScreenshot(driver, "Scroll_Down");
        Assert.assertTrue(testCasesPage.getScrollPosition() > 0, "Scroll down failed");

        // Scroll up
        testCasesPage.scrollToTop();
        ScreenshotUtils.takeScreenshot(driver, "Scroll_Up");
        Assert.assertTrue(testCasesPage.getScrollPosition() == 0, "Scroll up failed");
    }
}
