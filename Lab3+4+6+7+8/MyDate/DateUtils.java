import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class DateUtils {
    public static void compareDates(MyDate date1, MyDate date2) {
        LocalDate date1Local = LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDay());
        LocalDate date2Local = LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDay());
        int result = date1Local.compareTo(date2Local);
        if (result < 0) {
            System.out.println(date1.toString() + " < " + date2.toString());
        } else if (result == 0) {
            System.out.println(date1.toString() + " = " + date2.toString());
        } else {
            System.out.println(date1.toString() + " > " + date2.toString());    
        }
    }

    public static void sortDates(MyDate[] dates) {
        LocalDate[] datesLocal = new LocalDate[dates.length];
        for (int i = 0; i < dates.length; i++) {
            datesLocal[i] = LocalDate.of(dates[i].getYear(), dates[i].getMonth(), dates[i].getDay());
        }
        Arrays.sort(datesLocal, Comparator.nullsFirst(LocalDate::compareTo));
        for (int i = 0; i < dates.length; i++) {
            int year = datesLocal[i].getYear();
            int month = datesLocal[i].getMonthValue();
            int day = datesLocal[i].getDayOfMonth();
            dates[i] = new MyDate(day, month, year);
        }
    }
}
