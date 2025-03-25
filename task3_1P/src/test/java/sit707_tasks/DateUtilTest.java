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

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);  // Initialize with January 1, 2024
	    date.increment();  // Increment the date by 1
	    System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date); // Output the result
	    Assert.assertEquals(2, date.getDay());  // Should be 2nd January
	    Assert.assertEquals(1, date.getMonth()); // Should still be January
	    Assert.assertEquals(2024, date.getYear()); // Should still be the same year
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);  // Initialize with January 1, 2024
	    date.decrement();  // Decrement the date by 1
	    System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date); // Output the result
	    Assert.assertEquals(31, date.getDay()); // Should go back to 31st December
	    Assert.assertEquals(12, date.getMonth()); // Should be December
	    Assert.assertEquals(2023, date.getYear()); // Should be the previous year
	}
	
	/*
	 * Previous Date Test Cases
	 */
	
	//Test Case 1A
	@Test
	public void testPreviousJune1ShouldBeMay31() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.decrement();
	    System.out.println("testPreviousJune1ShouldBeMay31 > " + date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	//Test Case 2A
	@Test
	public void testPreviousJune2ShouldBeJune1() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.decrement();
	    System.out.println("testPreviousJune2ShouldBeJune1 > " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 3A
	@Test
	public void testPreviousJune15ShouldBeJune14() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.decrement();
	    System.out.println("testPreviousJune15ShouldBeJune14 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 4A
	@Test
	public void testPreviousJune30ShouldBeJune29() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.decrement();
	    System.out.println("testPreviousJune30ShouldBeJune29 > " + date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

//	//Test Case 5A
	@Test
	public void testInvalidJune31ShouldReturnError() {
	    try {
	        DateUtil date = new DateUtil(31, 6, 1994);
	        fail("Exception not thrown for invalid date");
	    } catch (RuntimeException e) {
	    	System.out.println("testInvalidJune31ShouldReturnError > " + e.getMessage());
	        Assert.assertTrue(e.getMessage().contains("Invalid day"));
	    }
	}

	//Test Case 6A
	@Test
	public void testPreviousJanuary15ShouldBeJanuary14() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.decrement();
	    System.out.println("testPreviousJanuary15ShouldBeJanuary14 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	//Test Case 7A
	@Test
	public void testPreviousFebruary15ShouldBeFebruary14() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.decrement();
	    System.out.println("testPreviousFebruary15ShouldBeFebruary14 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	//Test case 8A
	@Test
	public void testPreviousNovember15ShouldBeNovember14() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.decrement();
	    System.out.println("testPreviousNovember15ShouldBeNovember14 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	//Test Case 9A
	@Test
	public void testPreviousDecember15ShouldBeDecember14() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.decrement();
	    System.out.println("testPreviousDecember15ShouldBeDecember14 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 10A
	@Test
	public void testPreviousJune15ShouldBeJune14For1700() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.decrement();
	    System.out.println("testPreviousJune15ShouldBeJune14For1700 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}

	//Test Case 11A
	@Test
	public void testPreviousJune15ShouldBeJune14For1701() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.decrement();
	    System.out.println("testPreviousJune15ShouldBeJune14For1701 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}

	//Test Case 12A
	@Test
	public void testPreviousJune15ShouldBeJune14For2023() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.decrement();
	    System.out.println("testPreviousJune15ShouldBeJune14For2023 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}

	//Test Case 13A
	@Test
	public void testPreviousJune15ShouldBeJune14For2024() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.decrement();
	    System.out.println("testPreviousJune15ShouldBeJune14For2024 > " + date);
	    Assert.assertEquals(14, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}

	//Next Date Test Cases
	
	//Test Case 1B
	@Test
	public void testNextJune1ShouldBeJune2() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    date.increment();
	    System.out.println("testNextJune1ShouldBeJune2 > " + date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 2B
	@Test
	public void testNextJune2ShouldBeJune3() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    date.increment();
	    System.out.println("testNextJune2ShouldBeJune3 > " + date);
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 3B
	@Test
	public void testNextJune15ShouldBeJune16() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    date.increment();
	    System.out.println("testNextJune15ShouldBeJune16 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

	//Test Case 4B
	@Test
	public void testNextJune30ShouldBeJuly1() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    date.increment();
	    System.out.println("testNextJune30ShouldBeJuly1 > " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
	
	//Test Case 5B
	@Test
	public void testInvalidJune31nextdayShouldReturnError() {
	    try {
	        // 31st June is an invalid date because June only has 30 days
	        DateUtil date = new DateUtil(31, 6, 1994);  
	        fail("Exception not thrown for invalid date");  
	    } catch (RuntimeException e) {
	    	System.out.println("testInvalidJune31ShouldReturnError > " + e.getMessage());
	        Assert.assertTrue(e.getMessage().contains("Invalid day"));
	    }
	}


		
		//Test Case 6B
	@Test
	public void testNextJanuary15ShouldBeJanuary16() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    date.increment();
	    System.out.println("testNextJanuary15ShouldBeJanuary16 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}

		
		//Test Case 7B
	@Test
	public void testNextFebruary15ShouldBeFebruary16() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    date.increment();
	    System.out.println("testNextFebruary15ShouldBeFebruary16 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
		
		//Test case 8B
	@Test
	public void testNextNovember15ShouldBeNovember16() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    date.increment();
	    System.out.println("testNextNovember15ShouldBeNovember16 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
		
		//Test Case 9B
	@Test
	public void testNextDecember15ShouldBeDecember16() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    date.increment();
	    System.out.println("testNextDecember15ShouldBeDecember16 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	    Assert.assertEquals(1994, date.getYear());
	}
		
		//Test Case 10B
	@Test
	public void testNextJune15ShouldBeJune16For1700() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    date.increment();
	    System.out.println("testNextJune15ShouldBeJune16For1700 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1700, date.getYear());
	}
		
		//Test Case 11B
	@Test
	public void testNextJune15ShouldBeJune16For1701() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    date.increment();
	    System.out.println("testNextJune15ShouldBeJune16For1701 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(1701, date.getYear());
	}
		
		//Test Case 12B
	@Test
	public void testNextJune15ShouldBeJune16For2023() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    date.increment();
	    System.out.println("testNextJune15ShouldBeJune16For2023 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2023, date.getYear());
	}
		
		//Test Case 13B
	@Test
	public void testNextJune15ShouldBeJune16For2024() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    date.increment();
	    System.out.println("testNextJune15ShouldBeJune16For2024 > " + date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	    Assert.assertEquals(2024, date.getYear());
	}
	
	//Extra Test Case for February with Leap year
	
	//Test Case 1A
	@Test
	public void testNextFebruary28ShouldBeFebruary29() {
	    // February 28, 2024 (leap year), should increment to February 29, 2024
	    DateUtil date = new DateUtil(28, 2, 2024);
	    date.increment();
	    System.out.println("testNextFebruary28ShouldBeFebruary29 > " + date);
	    Assert.assertEquals(29, date.getDay());  // Should be 29th February
	    Assert.assertEquals(2, date.getMonth()); // Should still be February
	    Assert.assertEquals(2024, date.getYear()); // Should be 2024
	}

	//Test Case 2A
	@Test
	public void testNextFebruary29ShouldBeMarch1() {
	    // February 29, 2024 (leap year), should increment to March 1, 2024
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.increment();
	    System.out.println("testNextFebruary29ShouldBeMarch1 > " + date);
	    Assert.assertEquals(1, date.getDay());   // Should be 1st March
	    Assert.assertEquals(3, date.getMonth()); // Should be March
	    Assert.assertEquals(2024, date.getYear()); // Should be 2024
	}
	
	//Test Case 3A
	@Test
	public void testPreviousFebruary29ShouldBeFebruary28() {
	    // February 29, 2024 (leap year), should decrement to February 28, 2024
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.decrement();
	    System.out.println("testPreviousFebruary29ShouldBeFebruary28 > " + date);
	    Assert.assertEquals(28, date.getDay());  // Should be 28th February
	    Assert.assertEquals(2, date.getMonth()); // Should still be February
	    Assert.assertEquals(2024, date.getYear()); // Should be 2024
	}

	//Test Case 4A
	@Test
	public void testPreviousMarch1ShouldBeFebruary29() {
	    // March 1, 2024, should decrement to February 29, 2024 (leap year)
	    DateUtil date = new DateUtil(1, 3, 2024);
	    date.decrement();
	    System.out.println("testPreviousMarch1ShouldBeFebruary29 > " + date);
	    Assert.assertEquals(29, date.getDay());  // Should be 29th February
	    Assert.assertEquals(2, date.getMonth()); // Should be February
	    Assert.assertEquals(2024, date.getYear()); // Should be 2024
	}

}
