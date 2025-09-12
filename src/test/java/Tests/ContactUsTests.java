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

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("subject")).clear();
        driver.findElement(By.name("subject")).sendKeys(subject);

        driver.findElement(By.name("message")).clear();
        driver.findElement(By.name("message")).sendKeys(message);
    }

    
    @Test
    public void verifyContactUsButtonNavigation() {
        driver.get(baseUrl);
        WebElement contactBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/contact_us']")));
        contactBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"));
    }

    
    @Test
    public void verifyNameFieldWithValidInput() throws Exception {
        Object[][] data = new DataProviderClass().getContactUsData();
        driver.get(contactUsUrl);

        for (Object[] row : data) {
            String name = row[0].toString();
            fillContactForm(name, "mail@test.com", "sub", "msg");
            Assert.assertEquals(driver.findElement(By.name("name")).getAttribute("value"), name);
        }
    }


    @Test
    public void verifyNameFieldWithInvalidInput() {
        driver.get(contactUsUrl);
        fillContactForm("", "test@mail.com", "sub", "msg");
        Assert.assertEquals(driver.findElement(By.name("name")).getAttribute("value"), "");
    }

 
    @Test
    public void verifyEmailFieldWithValidInput() throws Exception {
        Object[][] data = new DataProviderClass().getContactUsData();
        driver.get(contactUsUrl);

        for (Object[] row : data) {
            String email = "valid@mail.com"; // force valid
            fillContactForm("test", email, "sub", "msg");
            Assert.assertEquals(driver.findElement(By.name("email")).getAttribute("value"), email);
        }
    }

 
    @Test
    public void verifyEmailFieldWithInvalidInput() {
        driver.get(contactUsUrl);
        fillContactForm("test", "invalid-email", "sub", "msg");
        driver.findElement(By.name("submit")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"));
    }

  
    @Test
    public void verifySubjectFieldWithValidInput() {
        driver.get(contactUsUrl);
        fillContactForm("test", "mail@test.com", "Valid Subject", "msg");
        Assert.assertEquals(driver.findElement(By.name("subject")).getAttribute("value"), "Valid Subject");
    }

  
    @Test
    public void verifyMessageFieldWithValidInput() {
        driver.get(contactUsUrl);
        fillContactForm("test", "mail@test.com", "sub", "Valid Message");
        Assert.assertEquals(driver.findElement(By.name("message")).getAttribute("value"), "Valid Message");
    }

  
    @Test
    public void verifyFileAttachment() {
        driver.get(contactUsUrl);
        WebElement upload = driver.findElement(By.name("upload_file"));
        upload.sendKeys(dummyFilePath);
        Assert.assertTrue(upload.getAttribute("value").contains("novel-vista.txt"));
    }

    
    @Test
    public void verifySubscriptionWithInvalidEmail() {
        driver.get(baseUrl);
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        emailBox.sendKeys("invalid-email");
        driver.findElement(By.id("subscribe")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean errorShown;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe")));
            errorShown = false;
        } catch (TimeoutException e) {
            errorShown = true;
        }
        Assert.assertTrue(errorShown);
    }

   
    @Test
    public void verifySubscriptionWithValidEmail() {
        driver.get(baseUrl);
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        emailBox.sendKeys("user" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("subscribe")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success-subscribe"))).isDisplayed());
    }

   
    @Test
    public void verifySubmitButton() {
        driver.get(contactUsUrl);
        fillContactForm("Full Name", "form@mail.com", "Sub", "Msg");
        driver.findElement(By.name("upload_file")).sendKeys(dummyFilePath);
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();

        WebElement success = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
        Assert.assertTrue(success.isDisplayed());
    }

  
    @Test
    public void verifyHomeButtonAfterSubmit() {
        driver.get(contactUsUrl);
        fillContactForm("Full Name", "form@mail.com", "Sub", "Msg");
        driver.findElement(By.name("upload_file")).sendKeys(dummyFilePath);
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".status.alert.alert-success")));
        WebElement homeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-success[href='/']")));
        homeBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
    }

    
    @Test
    public void verifyScrollUpFunctionality() {
        driver.get(baseUrl);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement scrollUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollUp")));
        scrollUp.click();

        wait.until(webDriver -> (long) ((JavascriptExecutor) webDriver).executeScript("return window.pageYOffset;") == 0);
        Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return window.pageYOffset;"), 0L);
    }

   
    @Test
    public void verifyScrollDownFunctionality() {
        driver.get(baseUrl);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500)");
        long pos = (long) ((JavascriptExecutor) driver).executeScript("return window.pageYOffset;");
        Assert.assertTrue(pos > 0);
    }
}
