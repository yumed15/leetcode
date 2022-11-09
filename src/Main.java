import others.AllOne;
import others.BattleshipsInABoard;

public class Main {
    public static void main(String[] args) {
        BattleshipsInABoard board = new BattleshipsInABoard();
        char[][] input = {{'X','.','.','X'}, {'.','.','.','X'}, {'.','.','.','X'}};
        System.out.println(board.countBattleships(input));
    }
}
