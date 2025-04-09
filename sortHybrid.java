import java.util.ArrayList;
import java.util.List;

public class sortHybrid {

    static sortInsertion sI = new sortInsertion();
    static sortQuick sQ = new sortQuick();
    static sortSelection sS = new sortSelection();

    public int[] hybridSortQI(List<Integer> Array, int elements, int threshold) {
        int[] arr = new int[elements];
        List<List<Integer>> subList = new ArrayList<>();
        List<Integer> ArrayCopy = new ArrayList<>(Array);
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
        
        // creates sub-lists of the size of the threshold for the sort algorithms
        for (int i = 0; i < elements; i += threshold) {
            // Create sublist from i to i + threshold or the end of the list
            subList.add(Array.subList(i, Math.min(i + threshold, elements)));
        }


        int index = 0;
        for (int i = 0; i < subList.size(); i++) {
            List<Integer> cache = new ArrayList<>(subList.get(i));
            int[] cacheSorted = sI.insertionSort(cache, cache.size());
            for (int j = 0; j < cacheSorted.length; j++) {
                ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr
            }
        }

        // Sort the entire array using quicksort
        arr = sQ.quickSort(ArrayCopy, ArrayCopy.size());
        
        return arr;
    }

    public int[] hybridSortQS(List<Integer> Array, int elements, int threshold) {
        int[] arr = new int[elements];
        List<List<Integer>> subList = new ArrayList<>();
        List<Integer> ArrayCopy = new ArrayList<>(Array);
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
        
        // creates sub-lists of the size of the threshold for the sort algorithms
        for (int i = 0; i < elements; i += threshold) {
            // Create sublist from i to i + threshold or the end of the list
            subList.add(Array.subList(i, Math.min(i + threshold, elements)));
        }


        int index = 0;
        for (int i = 0; i < subList.size(); i++) {
            List<Integer> cache = new ArrayList<>(subList.get(i));
            int[] cacheSorted = sS.selectionSort(cache, cache.size());
            for (int j = 0; j < cacheSorted.length; j++) {
                ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr
            }
        }

        // Sort the entire array using quicksort
        arr = sQ.quickSort(ArrayCopy, ArrayCopy.size());
        
        return arr;
    }


    public static void main(String[] args) {
        sortHybrid sH = new sortHybrid();

        List<Integer> amountItems = new ArrayList<>();
        for (int i = 1; i < 32; i++){
            // amountItems.add(getRandomNumbers(8));
            amountItems.add( (int) ((Math.random() * (500 - 1)) + 1) );
        }

        int[] sortedListQI = sH.hybridSortQI(amountItems, amountItems.size(), 16);
        int[] sortedListQS = sH.hybridSortQS(amountItems, amountItems.size(), 16);

        System.out.println("Un-sorted list: " + amountItems);
        System.out.println("\nSorted list QI: ");
        for (int element = 0; element < sortedListQI.length; element++) {
            System.out.print(sortedListQI[element] + " ");
        }
        System.out.println("\nSorted list QS: ");
        for (int element = 0; element < sortedListQS.length; element++) {
            System.out.print(sortedListQS[element] + " ");
        }
    }
}
