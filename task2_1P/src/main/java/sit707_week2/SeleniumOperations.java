package sit707_week2;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib modified by Keerthana Vijekumar
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//OfficeWorks Registration Page
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Keerthana");
		
		
		
		/*
		 * Find following input fields and populate with values
		 */
		 	WebElement lastNameField = driver.findElement(By.id("lastname"));
	        lastNameField.sendKeys("Vijekumar"); 

	        WebElement phoneField = driver.findElement(By.id("phoneNumber"));
	        phoneField.sendKeys("0412345678"); 

	        WebElement emailField = driver.findElement(By.id("email"));
	        emailField.sendKeys("s224719679@example.com"); 

	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys("Password123"); 

	        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
	        confirmPasswordField.sendKeys("Password123"); 	
	        
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
	        WebDriverWait wait = new WebDriverWait(driver,10);
	        WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='account-action-btn']")));
		
	        createAccountButton.click();
	        System.out.println("Create Account button clicked!");
		/*
		 * Take screenshot using selenium API.
		 */
	        try {
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            screenshot.renameTo(new File("officeworks_registration.png"));
	            System.out.println("Screenshot saved: officeworks_registration.png");
	        } catch (Exception e) {
	            System.out.println("Screenshot capture failed: " + e.getMessage());
	        }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
	//Bunnings Registration Page
	public static void bunnings_registration_page(String url) {
	    // Set up ChromeDriver
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");

	    // Open Chrome browser
	    System.out.println("Fire up chrome browser.");
	    WebDriver driver = new ChromeDriver();
	    System.out.println("Driver info: " + driver);

	    sleep(2);

	    // Load the webpage
	    driver.get(url);

	    // Step 4: Locate and populate input fields 
	    WebElement emailField = driver.findElement(By.id("uid")); 
	    emailField.sendKeys("s224719679@example.com"); 

	    WebElement passwordField = driver.findElement(By.id("password")); 
	    passwordField.sendKeys("Password321"); 

	    WebElement firstNameField = driver.findElement(By.id("firstName")); 
	    firstNameField.sendKeys("Keerthana"); 

	    WebElement lastNameField = driver.findElement(By.id("lastName")); 
	    lastNameField.sendKeys("Vijekumar"); 


	    //Locate and click the "Create account" button using data-locator
	    WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-locator='input_CreateAccount']"));
	    createAccountButton.click();
	    System.out.println("Create Account button clicked!");
	    
	    
	    //Take screenshot
	    try {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        screenshot.renameTo(new File("bunnings_registration.png"));
	        System.out.println("Screenshot saved: bunnings_registration.png");
	    } catch (Exception e) {
	        System.out.println("Screenshot capture failed: " + e.getMessage());
	    }

	    // Step 6: Sleep for a while to observe the result
	    sleep(5);

	    // Step 7: Close the browser
	    driver.close();
	}
	
	
	
}
