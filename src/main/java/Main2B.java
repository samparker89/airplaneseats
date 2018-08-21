import java.util.List;

public class Main2B {

    private static final int TOTAL_VACANT_BLOCKS_PER_ROW = 3;
    private static final String NO_SEAT_RESERVATIONS = "";
    private static final List<String> LEFT_SEAT_BLOCK = List.of("A", "B", "C");
    private static final List<String> MIDDLE_SEAT_BLOCK_A = List.of("D", "E", "F");
    private static final List<String> MIDDLE_SEAT_BLOCK_B = List.of("E", "F", "G");
    private static final List<String> RIGHT_SEAT_BLOCK = List.of("H", "J", "K");
    private static final String WHOLE_WORD_FORMAT = " %s%s";

    private String takenSeats = "";

    public int solution(int noRows, String seats){

        int totalSpaces = noRows * TOTAL_VACANT_BLOCKS_PER_ROW;

        return NO_SEAT_RESERVATIONS.equals(seats) ? totalSpaces : calculateTakenSeats(noRows, seats);
    }

    private int calculateTakenSeats(int noRows, String seats) {
        //Add a space to the start of taken seats. This ensures when checking the strings for whole words, we match whole
        //words only. e.g. looking for "1A" in "11A" would return true. We do not want this. We could also use a regexp
        //in this scenario or also split and do a List.Contains.
        takenSeats = " " + seats;

        int totalSpaces = 0;

        for (int i = 1; i <= noRows; i++) {
            if (isBlockFree(i, LEFT_SEAT_BLOCK)) {
                totalSpaces++;
            }
            if (isBlockFree(i, MIDDLE_SEAT_BLOCK_A) || isBlockFree(i, MIDDLE_SEAT_BLOCK_B)) {
                totalSpaces++;
            }
            if (isBlockFree(i, RIGHT_SEAT_BLOCK)) {
                totalSpaces++;
            }
        }

        return totalSpaces;
    }

    private boolean isBlockFree(int row, List<String> token){
        return token
                .stream()
                .noneMatch(letter -> takenSeats.contains(String.format(WHOLE_WORD_FORMAT, row, letter)));
    }
}