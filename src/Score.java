class Score {
    private static int amountOfComputerScores = 0;
    private static int amountOfPlayerScores = 0;

    static int currentPlayerScore = 0;
    static int currentPlayer2Score = 0;

    static int currentComputerScore = 0;
    private static int bestPlayerScore = 0;
    private static int bestPlayer2Score = 0;

    public static void showScores(int typeOfGame) {
        //calculateScore();
        switch (typeOfGame) {
            case 1:
                System.out.println("\nYour scores: " + amountOfPlayerScores
                        + "\nComputer scores: " + amountOfComputerScores);
                break;
            case 2:
                System.out.println("\nPlayer 'x' scores: " + currentPlayerScore
                        + "\nPlayer 'o' scores: " + currentPlayer2Score);
        }
    }

    public static void showResultScores(int typeOfGame) {
        //calculateScore();
        calculateBestScore();
        switch (typeOfGame) {
            case 1:
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
        if (amountOfPlayerScores > bestPlayerScore) {
            bestPlayerScore = amountOfPlayerScores;
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
}
