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
        int[] amountItems = {1000, 2000, 3000, 4000, 5000, 6000, 500000};
        
        // Initializing variables for the sorted and reversed lists.
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        List<Integer> day, daySorted, savedSortNormal, savedSortReverse, savedSortSorted;
        ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();
        int[] sortedNormal, sortedReversed, sortedSorted;

        // Start timing the Normal Quick Sort Method.
        for (int i = 0; i < amountItems.length; i++) { 
            day = aE.createArray(amountItems[i]);
            week.add(day); 
        }


        // Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sortedNormal = quickSort(day, day.size());

            daySorted = new ArrayList<>(day);
            for (int element = 0; element < sortedNormal.length; element++) {
                daySorted.set(element, sortedNormal[element]);
            }
            weekSorted = new ArrayList<>(week);
            for (i = 0; i < week.size(); i++) {
                weekSorted.set(i, daySorted);
            }
        }

        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("Normal quicksort algorithm with unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            quickSort(day, day.size());
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = aE.calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("Reverse quicksort algorithm with unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            quickSortReverse(day, day.size());
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = aE.calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("Normal quicksort algorithm with pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            quickSort(day, day.size());
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = aE.calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");


        // FIXME: TEST PRINTS FOR PROGRAM FUNCTIONALITY VERIFICATION PROCEDURES.
        // System.out.println(week); // TODO: TEST THE GENERATION OF RANDOM VALUES FOR EVERY DAY IN VARIABLE LIST WEEK
        // System.out.println(weekSorted); // TODO: TEST THE GENERATION OF THE SORTED RANDOM ARRAY FOR EVERY DAY IN VARIABLE LIST WEEKSORTED
    }
}
