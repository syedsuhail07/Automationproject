package com.automationproj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By logo = By.xpath("//img[@alt='Website for automation practice']");
    By homeButton = By.xpath("//a[text()=' Home']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
