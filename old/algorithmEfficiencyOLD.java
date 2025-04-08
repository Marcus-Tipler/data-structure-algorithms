import java.util.ArrayList;
import java.util.List;

public class algorithmEfficiencyOLD extends sortQuick {

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
        int[] amountItems = {1000, 2000, 3000, 4000, 5000, 6000, 500000};
        
        // Initializing variables for the sorted and reversed lists.
        List<Integer> week, weekQuickNormal, weekQuickReverse, weekQuickSorted;
        long clockStart, clockNormal, clockReverse, clockSorted;

        ArrayList<List<Integer>> weeks = new ArrayList<>();
        ArrayList<List<Integer>> weeksSortedNormal = new ArrayList<>(), weeksSortedReverse = new ArrayList<>(), weeksSortedSorted = new ArrayList<>();
        // Start timing the Normal Quick Sort Method.
        for (int i = 0; i < amountItems.length; i++) { 
            week = aE.createArray(amountItems[i]);
            weeks.add(week); 
        }
        // System.out.println(weeks);
        int[] weekQuickNormy, weekQuickReversy;
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weeks.size(); i++) {
            week = weeks.get(i);
            weekQuickReverse = new ArrayList<>(week);
            // weekQuickNormal = quickSort(week, week.size());
            weekQuickNormy = quickSort(week, week.size());
            for (i = 0; i < week.size(); i++) {
                weekQuickReverse.set(i, weekQuickNormy[i]);
            }
            weekQuickReversy = quickSort(weekQuickReverse, weekQuickReverse.size());
            // weeksSortedNormal.add(weekQuickNormal);
            System.out.println("Unsorted Array: ");
            for (int element = 0; element < weekQuickNormy.length; element++) {
                System.out.print(weekQuickNormy[element] + ", ");
            }
            System.out.println("\n -------------------------------------------- ");
            System.out.println("Sorted Array: ");
            for (int element = 0; element < weekQuickReversy.length; element++) {
                System.out.print(weekQuickReversy[element] + ", ");
            }
            System.out.println("\n -------------------------------------------- ");
        }
        clockNormal = System.currentTimeMillis();
        System.out.println(clockNormal - clockStart);
        // for (int i = 0; i < weeks.size(); i++) {
        //     week = weeks.get(i);
        //     weekQuickReverse = quickSortReverse(week, week.size());
        //     weeksSortedReverse.add(weekQuickReverse);
        // }
        // clockReverse = System.currentTimeMillis();
        // System.out.println(clockReverse - clockNormal);
        // for (int i = 0; i < weeksSortedNormal.size(); i++) {
        //     week = weeksSortedNormal.get(i);
        //     weekQuickSorted = quickSort(week, week.size());
        //     weeksSortedSorted.add(weekQuickSorted);
        // }
        // clockSorted = System.currentTimeMillis();
        // System.out.println(clockSorted - clockReverse);
        // System.out.println(weeks);
        // for (int i = 0; i < amountItems.length; i++) {                                       // FIXME: Problem, this needs to be isolated and done on an individual basis.
        //     week = aE.createArray(amountItems[i]);
        //     System.out.println("NORMAL");
        //     clockStart = System.currentTimeMillis();
        //     weekQuickNormal = quickSort(week, week.size());
        //     clockNormal = System.currentTimeMillis();
        //     long deltaNormal = aE.calculateTime(clockStart, clockNormal);
        //     System.out.println("REVERSED");
        //     weekQuickReverse = quickSortReverse(week, week.size());
        //     clockReverse = System.currentTimeMillis();
        //     long deltaReverse = aE.calculateTime(clockNormal, clockReverse);
        //     System.out.println("SORTED");
        //     weekQuickSorted = quickSort(weekQuickNormal, weekQuickNormal.size());            // FIXME: Problem with sorted array causes Crash.
        //     clockSorted = System.currentTimeMillis();                                        // FIXME: Problem with sorted array causes Crash.
        //     long deltaSorted = aE.calculateTime(clockReverse, clockSorted);
        //     System.out.println(week);                                                        // TODO: Test Line.
        //     System.out.println(weekQuickNormal);                                             // TODO: Test Line.
        //     System.out.println(weekQuickReverse);                                            // TODO: Test Line.
        //     System.out.println(weekQuickSorted);                                             // TODO: Test Line.
        // }
        // System.out.println("\n\n");


        // long startTime = System.currentTimeMillis();

    }
}
