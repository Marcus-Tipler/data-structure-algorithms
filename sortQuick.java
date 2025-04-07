import java.util.ArrayList;
import java.util.List;

public class sortQuick {

    public static List<Integer> sorterQuick(List<Integer> listItems) {
        List<Integer> database = new ArrayList<>(listItems);
        if (database.size() < 2) {
			return database;
		}
        else {
            int leftBound = 0;
            int rightBound = database.size() - 1;
            hoarePartition(database, leftBound, rightBound);
            return database;
        }
    }


    public static List<Integer> sorterQuickReversed(List<Integer> listItems) {
        List<Integer> database = new ArrayList<>(listItems);
        if (database.size() < 2) {
			return database;
		}
        else {
            int leftBound = 0;
            int rightBound = database.size() - 1;
            hoarePartitionReverse(database, leftBound, rightBound);
            return database;
        }
    }


    public static void hoarePartition(List<Integer> database, int leftBound, int rightBound) {
        if (leftBound >= rightBound)
			return; // indices have crossed;
		int pivot = database.get(rightBound);
		int leftInd = leftBound; // will scan leftward
		int rightInd = rightBound - 1;// will scan right until lager than the pivot
		while (leftInd <= rightInd) { // scan right until larger than the pivot
			while ((leftInd <= rightInd) && (database.get(leftInd) <= pivot)) {
				leftInd++;
			}
			while ((rightInd >= leftInd) && (database.get(rightInd) >= pivot)) {
				rightInd--;
			}
			if (leftInd < rightInd) { // both elements were found so swap

				Swap(database, leftInd, rightInd);
			}
		} // loop continues until indices cross
		Swap(database, rightBound, leftInd);
		hoarePartition(database, leftBound, leftInd - 1); // left recursive call
		hoarePartition(database, leftInd + 1, rightBound); // right recursive call
	}


    public static void hoarePartitionReverse(List<Integer> database, int leftBound, int rightBound) {
        if (leftBound >= rightBound)
			return; // indices have crossed;
		int pivot = database.get(rightBound);
		int leftInd = leftBound; // will scan leftward
		int rightInd = rightBound - 1;// will scan right until lager than the pivot
		while (leftInd <= rightInd) { // scan right until larger than the pivot
			while ((leftInd <= rightInd) && (database.get(leftInd) >= pivot)) {
				leftInd++;
			}
			while ((rightInd >= leftInd) && (database.get(rightInd) <= pivot)) {
				rightInd--;
			}
			if (leftInd < rightInd) { // both elements were found so swap

				Swap(database, leftInd, rightInd);
			}
		} // loop continues until indices cross
		Swap(database, rightBound, leftInd);
		hoarePartitionReverse(database, leftBound, leftInd - 1); // left recursive call
		hoarePartitionReverse(database, leftInd + 1, rightBound); // right recursive call
	}

    // ----------------------------------------------------------------
    // Method for swapping a partition in the array.
    // -----------------------------------------------------------------
    public static void Swap(List<Integer> database, int j, int i) {
		int temp = database.get(j);
		database.set(j, database.get(i));
		database.set(i, temp);
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
        List<Integer> sortedBackwards = sorterQuickReversed(amountItems);
        System.out.println("Un-sorted list: " + amountItems);
        System.out.println("Sorted list: " + sortedList);
        System.out.println("Reversed list: " + sortedBackwards);
    }
}
