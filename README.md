# GOALS 
Build an event driven object-oriented Java program that takes as input an unsorted list of randomly generated integers, implements basic structures and uses algorithms to benchmark different sorting algorithms on the arrays. We will then proceed to compare their respective performances and provide evidence as to which of our tested sorting algorithm is best. 

# MY APPROACH 
Firstly, I decided to compartmentalise individual sorting algorithms in to their own classes for future ease of use. For the ‘Quick Sort’ algorithm I decided to use a stack-based approach, due to tests instantiating that this method drastically improves speeds and uses less memory. For the ‘Hybrid’ sorting classes, I used subarray lists of the size of a given threshold. This means that the sub arrays are only the size of the threshold and can be sorted by themselves before parsing them back in to their primary arrays to be sorted again. I used a combination of ‘Quick Sort’ mixed with either ‘Selection Sort’ or ‘Insertion Sort’ where ‘Quick Sort’ sorts the already sorted subarrays. All of this was planned, and mapped using Kanban and Infinite Canvas to keep track of progress and write out algorithms in Pseudocode before programming them in (find below). 

# EXTRACTS
'Quick-Sort Algorithm'
```java
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
```
```java
private int partition(int[] arr, int low, int high){
	if(arr.length <= 0) return -1;
	if(low >= high) return -1;
	
	int l = low;
	int r = high;
	int pivot = arr[l];
	
	while(l < r) {
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
```

'Insertion-Sort Algorithm'
```java
public int[] insertionSort(List<Integer> Array, int elements) {
	int[] arr = new int[elements];
	
	for (int element = 0; element < elements; element++) {
		arr[element] = Array.get(element);
	}
	
	if(arr.length <= 0) return arr;	  
	
	for( int i=0; i<arr.length-1; i++ ) {
	
		for( int j=i+1; j>0; j-- ) {
		
			if(arr[j - 1] <= arr[j])
				break;
				
			int temp = arr[j];
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
		}
	}
	return arr;
}
```

'Selection-Sort Algorithm'
```java
public int[] selectionSort(List<Integer> Array, int elements) {
	int[] arr = new int[elements];
	for (int element = 0; element < elements; element++) {
		arr[element] = Array.get(element);
	}
	
	if(arr.length <= 0) return arr;
	
	for(int i = 0; i < arr.length-1; i++) {
		int min = i;
		
		for(int j = i+1; j < arr.length; j++) {
			if(arr[j] < arr[min]) {
				min = j;
			}
		}
	
		if(min != i) {
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	return arr;
}
```

'Hybrid-Sort Algorithm'
```java
public int[] hybridSortQI(List<Integer> Array, int elements, int threshold) {
	int[] arr = new int[elements];
	List<List<Integer>> subList = new ArrayList<>();
	List<Integer> ArrayCopy = new ArrayList<>(Array);
	for (int element = 0; element < elements; element++) {
		arr[element] = Array.get(element);
	}
	if(arr.length <= 0) return arr;
	
	for (int i = 0; i < elements; i += threshold) {
		subList.add(Array.subList(i, Math.min(i + threshold, elements)));
	}
	
	int index = 0;
	for (int i = 0; i < subList.size(); i++) {
		List<Integer> cache = new ArrayList<>(subList.get(i));
		// Sort the subarrays using Insertion or Selection sort.
		int[] cacheSorted = sI.insertionSort(cache, cache.size());
	
		for (int j = 0; j < cacheSorted.length; j++) {
			ArrayCopy.set(index++, cacheSorted[j]);
		}
	} 
	// Sort the entire array using quicksort
	arr = sQ.quickSort(ArrayCopy, ArrayCopy.size());
	return arr;
}
```


# BENCHMARKING 
Firstly, to benchmark the hybrid sorting algorithms whilst at their peak efficiency, we needed to test which ‘threshold’ was best for each Hybrid Sort, so ‘benchmarkComputerThreshold.java’ was made, this file outputs a ‘Comma Separated Values (CSV)’ that is readable by Microsoft Excel. Once complete, benchmark performances can be graphed accordingly: