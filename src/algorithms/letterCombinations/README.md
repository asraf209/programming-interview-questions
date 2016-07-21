# Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given [here](./telephone-keypad.jpg)

## Example
Input: Digit string "23"

Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 

## Solutions
We will be using a Queue. 

Read each character of a string. If Queue is empty simply put all those into the Queue. Else, remove elements one by one from Queue and add each char with all those elements and insert them back into the Queue. 
