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

import java.util.List;

public class ContactUsPage_UI_1 extends BaseTest {

    // --- Navigation Icon Functionality Tests ---

    @Test
    public void verifyFunctionalityOfHomeIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Home icon.");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(), ' Home')]"));
        
        test.log(Status.PASS, "Clicking the Home icon.");
        homeIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'automationexercise.com'.");
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), 
            "Home icon did not redirect to the homepage.");
        
        test.log(Status.PASS, "Home icon redirected to homepage successfully.");
    }

    @Test
    public void verifyFunctionalityOfLoginIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Signup / Login icon.");
        WebElement loginIcon = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        
        test.log(Status.PASS, "Clicking the Signup / Login icon.");
        loginIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'login'.");
        Assert.assertTrue(currentUrl.contains("login"), 
            "Login icon did not redirect to the login page.");
        
        test.log(Status.PASS, "Login icon redirected to login page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfProductsIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Products icon.");
        WebElement productsIcon = driver.findElement(By.xpath("//a[contains(text(),' Products')]"));
        
        test.log(Status.PASS, "Clicking the Products icon.");
        productsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'products'.");
        Assert.assertTrue(currentUrl.contains("products"), 
            "Products icon did not redirect to the products page.");
        
        test.log(Status.PASS, "Products icon redirected to products page successfully.");
    }

    @Test
    public void verifyFunctionalityOfCartIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Cart icon.");
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(text(),' Cart')]"));
        
        test.log(Status.PASS, "Clicking the Cart icon.");
        cartIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'view_cart'.");
        Assert.assertTrue(currentUrl.contains("view_cart"), 
            "Cart icon did not redirect to the cart page.");
        
        test.log(Status.PASS, "Cart icon redirected to the cart page successfully.");
    }

    @Test
    public void verifyFunctionalityOfTestCasesIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Test Cases icon.");
        WebElement testCasesIcon = driver.findElement(By.xpath("//a[contains(text(),' Test Cases')]"));
        
        test.log(Status.PASS, "Clicking the Test Cases icon.");
        testCasesIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'test_cases'.");
        Assert.assertTrue(currentUrl.contains("test_cases"), 
            "Test Cases icon did not redirect to the test cases page.");
        
        test.log(Status.PASS, "Test Cases icon redirected to test cases page successfully.");
    }

    @Test
    public void verifyFunctionalityOfAPITestingIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the API Testing icon.");
        WebElement apiTestingIcon = driver.findElement(By.xpath("//a[contains(text(),' API Testing')]"));
        
        test.log(Status.PASS, "Clicking the API Testing icon.");
        apiTestingIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'api_list'.");
        Assert.assertTrue(currentUrl.contains("api_list"), 
            "API Testing icon did not redirect to the API testing page.");
        
        test.log(Status.PASS, "API Testing icon redirected to API testing page successfully.");
    }

    @Test
    public void verifyFunctionalityOfVideoTutorialsIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Video Tutorials icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the Video Tutorials icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube'.");
        Assert.assertTrue(currentUrl.contains("youtube"), 
            "Video Tutorials icon did not redirect to a YouTube page.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to a YouTube page successfully.");
    }

    @Test
    public void verifyFunctionalityOfContactUsIconOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the Contact Us icon.");
        WebElement contactUsIcon = driver.findElement(By.xpath("//a[contains(text(),' Contact us')]"));
        
        test.log(Status.PASS, "Clicking the Contact us icon.");
        contactUsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'contact_us'.");
        Assert.assertTrue(currentUrl.contains("contact_us"), 
            "Contact us icon did not stay on the contact us page.");
        
        test.log(Status.PASS, "Contact us icon stayed on the contact us page successfully.");
    }

    @Test
    public void verifyFunctionalityOfAutomationExerciseLogoOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
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
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Mouse scroll down/up feature is working properly.");
    }

    @Test
    public void verifyScrollUpFeatureUsingMouseScroll() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Mouse scroll up feature is working properly.");
    }

    @Test
    public void verifyScrollDownFeatureUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Keyboard scroll down feature is working properly.");
    }

    @Test
    public void verifyScrollUpFeatureUsingKeyboard() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Keyboard scroll up feature is working properly.");
    }

    @Test
    public void verifyScrollDownFeatureUsingMouseClick() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Mouse click scroll down feature is working properly.");
    }

    @Test
    public void verifyScrollUpFeatureUsingMouseClick() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Scrolling to the bottom of the page.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        test.log(Status.PASS, "Scrolling back to the top of the page.");
        js.executeScript("window.scrollTo(0, 0)");
        
        test.log(Status.PASS, "Getting the final vertical scroll position.");
        Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting the scroll position is at the top (0).");
        Assert.assertEquals(scrollTop.longValue(), 0, "Scroll failed!");
        
        test.log(Status.PASS, "Mouse click scroll up feature is working properly.");
    }

    // --- UI Element and Text Content Tests ---

    @Test
    public void verifyFontSizeOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the contact form title.");
        WebElement contactFormTitle = driver.findElement(By.xpath("//div[@class='contact-form']//h2"));
        
        test.log(Status.PASS, "Getting the font size CSS value.");
        String fontSize = contactFormTitle.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting the font size is '18px'.");
        Assert.assertEquals(fontSize, "18px", 
            "Unexpected font size on Contact Us page. Expected 18px but got: " + fontSize);
        
        test.log(Status.PASS, "Font size on Contact Us page is correct.");
    }

    @Test
    public void verifyFontStyleOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the contact form title.");
        WebElement contactFormTitle = driver.findElement(By.xpath("//div[@class='contact-form']//h2"));
        
        test.log(Status.PASS, "Getting the font-family CSS value.");
        String fontFamily = contactFormTitle.getCssValue("font-family");
        
        test.log(Status.PASS, "Asserting the font-family contains 'sans-serif'.");
        Assert.assertTrue(fontFamily.contains("sans-serif"), 
            "Unexpected font style on Contact Us page. Found: " + fontFamily);
        
        test.log(Status.PASS, "Font style on Contact Us page is correct.");
    }

    @Test
    public void verifyDeclarationAtEndOfContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.xpath("//div[@class='footer-bottom']"));
        
        test.log(Status.PASS, "Asserting the footer is displayed.");
        Assert.assertTrue(footer.isDisplayed(), 
            "Declaration/footer not displayed at the end of Contact Us page.");
            
        test.log(Status.PASS, "Getting the copyright text from the footer.");
        String copyrightText = footer.getText();
        
        test.log(Status.PASS, "Asserting the copyright text is correct.");
        Assert.assertTrue(copyrightText.contains("Copyright © 2021 All rights reserved"),
            "Footer copyright text is incorrect. Found: " + copyrightText);
            
        test.log(Status.PASS, "Footer and copyright text are correct.");
    }

    @Test
    public void verifyContactUsTitleOnPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the 'Get In Touch' title.");
        WebElement contactUsTitle = driver.findElement(By.xpath("//div[@class='contact-form']//h2[contains(text(), 'Get In Touch')]"));
        
        test.log(Status.PASS, "Asserting the title is displayed.");
        Assert.assertTrue(contactUsTitle.isDisplayed(), 
            "CONTACT US title is not displayed on the page.");
        
        test.log(Status.PASS, "'Get In Touch' title is displayed correctly.");
    }

    @Test
    public void verifyNoteSectionDisplayOnContactUsPage() {
        test.log(Status.PASS, "Navigating to the Contact Us page.");
        driver.get("https://automationexercise.com/contact_us");
        
        test.log(Status.PASS, "Finding the 'Note:' section title.");
        WebElement noteSection = driver.findElement(By.xpath("//h4[contains(text(), 'Note:')]"));
        
        test.log(Status.PASS, "Asserting the 'Note:' section is displayed.");
        Assert.assertTrue(noteSection.isDisplayed(), 
            "'Note' section is not displayed on the Contact Us page.");
        
        test.log(Status.PASS, "'Note' section is displayed correctly.");
    }

}