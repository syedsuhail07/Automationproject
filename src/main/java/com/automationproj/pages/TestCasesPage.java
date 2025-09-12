package com.automationproj.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestCasesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By testCasesBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    private By panels = By.xpath("//div[@class='panel-group']//h4/a");

    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickTestCasesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesBtn)).click();
        wait.until(ExpectedConditions.urlContains("test_cases"));
    }

    public boolean isOnTestCasesPage() {
        return driver.getCurrentUrl().contains("test_cases");
    }

    public int getPanelCount() {
        return driver.findElements(panels).size();
    }

    public WebElement getPanelHeader(int index) {
        return wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='panel-group']//h4/a)[" + index + "]")));
    }

    public WebElement getPanelBody(int index) {
        return driver.findElement(By.xpath("//div[@id='collapse" + index + "']"));
    }

    public List<WebElement> getPanelUrls(int index) {
        return driver.findElements(By.xpath("//div[@id='collapse" + index + "']//a"));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public long getScrollPosition() {
        return (long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
    }
}
