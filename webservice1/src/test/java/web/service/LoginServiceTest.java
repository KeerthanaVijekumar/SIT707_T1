package web.service;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class LoginServiceTest {

    private WebDriver driver;
    private final String loginUrl = "http://127.0.0.1:8082/login.html";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\keert\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void fillForm(WebDriver driver, String username, String password, String dob) {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(username);

        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys(password);

        // Clear DOB field using JavaScript and only fill if dob is not empty
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('dob')[0].value = '';");
        if (!dob.isEmpty()) {
            js.executeScript("document.getElementsByName('dob')[0].value = arguments[0];", dob);
        }

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("submit"))).click();
    }



    @Test
    public void testLoginSuccess() {
        driver.get(loginUrl);
        fillForm(driver, "keerthana", "keerthana_pass", "1997-07-17");

        new WebDriverWait(driver, 5)
            .until(ExpectedConditions.or(
                ExpectedConditions.titleIs("success"),
                ExpectedConditions.titleIs("fail")
            ));

        assertEquals("success", driver.getTitle());
    }


    @Test
    public void testInvalidUsername() {
        driver.get(loginUrl);
        fillForm(driver,"wronguser", "keerthana_pass", "1997-07-17");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidPassword() {
        driver.get(loginUrl);
        fillForm(driver,"keerthana", "wrong_pass", "1997-07-17");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testInvalidDOB() {
        driver.get(loginUrl);
        fillForm(driver,"keerthana", "keerthana_pass", "2000-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testEmptyFields() {
        driver.get(loginUrl);
        fillForm(driver, "", "", "");
        assertEquals("fail", driver.getTitle());
    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
