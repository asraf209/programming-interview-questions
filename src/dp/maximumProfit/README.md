# Maximum Profit in Job Scheduling

We have <code>n</code> jobs, where every job is scheduled to be done from <code>startTime[i]</code> to <code>endTime[i]</code>, obtaining a profit of <code>profit[i]</code>.

You're given the <code>startTime</code>, <code>endTime</code> and <code>profit</code> arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time <code>X</code> you will be able to start another job that starts at time <code>X</code>.


## Example:

### [Sample 1](./Sample1.PNG)
Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]

Output: 120

Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

### [Sample 2](./Sample2.PNG)
Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]

Output: 150

Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.

### [Sample 3](./Sample3.PNG)
Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]

Output: 6