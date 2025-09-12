package Tests;

import Base.BaseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automationproj.pages.Functional_ProductPage;
import com.automationproj.utilities.ExcelUtilities;

public class Product_Func_1 extends BaseTest {
	
	String baseurl = "https://automationexercise.com/";
    String produrl = "https://www.automationexercise.com/products";
    String viewprodurl = "https://www.automationexercise.com/product_details/1";
    
    @Test
    public void TC_ECOM_Product_001_ProductsButton() {
    	driver.get(baseurl);
    	test.info("Home page is loaded:  " + baseurl);
    	Functional_ProductPage productPage = new Functional_ProductPage(driver);
    	
    	productPage.redirectToProducts();
    	test.info("Redirection from Home page to Products page");
    }

	@Test
    public void TC_ECOM_Product_002_SearchBarVisiblity() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl);
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        
        try {
            Assert.assertTrue(productPage.isSearchBarVisible(), "❌ Search bar is NOT visible!");
            test.pass("✅ Search bar is visible");
        } catch (AssertionError e) {
            test.fail(e.getMessage());
            throw e; // rethrow so TestNG marks test as failed
        }
        	
        
    }

    @Test
    public void TC_ECOM_Product_003_SearchFunctionality() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl);
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        productPage.searchProduct("Tshirt");
        test.info("Searched for product: Tshirt");
        
        try {
            // Example: check if at least one product containing "Tshirt" is displayed
            WebElement result = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
            Assert.assertTrue(result.isDisplayed(), "❌ Search results are NOT displayed for 'Tshirt'!");
            test.pass("✅ Search results are displayed for 'Tshirt'");
        } catch (Exception e) {
            test.fail("❌ Search results are NOT displayed for 'Tshirt'!");
            throw e;
        }
        
    }

    @Test
    public void TC_ECOM_Product_005_VerifyWomenCategoryDropdown() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        productPage.clickWomenIcon();
        test.info("Women icon is clicked");
        
        //try {
        	//Assert.assertTrue(productPage.isWomenDropdownVisible(), "❌ Women dropdown did not appear!");
        	//test.pass("Women category dropwdown displayed");
        //} catch (AssertionError e) {
        	//test.fail(e.getMessage());
        	//}
        
	}
        

    @Test
    public void TC_ECOM_Product_006_VerifyMenCategoryDropdown() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        productPage.clickMenIcon();
        test.info("Men icon is clicked");
        Assert.assertTrue(productPage.isMenDropdownVisible(), "❌ Men dropdown did not appear!");
    }

    @Test
    public void TC_ECOM_Product_007_KidsIcon() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Kids icon is clicked");
        Assert.assertTrue(productPage.expandKidsCategory(), "❌ Kids dropdown did not appear!");
    }

    @Test
    public void TC_ECOM_Product_008_PoloProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Polo icon is clicked");
        test.info("Redirected to Polo products");
        productPage.verifyBrandProduct("//a[text()='Polo']", "Automation Exercise - Polo Products");
    }

    @Test
    public void TC_ECOM_Product_009_HmProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("H&M icon is clicked");
        test.info("Redirected to H&M products");
        productPage.verifyBrandProduct("//a[text()='H&M']", "Automation Exercise - H&M Products");
    }

    @Test
    public void TC_ECOM_Product_010_MadameProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Madame icon is clicked");
        test.info("Redirected to Madame products");
        productPage.verifyBrandProduct("//a[text()='Madame']", "Automation Exercise - Madame Products");
    }

    @Test
    public void TC_ECOM_Product_011_MastHarbourProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Mast Harbour icon is clicked");
        test.info("Redirected to Mast Harbour products");
        productPage.verifyBrandProduct("//a[text()='Mast & Harbour']", "Automation Exercise - Mast & Harbour Products");
    }
    
    @Test
    public void TC_ECOM_Product_012_BabyhugProducts() {
        driver.get(produrl);
        test.info("Product page is opened: " + produrl );
        Functional_ProductPage productPage = new Functional_ProductPage(driver);
        test.info("Baby Hug icon is clicked");
        test.info("Redirected to Baby Hug products");
        productPage.verifyBrandProduct("//a[text()='Babyhug']", "Automation Exercise - Babyhug Products");
    }
}
