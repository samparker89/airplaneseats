public class Main {

    private static final int TOTAL_VACANT_BLOCKS_PER_ROW = 3;
    private static final String NO_SEAT_RESERVATIONS = "";
    private static final String WHOLE_WORD_FORMAT = " %s";

    public int solution(int noRows, String takenSeats){

        int totalSpaces = noRows * TOTAL_VACANT_BLOCKS_PER_ROW;

        //Add a space to the start of taken seats. This ensures when checking the strings for whole words, we match whole
        //words only. e.g. looking for "1A" in "11A" would return true. We do not want this. We could also use a regexp
        //in this scenario or also split and do a List.Contains.
        takenSeats = " " + takenSeats;

        if(!NO_SEAT_RESERVATIONS.equals(takenSeats)) {
            for (int i = 1; i <= noRows; i++) {
                if (isLeftSeatBlockTaken(takenSeats, i)) {
                    totalSpaces--;
                }
                if (isMiddleSeatBlockTaken(takenSeats, i)) {
                    totalSpaces--;
                }
                if (isRightSeatBlockTaken(takenSeats, i)) {
                    totalSpaces--;
                }
            }
        }
        return totalSpaces;
    }

    private boolean isLeftSeatBlockTaken(String takenSeats, int currentRow){
        return takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "A")) ||
               takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "B")) ||
               takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "C"));
    }

    private boolean isMiddleSeatBlockTaken(String takenSeats, int currentRow){
        return (takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "D")) &&
                    takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "G"))) ||
                takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "E")) ||
                takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "F"));
    }

    private boolean isRightSeatBlockTaken(String takenSeats, int currentRow){
        return takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "H")) ||
                takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "J")) ||
                takenSeats.contains(String.format(WHOLE_WORD_FORMAT, currentRow + "K"));
    }
}
