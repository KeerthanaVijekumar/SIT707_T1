package sit707_tasks;

public class Main {
    public static void main(String[] args) {
        DateUtil date = new DateUtil(5, 4, 2024); // Friday
        System.out.println("Original Date: " + date);
        date.calculateNextWorkingDay();
        System.out.println("Next Working Day: " + date);
    }
}
