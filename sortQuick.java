import java.util.ArrayList;
import java.util.List;

public class sortQuick {
    public static List<Integer> sorterQuick(List<Integer> listItems) {
        List<Integer> sortedList = new ArrayList<>(listItems);
        int pivot = listItems.get(0);
        int low = - 1;
        int high = listItems.size();
        while (true) { 
            low++;
            while (listItems.get(low) > pivot) {
                low++;
            }
            high--;
            while (listItems.get(high) > pivot) {
                high--;
            }
            if (low >= high) {
                return sortedList;
            }
            int temp = listItems.get(low);
            sortedList.set(low, listItems.get(high));
            sortedList.set(high, temp);
        }
    }


    public static List<Integer> sorterReverseQuick(List<Integer> listItems) {
        List<Integer> reversedList = new ArrayList<>(listItems);
        int pivot = listItems.get(0);
        int low = - 1;
        int high = listItems.size();
        while (true) { 
            low++;
            while (listItems.get(low) < pivot) {
                low++;
            }
            high--;
            while (listItems.get(high) < pivot) {
                high--;
            }
            if (low >= high) {
                return reversedList;
            }
            int temp = listItems.get(low);
            reversedList.set(low, listItems.get(high));
            reversedList.set(high, temp);
        }
    }


    public static void main(String[] args) {
        List<Integer> amountItems = new ArrayList<Integer>();
        for (int i = 1; i < 8; i++){
            amountItems.add(i);
        }

        List<Integer> sortedList = sorterQuick(amountItems);
        List<Integer> sortedBackwards = sorterReverseQuick(amountItems);
        System.out.println(sortedList);
        System.out.println(sortedBackwards);
    }
}
