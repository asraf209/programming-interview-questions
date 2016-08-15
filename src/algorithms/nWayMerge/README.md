# N-way merge

A 2-way merge is widely studied as a part of Merge sort algorithm. But we are interested here to find out the best way one can perform an N-way merge

Lets say, we have N(=100) files which have sorted 1 million integers each. We have to merge them into 1 single file which will have those 100 million sorted integers.


## Solutions

1. Create a priority queue
+ Iterate through each file f
	1. Enqueue the pair (nextNumberIn(f), f) using the first value as priority key.
+ While queue not empty
	1. dequeue head (m, f) of queue
	2. output m
	3. if f not depleted
		1. enqueue (nextNumberIn(f), f)


## Complexity

Since adding elements to a priority queue can be done in logarithmic time, item 2 is O(N × log N). Since (almost all) iterations of the while loop adds an element, the whole while-loop is O(M × log N) where M is the total number of numbers to sort.

Assuming all files have a non-empty sequence of numbers, we have M > N and thus the whole algorithm should be O(M × log N).