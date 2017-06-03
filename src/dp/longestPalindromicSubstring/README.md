# Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


## Examples
If the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.

## Solutions
### Method 1 ( Brute Force ) 
The simple approach is to check each substring whether the substring is a palindrome or not. We can run three loops, the outer two loops pick all substrings one by one by fixing the corner characters, the inner loop checks whether the picked substring is palindrome or not.

Time complexity: O ( n^3 ) <br />
Space complexity: O ( 1 )

### Methhod 2 ( Dynamic Programming )
Based on http://articles.leetcode.com/longest-palindromic-substring-part-i/

For "abcba", "bcb" is a palindrome. Now if we add char on their both sides "abcba" it still a palindrome. We just need to check that if the chars we are adding(0, 4) are same and rest of the string(1-3) is a palindrome. 

