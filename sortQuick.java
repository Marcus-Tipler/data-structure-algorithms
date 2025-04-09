import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class sortQuick {
    // ----------------------------------------------------------------
    // Declares values for quick sort and reversed quick sort methods.
    // ----------------------------------------------------------------
    public int[] quickSort(List<Integer> Array, int elements) {
        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
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
    public int[] quickSortReverse(List<Integer> Array, int elements) {
        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();
            int low = stack.pop();

            int pivotIdx = partitionReverse(arr, low, high);
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
    private int partition(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];
        while(l < r){
            while(l < r && arr[r] >= pivot){ 
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }
    private int partitionReverse(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];
        while(l < r){
            while(l < r && arr[r] <= pivot){ 
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] >= pivot){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;
        return l;
    }

    // ----------------------------------------------------------------
    // Main method for testing the quick sort algorithm outside the class.
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        sortQuick sQ = new sortQuick();


        List<Integer> amountItems = new ArrayList<>();
        for (int i = 1; i < 8; i++){
            // amountItems.add(getRandomNumbers(8));
            amountItems.add(i);
        }
        // List<Integer> sortedList = quickSort(amountItems, amountItems.size());
        // List<Integer> sortedBackwards = quickSortReverse(amountItems, amountItems.size());
        int[] sortedList = sQ.quickSort(amountItems, amountItems.size());
        int[] sortedListReverse = sQ.quickSortReverse(amountItems, amountItems.size());

        System.out.println("Un-sorted list: " + amountItems);
        System.out.print("Sorted list: ");
        for (int element = 0; element < sortedList.length; element++) {
            System.out.print(sortedList[element] + " ");
        }
        System.out.println("");
        System.out.print("Sorted list (in reverse): ");
        for (int element = 0; element < sortedListReverse.length; element++) {
            System.out.print(sortedListReverse[element] + " ");
        }
        System.out.println("");
        // System.out.println("Reversed list: " + sortedBackwards);

        sQ.quickSort(amountItems, amountItems.size());
    }
}