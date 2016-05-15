# Time Travel Map

Make a map data structure with k, timestamp(t) and v. It should support basic Map <key, value> operations (get, put).

Put:

1. k1, t1 -> v1
+ k1, t3 -> v3
+ k2, t3 -> v4
+ k1, t4 -> v5

Get:

1. k1, t1 => v1
+ k1, t2 => v1
+ k1, t6 => v5
+ k2, t2 => None

Given a pair of k and time t, it should map the corresponding value v. 
For any given time t, if it is not in the map then return value from its closest time that happened already.

Example:

for (k1, t2), it is not in the map. So it should return v1; the value of its closest time t1 that happened already.
for (k2, t2), there is no value that happened in or before t2. So return none.
