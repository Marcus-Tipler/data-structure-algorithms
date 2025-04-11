# Algorithms and Approach
On the subject of the approach: I decided to compartmentalise the primary methods of my program in to their own class files. This makes things easier to diagnose and debug.

# What's different?


# Screenshots and Overview


```java
import java.util.ArrayList;

import java.util.List;

import java.util.Stack;

  

public class sortQuick {

// ----------------------------------------------------------------

// Declares values for quick sort and reversed quick sort methods.

// ----------------------------------------------------------------

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

public int[] quickSortReverse(List<Integer> Array, int elements) {

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

  

int pivotIdx = partitionReverse(arr, low, high);

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

private int partition(int[] arr, int low, int high){

if(arr.length <= 0) return -1;

if(low >= high) return -1;

int l = low;

int r = high;

  

int pivot = arr[l];

while(l < r){

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

private int partitionReverse(int[] arr, int low, int high){

if(arr.length <= 0) return -1;

if(low >= high) return -1;

int l = low;

int r = high;

  

int pivot = arr[l];

while(l < r){

while(l < r && arr[r] <= pivot){

r--;

}

arr[l] = arr[r];

while(l < r && arr[l] >= pivot){

l++;

}

arr[r] = arr[l];

}

arr[l] = pivot;

return l;

}

  

// ----------------------------------------------------------------

// Main method for testing the quick sort algorithm outside the class.

// -----------------------------------------------------------------

public static void main(String[] args) {

sortQuick sQ = new sortQuick();

  
  

List<Integer> amountItems = new ArrayList<>();

for (int i = 1; i < 8; i++){

// amountItems.add(getRandomNumbers(8));

amountItems.add(i);

}

// List<Integer> sortedList = quickSort(amountItems, amountItems.size());

// List<Integer> sortedBackwards = quickSortReverse(amountItems, amountItems.size());

int[] sortedList = sQ.quickSort(amountItems, amountItems.size());

int[] sortedListReverse = sQ.quickSortReverse(amountItems, amountItems.size());

  

System.out.println("Un-sorted list: " + amountItems);

System.out.print("Sorted list: ");

for (int element = 0; element < sortedList.length; element++) {

System.out.print(sortedList[element] + " ");

}

System.out.println("");

System.out.print("Sorted list (in reverse): ");

for (int element = 0; element < sortedListReverse.length; element++) {

System.out.print(sortedListReverse[element] + " ");

}

System.out.println("");

// System.out.println("Reversed list: " + sortedBackwards);

  

sQ.quickSort(amountItems, amountItems.size());

}

}
```

```java
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
```

```java
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

for (int i = 1; i < 8; i++){

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
```

```java
import java.util.ArrayList;

import java.util.List;

  

public class sortHybrid {

  

static sortInsertion sI = new sortInsertion();

static sortQuick sQ = new sortQuick();

static sortSelection sS = new sortSelection();

  

public int[] hybridSortQI(List<Integer> Array, int elements, int threshold) {

int[] arr = new int[elements];

List<List<Integer>> subList = new ArrayList<>();

List<Integer> ArrayCopy = new ArrayList<>(Array);

for (int element = 0; element < elements; element++) {

arr[element] = Array.get(element);

}

if(arr.length <= 0) return arr;

// creates sub-lists of the size of the threshold for the sort algorithms

for (int i = 0; i < elements; i += threshold) {

// Create sublist from i to i + threshold or the end of the list

subList.add(Array.subList(i, Math.min(i + threshold, elements)));

}

  
  

int index = 0;

for (int i = 0; i < subList.size(); i++) {

List<Integer> cache = new ArrayList<>(subList.get(i));

int[] cacheSorted = sI.insertionSort(cache, cache.size());

for (int j = 0; j < cacheSorted.length; j++) {

ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr

}

}

  

// Sort the entire array using quicksort

arr = sQ.quickSort(ArrayCopy, ArrayCopy.size());

return arr;

}

public int[] hybridSortQIReverse(List<Integer> Array, int elements, int threshold) {

int[] arr = new int[elements];

List<List<Integer>> subList = new ArrayList<>();

List<Integer> ArrayCopy = new ArrayList<>(Array);

for (int element = 0; element < elements; element++) {

arr[element] = Array.get(element);

}

if(arr.length <= 0) return arr;

// creates sub-lists of the size of the threshold for the sort algorithms

for (int i = 0; i < elements; i += threshold) {

// Create sublist from i to i + threshold or the end of the list

subList.add(Array.subList(i, Math.min(i + threshold, elements)));

}

  
  

int index = 0;

for (int i = 0; i < subList.size(); i++) {

List<Integer> cache = new ArrayList<>(subList.get(i));

int[] cacheSorted = sI.insertionSortReverse(cache, cache.size());

for (int j = 0; j < cacheSorted.length; j++) {

ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr

}

}

  

// Sort the entire array using quicksort

arr = sQ.quickSortReverse(ArrayCopy, ArrayCopy.size());

return arr;

}

  

public int[] hybridSortQS(List<Integer> Array, int elements, int threshold) {

int[] arr = new int[elements];

List<List<Integer>> subList = new ArrayList<>();

List<Integer> ArrayCopy = new ArrayList<>(Array);

for (int element = 0; element < elements; element++) {

arr[element] = Array.get(element);

}

if(arr.length <= 0) return arr;

// creates sub-lists of the size of the threshold for the sort algorithms

for (int i = 0; i < elements; i += threshold) {

// Create sublist from i to i + threshold or the end of the list

subList.add(Array.subList(i, Math.min(i + threshold, elements)));

}

  
  

int index = 0;

for (int i = 0; i < subList.size(); i++) {

List<Integer> cache = new ArrayList<>(subList.get(i));

int[] cacheSorted = sS.selectionSort(cache, cache.size());

for (int j = 0; j < cacheSorted.length; j++) {

ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr

}

}

  

// Sort the entire array using quicksort

arr = sQ.quickSort(ArrayCopy, ArrayCopy.size());

return arr;

}

public int[] hybridSortQSReverse(List<Integer> Array, int elements, int threshold) {

int[] arr = new int[elements];

List<List<Integer>> subList = new ArrayList<>();

List<Integer> ArrayCopy = new ArrayList<>(Array);

for (int element = 0; element < elements; element++) {

arr[element] = Array.get(element);

}

if(arr.length <= 0) return arr;

// creates sub-lists of the size of the threshold for the sort algorithms

for (int i = 0; i < elements; i += threshold) {

// Create sublist from i to i + threshold or the end of the list

subList.add(Array.subList(i, Math.min(i + threshold, elements)));

}

  
  

int index = 0;

for (int i = 0; i < subList.size(); i++) {

List<Integer> cache = new ArrayList<>(subList.get(i));

int[] cacheSorted = sS.selectionSortReverse(cache, cache.size());

for (int j = 0; j < cacheSorted.length; j++) {

ArrayCopy.set(index++, cacheSorted[j]); // Copy sorted elements back into arr

}

}

  

// Sort the entire array using quicksort

arr = sQ.quickSortReverse(ArrayCopy, ArrayCopy.size());

return arr;

}

  
  

public static void main(String[] args) {

sortHybrid sH = new sortHybrid();

  

List<Integer> amountItems = new ArrayList<>();

for (int i = 1; i < 32; i++){

// amountItems.add(getRandomNumbers(8));

amountItems.add( (int) ((Math.random() * (500 - 1)) + 1) );

}

  

int[] sortedListQI = sH.hybridSortQI(amountItems, amountItems.size(), 16);

int[] sortedListQS = sH.hybridSortQS(amountItems, amountItems.size(), 16);

int[] sortedListQIReverse = sH.hybridSortQIReverse(amountItems, amountItems.size(), 16);

int[] sortedListQSReverse = sH.hybridSortQSReverse(amountItems, amountItems.size(), 16);

  

System.out.println("Un-sorted list: " + amountItems);

System.out.println("\nSorted list QI: ");

for (int element = 0; element < sortedListQI.length; element++) {

System.out.print(sortedListQI[element] + " ");

}

System.out.println("\nSorted list QS: ");

for (int element = 0; element < sortedListQS.length; element++) {

System.out.print(sortedListQS[element] + " ");

}

System.out.println("\nSorted list QI (reversed): ");

for (int element = 0; element < sortedListQIReverse.length; element++) {

System.out.print(sortedListQIReverse[element] + " ");

}

System.out.println("\nSorted list QS (reversed): ");

for (int element = 0; element < sortedListQSReverse.length; element++) {

System.out.print(sortedListQSReverse[element] + " ");

}

}

}
```

```java
import java.util.ArrayList;

import java.util.List;

  

public class benchmarkRun {

  

public benchmarkRun() {

super();

}

  
  

// ----------------------------------------------------------

// Imports the sorting algorithm and print classes.

// ----------------------------------------------------------

static benchmarkHuman bH = new benchmarkHuman();

static benchmarkComputer bC = new benchmarkComputer();

static sortQuick sQ = new sortQuick();

  
  

// ----------------------------------------------------------

// Main method to run all of the benchmarks.

// ----------------------------------------------------------

public static void main(String[] args) {

// Create a new instance of the java class (common practice).

benchmarkRun bR = new benchmarkRun();

  

// Variables for array sizes per day.

int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};

// Initializing variables for the sorted and reversed lists.

List<Integer> day, daySorted;

ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();

int[] sortedNormal;

  

// Creates an array of unsorted integers of the size specified.

for (int i = 0; i < amountItems.length; i++) {

day = bH.createArray(amountItems[i]);

week.add(day);

}

  

// Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sortedNormal = sQ.quickSort(day, day.size());

  

daySorted = new ArrayList<>(day);

for (int element = 0; element < sortedNormal.length; element++) {

daySorted.set(element, sortedNormal[element]);

}

weekSorted = new ArrayList<>(week);

for (i = 0; i < week.size(); i++) {

weekSorted.set(i, daySorted);

}

}

  

// prints the benchmark results in a human-readable format.

System.out.println("\n----------------------------------------\n");

System.out.println("HUMAN READABLE BENCHMARK RESULTS:\n\n");

bH.printHumanReadable(week, weekSorted);

// prints the benchmark results in a computer-readable format.

System.out.println("\n----------------------------------------\n");

System.out.println("COMPUTER READABLE BENCHMARK RESULTS:\n\n");

bC.printComputerReadable(week, weekSorted);

System.out.println("");

System.out.println("\n----------------------------------------\n");

// aE.printComputerReadable(week, weekSorted);

  
  

// FIXME: TEST PRINTS FOR PROGRAM FUNCTIONALITY VERIFICATION PROCEDURES.

// System.out.println(week); // TODO: TEST THE GENERATION OF RANDOM VALUES FOR EVERY DAY IN VARIABLE LIST WEEK

// System.out.println(weekSorted); // TODO: TEST THE GENERATION OF THE SORTED RANDOM ARRAY FOR EVERY DAY IN VARIABLE LIST WEEKSORTED

}

}
```

```java
import java.util.ArrayList;

import java.util.List;

  

public class benchmarkHuman {

  

// ----------------------------------------------------------

// Imports the sorting algorithm classes.

// ----------------------------------------------------------

static sortHybrid sH = new sortHybrid();

static sortQuick sQ = new sortQuick();

static sortInsertion sI = new sortInsertion();

static sortSelection sS = new sortSelection();

  
  

// ----------------------------------------------------------

// Creates an array of random integers of the size specified.

// ----------------------------------------------------------

public List<Integer> createArray(int amountItems) {

List<Integer> itemsWeek = new ArrayList<>();

for (int i = 0; i < amountItems; i++) {

int intRandom = getRandomNumber(amountItems);

itemsWeek.add(intRandom);

}

return itemsWeek;

}

  
  

// ----------------------------------------------------------

// Generates a random number between 1 and the maximum specified.

// ----------------------------------------------------------

public int getRandomNumber(int max) {

return (int) ((Math.random() * (max - 1)) + 1);

}

  
  

// ----------------------------------------------------------

// Calculates the delta between start and end time for benchmarking.

// ----------------------------------------------------------

public long calculateTime(long clockOrigin, long clockOut) {

long clockDelta = clockOut - clockOrigin;

System.out.println("Execution Time: " + clockDelta + "ms.");

return clockDelta;

}

  
  

// ----------------------------------------------------------

// Benchmarks the sorting algorithms with different scenarios.

// ----------------------------------------------------------

public void benchmarkQuickSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

  

// Starts the LOOP & TIMER for Unsorted List.

System.out.println("unsorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sQ.quickSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

System.out.println("unsorted list (reversed): ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sQ.quickSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

System.out.println("pre-sorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sQ.quickSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

System.out.println("\nProgram Benchmark Results: ");

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println("Average Execution Time: " + clockAverage + "ms");

}

public void benchmarkInsertionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

System.out.println("unsorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sI.insertionSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

System.out.println("unsorted list (reversed): ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sI.insertionSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

System.out.println("pre-sorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sI.insertionSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

System.out.println("\nProgram Benchmark Results: ");

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println("Average Execution Time: " + clockAverage + "ms");

}

public void benchmarkSelectionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

System.out.println("unsorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sS.selectionSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

System.out.println("unsorted list (reversed): ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sS.selectionSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

System.out.println("pre-sorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sS.selectionSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

System.out.println("\nProgram Benchmark Results: ");

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println("Average Execution Time: " + clockAverage + "ms");

}

public void benchmarkHybridSortQI(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER Unsorted List.

System.out.println("unsorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

System.out.println("unsorted list (reversed): ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQIReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

System.out.println("pre-sorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

System.out.println("\nProgram Benchmark Results: ");

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println("Average Execution Time: " + clockAverage + "ms");

}

public void benchmarkHybridSortQS(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

System.out.println("unsorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

System.out.println("unsorted list (reversed): ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQSReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

System.out.println("pre-sorted list: ");

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

System.out.println("\nProgram Benchmark Results: ");

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println("Average Execution Time: " + clockAverage + "ms");

}

  
  

// ----------------------------------------------------------

// Prints the benchmark results in a human-readable format.

// ----------------------------------------------------------

public void printHumanReadable(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

System.out.println("BENCHMARK FOR QUICK SORT: ");

benchmarkQuickSort(week, weekSorted);

System.out.println("\n\nBENCHMARK FOR INSERTION SORT: ");

benchmarkInsertionSort(week, weekSorted);

System.out.println("\n\nBENCHMARK FOR SELECTION SORT: ");

benchmarkSelectionSort(week, weekSorted);

System.out.println("\n\nBENCHMARK FOR HYBRID QUICK-INSERTION SORT: ");

benchmarkHybridSortQI(week, weekSorted, 16);

System.out.println("\n\nBENCHMARK FOR HYBRID QUICK-SELECTION SORT: ");

benchmarkHybridSortQS(week, weekSorted, 6);

}

  
  

// ----------------------------------------------------------

// Main method to run the human-readable benchmark.

// ----------------------------------------------------------

public static void main(String[] args) {

// Create a new instance of the java class (common practice).

benchmarkHuman bH = new benchmarkHuman();

  

// Variables for array sizes per day.

int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};

// Initializing variables for the sorted and reversed lists.

List<Integer> day, daySorted;

ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();

int[] sortedNormal;

  

// Creates an array of unsorted integers of the size specified.

for (int i = 0; i < amountItems.length; i++) {

day = bH.createArray(amountItems[i]);

week.add(day);

}

  

// Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sortedNormal = sQ.quickSort(day, day.size());

  

daySorted = new ArrayList<>(day);

for (int element = 0; element < sortedNormal.length; element++) {

daySorted.set(element, sortedNormal[element]);

}

weekSorted = new ArrayList<>(week);

for (i = 0; i < week.size(); i++) {

weekSorted.set(i, daySorted);

}

}

  

// prints the benchmark results in a human-readable format.

bH.printHumanReadable(week, weekSorted);

}

  

}
```

```java
import java.util.ArrayList;

import java.util.List;

  

public class benchmarkComputerThreshold {

  

// ----------------------------------------------------------

// Imports the sorting algorithm classes.

// ----------------------------------------------------------

static sortHybrid sH = new sortHybrid();

static sortQuick sQ = new sortQuick();

static sortInsertion sI = new sortInsertion();

static sortSelection sS = new sortSelection();

  
  

// ----------------------------------------------------------

// Creates an array of random integers of the size specified.

// ----------------------------------------------------------

public List<Integer> createArray(int amountItems) {

List<Integer> itemsWeek = new ArrayList<>();

for (int i = 0; i < amountItems; i++) {

int intRandom = getRandomNumber(amountItems);

itemsWeek.add(intRandom);

}

return itemsWeek;

}

  
  

// ----------------------------------------------------------

// Generates a random number between 1 and the maximum specified.

// ----------------------------------------------------------

public int getRandomNumber(int max) {

return (int) ((Math.random() * (max - 1)) + 1);

}

  
  

// ----------------------------------------------------------

// Calculates the delta between start and end time for benchmarking.

// ----------------------------------------------------------

public long calculateTime(long clockOrigin, long clockOut) {

long clockDelta = clockOut - clockOrigin;

return clockDelta;

}

  
  

// ----------------------------------------------------------

// Benchmarks the sorting algorithms with different scenarios.

// ----------------------------------------------------------

public void benchmarkHybridSortQI(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQIReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println(threshold + "," + clockAverage);

}

public void benchmarkHybridSortQS(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQSReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.println(threshold + "," + clockAverage);

}

  
  

// ----------------------------------------------------------

// Prints the benchmark results in a computer-readable format.

// ----------------------------------------------------------

public void printComputerReadable(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

System.out.println("threshold,averagetime");

for (int threshold = 5; threshold <= 25; threshold++) {

benchmarkHybridSortQI(week, weekSorted, threshold);

}

System.out.println("\nthreshold,averagetime");

for (int threshold = 5; threshold <= 25; threshold++) {

benchmarkHybridSortQS(week, weekSorted, threshold);

}

}

  
  

// ----------------------------------------------------------

// Main method to run the computer-readable benchmark.

// ----------------------------------------------------------

public static void main(String[] args) {

// Create a new instance of the java class (common practice).

benchmarkComputerThreshold bCt = new benchmarkComputerThreshold();

  

// Variables for array sizes per day.

int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};

// Initializing variables for the sorted and reversed lists.

List<Integer> day, daySorted;

ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();

int[] sortedNormal;

  

// Creates an array of unsorted integers of the size specified.

for (int i = 0; i < amountItems.length; i++) {

day = bCt.createArray(amountItems[i]);

week.add(day);

}

  

// Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sortedNormal = sQ.quickSort(day, day.size());

  

daySorted = new ArrayList<>(day);

for (int element = 0; element < sortedNormal.length; element++) {

daySorted.set(element, sortedNormal[element]);

}

weekSorted = new ArrayList<>(week);

for (i = 0; i < week.size(); i++) {

weekSorted.set(i, daySorted);

}

}

  

// prints the benchmark results in a computer-readable format.

bCt.printComputerReadable(week, weekSorted);

}

}
```

```java
import java.util.ArrayList;

import java.util.List;

  

public class benchmarkComputer {

  

// ----------------------------------------------------------

// Imports the sorting algorithm classes.

// ----------------------------------------------------------

static sortHybrid sH = new sortHybrid();

static sortQuick sQ = new sortQuick();

static sortInsertion sI = new sortInsertion();

static sortSelection sS = new sortSelection();

  
  

// ----------------------------------------------------------

// Creates an array of random integers of the size specified.

// ----------------------------------------------------------

public List<Integer> createArray(int amountItems) {

List<Integer> itemsWeek = new ArrayList<>();

for (int i = 0; i < amountItems; i++) {

int intRandom = getRandomNumber(amountItems);

itemsWeek.add(intRandom);

}

return itemsWeek;

}

  
  

// ----------------------------------------------------------

// Generates a random number between 1 and the maximum specified.

// ----------------------------------------------------------

public int getRandomNumber(int max) {

return (int) ((Math.random() * (max - 1)) + 1);

}

  
  

// ----------------------------------------------------------

// Calculates the delta between start and end time for benchmarking.

// ----------------------------------------------------------

public long calculateTime(long clockOrigin, long clockOut) {

long clockDelta = clockOut - clockOrigin;

return clockDelta;

}

  
  

// ----------------------------------------------------------

// Benchmarks the sorting algorithms with different scenarios.

// ----------------------------------------------------------

public void benchmarkQuickSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

  

// Starts the LOOP & TIMER for Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sQ.quickSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sQ.quickSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sQ.quickSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.print("quicksort," + clockNormal + "," + clockReverse + "," + clockSorted + "," + clockAverage);

}

public void benchmarkInsertionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sI.insertionSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sI.insertionSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sI.insertionSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.print("insertionsort," + clockNormal + "," + clockReverse + "," + clockSorted + "," + clockAverage);

}

public void benchmarkSelectionSort(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sS.selectionSort(day, day.size());

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sS.selectionSortReverse(day, day.size());

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sS.selectionSort(day, day.size());

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.print("selectionsort," + clockNormal + "," + clockReverse + "," + clockSorted + "," + clockAverage);

}

public void benchmarkHybridSortQI(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQIReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQI(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.print("hybridqisort," + clockNormal + "," + clockReverse + "," + clockSorted + "," + clockAverage);

}

public void benchmarkHybridSortQS(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted, int threshold) {

List<Integer> day;

long clockStart, clockNormal, clockReverse, clockSorted, clockAverage;

// Starts the LOOP & TIMER for Unsorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockNormal = System.currentTimeMillis();

clockNormal = calculateTime(clockStart, clockNormal);

  

// Starts the LOOP & TIMER for Unsorted List (reversed).

clockStart = System.currentTimeMillis();

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sH.hybridSortQSReverse(day, day.size(), threshold);

}

clockReverse = System.currentTimeMillis();

clockReverse = calculateTime(clockStart, clockReverse);

  

// Starts the LOOP & TIMER for Sorted List.

clockStart = System.currentTimeMillis();

for (int i = 0; i < weekSorted.size(); i++) {

day = weekSorted.get(i);

sH.hybridSortQS(day, day.size(), threshold);

}

clockSorted = System.currentTimeMillis();

clockSorted = calculateTime(clockStart, clockSorted);

  

// Computes average time between three pre-computed scenario times to make a benchmark.

clockAverage = (clockNormal + clockReverse + clockSorted) / 3 ;

System.out.print("hybridqssort," + clockNormal + "," + clockReverse + "," + clockSorted + "," + clockAverage);

}

  
  

// ----------------------------------------------------------

// Prints the benchmark results in a computer-readable format.

// ----------------------------------------------------------

public void printComputerReadable(ArrayList<List<Integer>> week, ArrayList<List<Integer>> weekSorted) {

System.out.println("title,normalsort,reversesort,sortedsort,averagetime");

benchmarkQuickSort(week, weekSorted);

System.out.println("");

benchmarkInsertionSort(week, weekSorted);

System.out.println("");

benchmarkSelectionSort(week, weekSorted);

System.out.println("");

benchmarkHybridSortQI(week, weekSorted, 16);

System.out.println("");

benchmarkHybridSortQS(week, weekSorted, 6);

}

  
  

// ----------------------------------------------------------

// Main method to run the computer-readable benchmark.

// ----------------------------------------------------------

public static void main(String[] args) {

// Create a new instance of the java class (common practice).

benchmarkComputer bC = new benchmarkComputer();

  

// Variables for array sizes per day.

int[] amountItems = {1000, 5000, 10000, 50000, 75000, 100000, 500000};

// Initializing variables for the sorted and reversed lists.

List<Integer> day, daySorted;

ArrayList<List<Integer>> week = new ArrayList<>(), weekSorted = new ArrayList<>();

int[] sortedNormal;

  

// Creates an array of unsorted integers of the size specified.

for (int i = 0; i < amountItems.length; i++) {

day = bC.createArray(amountItems[i]);

week.add(day);

}

  

// Pre-computes the LOOP for NormalQuickSort with Unsorted List to make Sorted List.

for (int i = 0; i < week.size(); i++) {

day = week.get(i);

sortedNormal = sQ.quickSort(day, day.size());

  

daySorted = new ArrayList<>(day);

for (int element = 0; element < sortedNormal.length; element++) {

daySorted.set(element, sortedNormal[element]);

}

weekSorted = new ArrayList<>(week);

for (i = 0; i < week.size(); i++) {

weekSorted.set(i, daySorted);

}

}

  

// prints the benchmark results in a computer-readable format.

bC.printComputerReadable(week, weekSorted);

}

}
```

1. **Introduction**:

* Briefly introduce the topic of benchmarking sort algorithms.

* Mention the purpose of the code: comparing different sorting algorithms (e.g., QuickSort, InsertionSort, SelectionSort, HybridSort) and their performance under various conditions.

2. **Code Structure**:

* Describe the overall structure of the code, including classes, methods, variables, and data structures used.

* Highlight the main components:

+ `benchmarkComputer` class: responsible for creating arrays, pre-computing results, and printing the benchmark results.

+ Sorting algorithms (e.g., QuickSort, InsertionSort, SelectionSort) implemented in separate classes or methods.

3. **Sorting Algorithms**:

* Describe each sorting algorithm used in the code, including:

+ QuickSort: a popular, efficient sorting algorithm with an average time complexity of O(n log n).

+ InsertionSort: a simple, linear-time sorting algorithm suitable for small datasets.

+ SelectionSort: another simple, linear-time sorting algorithm that's easy to understand but less efficient than QuickSort.

+ HybridSort (QI and QS): combining elements from multiple algorithms to achieve better performance.

4. **Benchmarking**:

* Explain the approach used to benchmark the sorting algorithms:

+ Creating arrays of different sizes (e.g., 1000, 5000, 10000) to test the algorithms under varying conditions.

+ Pre-computing results for each algorithm to facilitate comparison and printing of results.

5. **Results**:

* Summarize the printed benchmark results, highlighting any notable observations or findings, such as:

+ Which algorithm performed best under which conditions?

+ Any surprising or unexpected results?

6. **Conclusion**:

* Recap the main points discussed in your report.

* Provide some final thoughts on the importance of benchmarking and comparing different sorting algorithms to understand their strengths and weaknesses.

  

Remember to also follow any specific guidelines or requirements set by your instructor or assignment. Good luck with your report!