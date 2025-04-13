public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO pieces on the path detection | not capturing team pieces


        if(Math.abs(srcRow - destRow) == Math.abs(srcCol - destCol)){
            return true;
        }

        return false;
    }
}
