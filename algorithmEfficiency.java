import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class algorithmEfficiency extends sortQuick {

    public algorithmEfficiency() {
        super();
    }

    public List<Integer> createArray(int amountItems) {
        List<Integer> itemsWeek = new ArrayList<Integer>();
        for (int i = 0; i < amountItems; i++) {
            int intRandom = getRandomNumber(amountItems);
            itemsWeek.add(intRandom);
        }
        return itemsWeek;
    }

    public int getRandomNumber(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }


    public long calculateTime(long clockOrigin, long clockOut) {
        // Calculate the time difference between the two clocks.
        long clockDelta = clockOut - clockOrigin;
        System.out.println("Execution Time: " + clockDelta + "ms.");    // FIXME: ROUND VALUES PLEASE.
        return clockDelta;
    }


    public static void main(String[] args) {
        // Create a new instance of the java class (common practice).
        algorithmEfficiency aE = new algorithmEfficiency();

        // Variables for array sizes per day.
        int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};
        
        // Initializing variables for the sorted and reversed lists.
        List<Integer> week;
        List<Integer> weekQuickNormal, weekQuickReverse, weekQuickSorted;
        long clockStart, clockNormal, clockReverse, clockSorted;

        // Start timing the Normal Quick Sort Method.
        for (int i = 0; i < amountItems.length; i++) {                  // FIXME: Problem, this needs to be isolated and done on an individual basis.
            week = aE.createArray(amountItems[i]);
            System.out.println("NORMAL");
            clockStart = System.currentTimeMillis();
            weekQuickNormal = sorterQuick(week);
            clockNormal = System.currentTimeMillis();
            long deltaNormal = aE.calculateTime(clockStart, clockNormal);
            System.out.println("REVERSED");
            weekQuickReverse = sorterQuickReversed(week);
            clockReverse = System.currentTimeMillis();
            long deltaReverse = aE.calculateTime(clockNormal, clockReverse);
            System.out.println("SORTED");
            weekQuickSorted = quickSort(weekQuickNormal, weekQuickNormal.size());          // FIXME: Problem with sorted array causes Crash.
            clockSorted = System.currentTimeMillis();                // FIXME: Problem with sorted array causes Crash.
            long deltaSorted = aE.calculateTime(clockReverse, clockSorted);
            // System.out.println(week);                                // TODO: Test Line.
            // System.out.println(weekSorted);                          // TODO: Test Line.
        }
        System.out.println("\n\n");


        // long startTime = System.currentTimeMillis();

    }
}
