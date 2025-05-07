package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8080/login"); 
        
     // Short wait to ensure the page loads fully
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFullGameFlow_CorrectAnswers() {
        // Login
        driver.findElement(By.name("username")).sendKeys("keerthana");
        driver.findElement(By.name("passwd")).sendKeys("keerthana_pass");
        driver.findElement(By.name("dob")).sendKeys("2000-01-01");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Q1 (1 + 2 = 3)
        driver.findElement(By.name("number1")).sendKeys("1");
        driver.findElement(By.name("number2")).sendKeys("2");
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        // Q2 (5 - 3 = 2)
        driver.findElement(By.name("number1")).sendKeys("5");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        // Q3 (4 * 5 = 20)
        driver.findElement(By.name("number1")).sendKeys("4");
        driver.findElement(By.name("number2")).sendKeys("5");
        driver.findElement(By.name("result")).sendKeys("20");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Final check: either stays on Q3 or moves to a success page
        assertTrue(driver.getCurrentUrl().contains("/q3") || driver.getCurrentUrl().contains("/success"));
    }

    @Test
    public void testLoginFailure() {
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("wrongpass");
        driver.findElement(By.name("dob")).sendKeys("2020-01-01");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Expect to stay on login page
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

