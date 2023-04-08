import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;


public class ASCII_TriangleGenerator {

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);

        int n = 0;
        boolean validInput = false;

        while(!validInput) {
            try {
                System.out.print("n= ");
                n = keyboard.nextInt();
                if(n<0) throw new ArithmeticException();
                validInput = true;

            }
            catch(InputMismatchException e) {
                System.out.println("Invalid input! Try again.");
                keyboard.next();

            }
            catch(ArithmeticException e){
                System.out.println("Invalid input! Try again.");

            }
        }

        String Star = "";

        for(int i=0; i<n; i++) {
            String Line = "";

            for(int j=0; j<n+i; j++) {
                if(j<n-i-1) Line += " ";
                else Line += "*";

            }

            Star += Line + "\n";

        }

        System.out.println(Star);

        keyboard.close();

    }
}
