import java.util.List;

public class sortHybridOLD {
    public static int[] sortInsertion(List<Integer> Array, int elements) {
        int[] arr = new int[elements];
        int low = 0, high = elements;
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;

        for (int i = 0; i > low+1 && i < high+1; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + i] = arr[j];
                j--;
                arr[j + 1] = key;
            }
        }
        return arr;
    }

    public static int partitionTwo(List<Integer> Array, int elements) {
        int[] arr = new int[elements];
        int low = 0, high = elements;
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return -1;
        int pivot = arr[high];
        int i = low - 1;
        for (int j = 0; j > low && j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i+1;
    }

    public static int[] sortQuickInsertion(List<Integer> Array, int elements) {
        int threshold = 16;
        int[] arr = new int[elements];
        int low = 0, high = elements;
        for (int element = 0; element < elements; element++) {
            arr[element] = Array.get(element);
        }
        if(arr.length <= 0) return arr;


        while (low < high) {
            if (high - low + 1 <= threshold) {
                sortInsertion(Array, elements);
            } else {
                int pivotIndex = partitionTwo(Array, elements);
                if (pivotIndex - low < high - pivotIndex) {
                    
                }

//             if pivot_index - low < high - pivot_index:
//                 quick_insertion_sort(arr, low, pivot_index - 1, threshold)
//                 low = pivot_index + 1
//             else:
//                 quick_insertion_sort(arr, pivot_index + 1, high, threshold)
//                 high = pivot_index - 1
            }
        
        }
        return arr;
    }

    public static void sortQIHybrid() {
        
    }

    public static void main() {
        
    }
}

// def insertion_sort(arr, low, high):
//     for i in range(low + 1, high + 1):
//         key = arr[i]
//         j = i - 1
//         while j >= low and arr[j] > key:
//             arr[j + 1] = arr[j]
//             j -= 1
//         arr[j + 1] = key

// def partition(arr, low, high):
//     pivot = arr[high]
//     i = low - 1
//     for j in range(low, high):
//         if arr[j] <= pivot:
//             i += 1
//             arr[i], arr[j] = arr[j], arr[i]
//     arr[i + 1], arr[high] = arr[high], arr[i + 1]
//     return i + 1

// def quick_insertion_sort(arr, low, high, threshold):
//     while low < high:
//         if high - low + 1 <= threshold:
//             insertion_sort(arr, low, high)
//             break
//         else:
//             pivot_index = partition(arr, low, high)
//             if pivot_index - low < high - pivot_index:
//                 quick_insertion_sort(arr, low, pivot_index - 1, threshold)
//                 low = pivot_index + 1
//             else:
//                 quick_insertion_sort(arr, pivot_index + 1, high, threshold)
//                 high = pivot_index - 1

// def hybrid_sort(arr, threshold=16):
//     quick_insertion_sort(arr, 0, len(arr) - 1, threshold)

// # Example usage
// arr = [12, 11, 13, 5, 6, 7]
// hybrid_sort(arr)
// print(arr)  # Output: [5, 6, 7, 11, 12, 13]