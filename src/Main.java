import java.util.Scanner;

/**
 * Main class of the program to calculate the sum of the first N Lucas numbers.
 */
public class Main {

    /**
     * Main method of the program.
     *
     * @param args Command-line arguments (can be empty).
     */
    public static void main(String[] args) {
        int n;

        if (args.length == 0) {
            System.out.println("No arguments passed through the terminal\nEnter N:");
            n = getInputNumber();
        } else {
            n = Integer.parseInt(args[0]);
        }

        System.out.printf("Sum of the first %d Lucas numbers = %d ", n, countSum(n));
    }

    /**
     * Method to obtain the user-input number N.
     *
     * @return The number N entered by the user.
     */
    private static int getInputNumber() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        return n;
    }

    /**
     * Method to calculate the sum of the first N Lucas numbers.
     *
     * @param n The number of Lucas numbers to calculate.
     * @return The sum of the first N Lucas numbers.
     */
    public static int countSum(int n) {
        int sum = 0;

        if(n < 0){
            System.out.println("N can't be negative.");
            return 0;
        }

        for (int i = 0; i < n; i++) {
            sum += LukeNumber.getValue();
            LukeNumber.nextValue();
        }

        return sum;
    }
}
