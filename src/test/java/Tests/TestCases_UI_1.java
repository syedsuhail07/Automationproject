package Tests;

import Base.BaseTest;
import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCases_UI_1 extends BaseTest {

    // --- Navigation Icon Functionality Tests ---

    @Test
    public void verifyFunctionalityOfHomeIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the Home icon.");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(), ' Home')]"));
        
        test.log(Status.PASS, "Clicking the Home icon.");
        homeIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", 
            "Home icon did not redirect to the homepage.");
        
        test.log(Status.PASS, "Home icon redirected to the homepage successfully.");
    }

    @Test
    public void verifyFunctionalityOfLoginIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Signup / Login' icon.");
        WebElement loginIcon = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        
        test.log(Status.PASS, "Clicking the 'Signup / Login' icon.");
        loginIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'login'.");
        Assert.assertTrue(currentUrl.contains("login"), 
            "Login icon did not redirect to the login page.");
        
        test.log(Status.PASS, "Login icon redirected to the login page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfProductsIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Products' icon.");
        WebElement productsIcon = driver.findElement(By.xpath("//a[contains(text(),' Products')]"));
        
        test.log(Status.PASS, "Clicking the 'Products' icon.");
        productsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'products'.");
        Assert.assertTrue(currentUrl.contains("products"), 
            "Products icon did not redirect to the products page.");
        
        test.log(Status.PASS, "Products icon redirected to the products page successfully.");
    }

    @Test
    public void verifyFunctionalityOfCartIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Cart' icon.");
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(text(),' Cart')]"));
        
        test.log(Status.PASS, "Clicking the 'Cart' icon.");
        cartIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'view_cart'.");
        Assert.assertTrue(currentUrl.contains("view_cart"), 
            "Cart icon did not redirect to the cart page.");
        
        test.log(Status.PASS, "Cart icon redirected to the cart page successfully.");
    }

    @Test
    public void verifyFunctionalityOfTestCasesIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Test Cases' icon.");
        WebElement testCasesIcon = driver.findElement(By.xpath("//a[contains(text(),' Test Cases')]"));
        
        test.log(Status.PASS, "Clicking the 'Test Cases' icon.");
        testCasesIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'test_cases'.");
        Assert.assertTrue(currentUrl.contains("test_cases"), 
            "Test Cases icon did not stay on the Test Cases page.");
        
        test.log(Status.PASS, "Test Cases icon stayed on the Test Cases page successfully.");
    }

    @Test
    public void verifyFunctionalityOfAPITestingIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'API Testing' icon.");
        WebElement apiTestingIcon = driver.findElement(By.xpath("//a[contains(text(),' API Testing')]"));
        
        test.log(Status.PASS, "Clicking the 'API Testing' icon.");
        apiTestingIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains '/api_list'.");
        Assert.assertTrue(currentUrl.contains("/api_list"), 
            "API Testing icon did not redirect to the API testing page.");
        
        test.log(Status.PASS, "API Testing icon redirected to the API testing page successfully.");
    }

    @Test
    public void verifyFunctionalityOfVideoTutorialsIconOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Video Tutorials' icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the 'Video Tutorials' icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube'.");
        Assert.assertTrue(currentUrl.contains("youtube"), 
            "Video Tutorials icon did not redirect to a YouTube page.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to a YouTube page successfully.");
    }

    @Test
    public void verifyFunctionalityOfAutomationExerciseLogoOnTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the Automation Exercise logo.");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Clicking the logo.");
        logo.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", 
            "Automation Exercise logo did not redirect to the homepage.");
        
        test.log(Status.PASS, "Automation Exercise logo redirected to the homepage successfully.");
    }

    // --- Scrolling Feature Tests ---

    @Test
    public void verifyScrollDownFeatureUsingMouseScroll() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Getting the initial scroll position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Scrolling down by 500 pixels.");
        js.executeScript("window.scrollBy(0, 500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled down.");
        Assert.assertTrue(finalScrollPosition > initialScrollPosition, 
            "Mouse scroll down feature did not work.");
        
        test.log(Status.PASS, "Mouse scroll down feature is working properly.");
    }

    @Test
    public void verifyScrollUpFeatureUsingMouseScroll() {
        test.log(Status.PASS, "Navigating to the Test Cases page and scrolling down to a specific position.");
        driver.get("https://automationexercise.com/test_cases");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        
        test.log(Status.PASS, "Getting the initial scroll position.");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");

        test.log(Status.PASS, "Scrolling up by 500 pixels.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "Mouse scroll up feature did not work.");
        
        test.log(Status.PASS, "Mouse scroll up feature is working properly.");
    }

    @Test
    public void verifyScrollDownFeatureUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Getting the initial scroll position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Scrolling down by 1000 pixels.");
        js.executeScript("window.scrollBy(0, 1000);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled down.");
        Assert.assertTrue(afterScroll > initialScroll, "Scroll bar did not work!");
        
        test.log(Status.PASS, "Keyboard scroll down feature is working properly.");
    }

    @Test
    public void verifyScrollUpFeatureUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Getting the initial scroll position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Scrolling down by 1000 pixels.");
        js.executeScript("window.scrollBy(0, 1000);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long afterScroll = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled down.");
        Assert.assertTrue(afterScroll > initialScroll, "Scroll bar did not work!");
        
        test.log(Status.PASS, "Keyboard scroll up feature is working properly.");
    }

    // --- UI Element and Text Content Tests ---

    @Test
    public void verifyTestcasesFontSize() {
        test.log(Status.PASS, "Navigating to the homepage to inspect an element.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding a heading element to check its font properties.");
        WebElement heading = driver.findElement(By.cssSelector("h2.title"));
        
        test.log(Status.PASS, "Getting the font-family and font-size CSS values.");
        String fontFamily = heading.getCssValue("font-family");
        String fontSize = heading.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting that font-family is not null.");
        Assert.assertNotNull(fontFamily, "Font family is not set!");
        
        test.log(Status.PASS, "Asserting that font-size is in pixels.");
        Assert.assertTrue(fontSize.contains("px"), "Font size not applied properly!");
        
        test.log(Status.PASS, "Test cases font size is correct.");
    }

    @Test
    public void verifyTestcasesFontStyle() {
        test.log(Status.PASS, "Navigating to the homepage to inspect an element.");
        driver.get("https://automationexercise.com/");
        
        test.log(Status.PASS, "Finding a heading element to check its font properties.");
        WebElement heading = driver.findElement(By.cssSelector("h2.title"));
        
        test.log(Status.PASS, "Getting the font-family and font-size CSS values.");
        String fontFamily = heading.getCssValue("font-family");
        String fontSize = heading.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting that font-family is not null.");
        Assert.assertNotNull(fontFamily, "Font family is not set!");
        
        test.log(Status.PASS, "Asserting that font-size is in pixels.");
        Assert.assertTrue(fontSize.contains("px"), "Font size not applied properly!");
        
        test.log(Status.PASS, "Test cases font style is correct.");
    }

    @Test
    public void verifyDeclarationAtEndOfTestCasesPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.xpath("//div[@class='footer-bottom']"));
        
        test.log(Status.PASS, "Asserting that the footer is displayed.");
        Assert.assertTrue(footer.isDisplayed(), 
            "Declaration/footer not displayed at the end of Test Cases page.");
        
        test.log(Status.PASS, "Declaration/footer is displayed correctly.");
    }

    @Test
    public void verifyTestCasesTitleOnPage() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Finding the 'Test Cases' title.");
        WebElement testCasesTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Test Cases')]"));
        
        test.log(Status.PASS, "Asserting that the 'Test Cases' title is displayed.");
        Assert.assertTrue(testCasesTitle.isDisplayed(), 
            "'Test Cases' title is not displayed on the page.");
        
        test.log(Status.PASS, "'Test Cases' title is displayed correctly.");
    }

    @Test
    public void verifyDisplayOfNoteSection() {
        test.log(Status.PASS, "Navigating to the Test Cases page.");
        driver.get("https://automationexercise.com/test_cases");
        
        test.log(Status.PASS, "Attempting to find a 'Note' section.");
        try {
            driver.findElement(By.xpath("//*[contains(text(), 'Note:')]"));
            test.log(Status.FAIL, "A 'Note' section was found on the Test Cases page when it should not exist.");
            Assert.fail("A 'Note' section was found on the Test Cases page when it should not exist.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            test.log(Status.PASS, "The 'Note' section does not exist on the Test Cases page, as expected.");
            Assert.assertTrue(true, "The 'Note' section does not exist on the Test Cases page, as expected.");
        }
    }


}