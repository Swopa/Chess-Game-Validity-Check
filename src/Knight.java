public class Knight extends Piece{
    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        return false;
    }
}
