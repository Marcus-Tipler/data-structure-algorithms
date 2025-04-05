import java.util.ArrayList;
import java.util.List;

public class algorithmEfficiency {

    public static List<Integer> createArray(int amountItems) {
        List<Integer> itemsWeek = new ArrayList<Integer>();
        for (int i = 0; i < amountItems; i++) {
            int intRandom = getRandomNumber(amountItems);
            itemsWeek.add(intRandom);
        }
        return itemsWeek;
    }

    public static int getRandomNumber(int max) {
        return (int) ((Math.random() * (max - 1)) + 1);
    }

    public static void main(String[] args) {
        int[] amountItems = {1000 / 1000, 5000 / 1000, 10000 / 1000, 50000 / 1000, 75000 / 1000, 100000 / 10000, 500000 / 10000};
        List<Integer> week;
        for (int i = 0; i < amountItems.length; i++) {
            week = createArray(amountItems[i]);
            System.out.println(week);
        }
        System.out.println("\n\n");


        // long startTime = System.currentTimeMillis();

    }
}
