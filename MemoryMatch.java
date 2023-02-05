import java.util.Scanner;
import java.util.Random;

public class MemoryMatch {
   static Scanner sc = new Scanner(System.in);
   static Random rnd = new Random();
   static int size = 4;
   static int[] cards = new int[size * 2];
   static boolean[] matched = new boolean[size * 2];

   public static void main(String[] args) {
      for (int i = 0; i < size * 2; i++) {
         cards[i] = i % size;
      }
      shuffle();

      int turns = 0;
      while (!isFinished()) {
         int card1 = selectCard();
         int card2 = selectCard();
         if (card1 == card2) {
            System.out.println("Please select two different cards.");
            continue;
         }

         turns++;
         System.out.println("You selected cards " + (card1 + 1) + " and " + (card2 + 1));
         if (cards[card1] == cards[card2]) {
            matched[card1] = true;
            matched[card2] = true;
            System.out.println("You found a match!");
         } else {
            System.out.println("Sorry, try again.");
         }
      }
      System.out.println("You won in " + turns + " turns!");
   }

   static void shuffle() {
      for (int i = 0; i < size * 2; i++) {
         int j = rnd.nextInt(size * 2);
         int temp = cards[i];
         cards[i] = cards[j];
         cards[j] = temp;
      }
   }

   static int selectCard() {
      System.out.print("Select a card by writing 1-10: ");
      int card = sc.nextInt() - 1;
      while (card < 0 || card >= size * 2 || matched[card]) {
         System.out.print("Invalid selection. Please select a card: ");
         card = sc.nextInt() - 1;
      }
      return card;
   }

   static boolean isFinished() {
      for (int i = 0; i < size * 2; i++) {
         if (!matched[i]) {
            return false;
         }
      }
      return true;
   }
}
