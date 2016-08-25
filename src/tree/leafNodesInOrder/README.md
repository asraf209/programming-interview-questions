# Traverse leaf nodes In-Order

Given a binary tree, take all leaf nodes in-order and, put them in a LinkedList and return the list

## Example

	   	   4		
	 	 /   \		
		2     5
	  / \		\
	 1	 3		 6
  
Return: 1->3->6


## Complexity
	Time: O(N)
	
	Space: O(log N) 
	This is due to the recursive function calls along the Tree height