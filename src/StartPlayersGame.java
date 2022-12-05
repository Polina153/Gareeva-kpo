public class StartPlayersGame extends NewGame{
    private int currentPlayerScore;
    private int currentPlayer2Score;
    boolean ifPlayer1CanMove;
    boolean ifPlayer2CanMove;

    StartPlayersGame() {
        super();
        currentPlayer2Score = 0;
        ifPlayer1CanMove = true;
        ifPlayer2CanMove = true;
    }
    public void game() {
        while (flag) {
            makeMoves();
            showScores();
        }
        showResultScores();
    }
    public void makeMoves() {
        if (board.flag) {
            board.showBoard();
            playerMoves(1);
            ifPlayer1CanMove = true;
        } else {
            if (!ifPlayer2CanMove) {
                flag = false;
                return;
            }
            System.out.println("No possible moves to you");
            ifPlayer1CanMove = false;
        }
        board.calculatePossibleMoves(2, 1);
        board.fillPossibleMoves();
        if (board.flag) {
            board.showBoard();
            playerMoves(2);
            ifPlayer2CanMove = true;
        } else {
            if (!ifPlayer1CanMove) {
                flag = false;
                return;
            } else {
                System.out.println("No possible moves to you");
                ifPlayer2CanMove = false;
            }
        }
        board.calculatePossibleMoves(1, 2);
        board.fillPossibleMoves();
    }

    public void calculateScore() {
        currentPlayerScore = board.calculateTiles(1);
        currentPlayer2Score = board.calculateTiles(2);
    }
    public void showScores() {
        System.out.println("\nPlayer 'x' scores: " + currentPlayerScore
                + "\nPlayer 'o' scores: " + currentPlayer2Score);
    }
    public void showResultScores() {
        calculateScore();
        if (currentPlayerScore > currentPlayer2Score) {
            System.out.printf("Player 'x' won by %d scores!", currentPlayerScore - currentPlayer2Score);
        } else if (currentPlayerScore < currentPlayer2Score) {
            System.out.printf("Player 'o' won by %d scores!", currentPlayer2Score - currentPlayerScore);
        } else {
            System.out.println("Wow! Dead head!");
        }
    }
}
