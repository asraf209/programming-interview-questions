package graph.courseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		// (prerequisiteCourse, listOfFolowingCoursesWeCanTake)
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		// Populate graph as adjacency list
		for(int[] array : prerequisites) {
			int course = array[0];
			int prerequisite = array[1];
			
			if(!map.containsKey(prerequisite))	map.put(prerequisite, new ArrayList<Integer>());
			map.get(prerequisite).add(course);
		}
		
		boolean[] visited = new boolean[numCourses];
		for(int currentCourse=0; currentCourse<numCourses; currentCourse++) {
			if(isCycle(currentCourse, map, visited)) {
				return false;
			}
		}
		
        return true;
    }
	
	private static boolean isCycle(int currentCourse, Map<Integer, List<Integer>> map, boolean[] visited) {
		// We came to the start node after traversing. Its a loop.
		if(visited[currentCourse])	return true;
		
		// No following course. No loop
		if (!map.containsKey(currentCourse))	return false;
		
		// Before backtracking, mark the node as visited
		visited[currentCourse] = true;
		
		// Backtracking
		boolean cycleFound = false;
		for(int followingCourse : map.get(currentCourse)) {
			cycleFound= isCycle(followingCourse, map, visited);
			if (cycleFound) {
				break;
			}
		}
		
		// After backtracking, free up the node. So that others can also traverse this
		visited[currentCourse] = false;
		return cycleFound;
	}

	public static void main(String args[]) {
		// Sample 1
		int numOfCourses1 = 2;
		int[][] prerequisites1 = new int[][] {{1,0}};
		System.out.println(canFinish(numOfCourses1, prerequisites1));
				
		// Sample 2
		int numOfCourses2 = 2;
		int[][] prerequisites2 = new int[][] {{1,0},{0,1}};
		System.out.println(canFinish(numOfCourses2, prerequisites2));
	}
}
