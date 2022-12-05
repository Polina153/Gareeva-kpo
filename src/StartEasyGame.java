public class StartEasyGame extends NewGame{
    private int amountOfComputerScores;
    private int bestPlayerScore = 0;
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
        calculateScore();
        System.out.println("\nYour scores: " + amountOfPlayerScores
                + "\nComputer scores: " + amountOfComputerScores);
    }

    public void showResultScores() {
        calculateScore();
        calculateBestScore();
        if (amountOfPlayerScores > amountOfComputerScores) {
            System.out.printf("Congratulations! You beat the computer by %d scores",
                    amountOfPlayerScores - amountOfComputerScores);
            System.out.print("\n\n\n");
        } else if (amountOfPlayerScores < amountOfComputerScores) {
            System.out.printf("Oops, sorry... computer beat you by %d scores",
                    amountOfComputerScores - amountOfPlayerScores);
            System.out.print("\n\n\n");
        } else {
            System.out.println("Wow! Dead head!");
            System.out.print("\n\n\n");
        }
    }
    public void computerMoves() {
        boolean current_flag = true;
        int x, y;
        int bestScore = 0;
        board.makeComputerMove();
        board.renewBoardAfterCompMove();
    }
    private void calculateBestScore() {
        if (amountOfPlayerScores > bestPlayerScore) {
            bestPlayerScore = amountOfPlayerScores;
        }
    }
    protected void showBestScore(){
        System.out.printf("Player x has the best score %d in this session", bestPlayerScore);
        System.out.println();
    }
}

