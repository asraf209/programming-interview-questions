# Flatten Binary Tree to Linked List

Given a binary tree, flatten it to a linked list in-place.

## Example

Given

	   	   1		
	 	 /   \		
		2     5
	  / \		\
	 3	 4		 6
  
The flattened tree should look like:

	1
	 \
	  2
	   \ 
	    3
	     \
	      4
	       \
	        5
	         \ 
	          6


## Complexity
	Time: O(N)
	
	Space: O(log N) 
	This is due to the recursive function calls along the Tree height