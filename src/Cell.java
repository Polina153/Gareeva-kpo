class Cell {
    private int x;
    private int y;

    private int previousX = 0;

    private int previousY = 0;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPreviousX() {
        return previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }
}
