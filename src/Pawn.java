public class Pawn extends Piece{

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO pieces on the path detection | not capturing team pieces | clean up messy else if cases

        int direction = this.isWhite ? 1 : -1;
        int startRow = this.isWhite ? 1 : 6;

        int rowDiff = destRow - srcRow;
        int colDiff = destCol - srcCol;

        Piece destinationPiece = board[destRow][destCol];


        if(srcCol == destCol && destinationPiece == null){
            if(rowDiff == direction){
                return true;
            }
            if(srcRow == startRow && rowDiff == 2*direction
                    && board[srcRow + direction][srcCol] == null){
                return true;
            }
        }


        //Capture a piece
        return destinationPiece != null && Math.abs(colDiff) == 1 && (rowDiff) == direction && destinationPiece.isWhite != this.isWhite;
    }
}
