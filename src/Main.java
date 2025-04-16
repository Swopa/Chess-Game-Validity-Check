import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pgn = "[Event \"Tbilisi FIDE GP 2015\"]\n" +
                "[Site \"Tbilisi GEO\"]\n" +
                "[Date \"2015.02.20\"]\n" +
                "[Round \"5.6\"]\n" +
                "[White \"Jobava,Ba\"]\n" +
                "[Black \"Mamedyarov,S\"]\n" +
                "[Result \"1-0\"]\n" +
                "[WhiteTitle \"GM\"]\n" +
                "[BlackTitle \"GM\"]\n" +
                "[WhiteElo \"2696\"]\n" +
                "[BlackElo \"2759\"]\n" +
                "[ECO \"A01\"]\n" +
                "[Opening \"Nimzovich-Larsen attack\"]\n" +
                "[Variation \"Indian variation\"]\n" +
                "[WhiteFideId \"13601520\"]\n" +
                "[BlackFideId \"13401319\"]\n" +
                "[EventDate \"2015.02.15\"]\n" +
                " \n" +
                "1. b3 Nf6 2. Bb2 g6 3. Nc3 Bg7 4. d4 c5 5. e3 cxd4 6. exd4 d5 7. Qd2 Nc6 8.\n" +
                "O-O-O Qa5 9. f3 h5 10. Kb1 Bf5 11. Bd3 Nxd4 12. Nge2 Nxe2 13. Qxe2 Bd7 14. Rhe1\n" +
                "e6 15. Bxg6 fxg6 16. Nxd5 Nxd5 17. Bxg7 Rg8 18. Qe5 Rxg7 19. Rxd5 Qb4 20. Rd6\n" +
                "Kf8 21. Red1 Bc6 22. R1d4 Qb5 23. Rd8+ Rxd8 24. Rxd8+ Ke7 25. Qd6+ Kf6 26. Qd4+\n" +
                "Kf7 27. Qf4+ Ke7 1-0";

        List<String> moves = PGNParser.parseMoves(pgn);

        System.out.println("Game Start:");
        printBoard(new Board());

        Board board = new Board();
        MoveInterpreter interpreter = new MoveInterpreter(board);

        for (String move : moves) {
            System.out.println("\nMove: " + move);
            interpreter.interpretMove(move);

            // Print the board after each move
            printBoard(board);
        }

        System.out.println("Game Over!");
    }

    public static void printBoard(Board board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.board[row][col];
                if (piece == null) {
                    System.out.print(" . ");
                } else {
                    char symbol;
                    if (piece instanceof Knight) {
                        symbol = 'N';
                    } else {
                        symbol = piece.getClass().getSimpleName().charAt(0);
                    }
                    System.out.print(symbol + (piece.isWhite ? "W" : "B") + " ");
                }
            }
            System.out.println();
        }
    }
}
