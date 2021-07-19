# Max Area of Island

You are given an <code>m x n</code> binary matrix <code>grid</code>. An island is a group of <code>1's</code> (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value <code>1</code> in the island.

Return the maximum area of an island in grid. If there is no island, return <code>0</code>


## Examples
### [Sample 1](./Sample1.PNG)
Input: grid = [ </br>
[0,0,1,0,0,0,0,1,0,0,0,0,0], </br>
[0,0,0,0,0,0,0,1,1,1,0,0,0], </br>
[0,1,1,0,1,0,0,0,0,0,0,0,0], </br>
[0,1,0,0,1,1,0,0,1,0,1,0,0], </br>
[0,1,0,0,1,1,0,0,1,1,1,0,0], </br>
[0,0,0,0,0,0,0,0,0,0,1,0,0], </br>
[0,0,0,0,0,0,0,1,1,1,0,0,0], </br>
[0,0,0,0,0,0,0,1,1,0,0,0,0]] </br>

Output: 6

Explanation: The answer is not 11, because the island must be connected 4-directionally.

### Sample 2
Input: grid = [[0,0,0,0,0,0,0,0]]

Output: 6