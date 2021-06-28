# Pour Water

You are given an elevation map represents as an integer array <code>heights</code>, where <code>heights[i]</code> representing the height of the terrain at index <code>i</code>. The width at each index is 1. You are also given two integers <code>volume</code> and <code>k</code>. <code>volume</code> units of water will fall at index <code>k</code>.

Water first drops at the index <code>k</code> and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:

- If the droplet would eventually fall by moving left, then move left.
- Otherwise, if the droplet would eventually fall by moving right, then move right.
- Otherwise, rise to its current position.

Here, <b>"eventually fall"</b> means that the droplet will eventually be at a lower level if it moves in that direction. Also, level means the height of the terrain plus any water in that column.

We can assume there is infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly on more than one grid block, and each unit of water has to be in exactly one block.


## Example 1

Input: heights = [2,1,1,2,1,2,2](./example1.png), volume = 4, k = 3 </br>
Output: [2,2,2,3,2,2,2]
