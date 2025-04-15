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
        int startRow = isWhite ? 0 : 7;

        if(underCheck(destRow, destCol, board)){
            return false;
        }


        if (destRow == startRow && colDiff == 1) {
            return canShortCastle(board);
        }

        if(destRow == startRow && colDiff == 2){
            return canLongCastle(board);
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
                if (piece instanceof King) continue;
                if(piece != null && piece.isWhite != this.isWhite){
                    if(piece.isValidMove(row, col, destRow, destCol, board)){
                        System.out.println("King is under check from: " + board[row][col] + " from position: " + row + col);
                        return true;
                    }
                }
            }
        }



        return false;
    }

    boolean canShortCastle(Piece[][] board){
        if(this.hasMoved){
            return false;
        }

        if(this.isWhite){
            Piece rook = board[0][7];
            if(rook == null || !(rook instanceof Rook) || rook.hasMoved()) return false;
            return board[0][5] == null && board[0][6] == null;
        }else {
            Piece rook = board[7][7];
            if(rook == null || !(rook instanceof Rook) || rook.hasMoved()) return false;
            return board[7][5] == null && board[7][6] == null;
        }
    }

    boolean canLongCastle(Piece[][] board){
        if(this.hasMoved){
            return false;
        }

        if(this.isWhite){
            Piece rook = board[0][0];
            if(rook == null || !(rook instanceof Rook) || rook.hasMoved()) return false;
            return board[0][1] == null && board[0][2] == null && board[0][3] == null;
        }else {
            Piece rook = board[7][0];
            if(rook == null || !(rook instanceof Rook) || rook.hasMoved()) return false;
            return board[7][1] == null && board[7][2] == null && board[7][3] == null;
        }
    }
}
