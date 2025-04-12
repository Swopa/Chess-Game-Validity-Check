abstract class Piece {
    boolean isWhite;
    abstract boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board);
}
