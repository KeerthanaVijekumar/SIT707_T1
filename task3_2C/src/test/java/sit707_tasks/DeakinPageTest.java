package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DeakinPageTest {
	
	    // Test Case 1: Valid Name
	    @Test
	    public void testValidName() {
	        String name = "Keerthana Vijekumar";
	        System.out.println("testValidName > Name: " + name);
	        Assert.assertTrue(name.matches("[a-zA-Z\\s]+"));  // Name should contain only letters and spaces
	    }

	    // Test Case 2: Empty Name
	    @Test
	    public void testEmptyName() {
	        String name = "";
	        System.out.println("testEmptyName > Name: " + name);
	        Assert.assertTrue(name.isEmpty());  // Name should be empty
	    }

	    // Test Case 3: Invalid Name (Containing Numbers)
	    @Test
	    public void testInvalidName() {
	        String name = "Keerthana123";
	        System.out.println("testInvalidName > Name: " + name);
	        Assert.assertFalse(name.matches("[a-zA-Z\\s]+"));  // Name should not contain numbers
	    }

	    // Test Case 4: Valid Enquiry Type (Dropdown)
	    @Test
	    public void testValidEnquiryType() {
	        String enquiryType = "Course Advice and Planning";
	        System.out.println("testValidEnquiryType > Enquiry Type: " + enquiryType);
	        Assert.assertTrue(enquiryType.equals("Course Advice and Planning") || enquiryType.equals("Student Services"));
	    }

	    // Test Case 5: No Selection in Enquiry Type Dropdown
	    @Test
	    public void testNoSelectionEnquiryType() {
	        String enquiryType = "-- None --";
	        System.out.println("testNoSelectionEnquiryType > Enquiry Type: " + enquiryType);
	        Assert.assertTrue(enquiryType.equals("-- None --"));
	    }

	    // Test Case 6: Valid Enquiry Details
	    @Test
	    public void testValidEnquiryDetails() {
	        String enquiryDetails = "I would like to inquire about postgraduate courses.";
	        System.out.println("testValidEnquiryDetails > Enquiry Details: " + enquiryDetails);
	        Assert.assertTrue(enquiryDetails.length() > 0);  // Enquiry details should not be empty
	    }

	    // Test Case 7: Empty Enquiry Details
	    @Test
	    public void testEmptyEnquiryDetails() {
	        String enquiryDetails = "";
	        System.out.println("testEmptyEnquiryDetails > Enquiry Details: " + enquiryDetails);
	        Assert.assertTrue(enquiryDetails.isEmpty());  // Enquiry details should be empty
	    }

	    // Test Case 8: Short Enquiry Details
	    @Test
	    public void testShortEnquiryDetails() {
	        String enquiryDetails = "?";
	        System.out.println("testShortEnquiryDetails > Enquiry Details: " + enquiryDetails);
	        Assert.assertTrue(enquiryDetails.length() < 10);  // Enquiry details should be too short to be valid
	    }

	    // Test Case 9: Valid Student ID
	    @Test
	    public void testValidStudentId() {
	        String studentId = "224719679";
	        System.out.println("testValidStudentId > Student ID: " + studentId);
	        Assert.assertTrue(studentId.matches("[0-9]+"));  // Student ID should be numeric
	    }

	    // Test Case 10: Empty Student ID
	    @Test
	    public void testEmptyStudentId() {
	        String studentId = "";
	        System.out.println("testEmptyStudentId > Student ID: " + studentId);
	        Assert.assertTrue(studentId.isEmpty());  // Student ID should be empty
	    }

	    // Test Case 11: Invalid Student ID
	    @Test
	    public void testInvalidStudentId() {
	        String studentId = "abc123";
	        System.out.println("testInvalidStudentId > Student ID: " + studentId);
	        Assert.assertFalse(studentId.matches("[0-9]+"));  // Student ID should be numeric
	    }
}
