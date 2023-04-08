import java.util.Scanner;
import java.util.Locale;


public class ASCII_TriangleGenerator {

    public static void main(String args[]) {
        Locale.setDefault(Locale.US);

        Scanner keyboard = new Scanner(System.in);

        System.out.print("n= ");
        int n = keyboard.nextInt();

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
