# Nearest Neighbor City

A number of cities are arranged on a graph that has been divided up like an ordinary Cartesian plane. Each city is located at an integral <code>(x, y)</code> coordinate intersection. City names and locations are given in the form of three arrays: <code>c</code>, <code>x</code>, and <code>y</code>, which are aligned by the index to provide the city name <code>(c[i])</code>, and its coordinates, <code>(x[il, y[i])</code>. 

Determine the name of the nearest city that shares either an <code>x</code> or a <code>y</code> coordinate with the queried city. If no other cities share an <code>x</code> or <code>y</code> coordinate, return NONE. If two cities have the same distance to the queried city, <code>q[i]</code>, consider the one with an alphabetically smaller name <code>(i.e. 'ab' < 'aba' < 'abb')</code> as the closest choice. The distance is denoted on a Euclidean plane: the difference in <code>x</code> plus the difference in <code>y</code>.

## Examples
### [Sample 1](./Sample1.PNG) </br>
n = 3 </br>
c = [c1, c2, c3] </br>
x = [3, 2, 1] </br>
y = [3, 2, 3] </br>
q = [c1, c2, c3] </br></br>
Output: [c3, NONE, c1]

### [Sample 2](./Sample2.PNG) </br>
n = 3 </br>
c = [fastcity, bigbanana, xyz] </br>
x = [23, 23, 23] </br>
y = [1, 10, 20] </br>
q = [fastcity, bigbanana, xyz] </br></br>
Output: [bigbanana, fastcity, bigbanana]

### [Sample 3](./Sample3.PNG) </br>
n = 3 </br>
c = [london, warshaw, hackerland] </br>
x = [1, 10, 20] </br>
y = [1, 10, 10] </br>
q = [london, warshaw, hackerland] </br></br>
Output: [NONE, hackerland, warshaw]

### [Sample 4](./Sample4.PNG) </br>
n = 5 </br>
c = [green, red, blue, yellow, pink] </br>
x = [100, 200, 300, 400, 500] </br>
y = [100, 200, 300, 400, 500] </br>
q = [green, red, blue, yellow, pink] </br></br>
Output: [NONE, NONE, NONE, NONE, NONE]