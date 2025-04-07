import java.util.ArrayList;
import java.util.List;

public class algorithmEfficiency extends sortQuick {

    public algorithmEfficiency() {
        super();
    }

    public List<Integer> createArray(int amountItems) {
        List<Integer> itemsWeek = new ArrayList<Integer>();
        for (int i = 0; i < amountItems; i++) {
            int intRandom = getRandomNumber(amountItems);
            itemsWeek.add(intRandom);
        }
        return itemsWeek;
    }

    public int getRandomNumber(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }

    public static void main(String[] args) {
        algorithmEfficiency aE = new algorithmEfficiency();

        int[] amountItems = {1000 / 1000, 5000 / 1000, 10000 / 1000, 50000 / 1000, 75000 / 1000, 100000 / 10000, 500000 / 10000};
        List<Integer> week;
        List<Integer> weekSorted;
        List<Integer> weekSortedReverse;
        for (int i = 0; i < amountItems.length; i++) {
            week = aE.createArray(amountItems[i]);
            weekSorted = sorterQuick(week);
            System.out.println(week);
            System.out.println(weekSorted);
        }
        System.out.println("\n\n");


        // long startTime = System.currentTimeMillis();

    }
}
