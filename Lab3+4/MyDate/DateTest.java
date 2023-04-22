
public class DateTest {
    

    public static void main(String[] args) {
    // Testing no parameter constructor
    MyDate date1 = new MyDate();
    date1.print(); // expected output: current date in the format dd/mm/yyyy

    // Testing 3 parameter constructor
    MyDate date2 = new MyDate(12, 4, 2023);
    date2.print(); // expected output: 22/04/2023

    // Testing string parameter constructor
    MyDate date3 = new MyDate("May 1st 2022");
    date3.print(); // expected output: 01/05/2022

    // Testing setter and getter methods
    MyDate date4 = new MyDate();
    date4.setDay(1);
    date4.setMonth(5);
    date4.setYear(2022);
    date4.print(); // expected output: 01/05/2022

    // Testing invalid date string
    MyDate date6 = new MyDate("February 29th 2019"); // not a leap year
    date6.print(); // expected output: Invalid date!
    // Testing invalid day
    MyDate date7 = new MyDate(31, 4, 2022); // April doesn't have 31 days
    date7.print(); // expected output: Invalid date!

    // Testing invalid month
    MyDate date8 = new MyDate(15, 13, 2022); // month should be between 1 and 12
    date8.print(); // expected output: Invalid date!

    // Testing setter and getter methods with invalid date
    MyDate date9 = new MyDate();
    date9.setDay(30);
    date9.setMonth(2); // expected output: Invalid month!
    date9.setYear(2022);
    date9.print(); // expected output: 30/currentMonth/2022

    
    MyDate date10 = new MyDate();
    date10.setDay("eleventh");
    date10.setMonth("August");
    date10.setYear("twenty twenty-two");
    date10.print();
   
    DateUtils.compareDates(date3, date4);

    MyDate[] dateList = {date2, date3, date4};
    DateUtils.sortDates(dateList);
    for (MyDate date : dateList) {
        System.out.print(date.toString() + " ");
    }
    }
}
