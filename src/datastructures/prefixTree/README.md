# Implement a Prefix Tree data structure

Prefix Tree or Trie is a data structure used for faster data lookup and retrieval. It is a multi way tree structure used to store String over an alphabet. It is mainly used for large dictionary of English words and for storing phone book/address book

## Operation Complexity

The time for searching, insertion and deletion is almost identical. Because the code paths followed for each are almost identical.

O(n); 	n - Length of the word  

## Advantages over BST

1. Worst case scenario, a key of length m takes O(m) time. BST performs search by doing O(log m) comparisons for each Character. So BST takes O(m log m) time in worst case

2. Prefix Tree is more space efficient. Because nodes are shared between keys with common initial subsequences.  