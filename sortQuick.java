import java.util.ArrayList;
import java.util.List;

public class sortQuick {
    // ----------------------------------------------------------------
    // Declares values for quick sort and reversed quick sort methods.
    // ----------------------------------------------------------------
    public static List<Integer> quickSort(List<Integer> Array, int elements) {
        List<Integer> arr = new ArrayList<>(Array);
        int i=0,L,R,pivot, arraySize = arr.size() + 1;
        int[] beg = new int[arraySize], end = new int[arraySize];
        beg[0]=0;
        end[0]=elements;
        while(i>=0) {
            L=beg[i];
            R=end[i]-1;
            if(L<R) {
                pivot=arr.get(L); if(i==arraySize-1) return arr;
                while(L<R) {
                    while(arr.get(R) >= pivot && L < R ) R--; if(L < R) arr.set(L++, arr.get(R));
                    while(arr.get(L) <= pivot && L < R) L++; if(L < R) arr.set(R--, arr.get(L));
                }
                arr.set(L, pivot);
                beg[i+1]=L+1;
                end[i+1]=end[i];
                end[i++]=L;
            } else {
                i--;
            }
        }
        return arr;
    }

    public static List<Integer> quickSortReverse(List<Integer> Array, int elements) {
        List<Integer> arr = new ArrayList<>(Array);
        int i=0,L,R,pivot, arraySize = arr.size() + 1;
        int[] beg = new int[arraySize], end = new int[arraySize];
        beg[0]=0;
        end[0]=elements;
        while(i>=0) {
            L=beg[i];
            R=end[i]-1;
            if(L<R) {
                pivot=arr.get(L); if(i==arraySize-1) return arr;
                while(L<R) {
                    while(arr.get(R) <= pivot && L < R ) R--; if(L < R) arr.set(L++, arr.get(R));
                    while(arr.get(L) >= pivot && L < R) L++; if(L < R) arr.set(R--, arr.get(L));
                }
                arr.set(L, pivot);
                beg[i+1]=L+1;
                end[i+1]=end[i];
                end[i++]=L;
            } else {
                i--;
            }
        }
        return arr;
    }


    // ----------------------------------------------------------------
    // Main method for testing the quick sort algorithm outside the class.
    // -----------------------------------------------------------------
    public static void main(String[] args) {
        List<Integer> amountItems = new ArrayList<Integer>();
        for (int i = 1; i < 8; i++){
            // amountItems.add(getRandomNumbers(8));
            amountItems.add(1);
        }
        List<Integer> sortedList = quickSort(amountItems, amountItems.size());
        List<Integer> sortedBackwards = quickSortReverse(amountItems, amountItems.size());
        System.out.println("Un-sorted list: " + amountItems);
        System.out.println("Sorted list: " + sortedList);
        System.out.println("Reversed list: " + sortedBackwards);

        quickSort(amountItems, amountItems.size());
    }
}