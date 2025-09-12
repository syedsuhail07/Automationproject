package com.automationproj.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ContactUsPage {
    WebDriver driver;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "subject")
    public WebElement subjectBox;

    @FindBy(name = "message")
    public WebElement messageBox;

    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @FindBy(name = "submit")
    public WebElement submitBtn;

    @FindBy(css = ".status.alert.alert-success")
    public WebElement successMessage;

    @FindBy(css = "a.btn.btn-success[href='/']")
    public WebElement homeBtn;

    // Subscription
    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionEmailBox;

    @FindBy(id = "subscribe")
    public WebElement subscriptionBtn;

    @FindBy(id = "success-subscribe")
    public WebElement subscriptionSuccess;

    // Scroll Up button
    @FindBy(id = "scrollUp")
    public WebElement scrollUpBtn;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterName(String name) {
        nameBox.clear();
        nameBox.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailBox.clear();
        emailBox.sendKeys(email);
    }

    public void enterSubject(String subject) {
        subjectBox.clear();
        subjectBox.sendKeys(subject);
    }

    public void enterMessage(String message) {
        messageBox.clear();
        messageBox.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        uploadFile.sendKeys(filePath);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void clickHome() {
        homeBtn.click();
    }

    public void subscribe(String email) {
        subscriptionEmailBox.clear();
        subscriptionEmailBox.sendKeys(email);
        subscriptionBtn.click();
    }
}
