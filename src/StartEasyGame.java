public class StartEasyGame extends NewGame{
    private int amountOfComputerScores = 0;
    private boolean playerMadeAMove;

    StartEasyGame() {
        super();
        playerMadeAMove = true;
        amountOfComputerScores = 0;
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
            playerMadeAMove = true;
        } else {
            if (!playerMadeAMove) {
                flag = false;
                return;
            }
            System.out.println("No possible moves to you");
            playerMadeAMove = false;
        }
        board.calculatePossibleMoves(2, 1);
        if (board.flag) {
            computerMoves();
        } else {
            if (!playerMadeAMove) {
                flag = false;
                return;
            } else {
            }
        }
        board.calculatePossibleMoves(1, 2);
        board.fillPossibleMoves();
    }
    public void calculateScore() {
        amountOfPlayerScores = board.calculateTiles(1);
        amountOfComputerScores = board.calculateTiles(2);
    }

    public void showScores() {
        System.out.println("\nYour scores: " + amountOfPlayerScores
                + "\nComputer scores: " + amountOfComputerScores);
    }

    public void showResultScores() {
        calculateScore();
        if (amountOfPlayerScores > amountOfComputerScores) {
            System.out.printf("Congratulations! You beat the computer by %d scores",
                    amountOfPlayerScores - amountOfComputerScores);
        } else if (amountOfPlayerScores < amountOfComputerScores) {
            System.out.printf("Oops, sorry... computer beat you by %d scores",
                    amountOfComputerScores - amountOfPlayerScores);
        } else {
            System.out.println("Wow! Dead head!");
        }
    }
    public void computerMoves() {
        boolean current_flag = true;
        int x, y;
        int bestScore = 0;
        board.makeComputerMove();
        board.reNewBoard();
    }
}

