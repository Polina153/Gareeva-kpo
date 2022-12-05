class StartEasyGame extends NewGame {
    private boolean playerMadeAMove;

    StartEasyGame() {
        super();
        playerMadeAMove = true;
    }

    public void game() {
        while (flag) {
            makeMoves();
            Score.showScores();
        }
        Score.showResultScores(1);
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

    public void computerMoves() {
        boolean current_flag = true;
        int x, y;
        int bestScore = 0;
        board.makeComputerMove();
        board.renewBoardAfterCompMove();
    }
    public void calculateScore() {
        Score.currentPlayerScore = board.calculateTiles(1);
        Score.currentComputerScore = board.calculateTiles(2);
    }
}

