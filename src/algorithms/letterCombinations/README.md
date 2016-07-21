# Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given [here](./telephone-keypad.jpg)

## Example
Input: Digit string "23"

Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 

## Solutions
We will be using a Queue. Read each character from a string and add it will all the contens of the Queue. Remove the content from Queue before doing the addition. Also insert it back in the Queue after addition.