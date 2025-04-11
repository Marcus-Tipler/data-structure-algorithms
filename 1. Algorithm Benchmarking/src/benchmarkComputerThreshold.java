import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class benchmarkComputerThreshold {

    // ----------------------------------------------------------
    // Imports the sorting algorithm classes. 
    // ----------------------------------------------------------
    static sortHybrid sH = new sortHybrid();
    static sortQuick sQ = new sortQuick();
    static sortInsertion sI = new sortInsertion();
    static sortSelection sS = new sortSelection();
    private Random random = new Random(12345);


    // ----------------------------------------------------------
    // Creates an array of random integers of the size specified.
    // ----------------------------------------------------------
    public List<Integer> createArray(int amountItems) {
        List<Integer> itemsWeek = new ArrayList<>();
        for (int i = 0; i < amountItems; i++) {
            int intRandom = getRandomNumber(amountItems);
            itemsWeek.add(intRandom);
        }
        return itemsWeek;
    }


    // ----------------------------------------------------------
    // Generates a random number between 1 and the maximum specified.
    // ----------------------------------------------------------
    public int getRandomNumber(int max) {
        return random.nextInt(max - 1) + 1;
    }


    // ----------------------------------------------------------
    // Calculates the delta between start and end time for benchmarking.
    // ----------------------------------------------------------
    public long calculateTime(long clockOrigin, long clockOut) {
        long clockDelta = clockOut - clockOrigin;
        return clockDelta;
    }


    // ----------------------------------------------------------
    // Benchmarks the sorting algorithms with different scenarios.
    // ----------------------------------------------------------
    public void benchmarkHybridSortQI(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER Unsorted List.
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQI(day, day.size(), threshold);
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for Unsorted List (reversed).
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQIReverse(day, day.size(), threshold);
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for Sorted List.
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sH.hybridSortQI(day, day.size(), threshold);
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println(threshold + ";" + clockAverage);
    }
    public void benchmarkHybridSortQS(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for Unsorted List.
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQS(day, day.size(), threshold);
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for Unsorted List (reversed).
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQSReverse(day, day.size(), threshold);
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for Sorted List.
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sH.hybridSortQS(day, day.size(), threshold);
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println(threshold + ";" + clockAverage);
    }


    // ----------------------------------------------------------
    // Prints the benchmark results in a computer-readable format.
    // ----------------------------------------------------------
    public void printComputerReadable(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {
        System.out.println("threshold;averagetime");
        for (int threshold = 1; threshold <= 25; threshold++) {
            benchmarkHybridSortQI(week, weekSorted, threshold);
        }
        System.out.println("\nthreshold;averagetime");
        for (int threshold = 1; threshold <= 25; threshold++) {
            benchmarkHybridSortQS(week, weekSorted, threshold);
        }
    }


    // ----------------------------------------------------------
    // Main method to run the computer-readable benchmark.
    // ----------------------------------------------------------
    public static void main(String[] args) {
        // Create a new instance of the java class (common practice).
        benchmarkComputerThreshold bCt = new benchmarkComputerThreshold();

        // Variables for array sizes per day.
        int[] amountItems = {10000, 50000, 100000, 500000, 750000, 1000000, 5000000};
        
        // Initializing variables for the sorted and reversed lists.
        List<Integer> day, daySorted;
        ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();
        int[] sortedNormal;

        // Creates an array of unsorted integers of the size specified.
        for (int i = 0; i < amountItems.length; i++) { 
            day = bCt.createArray(amountItems[i]);
            week.add(day); 
        }

        // Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sortedNormal = sQ.quickSort(day, day.size());

            daySorted = new ArrayList<>(day);
            for (int element = 0; element < sortedNormal.length; element++) {
                daySorted.set(element, sortedNormal[element]);
            }
            weekSorted = new ArrayList<>(week);
            for (i = 0; i < week.size(); i++) {
                weekSorted.set(i, daySorted);
            }
        }

        // prints the benchmark results in a computer-readable format.
        bCt.printComputerReadable(week, weekSorted);
    }
    
}
