import java.util.regex.Pattern;

public class Main3 {

    private static final int TOTAL_VACANT_BLOCKS_PER_ROW = 3;
    private static final String NO_SEAT_RESERVATIONS = "";
    private static final String REGEX_REPLACE = "%s";
    private static final String REGEX_IS_ONE_OF_LEFT_SEATS_TAKEN = "(?i)(.*( %sA| %sB| %sC).*)";
    private static final String REGEX_IS_ONE_OF_CENTRE_SEATS_TAKEN = "(?i)(.*( %sE| %sF).*)";
    private static final String REGEX_ARE_BOTH_END_SEATS_TAKE_IN_CENTER_BLOCK = "(?i)(?=.* %sD)(.*( %sG).*)";
    private static final String REGEX_IS_ONE_OF_RIGHT_SEATS_TAKEN = "(?i)(.*( %sH| %sJ| %sK).*)";

    private String takenSeats = "";

    public int solution(int noRows, String seats){

        int totalSpaces = noRows * TOTAL_VACANT_BLOCKS_PER_ROW;

        //Add a space to the start of taken seats. This ensures when checking the strings for whole words, we match whole
        //words only. e.g. looking for "1A" in "11A" would return true. We do not want this. We could also use a regexp
        //in this scenario or also split and do a List.Contains.
        takenSeats = " " + seats;

        if(!NO_SEAT_RESERVATIONS.equals(takenSeats)) {
            for (int i = 1; i <= noRows; i++) {

                Pattern patternA = createRegexp(REGEX_IS_ONE_OF_LEFT_SEATS_TAKEN, i);
                Pattern patternB = createRegexp(REGEX_IS_ONE_OF_CENTRE_SEATS_TAKEN, i);
                Pattern patternC = createRegexp(REGEX_ARE_BOTH_END_SEATS_TAKE_IN_CENTER_BLOCK, i);
                Pattern patternD = createRegexp(REGEX_IS_ONE_OF_RIGHT_SEATS_TAKEN, i);

                if (patternA.matcher(takenSeats).matches()) {
                    totalSpaces--;
                }
                if (patternB.matcher(takenSeats).matches() || patternC.matcher(takenSeats).matches()) {
                    totalSpaces--;
                }
                if (patternD.matcher(takenSeats).matches()) {
                    totalSpaces--;
                }
            }
        }
        return totalSpaces;
    }

    private Pattern createRegexp(String regexp, int replacement){
        String currentIteration = String.valueOf(replacement);
        return Pattern.compile(regexp.replace(REGEX_REPLACE, currentIteration));
    }
}
