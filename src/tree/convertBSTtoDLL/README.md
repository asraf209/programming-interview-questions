# Convert a BST to Doubly Linked List

Given a BST, convert it to a DLL. Values should be kept in order and the program should run in constant time and space. So you are allowed to change the given BST structure.  

## Solution

In-Order traversal. We will be treating left and right pointer of a BST Node as prev and next in a DLL.   

## Example

Input: [BST](./bst.jpg)

Output: 0<->1<->2<->3<->4<->5<->6