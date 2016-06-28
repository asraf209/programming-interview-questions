# Implement Auto-Complete feature

Lets say you have a dictionary of words. Now as you type a word, the program should give you suggested words that are in the dictionary. How do you implement that?

## Solution

We will be using Prefix Tree or Trie data structure. 

## Example

Dictionary Words = ["Kushtia", "Dhaka", "Dhamrai", "Kumar", "DhakaMan"]

Input = "dh"	<br /> 
Output = [DHAMRAI, DHAKA, DHAKAMAN]

Input = "kum" 	<br />
Output = [KUMAR]