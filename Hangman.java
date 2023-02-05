import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String word = "java";  // The word to be guessed
            int lives = 6;  // Number of lives the player has
            String guessed = "";  // String to store the correct guesses
            for (int i = 0; i < word.length(); i++) {
                guessed += "_";
            }

            while (lives > 0) {
                System.out.println("The word is: " + guessed);
                System.out.println("You have " + lives + " lives left.");
                System.out.print("Enter a letter: ");
                char c = sc.next().charAt(0);

                boolean found = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == c) {
                        found = true;
                        String before = guessed.substring(0, i);
                        String after = guessed.substring(i + 1);
                        guessed = before + c + after;
                    }
                }
                if (!found) {
                    lives--;
                    System.out.println("Incorrect! You have lost a life.");
                }

                if (!guessed.contains("_")) {
                    System.out.println("Congratulations! You have guessed the word " + word + " correctly.");
                    break;
                }
            }

            if (lives == 0) {
                System.out.println("You have run out of lives. The word was " + word + ".");
            }
        }
    }
}
