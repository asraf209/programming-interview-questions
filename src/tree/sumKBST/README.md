# Find two numbers in BST whose sum is k 

Given a binary search tree, find two numbers in the tree whose sum is k. If there are no such elements, state so. Assume that the tree is balanced. 

O(n) solution with O(log n) space was expected

## Example

Input: [Binary Search Tree](./bst.png) 

If k=32 return {12, 20}

If k=35 return {15, 20}

## Solution

The idea is same as finding the pair in sorted array. We traverse BST in Normal In-Order and Reverse In-Order simultaneously. In reverse inorder, we start from the rightmost node which is the maximum value node. In normal inorder, we start from the left most node which is minimum value node. We add sum of current nodes in both traversals and compare this sum with given target sum. 

If the sum is same as target sum, we return true. If the sum is more than target sum, we move to next node in reverse inorder traversal, otherwise we move to next node in normal inorder traversal. If any of the traversals is finished without finding a pair, we return false.