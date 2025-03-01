
public class Player {
    private String playerName;
    private char symbol;

    public Player(String playerName, char symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getName() {
        return playerName;
    }

    public char getSymbol() {
        return symbol;
    }
}
