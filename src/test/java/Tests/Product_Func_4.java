package Tests;

import Base.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationproj.pages.Functional_ProductPage;
import com.automationproj.utilities.ExcelUtilities;


public class Product_Func_4 extends BaseTest {
	
	String baseurl = "https://automationexercise.com/";
	String produrl = "https://www.automationexercise.com/products";

	
	@Test
    public void TC_ECOM_Product_036_ValidCVC() throws IOException, InterruptedException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String cvc = ExcelUtilities.getCellValue("Valid", 5, 0);

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
        productPage.enterCVC(cvc);
        test.info("Valid CVC filled in CVC field");
        Thread.sleep(2000);
    }

    @Test
    public void TC_ECOM_Product_037_InvalidCVC() throws IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String cvc = ExcelUtilities.getCellValue("Invalid", 5, 0);

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
        productPage.enterCVC(cvc);
        test.info("Invalid CVC filled in CVC field");
    }

    @Test
    public void TC_ECOM_Product_038_ValidMonth() throws IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String month = ExcelUtilities.getCellValue("Valid", 6, 0);

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
        productPage.enterExpiryMonth(month);
        test.info("Valid month filled in month field");
    }

    @Test
    public void TC_ECOM_Product_039_InvalidMonth() throws IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String month = ExcelUtilities.getCellValue("Invalid", 6, 0);

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
        productPage.enterExpiryMonth(month);
        test.info("Invalid month filled in month field");
    }

    @Test
    public void TC_ECOM_Product_040_ValidYear() throws IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String year = ExcelUtilities.getCellValue("Valid", 7, 0);

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
        productPage.enterExpiryYear(year);
        test.info("Valid Year filled in year field");
    }
    
    @Test
    public void TC_ECOM_Product_041_InvalidYear() throws InterruptedException, IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String year = ExcelUtilities.getCellValue("Invalid", 7, 0);

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
        productPage.enterExpiryYear(year);
        test.info("Invalid Year filled in year field");
        Thread.sleep(2000);
    }

    @Test
    public void TC_ECOM_Product_042_PlaceOrderButton() throws InterruptedException, IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String validName = ExcelUtilities.getCellValue("Valid", 3, 0);
        String card = ExcelUtilities.getCellValue("Valid", 4, 0);
        String cvc = ExcelUtilities.getCellValue("Valid", 5, 0);
        String month = ExcelUtilities.getCellValue("Valid", 6, 0);
        String year = ExcelUtilities.getCellValue("Valid", 7, 0);

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
        productPage.fillPaymentDetails(validName,card,cvc,month,year);
        test.info("Payment details are filled in respective fields");
        productPage.submitOrder();
        test.info("Pay and confirm Order button is clicked");
        Thread.sleep(3000);
    }

    @Test
    public void TC_ECOM_Product_043_DownloadInvoice() throws InterruptedException, IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String validName = ExcelUtilities.getCellValue("Valid", 3, 0);
        String card = ExcelUtilities.getCellValue("Valid", 4, 0);
        String cvc = ExcelUtilities.getCellValue("Valid", 5, 0);
        String month = ExcelUtilities.getCellValue("Valid", 6, 0);
        String year = ExcelUtilities.getCellValue("Valid", 7, 0);

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
        productPage.fillPaymentDetails(validName,card,cvc,month,year);
        test.info("Payment details are filled in respective fields");
        productPage.submitOrder();
        test.info("Pay and confirm Order button is clicked");
        Thread.sleep(3000);
        productPage.downloadInvoice();
        test.info("Download invoice button is clicked");
        Thread.sleep(3000);
    }

    @Test
    public void TC_ECOM_Product_045_ValidSubPayment() throws InterruptedException, IOException {
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String validName = ExcelUtilities.getCellValue("Valid", 3, 0);
        String card = ExcelUtilities.getCellValue("Valid", 4, 0);
        String cvc = ExcelUtilities.getCellValue("Valid", 5, 0);
        String month = ExcelUtilities.getCellValue("Valid", 6, 0);
        String year = ExcelUtilities.getCellValue("Valid", 7, 0);

        productPage.login(email, password);
        productPage.viewProduct();
        productPage.addProductToCart();
        productPage.viewCart();
        productPage.proceedToCheckout();
        productPage.placeOrder();
        productPage.fillPaymentDetails(validName,card,cvc,month,year);
        productPage.submitOrder();
        Thread.sleep(3000);
        productPage.subscribe(email);
        Thread.sleep(2000);
    }

    @Test
    public void TC_ECOM_Product_046_InvalidSubPayment() throws InterruptedException, IOException { //40
        driver.get(baseurl);
        test.info("Home page is opened: " + baseurl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);

        String email = ExcelUtilities.getCellValue("Valid", 1, 0);
        String email2 = ExcelUtilities.getCellValue("Invalid", 1, 0);
        String password = ExcelUtilities.getCellValue("Valid", 2, 0);
        String validName = ExcelUtilities.getCellValue("Valid", 3, 0);
        String card = ExcelUtilities.getCellValue("Valid", 4, 0);
        String cvc = ExcelUtilities.getCellValue("Valid", 5, 0);
        String month = ExcelUtilities.getCellValue("Valid", 6, 0);
        String year = ExcelUtilities.getCellValue("Valid", 7, 0);

        productPage.login(email, password);
        productPage.viewProduct();
        productPage.addProductToCart();
        productPage.viewCart();
        productPage.proceedToCheckout();
        productPage.placeOrder();
        productPage.fillPaymentDetails(validName,card,cvc,month,year);
        productPage.submitOrder();
        productPage.subscribe(email2);
        Thread.sleep(2000);
    }
    
    
	 
	}



