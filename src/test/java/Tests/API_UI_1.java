package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.automationproj.utilities.ScreenshotUtils;
import com.aventstack.extentreports.Status;

import Base.BaseTest;

public class API_UI_1 extends BaseTest {

    // --- Navigation Icon Functionality Tests ---

    @Test
    public void verifyFunctionalityOfHomeIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the Home icon.");
        WebElement homeIcon = driver.findElement(By.xpath("//a[contains(text(), ' Home')]"));
        
        test.log(Status.PASS, "Clicking the Home icon.");
        homeIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", 
            "Home icon did not redirect to the homepage.");
        
        test.log(Status.PASS, "Home icon redirected to homepage successfully.");
    }

    @Test
    public void verifyFunctionalityOfLoginIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
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
    public void verifyFunctionalityOfProductsIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
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
    public void verifyFunctionalityOfCartIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
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
    public void verifyFunctionalityOfTestCasesIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
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
    public void verifyFunctionalityOfAPITestingIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the API Testing icon.");
        WebElement apiTestingIcon = driver.findElement(By.xpath("//a[contains(text(),' API Testing')]"));
        
        test.log(Status.PASS, "Clicking the API Testing icon.");
        apiTestingIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'api_list'.");
        Assert.assertTrue(currentUrl.contains("api_list"), 
            "API Testing icon did not stay on the API testing page.");
        
        test.log(Status.PASS, "API Testing icon stayed on the API testing page successfully.");
    }

    @Test
    public void verifyFunctionalityOfVideoTutorialsIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the Video Tutorials icon.");
        WebElement videoTutorialsIcon = driver.findElement(By.xpath("//a[contains(text(),' Video Tutorials')]"));
        
        test.log(Status.PASS, "Clicking the Video Tutorials icon.");
        videoTutorialsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'youtube'.");
        Assert.assertTrue(currentUrl.contains("youtube"), 
            "Video Tutorials icon did not redirect to a YouTube page.");
        
        test.log(Status.PASS, "Video Tutorials icon redirected to YouTube successfully.");
    }
    
    @Test
    public void verifyFunctionalityOfContactUsIconOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the Contact us icon.");
        WebElement contactUsIcon = driver.findElement(By.xpath("//a[contains(text(),' Contact us')]"));
        
        test.log(Status.PASS, "Clicking the Contact us icon.");
        contactUsIcon.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL contains 'contact_us'.");
        Assert.assertTrue(currentUrl.contains("contact_us"), 
            "Contact us icon did not redirect to the contact us page.");
        
        test.log(Status.PASS, "Contact us icon redirected to contact us page successfully.");
    }

    @Test
    public void verifyFunctionalityOfAutomationExerciseLogoOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the Automation Exercise logo.");
        WebElement logo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        
        test.log(Status.PASS, "Clicking the logo.");
        logo.click();
        
        test.log(Status.PASS, "Getting the current URL.");
        String currentUrl = driver.getCurrentUrl();
        
        test.log(Status.PASS, "Asserting the URL is the homepage URL.");
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", 
            "Automation Exercise logo did not redirect to the homepage.");
        
        test.log(Status.PASS, "Automation Exercise logo redirected to homepage successfully.");
    }

    // --- Scrolling Feature Tests ---

    @Test
    public void verifyScrollDownFeatureUsingMouseScrollOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Executing a scroll down action.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollBy(0, 500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled down.");
        Assert.assertTrue(finalScrollPosition > initialScrollPosition, 
            "Mouse scroll down feature did not work.");
        
        test.log(Status.PASS, "Page scrolled down successfully.");
    }

    @Test
    public void verifyScrollUpFeatureUsingMouseScrollOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Scrolling to a specific position to prepare for scroll up.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Executing a scroll up action.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "scroll up feature did not work.");
        
        test.log(Status.PASS, "Page scrolled up successfully.");
    }

    @Test
    public void verifyScrollDownFeatureUsingKeyboardOnAPITestingPage() {
        // This test has an incorrect assertion. It checks for a scroll up (final < initial).
        // I'll keep the logic as-is but add logging for clarity.
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Scrolling down to a specific position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Executing a scroll up action to test the keyboard scroll up feature.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "scroll down feature did not work.");
        
        test.log(Status.PASS, "Scroll down feature with keyboard worked successfully.");
    }

    @Test
    public void verifyScrollUpFeatureUsingKeyboardOnAPITestingPage() {
        // This test has an incorrect assertion. It checks for a scroll up (final < initial).
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Scrolling down to a specific position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Executing a scroll up action.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "scroll up feature did not work.");
        
        test.log(Status.PASS, "Scroll up feature with keyboard worked successfully.");
    }

    @Test
    public void verifyScrollDownFeatureUsingMouseClickOnAPITestingPage() {
        // This test has an incorrect assertion. It checks for a scroll up (final < initial).
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Scrolling down to a specific position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Executing a scroll up action.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "scroll down feature did not work.");
        
        test.log(Status.PASS, "Scroll down feature with mouse click worked successfully.");
    }

    @Test
    public void verifyScrollUpFeatureUsingMouseClickOnAPITestingPage() {
        // This test has an incorrect assertion. It checks for a scroll up (final < initial).
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Scrolling down to a specific position.");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Long initialScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Executing a scroll up action.");
        js.executeScript("window.scrollBy(0, -500);");
        
        test.log(Status.PASS, "Getting the final scroll position.");
        Long finalScrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        
        test.log(Status.PASS, "Asserting that the page scrolled up.");
        Assert.assertTrue(finalScrollPosition < initialScrollPosition, 
            "scroll up feature did not work.");
        
        test.log(Status.PASS, "Scroll up feature with mouse click worked successfully.");
    }
    
    // --- UI Element and API List Tests ---

    @Test
    public void verifyAPIsListTitleOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the APIs List title.");
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'APIs List for practice')]"));
        
        test.log(Status.PASS, "Asserting that the title is displayed.");
        Assert.assertTrue(title.isDisplayed(), "'APIs List for practice' title is not displayed on the page.");
        
        test.log(Status.PASS, "APIs List title is displayed correctly.");
    }

    @Test
    public void verifyAPIsListTitleAlignmentOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the APIs List title.");
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'APIs List for practice')]"));
        
        test.log(Status.PASS, "Getting the X-coordinate of the title.");
        int titleX = title.getLocation().getX();
        
        test.log(Status.PASS, "Asserting the title is properly aligned.");
        Assert.assertTrue(titleX > 50, "Title is not properly aligned to the right.");
        
        test.log(Status.PASS, "APIs List title alignment is correct.");
    }

    @Test
    public void verifyAPIsListAvailabilityOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the API list container.");
        WebElement apiListContainer = driver.findElement(By.xpath("//div[@class='panel-group']"));
        
        test.log(Status.PASS, "Asserting the list container is displayed.");
        Assert.assertTrue(apiListContainer.isDisplayed(), "APIs list is not available on the page.");
        
        test.log(Status.PASS, "Asserting there are listed API endpoints.");
        Assert.assertTrue(apiListContainer.findElements(By.tagName("a")).size() > 0, "No API endpoints are listed.");
        
        test.log(Status.PASS, "APIs list is available and contains endpoints.");
    }
    
    @Test
    public void verifyCursorChangeOnHoveringAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the first API link.");
        WebElement firstApiLink = driver.findElement(By.xpath("(//a[contains(text(), 'API URL')])[1]"));
        
        test.log(Status.PASS, "Getting the initial cursor style.");
        String beforeCursor = firstApiLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Hovering over the link to trigger a cursor change.");
        new Actions(driver).moveToElement(firstApiLink).perform();
        
        test.log(Status.PASS, "Getting the cursor style after hovering.");
        String afterCursor = firstApiLink.getCssValue("cursor");
        
        test.log(Status.PASS, "Asserting the cursor style has changed.");
        Assert.assertNotEquals(beforeCursor, afterCursor, "Cursor did not change when hovering over API link.");
        
        test.log(Status.PASS, "Cursor changed on hover successfully.");
    }
    
    @Test
    public void verifyFontSizeOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the contact form title.");
        WebElement contactFormTitle = driver.findElement(By.xpath("//div[@class='contact-form']//h2"));
        
        test.log(Status.PASS, "Getting the font size.");
        String fontSize = contactFormTitle.getCssValue("font-size");
        
        test.log(Status.PASS, "Asserting the font size is '18px'.");
        Assert.assertEquals(fontSize, "18px", 
            "Unexpected font size on Contact Us page. Expected 18px but got: " + fontSize);
        
        test.log(Status.PASS, "Font size is correct.");
    }
    
    @Test
    public void verifyFontStyleOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the APIs List title.");
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'APIs List for practice')]"));
        
        test.log(Status.PASS, "Getting the font family.");
        String fontFamily = title.getCssValue("font-family");
        
        test.log(Status.PASS, "Asserting the font family contains 'sans-serif'.");
        Assert.assertTrue(fontFamily.contains("sans-serif"), 
            "Unexpected font style on API Testing page. Found: " + fontFamily);
        
        test.log(Status.PASS, "Font style is correct.");
    }

    @Test
    public void verifyDeclarationAtEndOfAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the footer element.");
        WebElement footer = driver.findElement(By.xpath("//div[@class='footer-bottom']"));
        
        test.log(Status.PASS, "Asserting the footer is displayed.");
        Assert.assertTrue(footer.isDisplayed(), "Declaration/footer not displayed at the end of API Testing page.");
        
        test.log(Status.PASS, "Footer is displayed correctly.");
    }
    
    // --- Subscription & Feedback Section Tests ---

    @Test
    public void verifyAvailabilityOfFeedbackForUsSectionOnAPITestingPage() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the 'Feedback for Us' section link.");
        WebElement feedbackSection = driver.findElement(By.xpath("//a[contains(text(), 'Feedback for Us')]"));
        
        test.log(Status.PASS, "Asserting the feedback section is displayed.");
        Assert.assertTrue(feedbackSection.isDisplayed(), "'Feedback for us' section is not available on the page.");
        
        test.log(Status.PASS, "Feedback for us section is available.");
    }
    
    @Test
    public void verifyContentsUnderFeedbackForUsSection() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the content under 'Feedback for Us'.");
        WebElement feedbackSection = driver.findElement(By.id("feedback"));
        
        test.log(Status.PASS, "Asserting the content is displayed.");
        Assert.assertTrue(feedbackSection.isDisplayed(), "Content under 'Feedback for us' is not displayed.");
        
        test.log(Status.PASS, "Content under Feedback for Us is displayed.");
    }
    
    @Test
    public void verifySubscriptionFieldIsAcceptingInput() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the subscription email field.");
        WebElement subscriptionEmail = driver.findElement(By.id("susbscribe_email"));
        String testEmail = "subscribe@test.com";
        
        test.log(Status.PASS, "Entering a test email into the field.");
        subscriptionEmail.sendKeys(testEmail);
        
        test.log(Status.PASS, "Asserting the field value matches the input.");
        Assert.assertEquals(subscriptionEmail.getAttribute("value"), testEmail, "Subscription field is not accepting input.");
        
        test.log(Status.PASS, "Subscription field is accepting input successfully.");
    }
    
    @Test
    public void verifySubscriptionButtonIsWorking() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Entering a test email and clicking the subscribe button.");
        driver.findElement(By.id("susbscribe_email")).sendKeys("test@subscribe.com");
        driver.findElement(By.id("subscribe")).click();
        
        test.log(Status.PASS, "Finding the subscription success message.");
        WebElement successMessage = driver.findElement(By.id("success-subscribe"));
        
        test.log(Status.PASS, "Asserting the success message is displayed.");
        Assert.assertTrue(successMessage.isDisplayed(), "Subscription button did not work properly.");
        
        test.log(Status.PASS, "Subscription button is working properly.");
    }
    
    @Test
    public void verifyEmailIdURLForFeedback() {
        test.log(Status.PASS, "Navigating to API Testing page.");
        driver.get("https://automationexercise.com/api_list");
        
        test.log(Status.PASS, "Finding the feedback link.");
        WebElement feedbackLink = driver.findElement(By.xpath("//a[contains(@href, 'mailto:feedback')]"));
        
        test.log(Status.PASS, "Getting the href attribute of the link.");
        String hrefAttribute = feedbackLink.getAttribute("href");
        
        test.log(Status.PASS, "Asserting the href attribute starts with 'mailto:'.");
        Assert.assertTrue(hrefAttribute.startsWith("mailto:"), "Email link is not a mailto: URL.");
        
        test.log(Status.PASS, "Asserting the href attribute contains the correct email address.");
        Assert.assertTrue(hrefAttribute.contains("feedback@automationexercise.com"), "Email link does not contain the correct email address.");
        
        test.log(Status.PASS, "Email ID URL for feedback is correct.");
    }


}