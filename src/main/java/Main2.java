import java.util.Arrays;
import java.util.List;

public class Main2 {

    private static final int TOTAL_VACANT_BLOCKS_PER_ROW = 3;
    private static final String NO_SEAT_RESERVATIONS = "";
    private static final String WHOLE_WORD_FORMAT = " %s";

    private String takenSeats = "";

    public int solution(int noRows, String seats){

        int totalSpaces = noRows * TOTAL_VACANT_BLOCKS_PER_ROW;

        //Add a space to the start of taken seats. This ensures when checking the strings for whole words, we match whole
        //words only. e.g. looking for "1A" in "11A" would return true. We do not want this. We could also use a regexp
        //in this scenario or also split and do a List.Contains.
        takenSeats = " " + seats;

        if(!NO_SEAT_RESERVATIONS.equals(takenSeats)) {
            for (int i = 1; i <= noRows; i++) {
                if (isBlockTaken(i, "A,B,C")) {
                    totalSpaces--;
                }
                if ((isBlockTaken(i, "DG,E,F"))) {
                    totalSpaces--;
                }
                if (isBlockTaken(i, "H,J,K")) {
                    totalSpaces--;
                }
            }
        }
        return totalSpaces;
    }

    private boolean isBlockTaken(int row, String string){
        List<String> seatsToCheck = Arrays.asList(string.split(","));

        long count = seatsToCheck
                .stream()
                .filter(s -> checkCombination(s, row))
                .count();

        return count > 0;
    }

    private boolean checkCombination(String sequence, int row){
        int seatsInBlockTaken = 0;
        char[] seatLetters = sequence.toCharArray();
        for(char seatLetter : seatLetters){
            if(takenSeats.contains(String.format(WHOLE_WORD_FORMAT, row + seatLetter))) {
                seatsInBlockTaken++;
            }
        }
        return seatsInBlockTaken == seatLetters.length;
    }
}
