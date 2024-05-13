import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    static int currency = 100;
    private int rank;
    private int suit;
    private static Random random = new Random();

    public static ArrayList<String> RANKSCLUB = new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"));
    public static ArrayList<String> RANKSSPADE = new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"));
    public static ArrayList<String> RANKSDIAMOND = new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"));
    public static ArrayList<String> RANKSHEART = new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"));



    public Blackjack(){


    }

    public static String createCard(){


        while (true){
            int randomNumber = random.nextInt(4);
            if(randomNumber == 0 && !RANKSDIAMOND.isEmpty()){
                int number = random.nextInt(RANKSDIAMOND.size());
                String Card = RANKSDIAMOND.get(number);
                RANKSDIAMOND.remove(number);
                return Card + " of Diamond";
            } else if(randomNumber == 1 && !RANKSSPADE.isEmpty()){
                int number = random.nextInt(RANKSSPADE.size());
                String Card = RANKSSPADE.get(number);
                RANKSSPADE.remove(number);
                return Card + " of Spades";
            }
            else if(randomNumber == 2&& !RANKSCLUB.isEmpty()){
                int number = random.nextInt(RANKSCLUB.size());
                String Card = RANKSCLUB.get(number);
                RANKSCLUB.remove(number);
                return Card + " of Club";
            }
            else if(randomNumber == 3 && !RANKSHEART.isEmpty()){
                int number = random.nextInt(RANKSHEART.size());
                String Card = RANKSHEART.get(number);
                RANKSHEART.remove(number);
                return Card + " of Heart";
            }
        }
    }
    public static int drawCard(int draws){
        ArrayList<String> drawnCards = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < draws; i++) {
            String card = createCard();
            //System.out.println(card);
            String rankString = card.split(" ")[0];

            int rank;
            if (rankString.equals("Ace")){
                rank = 11;
            }
            else if (rankString.equals("Jack") || rankString.equals("Queen") || rankString.equals("King")){
                rank = 10;
            }
            else {
                rank = Integer.parseInt(rankString);
            }
            drawnCards.add(card);
            sum += rank;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum;
        int dealerSum;

        sum = drawCard(2);
        System.out.println("You start out with: " + sum);

        dealerSum = drawCard(1);
        System.out.println("Dealer starts out with: " + dealerSum);

        while(true){

        System.out.println("Hit or Stand?");
        String turnInput = in.next().toLowerCase();

         switch (turnInput){
            case "hit":
                sum += drawCard(1);

            case "stand":
                System.out.println("Stand.");
                break;

            default: // Defaults to this if the input isn't any of the above and repeats the question
                System.out.println("Not a valid input.");
        }

        System.out.println("Player's score: " + sum);


         if (dealerSum < 17){
             dealerSum += drawCard(1);
         }
         System.out.println("Dealer has a total of: " + dealerSum);

            if (sum == 21){
                System.out.println("Player scored a blackjack!");
                break;
            }
            if (sum > 21){
                System.out.println("Player busted. Dealer wins.");
                break;
            }

         if (dealerSum < sum){
             System.out.println("Player wins!");
             break;
         } else if (dealerSum > sum){
             System.out.println("Dealer wins.");
             break;
         } else {
             System.out.println("It's a draw.");
             break;
         }
        }
        Main.main(new String[]{});
    }
}

// Made a card system that creates cards with suit and rank.
// Separates the value from the suit and adds it to the alreadyFound list.

