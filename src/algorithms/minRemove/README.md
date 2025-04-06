# Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

## Example
**Example 1:**

Input: s = "lee(t(c)o)de)" <br />
Output: "lee(t(c)o)de" <br />
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

**Example 2:**

Input: s = "a)b(c)d" <br />
Output: "ab(c)d" <br />

**Example 3:**

Input: s = "))((" <br />
Output: "" <br />
Explanation: An empty string is also valid.