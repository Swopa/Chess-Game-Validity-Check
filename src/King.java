public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO pieces on the path detection | not capturing team pieces | check

        int rowDiff = Math.abs(srcRow-destRow);
        int colDiff = Math.abs(srcCol-destCol);


        if((rowDiff <= 1 && colDiff <= 1) && (rowDiff + colDiff) != 0){
            return true;
        }

        return false;
    }
}
