import java.util.Arrays;

public class sortHybrid {
    public static void main(String[] args) {
        int[] arr = new int[500000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * arr.length);
        }

        System.out.println("Original array: " + Arrays.toString(arr));
        hybridSort(arr, arr.length, 500000);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    private static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array using Quicksort's partitioning scheme
            int pivot = partition(arr, low, high);
            // Recursively sort the left and right subarrays
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
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
    private static void hybridSort(int[] arr, int n, int threshold) {
        if (n <= threshold) {
            insertionSort(arr, 0, n);
        } else {
            quicksort(arr, 0, n - 1);
            for (int i = n / 2; i < n; i++) {
                insertionSort(arr, i, n - 1);
            }
        }
    }
}