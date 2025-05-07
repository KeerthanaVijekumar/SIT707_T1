package sit707_tasks;

/**
 * Main class to demonstrate Add N Days to a Date functionality.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Add N days to a date — Demo:");

        // Example 1: Add 0 days
        DateUtil date1 = new DateUtil(1, 1, 2024);
        System.out.println("Original: " + date1);
        date1.addDays(0);
        System.out.println("After adding 0 days: " + date1);
        System.out.println();

        // Example 2: Add 30 days
        DateUtil date2 = new DateUtil(1, 3, 2024);
        System.out.println("Original: " + date2);
        date2.addDays(30);
        System.out.println("After adding 30 days: " + date2);
        System.out.println();

        // Example 3: Add 365 days
        DateUtil date3 = new DateUtil(1, 1, 2024);
        System.out.println("Original: " + date3);
        date3.addDays(365);
        System.out.println("After adding 365 days: " + date3);
    }
}
