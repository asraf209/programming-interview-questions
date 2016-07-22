# Merge k sorted lists

Merge K sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


## Example

Input:	k = 3

	{ {1, 3, 5, 7},	<br />
    	{2, 4, 6, 8},	<br />
         {0, 9, 10, 11}} 


Output: 0 1 2 3 4 5 6 7 8 9 10 11 

## Solutions:
1) Same as merging two sorted lists. First merge two sorted lists. Then merge the next list with the output of earlier merge

Time complexity: O(m1+m2+m3+.....+mn)	<br />
Space complexity: O(m1+m2+m3+.....+mn)

2) Another approach is to use a MinHeap. Make a MinHeap of K nodes, taking each of them(Head) from K list respectively. <br /> 
   The root of the Heap will contain the minimum Node. Take it out from Heap and store in the output list <br />
   Replace Heap root with the next Node from the list from which the Node was extracted
   
   Time complexity: O(m1+m2+m3+.....+mn)*logK	<br />
   Space complexity: O(m1+m2+m3+.....+mn)