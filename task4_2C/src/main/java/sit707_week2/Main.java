package sit707_week2;

public class Main 
{
	 public static void main(String[] args) {
	        String testUrl = "https://www.bunnings.com.au/login";
	        String testEmail = "your_valid_email@example.com";
	        String testPassword = "yourValidPassword";

	        boolean result = SeleniumOperations.bunnings_login_test_case(testUrl, testEmail, testPassword);
	        System.out.println("Manual Login Test Result: " + (result ? "SUCCESS" : "FAILURE"));
	    }
}
