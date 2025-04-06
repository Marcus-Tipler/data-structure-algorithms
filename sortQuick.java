import java.util.ArrayList;
import java.util.List;

public class sortQuick {

    public static List<Integer> sorterQuick(List<Integer> listItems) {
        List<Integer> sortedList = new ArrayList<>(listItems);
        int pivot = sortedList.get(0);
        int low = - 1;
        int high = listItems.size();
        if (low < high) {
            List<Integer> pi = hoarePartition(sortedList);
            sorterQuick(pi);
        }
        return sortedList;
    }


    public static List<Integer> hoarePartition(List<Integer> listItems) {
        List<Integer> sortedList = new ArrayList<>(listItems);
        int pivot = sortedList.get(0);
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


    public static List<Integer> hoarePartitionReverse(List<Integer> listItems) {
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

    public static int getRandomNumbers(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }


    public static void main(String[] args) {
        List<Integer> amountItems = new ArrayList<Integer>();
        for (int i = 1; i < 8; i++){
            amountItems.add(getRandomNumbers(8));
        }

        List<Integer> sortedList = sorterQuick(amountItems);
        // List<Integer> sortedBackwards = sorterReverseQuick(amountItems);
        System.out.println("Un-sorted list: " + amountItems);
        System.out.println("Sorted list: " + sortedList);
        // System.out.println("Reversed list: " + sortedBackwards);
    }
}
