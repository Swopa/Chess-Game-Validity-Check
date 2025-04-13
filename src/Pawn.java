public class Pawn extends Piece{

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO pieces on the path detection | not capturing team pieces | clean up messy else if cases

        if(this.isWhite){
            if(board[destRow][destCol] == null && (srcCol == destCol)){
                if(srcRow == 1){
                    if((destRow - srcRow) <= 2){
                        return true;
                    }
                }else{
                    if((destRow - srcRow) == 1){
                        return true;
                    }
                }
            }else if(board[destRow][destCol] != null && Math.abs((destCol - srcCol)) == 1 && (destRow - srcRow) == 1){
                return true;
            }
        }else{
            if(board[destRow][destCol] == null && (srcCol == destCol)){
                if(srcRow == 6){
                    if((srcRow - destRow) <= 2){
                        return true;
                    }
                }else{
                    if((srcRow - destRow) == 1){
                        return true;
                    }
                }
            }else if(board[destRow][destCol] != null && Math.abs((destCol - srcCol)) == 1 && (destRow - srcRow) == 1){
                return true;
            }
        }



        return false;
    }
}
