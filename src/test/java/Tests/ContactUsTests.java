package Tests;

import Base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsTests extends BaseTest {

    private final String baseUrl = "https://automationexercise.com/";
    private final String contactUsUrl = "https://automationexercise.com/contact_us";
    private final String dummyFilePath = "C:\\Users\\CHAKRADHAR\\OneDrive\\Documents\\novel-vista.txt";

    private void fillContactForm(String name, String email, String subject, String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[action='/contact_us']")));

        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(name);
        test.info("Entered Name: " + name);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        test.info("Entered Email: " + email);

        driver.findElement(By.name("subject")).clear();
        driver.findElement(By.name("subject")).sendKeys(subject);
        test.info("Entered Subject: " + subject);

        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys(message);
        test.info("Entered Message: " + message);
    }

    @Test
    public void TC_001_VerifyContactUsButtonNavigation() {
        driver.get(baseUrl);
        test.info("Opened Base URL: " + baseUrl);

        WebElement contactBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/contact_us']")));
        contactBtn.click();
        test.info("Clicked Contact Us button");

        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Contact Us navigation failed!");
        test.pass("✅ Contact Us navigation successful.");
    }

    @Test
    public void TC_002_VerifyNameFieldWithValidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("John Doe", "mail@test.com", "Sub", "Msg");
        String actual = driver.findElement(By.name("name")).getAttribute("value");

        Assert.assertEquals(actual, "John Doe", "Name field did not accept valid input!");
        test.pass("✅ Name field accepted valid input.");
    }

    @Test
    public void TC_003_VerifyNameFieldWithInvalidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("", "mail@test.com", "Sub", "Msg");
        String actual = driver.findElement(By.name("name")).getAttribute("value");

        Assert.assertEquals(actual, "", "Name field did not reject invalid input!");
        test.pass("✅ Name field rejected invalid input.");
    }

    @Test
    public void TC_004_VerifyEmailFieldWithValidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("User", "valid@mail.com", "Sub", "Msg");
        String actual = driver.findElement(By.name("email")).getAttribute("value");

        Assert.assertEquals(actual, "valid@mail.com", "Email field did not accept valid input!");
        test.pass("✅ Email field accepted valid input.");
    }

    @Test
    public void TC_005_VerifyEmailFieldWithInvalidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("User", "invalid-email", "Sub", "Msg");
        driver.findElement(By.name("submit")).click();
        test.info("Submitted form with invalid email");

        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Invalid email allowed submission!");
        test.pass("✅ Invalid email prevented form submission.");
    }

    @Test
    public void TC_006_VerifySubjectFieldWithValidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("User", "mail@test.com", "Valid Subject", "Msg");
        String actual = driver.findElement(By.name("subject")).getAttribute("value");

        Assert.assertEquals(actual, "Valid Subject", "Subject field did not accept valid input!");
        test.pass("✅ Subject field accepted valid input.");
    }

    @Test
    public void TC_007_VerifyMessageFieldWithValidInput() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("User", "mail@test.com", "Sub", "Valid Message");
        String actual = driver.findElement(By.name("message")).getAttribute("value");

        Assert.assertEquals(actual, "Valid Message", "Message field did not accept valid input!");
        test.pass("✅ Message field accepted valid input.");
    }

    @Test
    public void TC_008_VerifyFileAttachment() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        WebElement upload = driver.findElement(By.name("upload_file"));
        upload.sendKeys(dummyFilePath);
        test.info("File attached: " + dummyFilePath);

        Assert.assertTrue(upload.getAttribute("value").contains("novel-vista.txt"), "File not uploaded!");
        test.pass("✅ File uploaded successfully.");
    }

    @Test
    public void TC_009_VerifySubscriptionWithInvalidEmail() {
        driver.get(baseUrl);
        test.info("Opened Base URL");

        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        emailBox.sendKeys("invalid-email");
        driver.findElement(By.id("subscribe")).click();
        test.info("Submitted subscription with invalid email");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean errorShown;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
            errorShown = false;
        } catch (TimeoutException e) {
            errorShown = true;
        }

        Assert.assertTrue(errorShown, "Invalid email was accepted in subscription!");
        test.pass("✅ Invalid email rejected in subscription.");
    }

    @Test
    public void TC_010_VerifySubscriptionWithValidEmail() {
        driver.get(baseUrl);
        test.info("Opened Base URL");

        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        String email = "user" + System.currentTimeMillis() + "@mail.com";
        emailBox.sendKeys(email);
        driver.findElement(By.id("subscribe")).click();
        test.info("Submitted subscription with valid email: " + email);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));

        Assert.assertTrue(success.isDisplayed(), "Subscription success message not displayed!");
        test.pass("✅ Subscription successful with valid email.");
    }

    @Test
    public void TC_011_VerifySubmitButton() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("Full Name", "form@mail.com", "Sub", "Msg");
        driver.findElement(By.name("upload_file")).sendKeys(dummyFilePath);
        test.info("Attached file and submitting form");

        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();

        WebElement success = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));

        Assert.assertTrue(success.isDisplayed(), "Success message not displayed after submission!");
        test.pass("✅ Form submitted successfully.");
    }

    @Test
    public void TC_012_VerifyHomeButtonAfterSubmit() {
        driver.get(contactUsUrl);
        test.info("Opened Contact Us page");

        fillContactForm("Full Name", "form@mail.com", "Sub", "Msg");
        driver.findElement(By.name("upload_file")).sendKeys(dummyFilePath);
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
        test.info("Submitted form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
        WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-success[href='/']")));
        homeBtn.click();
        test.info("Clicked Home button");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl, "Home button did not navigate to homepage!");
        test.pass("✅ Home button navigated to homepage.");
    }

    @Test
    public void TC_013_VerifyScrollUpFunctionality() {
        driver.get(baseUrl);
        test.info("Opened Base URL and scrolling down");

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scrollUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        scrollUp.click();
        test.info("Clicked scroll up button");

        wait.until(webDriver -> (long) ((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset;") == 0);

        Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return window.pageYOffset;"), 0L, "Scroll up failed!");
        test.pass("✅ Scroll up successful.");
    }

    @Test
    public void TC_014_VerifyScrollDownFunctionality() {
        driver.get(baseUrl);
        test.info("Opened Base URL and scrolling down by 500px");

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500)");
        long pos = (long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");

        Assert.assertTrue(pos > 0, "❌ Scroll down failed!");
        test.pass("✅ Scroll down successful.");
    }
}
