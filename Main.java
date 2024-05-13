import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;


        while (playAgain){
            System.out.println("Which game do you want to play? \nHangman, Blackjack, Numbers or would you want to Quit?");
            String game = in.next().toLowerCase();

            switch (game) { // Switch statement instead of a lot of "if else"
                case "hangman":
                    Hangman.main(new String[]{});
                    break;
                case "blackjack":
                    Blackjack.main(new String[]{});
                    break;
                case "numbers":
                    NumberGuessing.main(new String[]{});
                    break;
                case "quit":
                    System.out.println("Goodbye!");
                    playAgain = false;
                    break;

                default: // Defaults to this if the input isn't any of the cases above and repeats the question
                    System.out.println("Not a valid input.");
            }
        }
    }
}
