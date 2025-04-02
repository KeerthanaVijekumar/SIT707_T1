package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib Modified by Keerthana Vijekumar
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s224719679";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Keerthana";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	// TC1: Empty username & empty password
    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // TC2: Empty username & wrong password
    @Test
    public void testEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("", "wrong");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // TC3: Empty username & correct password
    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("", "keerthana_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    // TC4: Wrong username & empty password
    @Test
    public void testWrongUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("wrong", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    // TC5: Wrong username & wrong password
    @Test
    public void testWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("wrong", "wrong");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // TC6: Wrong username & correct password
    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrong", "keerthana_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // TC7: Correct username & empty password
    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("keerthana", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    // TC8: Correct username & wrong password
    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("keerthana", "wrong");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    // TC9: Correct login (no code validation)
    @Test
    public void testCorrectLoginWithoutValidationCode() {
        LoginStatus status = LoginForm.login("keerthana", "keerthana_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("654321", status.getErrorMsg());
        // No validation step
    }

    // TC10: Correct login, wrong validation code
    @Test
    public void testCorrectLoginWithWrongValidationCode() {
        LoginStatus status = LoginForm.login("keerthana", "keerthana_pass");
        Assert.assertTrue(status.isLoginSuccess());

        boolean result = LoginForm.validateCode("wrong");
        Assert.assertFalse(result);
    }

    // TC11: Correct login, correct validation code
    @Test
    public void testCorrectLoginWithCorrectValidationCode() {
        LoginStatus status = LoginForm.login("keerthana", "keerthana_pass");
        Assert.assertTrue(status.isLoginSuccess());

        String code = status.getErrorMsg(); // should be "123456"
        boolean result = LoginForm.validateCode(code);
        Assert.assertTrue(result);
    }
}
