# Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.


## Example

	  1		
	 / \		
	2   3		
  
The root-to-leaf path 1->2 represents the number 12.

The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.


## Complexity
	Time: O(N)
	
	Space: O(log N) 
	This is due to the recursive function calls along the Tree height