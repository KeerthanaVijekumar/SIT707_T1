package sit707_week4;

/**
 * Authenticates user based on username, password and validation code.
 * @author Ahsan Habib modified by Keerthana Vijekumar
 */
public class LoginForm {
	private static String USERNAME = "keerthana";
	private static String PASSWORD = "keerthana_pass";
	private static String VALIDATION_CODE = "654321";

	public static LoginStatus login(String username, String password) {
		if (username == null || username.length()==0) 
			return new LoginStatus(false, "Empty Username");
		
		if (password == null || password.length()==0) 
			return new LoginStatus(false, "Empty Password");
		
		if (!username.equals(USERNAME)) 
			return new LoginStatus(false, "Credential mismatch");
		
		if (!password.equals(PASSWORD)) 
			return new LoginStatus(false, "Credential mismatch");
		
		return new LoginStatus(true, VALIDATION_CODE);
	}
	
	public static boolean validateCode(String code) {
		if (code == null || code.length()==0 || !code.equals(VALIDATION_CODE)) 
			return false;
		return true;
	}
}
