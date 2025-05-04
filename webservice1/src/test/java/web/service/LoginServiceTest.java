package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

//Keerthana Vijekumar

public class LoginServiceTest {

    private WebDriver driver;
    private final String loginUrl = "http://127.0.0.1:8082/login.html";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginSuccess() {
        driver.get(loginUrl);

        driver.findElement(By.name("username")).sendKeys("keerthana");
        driver.findElement(By.name("passwd")).sendKeys("keerthana_pass");
        driver.findElement(By.name("dob")).sendKeys("1997-07-17");

        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.or(
                ExpectedConditions.titleIs("success"),
                ExpectedConditions.titleIs("fail")
        ));

        assertEquals("success", driver.getTitle());
    }

    @Test
    public void testEmptyFields() {
        driver.get(loginUrl);

        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("passwd")).sendKeys("");
        driver.findElement(By.name("dob")).sendKeys("");

        driver.findElement(By.name("submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.or(
            ExpectedConditions.titleIs("success"),
            ExpectedConditions.titleIs("fail")
        ));

        String actualTitle = driver.getTitle();
        System.out.println("Title for empty fields test = " + actualTitle);  
        assertEquals("fail", actualTitle);
    }


    @Test
    public void testInvalidUsername() {
        driver.get(loginUrl);

        driver.findElement(By.name("username")).sendKeys("wronguser");
        driver.findElement(By.name("passwd")).sendKeys("keerthana_pass");
        driver.findElement(By.name("dob")).sendKeys("1997-07-17");

        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.or(
                ExpectedConditions.titleIs("success"),
                ExpectedConditions.titleIs("fail")
        ));

        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidPassword() {
        driver.get(loginUrl);

        driver.findElement(By.name("username")).sendKeys("keerthana");
        driver.findElement(By.name("passwd")).sendKeys("wrong_pass");
        driver.findElement(By.name("dob")).sendKeys("1997-07-17");

        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.or(
                ExpectedConditions.titleIs("success"),
                ExpectedConditions.titleIs("fail")
        ));

        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidDOB() {
        driver.get(loginUrl);

        driver.findElement(By.name("username")).sendKeys("keerthana");
        driver.findElement(By.name("passwd")).sendKeys("keerthana_pass");
        driver.findElement(By.name("dob")).sendKeys("2000-01-01");

        driver.findElement(By.name("submit")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.or(
                ExpectedConditions.titleIs("success"),
                ExpectedConditions.titleIs("fail")
        ));

        assertEquals("fail", driver.getTitle());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
