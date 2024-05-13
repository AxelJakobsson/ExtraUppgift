import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    static int numberToGuess;

    public static int createNumber(int limit){
        int number;
        Random random = new Random();


        number = random.nextInt(limit) + 1;
        return number;
    }

    public static void main(String[] args) {
        int limit = 0;
        Scanner scanner = new Scanner(System.in);

        while (true){
            if (limit == 0){
                System.out.println("What's the highest possible number you want to create? Recommended: 100");
                try {
                    limit = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) { // Catches error to not break program if a string is input
                    System.out.println("Invalid input.");
                }
            }
        }
        numberToGuess = createNumber(limit); // Creates the number based on your limit


        while (true) {
            System.out.println("Enter your guess:");
            try {
                int input = Integer.parseInt(scanner.next()); // Put in the guess

                if (input == numberToGuess){
                    System.out.println("You got the number! You win.");
                    break;
                }
                else if (Math.abs(input - numberToGuess) <= 5){ //  Math abs to make it an absolute number so it doesn't go into negatives
                    System.out.println("Super hot"); // Really close

                }
                else if (Math.abs(input - numberToGuess) <= 10) {
                    System.out.println("Hot"); // Close guess

                } else {
                    System.out.println("Cold"); // Not close
                }
            } catch (NumberFormatException e) { // Catches invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
