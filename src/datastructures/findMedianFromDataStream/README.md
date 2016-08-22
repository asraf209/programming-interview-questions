# Find median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: <br /> 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure. <br />
double findMedian() - Return the median of all elements so far. <br />


## Example
add(1)	<br />
add(2)  <br />
findMedian() -> 1.5 <br />
add(3)  <br />
findMedian() -> 2 
