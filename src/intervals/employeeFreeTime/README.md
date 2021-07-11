# Employee Free Time

We are given a list <code>schedule</code> of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping <code>Intervals</code>, and these intervals are in sorted order.

Return the list of finite intervals representing <b>common, positive-length free time</b> for all employees, also in sorted order.

Even though we are representing <code>Intervals</code> in the form <code>[x, y]</code>, the objects inside are Intervals, not lists or arrays. 
For example, <code>schedule[0][0].start = 1, schedule[0][0].end = 2,</code> and <code>schedule[0][0][0]</code> is not defined).  Also, we wouldn't include intervals like <code>[5, 5]</code> in our answer, as they have zero length

 


## Examples
### Example1
Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]	</br>
Output: [[3,4]]

Explanation: There are a total of three employees, and all common free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

### Example2
Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]	</br>
Output: [[5,6],[7,9]]

### Example3
Input: schedule = [[[7,24],[29,33],[45,57],[66,69],[94,99]],[[6,24],[43,49],[56,59],[61,75],[80,81]],[[5,16],[18,26],[33,36],[39,57],[65,74]],[[9,16],[27,35],[40,55],[68,71],[78,81]],[[0,25],[29,31],[40,47],[57,87],[91,94]]]	</br>
Output: [[26,27],[36,39],[87,91]]