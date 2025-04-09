import java.util.Arrays;
import java.util.Stack;

public class sortHybrid {
    public static void main(String[] args) {
        int[] arr = new int[500000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * arr.length);
        }

        System.out.println("Original array: " + Arrays.toString(arr));
        int[] sorted = hybridSort(arr, 10);
        System.out.println("Sorted array: ");
        for (int elements = 0; elements < sorted.length; elements++) {
            System.out.print(sorted[elements] + ", ");
        }
    }

    private static int[] quicksort(int[] arr, int elements, int threshold) {
        if(arr.length <= 0) return arr;

        // Add a threshold detection
        if (arr.length <= threshold) {
            insertionSort(arr, elements - 1, threshold);
            return arr;
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);
            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
        return arr;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low; i < high; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Use Quicksort's partitioning scheme to select a pivot element
        int pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hybrid method that combines Quicksort and Insertion Sort
    private static int[] hybridSort(int[] arr, int threshold) {
        int[] sorted = quicksort(arr, arr.length, threshold);
        return sorted;
    }
}