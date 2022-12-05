class Score {
    private static int amountOfComputerScores = 0;
    private static int amountOfPlayerScores = 0;

    static int currentPlayerScore = 0;
    static int currentPlayer2Score = 0;

    static int currentComputerScore = 0;
    private static int bestPlayerScore = 0;
    private static int bestPlayer2Score = 0;

    public static void showScores() {
        calculateScore();
        System.out.println("\nYour scores: " + amountOfPlayerScores
                + "\nComputer scores: " + Score.getAmountOfComputerScores());
    }

    public static void showResultScores(int typeOfGame) {
        calculateScore();
        calculateBestScore();
        switch (typeOfGame) {
            case 1:
                if (amountOfPlayerScores > Score.getAmountOfComputerScores()) {
                    System.out.printf("Congratulations! You beat the computer by %d scores",
                            amountOfPlayerScores - Score.getAmountOfComputerScores());
                    System.out.print("\n\n\n");
                } else if (amountOfPlayerScores < Score.getAmountOfComputerScores()) {
                    System.out.printf("Oops, sorry... computer beat you by %d scores",
                            Score.getAmountOfComputerScores() - amountOfPlayerScores);
                    System.out.print("\n\n\n");
                } else {
                    System.out.println("Wow! Dead head!");
                    System.out.print("\n\n\n");
                }
                break;
            case 2:
                if (currentPlayerScore > currentPlayer2Score) {
                    System.out.printf("Player 'x' won by %d scores!", currentPlayerScore - currentPlayer2Score);
                    calculateBestScore();
                    System.out.print("\n\n\n");
                } else if (currentPlayerScore < currentPlayer2Score) {
                    System.out.printf("Player 'o' won by %d scores!", currentPlayer2Score - currentPlayerScore);
                    calculateBestScore();
                    System.out.print("\n\n\n");
                } else {
                    System.out.println("Wow! Dead head!");
                    calculateBestScore();
                    System.out.print("\n\n\n");
                }
        }
    }

    private static void calculateBestScore() {
        if (amountOfPlayerScores > Score.getBestPlayerScore()) {
            Score.setBestPlayerScore(amountOfPlayerScores);
        }
        if (currentPlayer2Score > bestPlayer2Score) {
            bestPlayer2Score = currentPlayer2Score;
        }
    }

    protected void showBestScore() {
        System.out.printf("Player x has the best score %d in this session", bestPlayerScore);
        System.out.println();
        System.out.printf("Player o has the best score %d in this session", bestPlayer2Score);
        System.out.println();
    }

    public static int getAmountOfComputerScores() {
        return amountOfComputerScores;
    }

    public static void setAmountOfComputerScores(int amountOfComputerScores) {
        Score.amountOfComputerScores = amountOfComputerScores;
    }

    public static int getBestPlayerScore() {
        return bestPlayerScore;
    }

    public static void setBestPlayerScore(int bestPlayerScore) {
        Score.bestPlayerScore = bestPlayerScore;
    }

    public static int getBestPlayer2Score() {
        return bestPlayer2Score;
    }

    public static void setBestPlayer2Score(int bestPlayer2Score) {
        Score.bestPlayer2Score = bestPlayer2Score;
    }

    public static int getAmountOfPlayerScores() {
        return amountOfPlayerScores;
    }

    public static void setAmountOfPlayerScores(int amountOfPlayerScores) {
        Score.amountOfPlayerScores = amountOfPlayerScores;
    }

    public static int getCurrentPlayerScore() {
        return currentPlayerScore;
    }

    public static int getCurrentPlayer2Score() {
        return currentPlayer2Score;
    }
}
