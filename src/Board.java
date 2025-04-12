public class Board {
    Piece[][] board = new Piece[8][8];

    void movePiece(int srcRow, int srcCol, int destRow, int destCol){
        Piece p = board[srcRow][srcCol];
        if(p != null && p.isValidMove(srcRow, srcCol, destRow, destCol, board)){
            board[destRow][destCol] = p;
            board[srcRow][srcCol] = null;
        }else {
            System.out.println("Invalid Move!");
        }
    }
}
