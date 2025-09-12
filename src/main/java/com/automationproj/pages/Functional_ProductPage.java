package com.automationproj.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;


public class Functional_ProductPage {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	// Locators
	private By ProductButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	
    private By searchBox = By.id("search_product");
    private By searchButton = By.id("submit_search");
    
    private By womenIcon = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    private By womenDropdown = By.xpath("//*[@id=\"Women\"]/div");
    private By menIcon = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    private By menDropdown = By.id("Men");
    private By kidsIcon = By.xpath("//*[@id=\"accordian\"]/div[3]/div[1]/h4/a");
    private By kidsDropdown = By.xpath("//*[@id=\"Kids\"]/div");
    
    private By firstViewProductBtn = By.xpath("(//a[text()='View Product'])[1]");
    private By productInfoSection = By.cssSelector(".product-information");

    private By firstAddToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    private By addToCartModal = By.cssSelector("#cartModal .modal-content");
    private By viewCartLink = By.xpath("//p[@class='text-center']/a");
    private By cartTable = By.cssSelector("#cart_info_table");
    
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By reviewField = By.id("review");
    
    private By submitReviewBtn = By.id("button-review");
    
    private By subscribeEmail = By.xpath("//*[@id=\"susbscribe_email\"]");
    private By subscribeBtn = By.id("subscribe");
    
    
    private By commentBox = By.name("message");
    
    private By placeOrderBtn = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    By cardField = By.name("card_number");
    By cvcField = By.name("cvc");
    By expiryMonthField = By.name("expiry_month");
    By expiryYearField = By.name("expiry_year");
    
    By submitBtn = By.id("submit");
    
    By downloadInvoiceBtn = By.xpath("//*[@id=\"form\"]/div/div/div/a");
    
    By continueBtn = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By deleteFromCart = By.className("cart_quantity_delete");
    
    
    
    
    By loginLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By loginEmail = By.name("email");
    private By loginPassword = By.name("password");
    private By loginBtn = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");

    private By viewProductLink = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By addToCartBtn = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By viewCartBtn = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a");
    private By proceedToCheckoutBtn = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    

    // Constructor
    public Functional_ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    // Actions
    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }
    
    
    
    
 // 🔹 Helper: Scroll element into view
    public void redirectToProducts() {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(ProductButton));
        scrollToElement(productElement);
        productElement.click();
    }
    
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean isSearchBarVisible() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public void clickWomenIcon() {
        driver.findElement(womenIcon).click();
    }

    public boolean isWomenDropdownVisible() {
        return driver.findElement(womenDropdown).isDisplayed();
    }

    public void clickMenIcon() {
        driver.findElement(menIcon).click();
    }

    public boolean isMenDropdownVisible() {
        return driver.findElement(menDropdown).isDisplayed();
    }

 // Expand Kids category
    public boolean expandKidsCategory() {
        WebElement plusIcon = driver.findElement(By.xpath("//*[@id=\"accordian\"]/div[3]/div[1]/h4/a"));
        scrollToElement(plusIcon);
        plusIcon.click();

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"Kids\"]/div"));
        return dropdown.isDisplayed();
    }

    
    // Verify brand product page
    public void verifyBrandProduct(String xpath, String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement brandLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        scrollToElement(brandLink);
        wait.until(ExpectedConditions.elementToBeClickable(brandLink)).click();

        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "❌ Page title does not match!");
        System.out.println("✅ Verified: " + expectedTitle);
    }
    
 // ✅ Actions
    public void clickFirstViewProduct() {
        WebElement viewProductBtn = wait.until(
                ExpectedConditions.elementToBeClickable(firstViewProductBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProductBtn);
        viewProductBtn.click();
    }

    public boolean isProductInfoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productInfoSection)).isDisplayed();
    }

    public boolean isOnProductDetailsPage() {
        return driver.getCurrentUrl().contains("product_details");
    }

    public void addFirstProductToCart() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
        addToCartBtn.click();
    }

    public boolean isAddToCartModalVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartModal)).isDisplayed();
    }

    public void clickViewCart() {
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewCartLink));
        viewCart.click();
    }

    public boolean isOnCartPage() {
        wait.until(ExpectedConditions.titleContains("Checkout"));
        return driver.getCurrentUrl().contains("view_cart");
    }

    public boolean isCartTableVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartTable)).isDisplayed();
    }

    public boolean isFirstProductInCartVisible() {
        WebElement firstProduct = driver.findElement(By.xpath("//tbody/tr[1]"));
        return firstProduct.isDisplayed();
    }
  
    public void enterName(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(nameField));
        scrollIntoView(nameInput);
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        scrollIntoView(emailInput);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterReview(String review) {
        WebElement reviewInput = wait.until(ExpectedConditions.elementToBeClickable(reviewField));
        scrollIntoView(reviewInput);
        reviewInput.clear();
        reviewInput.sendKeys(review);
    }
    
    public void submitReview() {
        driver.findElement(submitReviewBtn).click();
    }

    public void subscribe(String email) {
        actions.sendKeys(Keys.END).perform(); // Scroll to bottom

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(subscribeEmail));
        emailField.click();
        emailField.sendKeys(email);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(subscribeBtn));
        button.click();

    }

    public void login(String email, String password) {
        driver.findElement(loginLink).click();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public void viewProduct() {
        WebElement viewProduct = wait.until(ExpectedConditions.elementToBeClickable(viewProductLink));
        scrollToElement(viewProduct);
        viewProduct.click();
    }

    public void addProductToCart() {
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        scrollToElement(addBtn);
        addBtn.click();
    }

    public void viewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public void enterComment(String comment) {
        WebElement commentBoxElem = wait.until(ExpectedConditions.elementToBeClickable(commentBox));
        scrollToElement(commentBoxElem);
        commentBoxElem.sendKeys(comment);
    }
    
    public void enterNameOnCard(String name) {
        driver.findElement(nameOnCard).sendKeys(name);
    }

    public void enterCardNumber(String card) {
        driver.findElement(cardNumber).sendKeys(card);
    }
    
    public void placeOrder() {
        driver.findElement(placeOrderBtn).click();
    }
    
    public void enterCVC(String cvc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField)).sendKeys(cvc);
    }

    public void enterExpiryMonth(String month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryMonthField)).sendKeys(month);
    }

    public void enterExpiryYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryYearField)).sendKeys(year);
    }
    
    public void fillPaymentDetails(String name, String card, String cvc, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(cvcField).sendKeys(cvc);
        driver.findElement(expiryMonthField).sendKeys(month);
        driver.findElement(expiryYearField).sendKeys(year);
    }

    public void submitOrder() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }

    public void downloadInvoice() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceBtn)).click();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void removeFromCart() {
        driver.findElement(deleteFromCart).click();
    }

    public void scrollDownKey(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(500);
        }
    }

    public void scrollUpKey(int times) throws InterruptedException {
        actions.sendKeys(Keys.END).perform();
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.ARROW_UP).perform();
            Thread.sleep(500);
        }
    }

}


