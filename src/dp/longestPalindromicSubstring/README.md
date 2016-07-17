# Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


## Examples
S = “caba”, S’ = “abac” <br />
The longest common substring between S and S’ is “aba”, which is the answer.

If the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.

## Solutions
### Method 1 ( Brute Force ) 
The simple approach is to check each substring whether the substring is a palindrome or not. We can run three loops, the outer two loops pick all substrings one by one by fixing the corner characters, the inner loop checks whether the picked substring is palindrome or not.

Time complexity: O ( n^3 ) <br />
Space complexity: O ( 1 )

### Methhod 2 ( Dynamic Programming )
Based on http://articles.leetcode.com/longest-palindromic-substring-part-i/

 

