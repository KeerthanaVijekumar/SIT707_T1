package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

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

    // ----------------------------
    // Boundary Value Analysis (BVA)
    // ----------------------------

    @Test
    public void testAddZeroDays() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.addDays(0);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
        System.out.println("testAddZeroDays > " + date);
    }

    @Test
    public void testAddOneDay() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.addDays(1);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out.println("testAddOneDay > " + date);
    }

    @Test
    public void testAdd28Days() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.addDays(28);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        System.out.println("testAdd28Days > " + date);
    }

    @Test
    public void testAdd30Days() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.addDays(30);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        System.out.println("testAdd30Days > " + date);
    }

    @Test
    public void testAdd365Days() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.addDays(365);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
        System.out.println("testAdd365Days > " + date);
    }

    // ----------------------------
    // Equivalence Class Testing (ECT)
    // ----------------------------

    @Test(expected = IllegalArgumentException.class)
    public void testAddNegativeDays() {
        DateUtil date = new DateUtil(10, 1, 2024);
        date.addDays(-5);  // Invalid input
    }

    @Test
    public void testAddToLeapYearFebruary() {
        DateUtil date = new DateUtil(27, 2, 2024);  // Leap year
        date.addDays(2);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        System.out.println("testAddToLeapYearFebruary > " + date);
    }

    @Test
    public void testAddToNonLeapYearFebruary() {
        DateUtil date = new DateUtil(27, 2, 2023);  // Non-leap year
        date.addDays(2);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        System.out.println("testAddToNonLeapYearFebruary > " + date);
    }

    @Test
    public void testAddDaysYearRollover() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.addDays(1);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
        System.out.println("testAddDaysYearRollover > " + date);
    }
}
