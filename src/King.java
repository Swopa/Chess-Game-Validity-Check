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

        if(underCheck(destRow, destCol, board)){
            return false;
        }

        if((rowDiff <= 1 && colDiff <= 1) && (rowDiff + colDiff) != 0){
            Piece destPiece = board[destRow][destCol];

            return destPiece == null || destPiece.isWhite != this.isWhite;
        }

        return false;
    }

    boolean underCheck(int destRow, int destCol, Piece[][] board){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                Piece piece = board[row][col];
                if(piece != null && piece.isWhite != this.isWhite){
                    if(piece.isValidMove(row, col, destRow, destCol, board)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean shortCastling(){
        return false;
    }

    boolean longCastling(){
        return false;
    }
}
