package procedure.dispCurrentMonth;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DispCurrentMonth {

    private LocalDate date;

    public void dispCurrentMonth(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        dispProcess(date);
    }

    public void dispCurrentMonth() {
        this.date = LocalDate.now();
        dispProcess(date);
    }

    private void dispProcess(LocalDate date) {
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // first day of month(today - (today - 1))
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon  Tue  Wed  Thu  Fri  Sat  Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("     ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
            date = date.plusDays(1);
            // new line
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println("");
            }
        }
    }
}
