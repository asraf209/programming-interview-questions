# Find maximum height of a cell in 2D array

Given a 2D array which represents a landscape, <code>0</code> being sea and <code>1</code> being land, find the maximum possible height of the building that you can build on any land. 

The height of a sea cell is <code>0</code>, meaning you can't build any building over there.

Height of a land, from its neighbor should not go beyond <code>1</code>

## Example

0, 1, 1, 1, 1, 1	</br>
1, 1, 1, 1, 1, 1	</br>
1, 1, 1, 1, 1, 1	</br>
1, 1, 1, 1, 1, 1	</br>
1, 1, 1, 1, 1, 0	</br>

0, 1, 2, 3, 4, 4	</br>
1, 1, 2, 3, 3, 3	</br>
2, 2, 3, 3, 2, 2	</br>
3, 3, 3, 2, 1, 1	</br>
4, 4, 3, 2, 1, 0	</br>

<b>Note:</b> We can start from a sea <code>0</code> (basepoint), keep exploring other points and then backtrack (DFS). But that will lead to us in a situation where the constraint (no two building should have height gap of more than 1) wont meet.

That's why we need to start exploring from all basepoints <code>(0)</code> at once. And then keep exploring their adjacent, and then their adjacent, and so on (BFS)