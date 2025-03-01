import java.util.Scanner;

public class TicTacToe {
    private char[] board;
    private Player[] players;
    private int turn;
    private boolean endGame;
    private static final int[][] WINNING_MOVES = {
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}
    };
    private Scanner scanner;

    public TicTacToe(Player player1, Player player2) {
        board = new char[]{
            '_', '_', '_',
            '_', '_', '_',
            '_', '_', '_'
        };
        players = new Player[]{player1, player2};
        turn = 0;
        endGame = false;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Tic-Tac-Toe Game(3x3)");
        printBoard();

        while (!endGame) {
            play();
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkWin(char symbol) {
        for (int[] winMove : WINNING_MOVES) {
            if (board[winMove[0]] == symbol && board[winMove[1]] == symbol && board[winMove[2]] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean isTie() {
        for (char c : board) {
            if (c == '_') return false;
        }
        return !checkWin(players[0].getSymbol()) && !checkWin(players[1].getSymbol());
    }

    private boolean placeMove(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) return false;
        if (board[y * 3 + x] != '_') return false;
        board[y * 3 + x] = players[turn].getSymbol();
        return true;
    }

    private void play() {
        int x, y;
        boolean validMove;

        do {
            System.out.print(players[turn].getName() + " (" + players[turn].getSymbol() + ") move: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            validMove = placeMove(x, y);
            if (!validMove) {
                System.out.println("Invalid move. Insert again!");
            }
        } while (!validMove);

        printBoard();

        if (checkWin(players[turn].getSymbol())) {
            System.out.println(players[turn].getName() + " WINS! Thank You For Playing The Game...");
            endGame = true;
            return;
        }

        if (isTie()) {
            System.out.println("It's a TIE!");
            endGame = true;
            return;
        }

        turn = (turn + 1) % 2;
    }
}
