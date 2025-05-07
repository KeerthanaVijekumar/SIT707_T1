package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "S224719679";
        Assert.assertNotNull(studentId);
        System.out.println(studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Keerthana";
        Assert.assertNotNull(studentName);
        System.out.println(studentName);
    }

    // ----------------------------
    // BOUNDARY VALUE ANALYSIS
    // ----------------------------

    @Test
    public void testFridayToMonday() {
        DateUtil date = new DateUtil(5, 4, 2024); // Friday
        date.calculateNextWorkingDay();
        Assert.assertEquals(8, date.getDay());
        System.out.println("Friday to Monday > " + date);
    }

    @Test
    public void testSaturdayToMonday() {
        DateUtil date = new DateUtil(6, 4, 2024); // Saturday
        date.calculateNextWorkingDay();
        Assert.assertEquals(8, date.getDay());
        System.out.println("Saturday to Monday > " + date);
    }

    @Test
    public void testSundayToMonday() {
        DateUtil date = new DateUtil(7, 4, 2024); // Sunday
        date.calculateNextWorkingDay();
        Assert.assertEquals(8, date.getDay());
        System.out.println("Sunday to Monday > " + date);
    }

    // ----------------------------
    // EQUIVALENCE CLASS TESTING
    // ----------------------------

    @Test
    public void testWeekdayAdvance() {
        DateUtil date = new DateUtil(2, 4, 2024); // Tuesday
        date.calculateNextWorkingDay();
        Assert.assertEquals(3, date.getDay());
        System.out.println("Tuesday to Wednesday > " + date);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDate() {
        new DateUtil(32, 1, 2024); // Invalid day
    }

    @Test
    public void testMonthEndRollover() {
        DateUtil date = new DateUtil(31, 1, 2024); // Wednesday
        date.calculateNextWorkingDay();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out.println("End of Jan to Feb > " + date);
    }

    @Test
    public void testYearEndRollover() {
        DateUtil date = new DateUtil(29, 12, 2023); // Friday
        date.calculateNextWorkingDay(); // Should skip weekend
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
        System.out.println("Dec 29 to Jan 1 > " + date);
    }
}
