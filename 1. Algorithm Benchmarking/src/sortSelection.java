import java.util.ArrayList;
import java.util.List;

public class sortSelection {
    public int[] selectionSort(List<Integer> Array, int elements){
        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public int[] selectionSortReverse(List<Integer> Array, int elements){
        int[] arr = new int[elements];
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        sortSelection sS = new sortSelection();

        List<Integer> amountItems = new ArrayList<>();
        for (int i = 1; i < 32; i++){
            // amountItems.add(getRandomNumbers(8));
            amountItems.add( (int) ((Math.random() * (500 - 1)) + 1) );
        }

        int[] sortedList = sS.selectionSort(amountItems, amountItems.size());
        int[] sortedListReverse = sS.selectionSortReverse(amountItems, amountItems.size());

        System.out.println("Un-sorted list: " + amountItems);
        System.out.print("Sorted list: ");
        for (int element = 0; element < sortedList.length; element++) {
            System.out.print(sortedList[element] + " ");
        }
        System.out.println("");
        System.out.print("Sorted list (reverse): ");
        for (int element = 0; element < sortedListReverse.length; element++) {
            System.out.print(sortedListReverse[element] + " ");
        }
    }
}
