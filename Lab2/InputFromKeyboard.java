import java.util.Scanner;
import java.util.Locale;

public class InputFromKeyboard {


    public static void main(String args[]){
        // Set default locale to accept a period as the decimal seperator
        Locale.setDefault(Locale.US);

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mrs/Mr. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");

    }
}