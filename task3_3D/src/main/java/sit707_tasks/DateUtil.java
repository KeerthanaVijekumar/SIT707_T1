package sit707_tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private LocalDate date;

    public DateUtil(int day, int month, int year) {
        try {
            this.date = LocalDate.of(year, month, day);
        } catch (Exception e) {
            throw new RuntimeException("Invalid input date: " + day + "/" + month + "/" + year);
        }
    }

    public void nextBusinessDay() {
        date = date.plusDays(1);
        while (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }
    }

    public int getDay() { return date.getDayOfMonth(); }
    public int getMonth() { return date.getMonthValue(); }
    public int getYear() { return date.getYear(); }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
