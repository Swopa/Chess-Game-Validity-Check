public class Queen extends Piece{


    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board)  {
        //TODO combine rook and bishop logic
        return false;
    }
}
