import java.util.ArrayList;
import java.util.List;

public class sortInsertion {
    public int[] insertionSort(List<Integer> Array, int elements){

        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;

        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        return arr;
    }

    public int[] insertionSortReverse(List<Integer> Array, int elements){

        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;

        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] >= arr[j] )
                    break;
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        sortInsertion sI = new sortInsertion();

        List<Integer> amountItems = new ArrayList<>();
        for (int i = 1; i < 500000; i++){
            // amountItems.add(getRandomNumbers(8));
            amountItems.add(i);
        }

        int[] sortedList = sI.insertionSort(amountItems, amountItems.size());
        int[] sortedListReverse = sI.insertionSortReverse(amountItems, amountItems.size());

        System.out.println("Un-sorted list: " + amountItems);
        System.out.print("Sorted list: ");
        for (int element = 0; element < sortedList.length; element++) {
            System.out.print(sortedList[element] + " ");
        }
        System.out.println("");
        System.out.print("Sorted list (reversed): ");
        for (int element = 0; element < sortedListReverse.length; element++) {
            System.out.print(sortedListReverse[element] + " ");
        }
        System.out.println("");
    }
}
