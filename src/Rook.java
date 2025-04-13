public class Rook extends Piece{
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    boolean isValidMove(int srcRow, int srcCol, int destRow, int destCol, Piece[][] board) {
        //TODO pieces on the path detection | not capturing team pieces

        if((srcRow == destRow && srcCol != destCol) || (srcRow != destRow && srcCol == destCol)){
            return true;
        }

        return false;
    }
}
