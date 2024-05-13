import java.util.*;


public class Hangman {
    public static ArrayList<String> wordsList = new ArrayList<>();
    Random random = new Random();

    static String word;
    static String hiddenWord;
    static int tries = 6;




public static String makeWord(String str){
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        stringBuilder.append("_");
    }
    return stringBuilder.toString();
}


    public static void main(String[] args) {
    tries = 6;
        String[] list = {"bolt", "count", "help", "beneficiary", "coup", "junior"
        , "despise", "explosion", "deputy"}; // Ordlista
        wordsList.addAll(Arrays.asList(list));
        Collections.shuffle(wordsList); // Shuffle the above list because I always choose the first one.

        word = wordsList.get(0); // Choose the word


        Scanner scanner = new Scanner(System.in);
        hiddenWord = makeWord(word);

        char guessedCharacter;

        ArrayList<Character> alreadyGuessed = new ArrayList<>();




        while (true){

            if (Objects.equals(hiddenWord, word)){ // If the entire word is guessed correctly
                System.out.println("The word was: " + word + "!");
                System.out.println("You win!");
                break;
            }
            if (tries == 0){ // Checks if a player has used up all tries
                System.out.println("You lose.\nThe word was: " + word);
                break;
            }

            while (true){ // Loop for player input
                System.out.println("Hint: " + hiddenWord);
                System.out.println("Guess the word: ");
                guessedCharacter = scanner.next().toLowerCase().charAt(0);

                if (!alreadyGuessed.contains(guessedCharacter)){ //Checks if the character is unique
                    alreadyGuessed.add(guessedCharacter); // Add the character to the list of already guessed
                    break; // Break out of the loop
                }
                System.out.println("You've already guessed that character."); // Redo the loop if input isn't unique
            }


            if (word.toLowerCase().contains(String.valueOf(guessedCharacter))){ // Checks if the inputted character is in the word
                for (int i = 0; i < word.length(); i++){ // Loops for the words length
                    if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(guessedCharacter)){
                        StringBuilder temp = new StringBuilder(hiddenWord); // Makes a temporary stringbuilder out of hiddenWord
                        temp.setCharAt(i, word.charAt(i)); // adds the correct characters to the stringbuilder
                        hiddenWord = temp.toString(); // Copies the stringBuilder to the hidden word
                    }
                }
            }
            else {
                tries--;
                System.out.println("Incorrect. " + tries + " tries left."); // if guessed wrong character
                if (tries == 4){
                    System.out.println("                                                                                          O");
                }
                if (tries == 3){
                    System.out.println("                                                                                           O");
                    System.out.println("                                                                                           |   ");
                    System.out.println("                                                                                           |  ");
                }
                if (tries == 2){
                    System.out.println("                                                                                          O");
                    System.out.println("                                                                                        \\ |  /");
                    System.out.println("                                                                                         \\| /");
                }
                if (tries == 1){
                    System.out.println("                                                                                          O");
                    System.out.println("                                                                                        \\ |  /");
                    System.out.println("                                                                                         \\| /");
                    System.out.println("                                                                                         /\\");
                    System.out.println("                                                                                        /  \\");
                }
                if (tries == 0){
                    System.out.println("                                                                                       ____________ ");
                    System.out.println("                                                                                       |          |  ");
                    System.out.println("                                                                                       O          |  ");
                    System.out.println("                                                                                     \\ |  /      |  ");
                    System.out.println("                                                                                      \\| /       |  ");
                    System.out.println("                                                                                      /\\         |  ");
                    System.out.println("                                                                                     /  \\      __|__");
                }
            }

        }
        Main.main(new String[]{});
    }
}

// Importera in en lista med många ord
// Välj ett av orden randomly och sätt det som 'word'
// Gör en metod för att bygga 'hiddenWord' som är lika långt som 'word' fast med massa "_"

// Gör en loop som kollar ifall man har redan gissat den bokstaven förut.
// Lägg till nya bokstäver i listan ovanför ifall man inte har gissat den förut.
// Gör en ny loop som kollar ifall bokstaven man gissar är i 'word'.
// Ifall den är det så lägger man till bokstaven i 'hiddenWord'

// Bygga en gubbe varje gång som gissar fel, när den är hel eller något sånt förlorar man.

// Ska göra listan med ord och importera in den.
// Ska göra något mer avancerat, vet inte riktigt än.