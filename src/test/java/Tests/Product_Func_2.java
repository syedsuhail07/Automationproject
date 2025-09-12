package Tests;

import Base.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationproj.pages.Functional_ProductPage;
import com.automationproj.utilities.ExcelUtilities;
public class Product_Func_2 extends BaseTest {

	String baseurl = "https://automationexercise.com/";
    String produrl = "https://www.automationexercise.com/products";
    String viewprodurl = "https://www.automationexercise.com/product_details/1";

    @Test
    public void TC_ECOM_Product_013_AllenSollyJuniorProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Allen Solly Junior icon is clicked");
        test.info("Redirected to Allen Solly Junior products");
        productPage.verifyBrandProduct("//a[text()='Allen Solly Junior']", "Automation Exercise - Allen Solly Junior Products");
    }

    @Test
    public void TC_ECOM_Product_014_KookiekidsProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Kookie Kids icon is clicked");
        test.info("Redirected to Kookie Kids products");
        productPage.verifyBrandProduct("//a[text()='Kookie Kids']", "Automation Exercise - Kookie Kids Products");
    }

    @Test
    public void TC_ECOM_Product_015_BibaProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Biba icon is clicked");
        test.info("Redirected to Biba products");
        productPage.verifyBrandProduct("//a[text()='Biba']", "Automation Exercise - Biba Products");
    }

    @Test
    public void TC_ECOM_Product_016_ViewProductButton() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        productPage.clickFirstViewProduct();
        test.info("Product details are displayed");

        Assert.assertTrue(productPage.isOnProductDetailsPage(),
                "❌ URL does not contain 'product_details'. Current URL: " + driver.getCurrentUrl());
        Assert.assertTrue(productPage.isProductInfoVisible(), "❌ Product details section not visible!");

        System.out.println("✅ View Product button works: navigated to details page successfully.");
    }

    @Test
    public void TC_ECOM_Product_017_AddToCart() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        productPage.addFirstProductToCart();
        test.info("Product added to cart");

        Assert.assertTrue(productPage.isAddToCartModalVisible(), "❌ Add to Cart modal popup not displayed!");

        productPage.clickViewCart();
        test.info("Redirected to Cart page");

        Assert.assertTrue(productPage.isOnCartPage(), "❌ Did not navigate to cart page!");
        Assert.assertTrue(productPage.isCartTableVisible(), "❌ Cart table not visible!");
        Assert.assertTrue(productPage.isFirstProductInCartVisible(), "❌ Product not found in cart!");

        System.out.println("✅ Add to Cart functionality works: product added and visible in cart.");
    }
    
    @Test
    public void TC_ECOM_Product_021_ValidNameField() throws Exception {
        driver.get(viewprodurl);
        test.info("View Product page is opened: " + viewprodurl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        String validName = ExcelUtilities.getCellValue("Valid", 3, 0);  // Row 3, Col 0
        productPage.enterName(validName);
        test.info("Data taken from Excel sheet");
        test.info("Valid name filled in Name Field");
    }

    @Test
    public void TC_ECOM_Product_022_InvalidNameField() throws Exception {
        driver.get(viewprodurl);
        test.info("View Product page is opened: " + viewprodurl );
        

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        String invalidName = ExcelUtilities.getCellValue("Invalid", 3, 0);
        productPage.enterName(invalidName);
        test.info("Data taken from Excel sheet");
        test.info("Invalid name filled in Name Field");
    }

    @Test
    public void TC_ECOM_Product_023_ValidMail() throws Exception {
        driver.get(viewprodurl);
        test.info("View Product page is opened: " + viewprodurl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        String validMail = ExcelUtilities.getCellValue("Valid", 1, 0);
        productPage.enterEmail(validMail);
        test.info("Data taken from Excel sheet");
        test.info("Valid mail filled in Email Field");
    }

    @Test
    public void TC_ECOM_Product_024_InvalidMail() throws Exception {
        driver.get(viewprodurl);
        test.info("View Product page is opened: " + viewprodurl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        String invalidMail = ExcelUtilities.getCellValue("Invalid", 1, 0);
        productPage.enterEmail(invalidMail);
        test.info("Data taken from Excel sheet");
        test.info("Invalid mail filled in Email Field");
    }

    @Test
    public void TC_ECOM_Product_025_ReviewField() throws Exception { //20
    	driver.get(baseurl);
    	test.info("Home page is opened: " + baseurl );

        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        String review = ExcelUtilities.getCellValue("Valid", 9, 0);
        
        productPage.viewProduct();
        test.info("Product details are displayed");
        productPage.enterReview(review);
        test.info("Data taken from Excel sheet");
        test.info("Review filled in Review Field");
        Thread.sleep(2000);
    }
}
