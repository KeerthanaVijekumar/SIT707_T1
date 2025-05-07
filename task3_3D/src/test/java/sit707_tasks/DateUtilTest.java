package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "S224719679";
        Assert.assertNotNull(studentId);
        System.out.println("Student ID: " + studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Keerthana";
        Assert.assertNotNull(studentName);
        System.out.println("Student Name: " + studentName);
    }


    // BOUNDARY VALUE ANALYSIS

    @Test
    public void testFridayToMondayNew() {
        DateUtil date = new DateUtil(10, 5, 2024); // Friday
        date.nextBusinessDay();
        System.out.println("Friday : Next Working Day: " + date);
        Assert.assertEquals(13, date.getDay()); // Monday
    }

    @Test
    public void testSaturdayToMondayNew() {
        DateUtil date = new DateUtil(11, 5, 2024); // Saturday
        date.nextBusinessDay();
        System.out.println("Saturday : Next Working Day: " + date);
        Assert.assertEquals(13, date.getDay()); // Monday
    }

    @Test
    public void testSundayToMondayNew() {
        DateUtil date = new DateUtil(12, 5, 2024); // Sunday
        date.nextBusinessDay();
        System.out.println("Sunday : Next Working Day: " + date);
        Assert.assertEquals(13, date.getDay()); // Monday
    }

  
    // EQUIVALENCE CLASS TESTING

    @Test
    public void testMidWeekToNext() {
        DateUtil date = new DateUtil(8, 5, 2024); // Wednesday
        date.nextBusinessDay();
        System.out.println("Wednesday : Next Working Day: " + date);
        Assert.assertEquals(9, date.getDay());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDay() {
        System.out.println("Testing invalid date creation...");
        new DateUtil(35, 1, 2024); // Invalid
    }

    @Test
    public void testMonthEndToNewMonth() {
        DateUtil date = new DateUtil(30, 4, 2024); // Tuesday
        date.nextBusinessDay();
        System.out.println("April 30 : Next Working Day: " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test
    public void testNewYearRollover() {
        DateUtil date = new DateUtil(29, 12, 2024); // Sunday
        date.nextBusinessDay();
        System.out.println("Dec 29 : Next Working Day: " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }
}
