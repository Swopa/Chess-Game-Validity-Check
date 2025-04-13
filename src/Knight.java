public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO not capturing team pieces


        if((Math.abs(destRow-srcRow) == 2 && Math.abs(destCol-srcCol) == 1) || (Math.abs(destRow-srcRow) == 1 && Math.abs(destCol-srcCol) == 2)){
            return true;
        }

        return false;
    }
}
