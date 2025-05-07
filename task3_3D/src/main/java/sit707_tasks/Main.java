package sit707_tasks;

public class Main {
    public static void main(String[] args) {
        DateUtil date = new DateUtil(11, 5, 2024); // Saturday
        System.out.println("Current Date: " + date);
        date.nextBusinessDay();
        System.out.println("Next Business Day: " + date);
    }
}
