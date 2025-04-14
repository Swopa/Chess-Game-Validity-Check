public class Knight extends Piece{
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        int rowDiff = Math.abs(destRow-srcRow);
        int colDiff = Math.abs(destCol-srcCol);


        //Knight moves in L-shapes. So either 2 spaces by row and 1 space by column or vice versa
        if(!((rowDiff != 2 &&  colDiff != 1) || (rowDiff != 1 && colDiff != 2))){
            return false;
        }


        Piece destPiece = board[destRow][destCol];
        return destPiece == null || destPiece.isWhite != this.isWhite;
    }
}
