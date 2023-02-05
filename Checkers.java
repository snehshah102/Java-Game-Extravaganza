import java.util.Scanner;

public class Checkers {
   static Scanner sc = new Scanner(System.in);
   static int[][] board = new int[8][8];
   static boolean player1Turn = true;

   public static void main(String[] args) {
      initializeBoard();
      System.out.println("Welcome to Checkers!");

      while (true) {
         displayBoard();
         if (player1Turn) {
            System.out.println("Player 1's turn.");
         } else {
            System.out.println("Player 2's turn.");
         }
         System.out.print("Enter row and column of piece to move: ");
         int fromRow = sc.nextInt() - 1;
         int fromCol = sc.nextInt() - 1;
         System.out.print("Enter row and column to move to: ");
         int toRow = sc.nextInt() - 1;
         int toCol = sc.nextInt() - 1;

         if (board[fromRow][fromCol] == 0 ||
             (player1Turn && board[fromRow][fromCol] == 2) ||
             (!player1Turn && board[fromRow][fromCol] == 1)) {
            System.out.println("Invalid move. Try again.");
            continue;
         }

         int distance = Math.abs(toRow - fromRow);
         if (distance != 1 && distance != 2) {
            System.out.println("Invalid move. Try again.");
            continue;
         }

         if (distance == 2) {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            if (board[jumpRow][jumpCol] == 0) {
               System.out.println("Invalid move. Try again.");
               continue;
            }
            board[jumpRow][jumpCol] = 0;
         }

         board[fromRow][fromCol] = 0;
         board[toRow][toCol] = player1Turn ? 1 : 2;
         player1Turn = !player1Turn;
      }
   }

   static void initializeBoard() {
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            if ((i + j) % 2 == 0) {
               board[i][j] = 0;
            } else if (i < 3) {
               board[i][j] = 2;
            } else if (i > 4) {
               board[i][j] = 1;
            }
         }
      }
   }

   static void displayBoard() {
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            System.out.print(board[i][j] + " ");
         }
         System.out.println();
      }
   }
}
