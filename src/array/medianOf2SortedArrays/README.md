# Median of two sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


## Example
nums1 = [1, 3]	<br />
nums2 = [2]

The median is 2.0

nums1 = [1, 2]	<br />
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

nums1 = [1, 5, 9, 10, 15, 20]	<br />
nums2 = [2, 3, 8, 13]

The median is (8 + 9)/2 = 8.5


## Solutions
### Trivial with extra space
1. Merge two Arrays in a separate one of size (m+n). 
-  Find the median from it

Space: O(m + n) <br /> 
Time: O(m + n)

### Trivial without extra space
1. Merge Arrays starting from the last element of 2nd Array
-  Compare Array1[last] with Array2[last]. If Array1[last] > Array2[last] swap them. Place the element in Array1 to the right position. (Insertion sort) 
-  When Array2 is done, stop
-  Now find the median considering size = Size(Array1) + Size(Array2)

Space: O(1) <br /> 
Time: O(m * n)

### O(log (m + n)) Solution
