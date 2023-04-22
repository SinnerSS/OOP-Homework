import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public boolean setDay(int day) {
        try {
            String date_string = String.format("%02d %02d %04d", day, this.month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(date_string, formatter);
            this.day = day;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid day!");
            return false;
        }
    }

    public int getMonth() {
        return month;
    }

    public boolean setMonth(int month) {
        try {
            String date_string = String.format("%02d %02d %04d", this.day, month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(date_string, formatter);
            this.month = month;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid month!");
            return false;
        }
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        try {
            String date_string = String.format("%02d %02d %04d", this.day, this.month, year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(date_string, formatter);
            this.year = year;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid year!");
            return false;
        }
    }

    public MyDate() {
        LocalDate now = LocalDate.now();
        this.day = now.getDayOfMonth();
        this.month = now.getMonthValue();
        this.year = now.getYear();
    }

    public MyDate(int day, int month, int year) {
        try {
            String date_string = String.format("%02d %02d %04d", day, month, year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(date_string, formatter);
            this.day = day;
            this.month = month;
            this.year = year;
        } catch (DateTimeParseException e) {

            this.day = -1;
            this.month = -1;
            this.year = -1;
        }
    }

    public MyDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d uuuu", Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate input = LocalDate.parse(date.replaceFirst("(?<=\\d)(st|nd|rd|th)", ""), formatter);
            this.day = input.getDayOfMonth();
            this.month = input.getMonthValue();
            this.year = input.getYear();
        } catch (DateTimeParseException e) {
            this.day = -1;
            this.month = -1;
            this.year = -1;
        }
    }

    public void print() {
        if (this.day == -1 || this.month == -1 || this.year == -1) {
            System.out.println("Invalid date!");
        } else {
            System.out.printf("%02d/%02d/%d\n", day, month, year);
        }
    }
}