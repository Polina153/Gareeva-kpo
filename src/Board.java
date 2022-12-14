import java.util.List;
import java.util.ArrayList;

public class Board {
    private int [][] board;
    private final List<Cell> possibleMoves;
    private final List<List<Cell>> tilesToFlip;
    public boolean flag;
    Board() {
        newBoard();
        tilesToFlip = new ArrayList<>();
        ArrayList<Cell> arr = new ArrayList<>();
        arr.add(new Cell(3,3));
        tilesToFlip.add(arr);
        arr = new ArrayList<>();
        arr.add(new Cell(3,3));
        tilesToFlip.add(arr);
        arr = new ArrayList<>();
        arr.add(new Cell(4,4));
        tilesToFlip.add(arr);
        arr = new ArrayList<>();
        arr.add(new Cell(4,4));
        tilesToFlip.add(arr);
        arr = new ArrayList<>();
        possibleMoves = new ArrayList<>();
        possibleMoves.add(new Cell(2,3));
        possibleMoves.add(new Cell(3,2));
        possibleMoves.add(new Cell(4,5));
        possibleMoves.add(new Cell(5,4));
        flag = true;
    }
    private void newBoard() {
        board = new int[8][8];
        board[3][3] = 2;
        board[3][4] = 1;
        board[4][4] = 2;
        board[4][3] = 1;
        board[2][3] = 3;
        board[3][2] = 3;
        board[4][5] = 3;
        board[5][4] = 3;
    }
    public void makeMove(int posX, int posY, int player) {
        board[posX][posY] = player;
        int i = 0;
        while (possibleMoves.get(i).x != posX || possibleMoves.get(i).y != posY) {
            i++;
        }
        for (Cell sl : tilesToFlip.get(i)) {
            board[sl.x][sl.y] = player;
        }
    }
    public void showBoard() {
        System.out.println("       1    2    3    4    5    6    7    8");
        for (int i = 0; i < 8; i++) {
            System.out.print("  " + (i + 1) + "  ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    System.out.print("[   ]");
                } else if (board[i][j] == 1) {
                    System.out.print("[ x ]");
                } else if (board[i][j] == 3) {
                    System.out.print("[ ? ]");
                } else {
                    System.out.print("[ o ]");
                }
            }
            System.out.print("\n");
        }
    }
    public void reNewBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
        tilesToFlip.clear();
        possibleMoves.clear();
    }
    public void calculatePossibleMoves(int player1, int player2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValidMove(player1, player2, i, j)) {
                    possibleMoves.add(new Cell(i, j));
                }
            }
        }
        if (possibleMoves.isEmpty()) {
            flag = false;
        } else {
            flag = true;
        }
    }
    public boolean isValidMove(int player1, int player2, int row, int column) {
        ArrayList<Cell> tmp = new ArrayList<>();
        if (board[row][column] != 0 || !posExists(row, column)) {
            return false;
        }
        board[row][column] = player1;
        int[][] directions = { {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1} };
        int x, y;
        for (int i = 0; i < directions.length; i++) {
            x = row + directions[i][0];
            y = column + directions[i][1];
            if (!posExists(x, y)) {
                continue;
            }
            while (board[x][y] == player2) {
                x += directions[i][0];
                y += directions[i][1];
                if (!posExists(x, y)) {
                    break;
                }
            }
            if (!posExists(x, y)) {
                continue;
            }
            if (board[x][y] == player1) {
                while (true) {
                    x -= directions[i][0];
                    y -= directions[i][1];
                    if (x == row && y == column) {
                        break;
                    }
                    tmp.add(new Cell(x, y));
                }
            }
        }
        board[row][column] = 0;
        if (tmp.isEmpty()) {
            return false;
        }
        tilesToFlip.add(tmp);
        return true;
    }
    private boolean posExists(int x, int y) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }
    public void fillPossibleMoves() {
        for (Cell sl : possibleMoves) {
            board[sl.x][sl.y] = 3;
        }
    }
    public boolean correctPos(int x, int y) {
        if (!posExists(x, y) || board[x][y] != 3) {
            return false;
        } else {
            return true;
        }
    }
    public int calculateTiles(int player) {
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == player) {
                    counter++;
                }
            }
        }
        return counter;
    }
    private boolean isOnEdge(int x, int y) {
        if (x == 0 || y == 0 || x == 8 || y == 8) {
            return true;
        } else {
            return false;
        }
    }
    public void makeComputerMove() {
        int bestId = calculateBestMove();
        board[possibleMoves.get(bestId).x][possibleMoves.get(bestId).y] = 2;
        for (Cell sl : tilesToFlip.get(bestId)) {
            board[sl.x][sl.y] = 2;
        }
    }
    public int calculateBestMove() {
        int bestScore = 0;
        int bestId = 0;
        for (int i = 0; i < possibleMoves.size(); i++) {
            int currentScore = 0;
            for (int j = 0; j < tilesToFlip.get(i).size(); j++) {
                if (isOnEdge(tilesToFlip.get(i).get(j).x, tilesToFlip.get(i).get(j).y)) {
                    currentScore += 2;
                } else {
                    currentScore += 1;
                }
            }
            if (tilesToFlip.get(i).size() == 1) {
                if (tilesToFlip.get(i).get(0).x == possibleMoves.get(i).x ||
                        tilesToFlip.get(i).get(0).y == possibleMoves.get(i).y) {
                    currentScore += 0.4;
                } else {
                    currentScore += 0.8;
                }
            }
            if (currentScore > bestScore) {
                bestId = i;
                bestScore = currentScore;
            }
        }
        return bestId;
    }
}
