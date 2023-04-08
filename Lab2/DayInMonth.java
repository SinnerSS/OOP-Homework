import java.util.InputMismatchException;
import java.util.Scanner;

public class DayInMonth {


    private static boolean IsLeapYear(int y){
        if(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) return true;
        return false;
        
    }
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        int d=0, m = 0,y = 0;
        boolean validInput = false;

        while(!validInput) {
            try {
                System.out.print("Enter month: ");
                m = keyboard.nextInt();

                if(m<=0 || m>12) throw new ArithmeticException();

                System.out.print("Enter year: ");
                y = keyboard.nextInt();

                if(m<0) throw new ArithmeticException();

                validInput = true;

            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input! Try again.");
                keyboard.next();

            }
            catch(ArithmeticException e) {
                System.out.println("Invalid input! Try again.");

            }
        }

        keyboard.close();

        if(m == 2) {
            if(IsLeapYear(y)) d = 29;
            else d = 28;

        }
        else if(m == 4 || m == 6 || m == 9 || m==11) d = 30;
        else d = 31;

        System.out.println("Number of day in that month: " + d);

    }
}