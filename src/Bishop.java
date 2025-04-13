public class Bishop extends Piece{
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        int rowDiff = Math.abs(srcRow - destRow);
        int colDiff = Math.abs(srcCol - destCol);

        //Bishop can move in diagonal direction by as much as he wants
        if(rowDiff != colDiff){
            return false;
        }
        //While moving in diagonal row and column change the same way

        int rowStep = rowDiff > 0 ? 1: -1;
        int colStep = colDiff > 0 ? 1: -1;

        int row = srcRow + rowStep;
        int col = srcCol + colStep;

        while(row != destRow && col != destCol){
            if(board[row][col] != null){
                return false;
            }
            row+=rowStep;
            col+=colStep;
        }

        Piece destPiece = board[destRow][destCol];

        return destPiece == null || destPiece.isWhite != this.isWhite;
    }
}
