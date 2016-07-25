# String Permutations, all unique

Print all the permutations of a given String. Given, all characters are unique

## Example
For input String "ABC", there are 6 permutations (n!)

ABC ACB BAC BCA CBA CAB

## Time Complexity
O(!n)

### Note
This program will also work for duplicate characters. We only need to use a Set. So whenever we print a String we check in the Set. If it is not there then print, otherwise discard

Image: ./permutations.gif
