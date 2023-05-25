import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private static final Map<String, Integer> DAY_NAMES_MAP = new HashMap<>();

    static {
        DAY_NAMES_MAP.put("first", 1);
        DAY_NAMES_MAP.put("second", 2);
        DAY_NAMES_MAP.put("third", 3);
        DAY_NAMES_MAP.put("fourth", 4);
        DAY_NAMES_MAP.put("fifth", 5);
        DAY_NAMES_MAP.put("sixth", 6);
        DAY_NAMES_MAP.put("seventh", 7);
        DAY_NAMES_MAP.put("eighth", 8);
        DAY_NAMES_MAP.put("ninth", 9);
        DAY_NAMES_MAP.put("tenth", 10);
        DAY_NAMES_MAP.put("eleventh", 11);
        DAY_NAMES_MAP.put("twelfth", 12);
        DAY_NAMES_MAP.put("thirteenth", 13);
        DAY_NAMES_MAP.put("fourteenth", 14);
        DAY_NAMES_MAP.put("fifteenth", 15);
        DAY_NAMES_MAP.put("sixteenth", 16);
        DAY_NAMES_MAP.put("seventeenth", 17);
        DAY_NAMES_MAP.put("eighteenth", 18);
        DAY_NAMES_MAP.put("nineteenth", 19);
        DAY_NAMES_MAP.put("twentieth", 20);
        DAY_NAMES_MAP.put("twenty-first", 21);
        DAY_NAMES_MAP.put("twenty-second", 22);
        DAY_NAMES_MAP.put("twenty-third", 23);
        DAY_NAMES_MAP.put("twenty-fourth", 24);
        DAY_NAMES_MAP.put("twenty-fifth", 25);
        DAY_NAMES_MAP.put("twenty-sixth", 26);
        DAY_NAMES_MAP.put("twenty-seventh", 27);
        DAY_NAMES_MAP.put("twenty-eighth", 28);
        DAY_NAMES_MAP.put("twenty-ninth", 29);
        DAY_NAMES_MAP.put("thirtieth", 30);
        DAY_NAMES_MAP.put("thirty-first", 31);
    }

    private static final Map<String, Integer> NUM_WORDS = new HashMap<>();

    static {
        NUM_WORDS.put("zero", 0);
        NUM_WORDS.put("one", 1);
        NUM_WORDS.put("two", 2);
        NUM_WORDS.put("three", 3);
        NUM_WORDS.put("four", 4);
        NUM_WORDS.put("five", 5);
        NUM_WORDS.put("six", 6);
        NUM_WORDS.put("seven", 7);
        NUM_WORDS.put("eight", 8);
        NUM_WORDS.put("nine", 9);
        NUM_WORDS.put("ten", 10);
        NUM_WORDS.put("eleven", 11);
        NUM_WORDS.put("twelve", 12);
        NUM_WORDS.put("thirteen", 13);
        NUM_WORDS.put("fourteen", 14);
        NUM_WORDS.put("fifteen", 15);
        NUM_WORDS.put("sixteen", 16);
        NUM_WORDS.put("seventeen", 17);
        NUM_WORDS.put("eighteen", 18);
        NUM_WORDS.put("nineteen", 19);
        NUM_WORDS.put("twenty", 20);
        NUM_WORDS.put("thirty", 30);
        NUM_WORDS.put("forty", 40);
        NUM_WORDS.put("fifty", 50);
        NUM_WORDS.put("sixty", 60);
        NUM_WORDS.put("seventy", 70);
        NUM_WORDS.put("eighty", 80);
        NUM_WORDS.put("ninety", 90);
    }

    private static final Map<String, Integer> NUM_MULTIPLIER = new HashMap<>();

    static {
        NUM_MULTIPLIER.put("hundred", 100);
        NUM_MULTIPLIER.put("thousand", 1000);
    }


    public int getDay() {
        return day;
    }

    public boolean setDay(int day) {
        try {
            String dateString = String.format("%02d %02d %04d", day, this.month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
            this.day = day;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid day!");
            return false;
        }
    }

    public boolean setDay(String dayName) {
        int day = DAY_NAMES_MAP.get(dayName.toLowerCase());
        try {
            String dateString = String.format("%02d %02d %04d", day, this.month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
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
            String dateString = String.format("%02d %02d %04d", this.day, month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
            this.month = month;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid month!");
            return false;
        }
    }

    public boolean setMonth(String month) {
        try {
            String dateString = String.format("%02d %s %04d", this.day, month, this.year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM uuuu", Locale.ENGLISH).withResolverStyle(ResolverStyle.STRICT);
            LocalDate date = LocalDate.parse(dateString, formatter);
            this.month = date.getMonthValue();
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
            String dateString = String.format("%02d %02d %04d", this.day, this.month, year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
            this.year = year;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid year!");
            return false;
        }
    }

    public boolean setYear(String yearName) {

        int year = convertEnglishYearToInteger(yearName);


        try {
            String dateString = String.format("%02d %02d %04d", this.day, this.month, year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
            this.year = year;
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid year!");
            return false;
        }
    }


    
    public static int convertEnglishYearToInteger(String input) {
        int result = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>();


        String[] words = input.toLowerCase().replaceAll("-", " ").split(" ");
        int length = words.length;

        for (int i = 0; i < length - 1; i++) {
            if (NUM_WORDS.containsKey(words[i])) {
                int value = NUM_WORDS.get(words[i]);
                if(NUM_MULTIPLIER.containsKey(words[i+1])) {
                    value *= NUM_MULTIPLIER.get(words[i+1]);
                } 
                numbers.add(value);
            } else if (NUM_MULTIPLIER.containsKey(words[i])){
                continue;
            } else {
                throw new IllegalArgumentException("Invalid number: " + words[i]);
            }
        }
        if(NUM_WORDS.containsKey(words[length - 1])) {
            result += NUM_WORDS.get(words[length - 1]);
        } else if(NUM_MULTIPLIER.containsKey(words[length - 1])){
            result *= NUM_MULTIPLIER.get(words[length - 1]);
        } else {
            throw new IllegalArgumentException("Invalid number: " + words[length - 1]);
        }
        if(numbers.size() == 1) {
            result += numbers.get(0);
        } else if (numbers.size() == 2) {
            int digits = 0;
            int first = numbers.get(0);

            while (first != 0) {
                digits++;
                first /= 10;
            }
            int multiplier = (int) Math.pow(10, 4 - digits);
            numbers.set(0, numbers.get(0) * multiplier);
            result += numbers.get(0) + numbers.get(1);
        }

        return result;
    }

    public MyDate() {
        LocalDate now = LocalDate.now();
        this.day = now.getDayOfMonth();
        this.month = now.getMonthValue();
        this.year = now.getYear();
    }

    public MyDate(int day, int month, int year) {
        try {
            String dateString = String.format("%02d %02d %04d", day, month, year);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM uuuu").withResolverStyle(ResolverStyle.STRICT);
            LocalDate.parse(dateString, formatter);
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

    public void print(String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            LocalDate date = LocalDate.of(year, month, day);
            System.out.println(formatter.format(date));
        } catch (DateTimeParseException e){
            System.out.println("Invalid format!");
        }

    }

    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }
}