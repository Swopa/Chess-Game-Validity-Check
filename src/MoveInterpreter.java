public class MoveInterpreter {
    private final Board board;
    private boolean whiteToMove = true;

    public MoveInterpreter(Board board){
        this.board = board;
    }

    public void interpretMove(String move){

        //TODO Add castling | Add Check
        if(move.equals("O-O")|| move.equals("O-O-O")){
            System.out.println("Castling not yet implemented");
            whiteToMove = !whiteToMove;
            return;
        }

        

        char pieceChar = 'P';
        int startIndex = 0;

        if(Character.isUpperCase(move.charAt(0)) && move.charAt(0) != 'O'){
            pieceChar = move.charAt(0);
            startIndex = 1;
        }

        move = move.replaceAll("[+#]", "");

        String dest = move.substring(move.length() - 2);
        int destCol = dest.charAt(0) - 'a';
        int destRow = Character.getNumericValue(dest.charAt(1)) - 1;
        
        String disambiguation = move.substring(startIndex, move.length() - 2);

        int[] source = findSourceSquare(pieceChar, destRow, destCol, disambiguation);

        if(source == null){
            System.out.println("Illegal move or ambigous: " + move);
            return;
        }

        System.out.printf("Moving %s from %c%d to %c%d%n",
                pieceChar,
                (char)(source[1] + 'a'), source[0] + 1,
                (char)(destCol + 'a'), destRow + 1
        );

        board.movePiece(source[0], source[1], destRow, destCol);
        whiteToMove = !whiteToMove;
    }

    int[] findSourceSquare(char pieceChar, int destRow, int destCol, String disambiguation){
        for(int row = 0; row < 8; row++){
            for(int col = 0; col < 8; col++){
                Piece piece = board.board[row][col];
                if(piece == null) continue;
                if(piece.isWhite != whiteToMove) continue;
                if(!matchPieceType(piece, pieceChar)) continue;
                if(!piece.isValidMove(row, col, destRow, destCol, board.board)) continue;

                if (!disambiguation.isEmpty()){
                    if(disambiguation.length() == 2){
                        int y = disambiguation.charAt(0) - 'a';
                        int x = Character.getNumericValue(disambiguation.charAt(1)) - 1;
                        if(row != x || col != y) continue;
                    } else if (Character.isDigit(disambiguation.charAt(0))) {
                        int x = Character.getNumericValue(disambiguation.charAt(0)) - 1;
                        if(row != x) continue;
                    } else if (Character.isLetter(disambiguation.charAt(0))) {
                        int y = disambiguation.charAt(0) - 'a';
                        if(col != y) continue;
                    }

                }

                return new int[]{row, col};
            }
        }
        return null;
    }

    private boolean matchPieceType(Piece piece, char pieceChar){
        return switch (pieceChar) {
            case 'N' -> piece instanceof Knight;
            case 'B' -> piece instanceof Bishop;
            case 'R' -> piece instanceof Rook;
            case 'Q' -> piece instanceof Queen;
            case 'K' -> piece instanceof King;
            case 'P' -> piece instanceof Pawn;
            default -> false;
        };
    }
}
