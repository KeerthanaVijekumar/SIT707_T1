package sit707_week2;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static boolean bunnings_login_test_case(String url, String email, String password) {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");

	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(url);
	        
	        boolean loginSuccessful = false;

	        try {
	            WebElement emailField = driver.findElement(By.id("username"));
	            WebElement passwordField = driver.findElement(By.id("password"));
	            WebElement loginButton = driver.findElement(By.id("login-submit"));

	            emailField.clear();
	            emailField.sendKeys(email);

	            passwordField.clear();
	            passwordField.sendKeys(password);

	            loginButton.click();

	            sleep(3);
	            String currentUrl = driver.getCurrentUrl();
	            loginSuccessful = !currentUrl.contains("login");
	            
	            // Take screenshot
	            try {
	                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                screenshot.renameTo(new File("bunnings_login_result.png"));
	                System.out.println("Screenshot saved: bunnings_login_result.png");
	            } catch (Exception e) {
	                System.out.println("Screenshot capture failed: " + e.getMessage());
	            }

	            // Sleep to observe result
	            sleep(5);

	        } catch (Exception e) {
	            System.out.println("Login failed: " + e.getMessage());
	            return false;
	        } finally {
	            driver.quit();
	        }	
	        return loginSuccessful;
	}
}
