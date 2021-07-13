# Course Schedule

There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [ai, bi]</code> indicates that you must take course <code>bi</code> first if you want to take course <code>ai</code>.

For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.
Return <code>true</code> if you can finish all courses. Otherwise, return <code>false</code>.

## Examples
### Sample 1
Input: numCourses = 2, prerequisites = [[1,0]]

Output: true

Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

### Sample 2
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]

Output: false

Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

## Solution
Basically this is a graph traversal problem, where we just need to identify if there any [cycle](./CyclicGraph.PNG) exists. 
Or in other words, if its a DAG.

Return <code>'true'</code> if its a DAG. <code>'false'</code> otherwise