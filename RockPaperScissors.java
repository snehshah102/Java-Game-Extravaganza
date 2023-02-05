import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Random random = new Random();
      
      System.out.println("Rock-Paper-Scissors game.");
      System.out.println("1. Rock");
      System.out.println("2. Paper");
      System.out.println("3. Scissors");
      System.out.println("Enter your choice (1, 2, or 3):");
      
      int playerChoice = scanner.nextInt();
      int computerChoice = random.nextInt(3) + 1;
      
      System.out.println("You chose " + choiceToString(playerChoice));
      System.out.println("Computer chose " + choiceToString(computerChoice));
      
      int result = determineWinner(playerChoice, computerChoice);
      
      if (result == 0) {
        System.out.println("It's a tie!");
      } else if (result == 1) {
        System.out.println("You win!");
      } else {
        System.out.println("Computer wins!");
      }
    }
  }
  
  public static String choiceToString(int choice) {
    switch (choice) {
      case 1:
        return "Rock";
      case 2:
        return "Paper";
      case 3:
        return "Scissors";
      default:
        return "Invalid choice";
    }
  }
  
  public static int determineWinner(int playerChoice, int computerChoice) {
    if (playerChoice == computerChoice) {
      return 0;
    } else if (playerChoice == 1 && computerChoice == 3) {
      return 1;
    } else if (playerChoice == 2 && computerChoice == 1) {
      return 1;
    } else if (playerChoice == 3 && computerChoice == 2) {
      return 1;
    } else {
      return -1;
    }
  }
}

/* This code uses the Scanner class to get the player's choice, the Random class to generate the computer's choice, 
and some simple logic to determine the winner of the game. The choiceToString method is used to convert the player's 
and computer's choices from integers to strings for display purposes, and the determineWinner method returns 0 for a tie, 
1 for a player win, and -1 for a computer win. */