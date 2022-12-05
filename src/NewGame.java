import java.util.Scanner;
public abstract class NewGame {
    protected Board board;
    protected boolean flag;
    protected int amountOfPlayerScores;
    NewGame () {
        board = new Board();
        amountOfPlayerScores = 0;
        flag = true;
    }
    protected abstract void makeMoves();
    protected abstract void showScores();
    protected void playerMoves(int player) {
        int x = 0, y = 0;
        boolean current_flag = true;
        Scanner input = new Scanner( System.in );
        do {
            try {
                if (player == 1) {
                    System.out.println("Player 'x' please enter a move");
                } else {
                    System.out.println("Player 'o' please enter a move");
                }
                System.out.println("Enter a row : ");
                x = input.nextInt();
                System.out.println("Enter a column : ");
                y = input.nextInt();
                if (!board.correctPos(x - 1, y - 1)) {
                    current_flag = false;
                } else {
                    current_flag = true;
                }
            } catch (Exception e) {
                current_flag = false;
                System.out.println("Wrong coordinates, try again");
            }
        } while (!current_flag);
        board.makeMove(x - 1, y - 1, player);
        board.showBoard();
    }
}

