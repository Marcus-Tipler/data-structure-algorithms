import java.util.ArrayList;
import java.util.List;

public class algorithmEfficiency {

    public algorithmEfficiency() {
        super();
    }

    // private static sortQuick sQ;
    // private static sortInsertion sI;
    static sortHybrid sH = new sortHybrid();
    static sortQuick sQ = new sortQuick();
    static sortInsertion sI = new sortInsertion();
    static sortSelection sS = new sortSelection();


    public List<Integer> createArray(int amountItems) {
        List<Integer> itemsWeek = new ArrayList<>();
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

    public void benchmarkQuickSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sQ.quickSort(day, day.size());
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("unsorted list (reversed): ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sQ.quickSortReverse(day, day.size());
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sQ.quickSort(day, day.size());
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");
    }


    public void benchmarkInsertionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sI.insertionSort(day, day.size());
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("unsorted list (reversed): ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sI.insertionSortReverse(day, day.size());
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sI.insertionSort(day, day.size());
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");
    }

    public void benchmarkSelectionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sS.selectionSort(day, day.size());
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("unsorted list (reversed): ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sS.selectionSortReverse(day, day.size());
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sS.selectionSort(day, day.size());
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");
    }


    public void benchmarkHybridSortQI(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQI(day, day.size(), threshold);
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("unsorted list (reversed): ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQIReverse(day, day.size(), threshold);
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sH.hybridSortQI(day, day.size(), threshold);
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");
    }

    public void benchmarkHybridSortQS(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {
        List<Integer> day;
        long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;
        // Starts the LOOP & TIMER for NormalQuickSort with Unsorted List.
        System.out.println("unsorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQS(day, day.size(), threshold);
        }
        clockNormal = System.currentTimeMillis();
        clockNormal = calculateTime(clockStart, clockNormal);

        // Starts the LOOP & TIMER for ReverseQuickSort with Unsorted List.
        System.out.println("unsorted list (reversed): ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < week.size(); i++) { 
            day = week.get(i);
            sH.hybridSortQSReverse(day, day.size(), threshold);
        }
        clockReverse = System.currentTimeMillis();
        clockReverse = calculateTime(clockStart, clockReverse);

        // Starts the LOOP & TIMER for NormalQuickSort with Sorted List.
        System.out.println("pre-sorted list: ");
        clockStart = System.currentTimeMillis();
        for (int i = 0; i < weekSorted.size(); i++) { 
            day = weekSorted.get(i);
            sH.hybridSortQS(day, day.size(), threshold);
        }
        clockSorted = System.currentTimeMillis();
        clockSorted = calculateTime(clockStart, clockSorted);

        // Computes average time between three pre-computed scenario times to make a benchmark.
        System.out.println("\nProgram Benchmark Results: ");
        clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;
        System.out.println("Average Execution Time: " + clockAverage + "ms");
    }


    public static void main(String[] args) {
        // Create a new instance of the java class (common practice).
        algorithmEfficiency aE = new algorithmEfficiency();

        // Variables for array sizes per day.
        int[] amountItems = {1000, 2000, 3000, 4000, 5000, 6000, 7000};
        
        // Initializing variables for the sorted and reversed lists.
        List<Integer> day, daySorted;
        ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();
        int[] sortedNormal;

        // Start timing the Normal Quick Sort Method.
        for (int i = 0; i < amountItems.length; i++) { 
            day = aE.createArray(amountItems[i]);
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

        System.out.println("BENCHMARK FOR QUICK SORT: ");
        aE.benchmarkQuickSort(week, weekSorted);
        System.out.println("\n\nBENCHMARK FOR INSERTION SORT: ");
        aE.benchmarkInsertionSort(week, weekSorted);
        System.out.println("\n\nBENCHMARK FOR SELECTION SORT: ");
        aE.benchmarkSelectionSort(week, weekSorted);
        System.out.println("\n\nBENCHMARK FOR HYBRID QUICK-INSERTION SORT: ");
        aE.benchmarkHybridSortQI(week, weekSorted, 15);
        System.out.println("\n\nBENCHMARK FOR HYBRID QUICK-SELECTION SORT: ");
        aE.benchmarkHybridSortQS(week, weekSorted, 15);


        // FIXME: TEST PRINTS FOR PROGRAM FUNCTIONALITY VERIFICATION PROCEDURES.
        // System.out.println(week); // TODO: TEST THE GENERATION OF RANDOM VALUES FOR EVERY DAY IN VARIABLE LIST WEEK
        // System.out.println(weekSorted); // TODO: TEST THE GENERATION OF THE SORTED RANDOM ARRAY FOR EVERY DAY IN VARIABLE LIST WEEKSORTED
    }
}
