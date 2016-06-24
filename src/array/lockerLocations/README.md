# Locker Locations

Let say, some company wants to undertake locker service across country. They want to ensure that lockers are placed so that customers in the city are always within a short distance from a Locker. You need to model locker placements and distances from lockers.

m - Length of the city in city blocks [1-9]
n - Width of the city in city blocks [1-9]
[x1, x2....] - X coordinates representing locker locations [1-9]
[y1, y2....] - Y coordinates representing locker locations [1-9]

Your job is to construct a 2-D grid of the City. Each element of the grid should be a positive whole number that specifies the # of blocks to the closest lockers. 

The distance between two lockers is the sum of their horizontal and vertical distance. Return the grid as 2-D array of integers where the first index corresponds to X dimension and the second index corresponds to the Y direction.

## Example

Given <br />
3	<br />
5	<br />
[1]	<br />
[1]	<br />

Return <br />
[		<br />
0, 1, 2	<br />
1, 2, 3	<br />
2, 3, 4	<br />
3, 4, 5	<br />
4, 5, 6	<br />
]


Given <br />
5	<br />
7	<br />
[2, 4]	<br />
[3, 7]	<br />

Return <br />
[	<br />
3, 2, 3, 4, 5	<br />
2, 1, 2, 3, 4	<br />
1, 0, 1, 2, 3	<br />
2, 1, 2, 3, 4	<br />
3, 2, 3, 2, 3	<br />
4, 3, 2, 1, 2	<br />
3, 2, 1, 0, 1	<br />
]