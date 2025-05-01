package sit707_week2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class BunningsJunitTest {
	
	private static final String LOGIN_URL = "https://www.bunnings.com.au/login";
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s224719679";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Keerthana Vijekumar";
		Assert.assertNotNull("Student name is null", studentName);
	}

    @Test
    public void testValidLogin() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "reviewkt24@gmail.com", "KT@Review24");
        assertTrue("Login should be successful with valid credentials", result);
    }

    @Test
    public void testInvalidEmail() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "wrongemail@gmail.com", "KT@Review24");
        assertFalse("Login should fail with invalid email", result);
    }

    @Test
    public void testInvalidPassword() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "reviewkt24@gmail.com", "wrongPassword");
        assertFalse("Login should fail with invalid password", result);
    }

    @Test
    public void testEmptyEmail() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "", "KT@Review24");
        assertFalse("Login should fail with empty email", result);
    }

    @Test
    public void testEmptyPassword() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "reviewkt24@gmail.com", "");
        assertFalse("Login should fail with empty password", result);
    }

    @Test
    public void testEmptyFields() {
        boolean result = SeleniumOperations.bunnings_login_test_case(LOGIN_URL, "", "");
        assertFalse("Login should fail with empty fields", result);
    }

}
