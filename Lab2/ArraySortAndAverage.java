import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraySortAndAverage {
    

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int size = 0;
        int[] arr = new int[size];
        boolean validInput = false;

        while(!validInput) {
            try {
                System.out.print("Enter the size of the array: ");
                size = keyboard.nextInt();

                if(size < 0) throw new ArithmeticException();

                arr = new int[size];
                System.out.print("Enter the elements of the array: ");
                for (int i = 0; i < size; i++) {
                    arr[i] = keyboard.nextInt();
                }

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

        Arrays.sort(arr);

        int sum = 0;
        double average = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (arr.length > 0) {
            average = (double) sum / arr.length;
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);


    }
}