package sit707_tasks;
import static org.junit.Assert.fail;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
/**
 * @author Ahsan Habib Modified by Keerthana Vijekumar
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "S224719679";
		Assert.assertNotNull("Student ID is null", studentId);
		System.out.println(studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Keerthana";
		Assert.assertNotNull("Student name is null", studentName);
		System.out.println(studentName);
	}
	
	// Day Equivalence Test Cases
	
	// Test Case for D1(Day between 1 to 28)	
	@Test
	public void testDayBetween1To28() {
	    DateUtil date = new DateUtil(15, 1, 2024);
	    System.out.println("testDayBetween1To28 > " + date);
	    date.increment();
	    Assert.assertEquals(16, date.getDay());  // Should increment to 16th January
	}

	// Test Case for D2(29th Day in Leap Year)
	@Test
	public void test29thDayLeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);  // 29th February in leap year
	    System.out.println("test29thDayLeapYear > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st March 2024
	}

	// Test Case for D3 (30th Day in Months with 30 Days)
	@Test
	public void test30thDayInMonthWith30Days() {
	    DateUtil date = new DateUtil(30, 4, 2024);  // 30th April 2024
	    System.out.println("test30thDayInMonthWith30Days > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st May 2024
	}
	
	// Test Case for D4 (31st Day in Months with 31 Days)
	@Test
	public void test31stDayInMonthWith31Days() {
	    DateUtil date = new DateUtil(31, 1, 2024);  // 31st January 2024
	    System.out.println("test31stDayInMonthWith31Days > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st February 2024
	}
	
	// Month Equivalence Classes Test Cases:
	
	// Test Case for M1 (31-Day Month)
	@Test
	public void test31stDayIn31DayMonth() {
	    DateUtil date = new DateUtil(31, 12, 2024);  // 31st December 2024
	    System.out.println("test31stDayIn31DayMonth > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st January 2025
	}
	
	// Test Case for M2 (30-Day Month)
	@Test
	public void test30thDayIn30DayMonth() {
	    DateUtil date = new DateUtil(30, 9, 2024);  // 30th September 2024
	    System.out.println("test30thDayIn30DayMonth > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st October 2024
	}

	// Test Case for M3 (February, Leap Year)
	@Test
	public void testFebruaryInLeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);  // 29th February 2024
	    System.out.println("testFebruaryInLeapYear > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st March 2024
	}
	
	// Test Case for M3 (February, Non-Leap Year)
	@Test
	public void testFebruaryInNonLeapYear() {
	    DateUtil date = new DateUtil(28, 2, 2023);  // 28th February 2023
	    System.out.println("testFebruaryInNonLeapYear > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st March 2023
	}
	
	// Year Equivalence Classes Test Cases
	
	// Test Case for Y1 (Leap Year)
	@Test
	public void testLeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);  // 29th February 2024 (Leap Year)
	    System.out.println("testLeapYear > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st March 2024
	}

	// Test Case for Y2 (Non-Leap Year)
	@Test
	public void testNonLeapYear() {
	    DateUtil date = new DateUtil(28, 2, 2023);  // 28th February 2023 (Non-Leap Year)
	    System.out.println("testNonLeapYear > " + date);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());  // Should transition to 1st March 2023
	}
}
