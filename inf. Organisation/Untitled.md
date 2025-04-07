// Sorts (a portion of) an array, divides it into partitions, then sorts those
algorithm quicksort(A, lo, hi) is 
  if lo >= 0 && hi >= 0 && lo < hi then
    p := partition(A, lo, hi) 
    quicksort(A, lo, p) // Note: the pivot is now included
    quicksort(A, p + 1, hi) 

// Divides array into two partitions
algorithm partition(A, lo, hi) is 
// Pivot value
pivot := A[lo] // Choose the first element as the pivot

// Left index
i := lo - 1 

// Right index
j := hi + 1

loop forever 
// Move the left index to the right at least once and while the element at
// the left index is less than the pivot
do i := i + 1 while A[i] < pivot

// Move the right index to the left at least once and while the element at
// the right index is greater than the pivot
do j := j - 1 while A[j] > pivot

// If the indices crossed, return
if i >= j then return j

// Swap the elements at the left and right indices
swap A[i] with A[j]



Employs two pointers, i and j, starting at the beginning and end of the array, respectively.

Moves i forward until an element greater than or equal to the pivot is found.

Moves j backward until an element less than or equal to the pivot is found.

Swaps the elements at i and j if they are out of place.

Continues until i and j cross, placing the pivot in its sorted position.

```python
    
    def quickSort(self,nums,left,right):
        if (left >= right):
            return
        p = nums[left]
        i = left
        j = right
        while (i != j):
            while (j > i) and nums[j] > p:
                j -= 1
            nums[i],nums[j] = nums[j],nums[i]
            while (i < j) and nums[i] <= p:
                i += 1
            nums[i],nums[j] = nums[j],nums[i]
        self.quickSort(nums,left,i-1)
        self.quickSort(nums,i+1,right)
        # print(nums)
        
    def quickArraySort(self,nums):
        left = 0
        right = len(nums) - 1
        self.quickSort(nums,left,right)
```

```python
def hoare_partition(arr, low, high):
    pivot = arr[low]
    i = low - 1
    j = high + 1

    while(True):
        i += 1
        while (arr[i] < pivot):
            i += 1
        j -= 1
        while (arr[j] > pivot):
            j -= 1
        if( i >= j):
            return j
        arr[i], arr[j] = arr[j],arr[i]

def quickSort(arr,low,high):
    if (low < high):
        pi = hoare_partition(arr,low,high)

        quickSort(arr,low, pi)
        quickSort(arr, pi+1, high)
```

