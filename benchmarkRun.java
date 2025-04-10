import java.util.ArrayList;
import java.util.List;

public class benchmarkRun {

    public benchmarkRun() {
        super();
    }


    // ----------------------------------------------------------
    // Imports the sorting algorithm and print classes. 
    // ----------------------------------------------------------
    static benchmarkHuman bH = new benchmarkHuman();
    static benchmarkComputer bC = new benchmarkComputer();
    static sortQuick sQ = new sortQuick();


    // ----------------------------------------------------------
    // Main method to run all of the benchmarks.
    // ----------------------------------------------------------
    public static void main(String[] args) {
        // Create a new instance of the java class (common practice).
        benchmarkRun bR = new benchmarkRun();

        // Variables for array sizes per day.
        int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};
        
        // Initializing variables for the sorted and reversed lists.
        List<Integer> day, daySorted;
        ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();
        int[] sortedNormal;

        // Creates an array of unsorted integers of the size specified.
        for (int i = 0; i < amountItems.length; i++) { 
            day = bH.createArray(amountItems[i]);
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

        // prints the benchmark results in a human-readable format.
        System.out.println("\n----------------------------------------\n");
        System.out.println("HUMAN READABLE BENCHMARK RESULTS:\n\n");
        bH.printHumanReadable(week, weekSorted);
        // prints the benchmark results in a computer-readable format.
        System.out.println("\n----------------------------------------\n");
        System.out.println("COMPUTER READABLE BENCHMARK RESULTS:\n\n");
        bC.printComputerReadable(week, weekSorted);
        System.out.println("");
        System.out.println("\n----------------------------------------\n");
        // aE.printComputerReadable(week, weekSorted);


        // FIXME: TEST PRINTS FOR PROGRAM FUNCTIONALITY VERIFICATION PROCEDURES.
        // System.out.println(week); // TODO: TEST THE GENERATION OF RANDOM VALUES FOR EVERY DAY IN VARIABLE LIST WEEK
        // System.out.println(weekSorted); // TODO: TEST THE GENERATION OF THE SORTED RANDOM ARRAY FOR EVERY DAY IN VARIABLE LIST WEEKSORTED
    }
}
