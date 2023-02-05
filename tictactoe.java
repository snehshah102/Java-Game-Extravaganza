import java.util.Scanner;

public class tictactoe {
    static Scanner scan = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static int turn = 0;
    static boolean gameOver = false;

    public static void main(String[] args) {
        printBoard();
        while (!gameOver) {
            playerTurn();
            printBoard();
            checkWin();
        }
    }

    public static void playerTurn() {
        int row, col;
        do {
            System.out.print("Player " + ((turn % 2) + 1) + ": Choose your row (1-3): ");
            row = scan.nextInt() - 1;
            System.out.print("Player " + ((turn % 2) + 1) + ": Choose your column (1-3): ");
            col = scan.nextInt() - 1;
        } while (board[row][col] != ' ');
        board[row][col] = (turn % 2 == 0) ? 'X' : 'O';
        turn++;
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                gameOver = true;
                System.out.println("Player " + (((turn - 1) % 2) + 1) + " wins!");
                return;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                gameOver = true;
                System.out.println("Player " + (((turn - 1) % 2) + 1) + " wins!");
                return;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            gameOver = true;
            System.out.println("Player " + (((turn - 1) % 2) + 1) + " wins!");
            return;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            gameOver = true;
            System.out.println("Player " + (((turn - 1) % 2) + 1) + " wins!");
            return;
            }
        if (turn == 9) {
        gameOver = true;
        System.out.println("It's a draw!");
        }
    }
}