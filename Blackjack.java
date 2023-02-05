import java.util.Scanner;
import java.util.Random;

public class Blackjack {
   static Scanner sc = new Scanner(System.in);
   static Random rnd = new Random();
   static int deckSize = 52;
   static int[] deck = new int[deckSize];
   static int playerScore = 0;
   static int dealerScore = 0;
   static boolean playerTurn = true;

   public static void main(String[] args) {
      for (int i = 0; i < deckSize; i++) {
         deck[i] = i % 13 + 1;
      }
      shuffle();

      System.out.println("Welcome to Blackjack!");
      System.out.println("Your starting score is 0.");
      System.out.println("The dealer's starting score is 0.");
      System.out.println("You will be playing against the dealer.");

      while (playerTurn) {
         int card = drawCard();
         System.out.println("You drew a " + card);
         playerScore += card;
         System.out.println("Your score is now " + playerScore);
         if (playerScore > 21) {
            System.out.println("Bust! You lose.");
            break;
         }
         System.out.print("Do you want to hit or stay? ");
         if (sc.nextLine().toLowerCase().startsWith("s")) {
            playerTurn = false;
         }
      }

      System.out.println("The dealer's turn.");
      while (dealerScore < 17) {
         int card = drawCard();
         System.out.println("The dealer drew a " + card);
         dealerScore += card;
         System.out.println("The dealer's score is now " + dealerScore);
         if (dealerScore > 21) {
            System.out.println("Dealer busts! You win!");
            break;
         }
      }

      if (playerScore <= 21 && dealerScore <= 21) {
         if (playerScore > dealerScore) {
            System.out.println("You win!");
         } else {
            System.out.println("You lose.");
         }
      }
   }

   static void shuffle() {
      for (int i = 0; i < deckSize; i++) {
         int j = rnd.nextInt(deckSize);
         int temp = deck[i];
         deck[i] = deck[j];
         deck[j] = temp;
      }
   }

   static int drawCard() {
      int card = deck[deckSize - 1];
      deckSize--;
      return card;
   }
}
