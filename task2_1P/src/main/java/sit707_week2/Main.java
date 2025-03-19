package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib modified by Keerthana Vijekumar
 */
public class Main 
{
    public static void main( String[] args )
    {
    	// OfficeWorks Registration
        SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        
        // Bunnings registration
        SeleniumOperations.bunnings_registration_page("https://www.bunnings.com.au/register");
    }
}
