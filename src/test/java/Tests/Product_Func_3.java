package Tests;

import Base.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationproj.pages.Functional_ProductPage;
import com.automationproj.utilities.ExcelUtilities;

public class Product_Func_3 extends BaseTest {

	String baseurl = "https://automationexercise.com/";
    String produrl = "https://www.automationexercise.com/products";
    String viewprodurl = "https://www.automationexercise.com/product_details/1";

    @Test
    public void TC_ECOM_Product_026_SubmitReview() throws IOException {
    	driver.get(viewprodurl);
    	test.info("View Product page is opened: " + viewprodurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String name = ExcelUtilities.getCellValue("Valid", 3, 0);
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String review = ExcelUtilities.getCellValue("Valid", 9, 0);
        
        test.info("Entire data taken from Excel sheet");
        productPage.enterName(name);
        test.info("Name filled in name field");
        productPage.enterEmail(email);
        test.info("Email filled in email field");
        productPage.enterReview(review);
        test.info("Review filled in review field");
        productPage.submitReview();
        test.info("Submit button is clicked");
    }

    @Test
    public void TC_ECOM_Product_027_ValidSubscription() throws IOException {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        

        String email = ExcelUtilities.getCellValue("Valid", 1, 0); // example row/col
        productPage.subscribe(email);
        
    }

    @Test
    public void TC_ECOM_Product_028_InvalidSubscription() throws IOException {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String invalidEmail = ExcelUtilities.getCellValue("Invalid", 1, 0); // example row/col
        productPage.subscribe(invalidEmail);
  
    }

    @Test
    public void TC_ECOM_Product_029_CheckoutFlow() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        test.info("Cart page is loaded");
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
    }

    @Test
    public void TC_ECOM_Product_030_AddComment() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String comment = ExcelUtilities.getCellValue("Valid", 11, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.enterComment(comment);
        test.info("Comment is filled in comment field");
    }
    
    @Test
    public void TC_ECOM_Product_031_PlaceOrderButton() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String comment = ExcelUtilities.getCellValue("Valid", 11, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.enterComment(comment);
        test.info("Comment is filled in comment field");
        productPage.placeOrder();
        test.info("Place order button is clicked");
    }

    @Test
    public void TC_ECOM_Product_032_ValidName() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String comment = ExcelUtilities.getCellValue("Valid", 11, 0);
        String name = ExcelUtilities.getCellValue("Valid", 3, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.enterComment(comment);
        test.info("Comment is filled in comment field");
        productPage.placeOrder();
        test.info("Place order button is clicked");
        productPage.enterNameOnCard(name);
        test.info("Valid name filled in name field");
    }

    @Test
    public void TC_ECOM_Product_033_InvalidName() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String comment = ExcelUtilities.getCellValue("Invalid", 11, 0);
        String name = ExcelUtilities.getCellValue("Invalid", 3, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.enterComment(comment);
        test.info("Comment is filled in comment field");
        productPage.placeOrder();
        test.info("Place order button is clicked");
        productPage.enterNameOnCard(name);
        test.info("Invalid name filled in name field");
    }

    @Test
    public void TC_ECOM_Product_034_ValidCard() throws Exception {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String card = ExcelUtilities.getCellValue("Valid", 4, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.placeOrder();
        test.info("Place order button is clicked");
        productPage.enterCardNumber(card);
        test.info("Valid card number filled in card field");
    }

    @Test
    public void TC_ECOM_Product_035_InvalidCard() throws Exception { //30
    	driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String card = ExcelUtilities.getCellValue("Invalid", 4, 0);

        productPage.login(email, password);
        test.info("Successfully logged in");
        productPage.viewProduct();
        productPage.addProductToCart();
        test.info("Product added to cart");
        productPage.viewCart();
        productPage.proceedToCheckout();
        test.info("Proceed to checkout button is clicked");
        productPage.placeOrder();
        test.info("Place order button is clicked");
        productPage.enterCardNumber(card);
        test.info("Invalid card number filled in card field");
    }
}
