package sit707_tasks;

public class DateUtil {

    private int day, month, year;

    public DateUtil(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new RuntimeException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new RuntimeException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 3000)
            throw new RuntimeException("Invalid year: " + year + ", expected range 1700-3000");
        if (day > monthDuration(month, year))
            throw new RuntimeException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
        
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void addDays(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot add negative days: " + n);
        }

        for (int i = 0; i < n; i++) {
            increment();
        }
    }

    private void increment() {
        if (day < monthDuration(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }

    public static int monthDuration(int month, int year) {
        if (month == 2) {
            return (isLeapYear(year)) ? 29 : 28;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else
            return 31;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
}
