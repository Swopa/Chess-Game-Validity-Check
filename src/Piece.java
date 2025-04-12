abstract class Piece {
    boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    abstract boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board);
}
