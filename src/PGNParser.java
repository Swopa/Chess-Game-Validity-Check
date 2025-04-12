import java.util.ArrayList;
import java.util.List;

public class PGNParser {
    public static List<String> parseMoves(String pgn){
        //This part of code removes metadata which pgn file contains. We do this by skipping lines that start with [
        StringBuilder movesOnly = new StringBuilder();
        String[] lines = pgn.split("\\R"); //Split by lines

        for(String line : lines){
            line = line.trim();
            if(!line.startsWith("[") && !line.isEmpty()){
                movesOnly.append(line).append(" ");
            }
        }



        // This part of code parses string of moves by removing empty spaces and putting each component in string array
        // and then removes numbers like 1. 2. and so on. leaves only list of move notations
        List<String> moves = new ArrayList<>();
        String[] init = movesOnly.toString().trim().split("\\s+");
        for(String part : init){
            if(!part.matches(".*\\d+\\.")){
                moves.add(part);
            }
        }
        return moves;
    }
}
