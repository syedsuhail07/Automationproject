package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aplitool {
	
	public static void main(String[] args) throws InterruptedException {
		Eyes eyes = new Eyes();
		eyes.setApiKey("RRN93OXMKRSvBS6FeDsBbh2YOCDGLMDRLYpylEtAUcA110");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		eyes.open(driver, "Demo App", "Login Test");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		//driver.get("https://demo.applitools.com");
		// First checkpoint
		eyes.checkWindow("Login orangehrm Page");   // Takes screenshot of login page
		// Perform login
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Second checkpoint
		eyes.checkWindow("OrangeHRM Dashboard");    // Takes screenshot after login
	String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		eyes.close();
		driver.quit();
		
		
		
	}
}



