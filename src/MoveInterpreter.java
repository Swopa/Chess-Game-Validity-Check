public class MoveInterpreter {
    private final Board board;
    private boolean whiteToMove = true;

    public MoveInterpreter(Board board){
        this.board = board;
    }

    public void interpretMove(String move){

        //TODO Add castling | Add Check | Add Promotion
        if(move.equals("O-O")|| move.equals("O-O-O")){
            boolean isShortCastling = move.equals("O-O");

            int row = whiteToMove ? 0 : 7;
            int srcCol = 4;
            int kingDestCol = isShortCastling ? 6 : 2;
            int rookSrcCol = isShortCastling ? 7 : 0;
            int rookDestCol = isShortCastling ? 5 : 3;

            Piece king = board.board[row][srcCol];
            Piece rook = board.board[row][rookSrcCol];

            if(king instanceof King && rook instanceof Rook && king.isWhite == whiteToMove && rook.isWhite == whiteToMove){
                if(king.isValidMove(row, srcCol, row, kingDestCol, board.board)){
                    board.board[row][kingDestCol] = king;
                    board.board[row][srcCol] = null;
                    king.markMove();

                    board.board[row][rookDestCol] = rook;
                    board.board[row][rookSrcCol] = null;
                    rook.markMove();

                    System.out.println("Moving " + king + " to: " + row + "," + kingDestCol);

                    whiteToMove = !whiteToMove;
                    return;
                }else {
                    System.out.println("Illegal castling move: " + move);
                }
            }else{
                System.out.println("Cannot castle: King or Rook in incorrect position");
                return;
            }



            whiteToMove = !whiteToMove;
            return;
        }



        char pieceChar = 'P';
        int startIndex = 0;

        if(Character.isUpperCase(move.charAt(0)) && move.charAt(0) != 'O'){
            pieceChar = move.charAt(0);
            startIndex = 1;
        }

        move = move.replaceAll("[+#x]", "");

        String dest = move.substring(move.length() - 2);
        int destCol = dest.charAt(0) - 'a';
        int destRow = Character.getNumericValue(dest.charAt(1)) - 1;

        String disambiguation = move.substring(startIndex, move.length() - 2);

        int[] source = findSourceSquare(pieceChar, destRow, destCol, disambiguation);

        if(source == null){
            System.out.println("===================================================================Illegal move or ambigous: " + move);
            return;
        }

        System.out.printf("Moving %s from %c%d to %c%d%n",
                pieceChar,
                (char)(source[1] + 'a'), source[0] + 1,
                (char)(destCol + 'a'), destRow + 1
        );

        board.movePiece(source[0], source[1], destRow, destCol);

        Piece piece = board.board[source[0]] [source[1]];

        if(piece instanceof King || piece instanceof Rook){
            piece.markMove();
        }

        whiteToMove = !whiteToMove;
    }

    int[] findSourceSquare(char pieceChar, int destRow, int destCol, String disambiguation){

        System.out.printf("Looking for move to (%d, %d) = %c%d with disambiguation [%s]\n",
                destRow, destCol, (char)(destCol + 'a'), destRow + 1, disambiguation);

        System.out.printf("Checking %s moves for %s to %c%d%n",
                whiteToMove ? "white" : "black", pieceChar, (char)(destCol + 'a'), destRow + 1);

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
