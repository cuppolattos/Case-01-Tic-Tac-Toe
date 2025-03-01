
public class Game {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'O');
        Player player2 = new Player("Player 2", 'X');
        TicTacToe game = new TicTacToe(player1, player2);
        game.startGame();
    }
}
