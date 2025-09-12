package Tests;

import Base.BaseTest;
import com.aventstack.extentreports.Status;
import com.automationproj.utilities.ScreenshotUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ALLCART_UI extends BaseTest {

    @Test
    public void verifyFunctionalityOfHomeIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the Home icon.");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(), ' Home')]"));
        
        test.log(Status.PASS, "Clicking the Home icon.");
        homeIcon.click();

        test.log(Status.PASS, "Getting the current URL after clicking.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains the expected domain.");
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), 
            "Home icon did not redirect to the homepage.");
        
        test.log(Status.PASS, "Home icon redirected to the homepage successfully.");
    }

    @Test
    public void verifyFunctionalityOfLoginIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the Signup / Login icon.");
        WebElement loginIcon = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        
        test.log(Status.PASS, "Clicking the Signup / Login icon.");
        loginIcon.click();

        test.log(Status.PASS, "Waiting for the URL to contain 'login'.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("login"));

        test.log(Status.PASS, "Getting the current URL after clicking.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'login'.");
        Assert.assertTrue(currentUrl.contains("login"), 
            "Login icon did not redirect to the login page.");
        
        test.log(Status.PASS, "Login icon redirected to the login page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfCartIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the Cart icon.");
        WebElement cartIcon = driver.findElement(By.xpath("//a[contains(text(), ' Cart')]"));
        
        test.log(Status.PASS, "Clicking the Cart icon.");
        cartIcon.click();

        test.log(Status.PASS, "Getting the current URL after clicking.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'view_cart'.");
        Assert.assertTrue(currentUrl.contains("view_cart"), 
            "Cart icon did not stay on the cart page.");
        
        test.log(Status.PASS, "Cart icon stayed on the cart page successfully.");
    }

    @Test
    public void verifyBreadcrumbNavigationOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the breadcrumb element.");
        WebElement breadcrumb = driver.findElement(By.xpath("//div[@class='container']/ol"));
        
        test.log(Status.PASS, "Getting the text of the breadcrumb.");
        String breadcrumbText = breadcrumb.getText();

        test.log(Status.PASS, "Asserting that the breadcrumb text is 'Home > Shopping Cart'.");
        Assert.assertTrue(breadcrumbText.contains("Home > Shopping Cart"), 
            "Breadcrumb text is incorrect. Found: " + breadcrumbText);
        
        test.log(Status.PASS, "Breadcrumb navigation is correct.");
    }
    
    @Test
    public void verifyCartEmptyMessageAndRedirectLink() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the 'Cart is empty!' message.");
        WebElement emptyCartMessage = driver.findElement(By.xpath("//*[contains(text(), 'Cart is empty!')]"));
        
        test.log(Status.PASS, "Asserting that the message is displayed.");
        Assert.assertTrue(emptyCartMessage.isDisplayed(), 
            "Cart empty message is not displayed.");
        
        test.log(Status.PASS, "Finding the 'Click here' redirect link.");
        WebElement redirectLink = driver.findElement(By.xpath("//a[contains(text(), 'Click here')]"));
        
        test.log(Status.PASS, "Asserting that the redirect link is displayed.");
        Assert.assertTrue(redirectLink.isDisplayed(), 
            "Redirect link to buy products is not displayed.");
        
        test.log(Status.PASS, "Empty cart message and redirect link are displayed correctly.");
    }

    @Test
    public void verifySubscriptionInputFieldAndButtonVisibility() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Waiting for the subscription email input to be visible.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe_email")));
        
        test.log(Status.PASS, "Waiting for the subscribe button to be visible.");
        WebElement subscribeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subscribe")));

        test.log(Status.PASS, "Asserting that the email input is visible.");
        Assert.assertTrue(emailInput.isDisplayed(), 
            "Subscription email input is not visible.");
        
        test.log(Status.PASS, "Asserting that the subscribe button is visible.");
        Assert.assertTrue(subscribeButton.isDisplayed(), 
            "Subscription button is not visible.");
        
        test.log(Status.PASS, "Subscription input and button are both visible.");
    }
    
    @Test
    public void verifySubscriptionPlaceholderText() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the subscription email input field.");
        WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
        
        test.log(Status.PASS, "Getting the placeholder text.");
        String placeholderText = emailInput.getAttribute("placeholder");

        test.log(Status.PASS, "Asserting the placeholder text is 'Your email here'.");
        Assert.assertEquals(placeholderText, "Your email here", 
            "Subscription placeholder text is incorrect. Found: " + placeholderText);
        
        test.log(Status.PASS, "Subscription placeholder text is correct.");
    }

    @Test
    public void verifySubscriptionNoteText() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the subscription note text element.");
        WebElement noteText = driver.findElement(By.xpath("//h2[contains(text(), 'Subscription')]"));
        
        test.log(Status.PASS, "Asserting that the note text is displayed.");
        Assert.assertTrue(noteText.isDisplayed(), 
            "Subscription note text is not displayed.");
        
        test.log(Status.PASS, "Subscription note text is displayed correctly.");
    }
    
    @Test
    public void verifyFooterCopyrightText() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the footer copyright text element.");
        WebElement footerCopyright = driver.findElement(By.xpath("//div[@class='footer-bottom']//p[contains(text(), 'Copyright')]"));
        
        test.log(Status.PASS, "Getting the copyright text.");
        String copyrightText = footerCopyright.getText();

        test.log(Status.PASS, "Asserting the copyright text contains the expected phrase.");
        Assert.assertTrue(copyrightText.contains("Copyright © 2021 All rights reserved"), 
            "Footer copyright text is incorrect. Found: " + copyrightText);
        
        test.log(Status.PASS, "Footer copyright text is correct.");
    }
    
    @Test
    public void verifyFunctionalityOfProductsIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the 'Products' icon.");
        WebElement productsIcon = driver.findElement(By.xpath("//a[contains(text(),' Products')]"));
        
        test.log(Status.PASS, "Clicking the 'Products' icon.");
        productsIcon.click();

        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'products'.");
        Assert.assertTrue(currentUrl.contains("products"), 
            "Products icon did not redirect to the products page.");
        
        test.log(Status.PASS, "Products icon redirected to the products page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfTestCasesIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the 'Test Cases' icon.");
        WebElement testCasesIcon = driver.findElement(By.xpath("//a[contains(text(),' Test Cases')]"));
        
        test.log(Status.PASS, "Clicking the 'Test Cases' icon.");
        testCasesIcon.click();

        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'test_cases'.");
        Assert.assertTrue(currentUrl.contains("test_cases"), 
            "Test Cases icon did not redirect to the test cases page.");
        
        test.log(Status.PASS, "Test Cases icon redirected to the test cases page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfAPITestingIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");
        
        test.log(Status.PASS, "Clicking the 'API Testing' icon.");
        driver.findElement(By.xpath("//a[@href='/api_list']")).click();
        
        test.log(Status.PASS, "Asserting that the URL contains 'api_list'.");
        Assert.assertTrue(driver.getCurrentUrl().contains("api_list"),
                "API Testing icon navigation failed!");
        
        test.log(Status.PASS, "API Testing icon redirected successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfVideoTutorialsIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the 'Video Tutorials' icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the 'Video Tutorials' icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'youtube'.");
        Assert.assertTrue(currentUrl.contains("youtube"), 
            "Video Tutorials icon did not redirect to a YouTube page.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to a YouTube page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfContactUsIconOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");

        test.log(Status.PASS, "Finding the 'Contact us' icon.");
        WebElement contactUsIcon = driver.findElement(By.xpath("//a[contains(text(),' Contact us')]"));
        
        test.log(Status.PASS, "Clicking the 'Contact us' icon.");
        contactUsIcon.click();

        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains 'contact_us'.");
        Assert.assertTrue(currentUrl.contains("contact_us"), 
            "Contact us icon did not redirect to the contact us page.");
        
        test.log(Status.PASS, "Contact us icon redirected to the contact us page successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfAutomationExerciseLogoOnCartPage() {
        test.log(Status.PASS, "Navigating to the cart page.");
        driver.get("https://automationexercise.com/view_cart");
        
        test.log(Status.PASS, "Finding the Automation Exercise logo.");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Clicking the logo.");
        logo.click();
        
        test.log(Status.PASS, "Getting the current URL after the click.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting that the URL contains the expected domain.");
        Assert.assertTrue(currentUrl.contains("automationexercise.com"), 
            "Automation Exercise logo did not redirect to the homepage.");
        
        test.log(Status.PASS, "Automation Exercise logo redirected to the homepage successfully.");
    }
    
//    @AfterMethod
//    public void captureScreenshot(ITestResult result) {
//        String testName = result.getMethod().getMethodName();
//        ScreenshotUtils.takeScreenshot(driver, testName);
//    }
}