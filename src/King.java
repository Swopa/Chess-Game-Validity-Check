public class King extends Piece{
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO check logic


        //King moves one space in any direction
        int rowDiff = Math.abs(srcRow-destRow);
        int colDiff = Math.abs(srcCol-destCol);


        if((rowDiff <= 1 && colDiff <= 1) && (rowDiff + colDiff) != 0){
            Piece destPiece = board[destRow][destCol];

            return destPiece == null || destPiece.isWhite != this.isWhite;
        }

        return false;
    }
}
