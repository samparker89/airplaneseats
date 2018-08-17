import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AirplaneSeatsTests {

    private Main2B airplaneSeats;

    @Before
    public void setup(){
        airplaneSeats = new Main2B();
    }

    @Test
    public void testRowCalculatorReturns0WhenAllSeatsAreTaken(){
        //GIVEN
        String input = createFullNumberOfRows(5);

        //WHEN
        int result = airplaneSeats.solution(5, input);

        //THEN
        Assert.assertEquals(0 ,result);
    }

    @Test
    public void testRowCalculatorReturnsCorrectNumberWhenNoSeatsAreTaken(){
        //GIVEN
        String input = "";

        //WHEN
        int result = airplaneSeats.solution(5, input);

        //THEN
        Assert.assertEquals(5 * 3 ,result);
    }

    private String createFullNumberOfRows(int number){
        String str = "%sA %sB %sC %sD %sE %sF %sG %sH %sJ %sK";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= number; i++){
            sb.append(str.replace("%s", String.valueOf(i)));
        }

        return sb.toString();
    }

    @Test
    public void testRowCalculatorReturnsAllAvailableSeatsForSpace(){
        //GIVEN
        String input = " ";

        //WHEN
        int result = airplaneSeats.solution(5, input);

        //THEN
        Assert.assertEquals(5 * 3,result);
    }

    @Test
    public void testNumbersDontMatchNumbers(){
        //GIVEN
        String input = "11A";

        //WHEN
        int result = airplaneSeats.solution(11, input);

        //THEN
        Assert.assertEquals(32, result);
    }


    @Test
    public void testRowCalculatorDoesNotMarkBlockAsTakenForSeatD(){
        //GIVEN
        String input = "1D";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(3,result);
    }

    @Test
    public void testRowCalculatorDoesNotMarkBlockAsTakenForSeatG(){
        //GIVEN
        String input = "1G";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(3,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForBothEndSeatsInMiddleColumn(){
        //GIVEN
        String input = "1D 1G";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForBothLeftSeatsInMiddleColumn(){
        //GIVEN
        String input = "1D 1E";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForMiddleSeatsInMiddleColumn(){
        //GIVEN
        String input = "1E 1F";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForMiddleSeatsInMiddleColumnOutOfOrder(){
        //GIVEN
        String input = "1F 1E";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForBothRightSeatsInMiddleColumn(){
        //GIVEN
        String input = "1F 1G";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForAnySeatInLeftSection(){
        //GIVEN
        String input = "1A";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorMarksBlockAsTakenForAnySeatInRightSection(){
        //GIVEN
        String input = "1K";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }



    @Test
    public void testRowCalculatorAcceptsFullyOccupiedRowWith1RowAndOutputs0(){
        //GIVEN
        String input = "1A 1B 1C 1D 1E 1F 1G 1H 1K 1J";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(0,result);
    }

    @Test
    public void testRowCalculatorAcceptsNilInputWith10RowsAndOutputs30(){
        //GIVEN
        String input = "";

        //WHEN
        int result = airplaneSeats.solution(10, input);

        //THEN
        Assert.assertEquals(30,result);
    }

    @Test
    public void testRowCalculatorAcceptsInputWith40RowsAndOutputs116(){
        //GIVEN
        String input = "1A 3C 2B 40G 5A";

        //WHEN
        int result = airplaneSeats.solution(40, input);

        //THEN
        Assert.assertEquals(116,result);
    }

    @Test
    public void testRowCalculatorAcceptsInputWithAMultiDigitNumber(){
        //GIVEN
        String input = "1A 1B 1C";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorAcceptsInputWithATripleDigitNumber(){
        //GIVEN
        String input = "1A 1B 1C";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorRemovesARowForE(){
        //GIVEN
        String input = "1E";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorRemovesARowForG(){
        //GIVEN
        String input = "1F";

        //WHEN
        int result = airplaneSeats.solution(1, input);

        //THEN
        Assert.assertEquals(2,result);
    }

    @Test
    public void testRowCalculatorAcceptsInputWithATripleDigitNumberAndMultiRows(){
        //GIVEN
        String input = "100A 100B 100C";

        //WHEN
        int result = airplaneSeats.solution(100, input);

        //THEN
        Assert.assertEquals(299,result);
    }

    @Test
    public void onlineTest(){
        //GIVEN
        String input = "1A 2F 1C";

        //WHEN
        int result = airplaneSeats.solution(2, input);

        //THEN
        Assert.assertEquals(4,result);
    }

    @Test
    @Ignore
    public void testRowCalculatorAcceptsReallyBigString(){
        //GIVEN
        String input = createMassiveInput(10000);

        //WHEN
        long startTime = System.currentTimeMillis();
        int result = airplaneSeats.solution(10000, input);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Program took %s milliseconds to run", (endTime - startTime)));

        //THEN
        Assert.assertEquals(0,result);
    }

    @Test
    public void testRowCalculatorAcceptsLotsOfRowsAndNoInput(){
        //GIVEN
        String input = " ";

        //WHEN
        int result = airplaneSeats.solution(1000, input);

        //THEN
        Assert.assertEquals(1000 * 3,result);
    }

    public String createMassiveInput(int noOfRows){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < noOfRows; i++){
            int value = i % 10;
            String letter = "";
            switch(value) {
                case(0):{
                    i++;
                    letter = "A";
                    break;
                }
                case(1):{
                    letter = "B";
                    break;
                }
                case(2):{
                    letter = "C";
                    break;
                }
                case(3):{
                    letter = "D";
                    break;
                }
                case(4):{
                    letter = "E";
                    break;
                }
                case(5):{
                    letter = "F";
                    break;
                }
                case(6):{
                    letter = "G";
                    break;
                }
                case(7):{
                    letter = "H";
                    break;
                }
                case(8):{
                    letter = "J";
                    break;
                }
                case(9):{
                    letter = "K";
                    break;
                }
            }
            sb.append(i).append(letter).append(" ");
        }
        return sb.toString();
    }

}
