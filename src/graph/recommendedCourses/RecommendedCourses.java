package graph.recommendedCourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecommendedCourses {

	class Course implements Comparable<Course>{
		String name;
		int count;
		
		public Course(String name, int count){
			this.name = name;
			this.count = count;
		}

		@Override
		public int compareTo(Course o) {
			int comp = o.count - this.count;	// Sort by count
			return comp==0?this.name.compareTo(o.name):comp;	// Also by name. For Math 101 and Eng 101, Eng 101 will come first
		}				
	}
	
	public List<String> getRankedCourses(Graph sn, String user){
		if(user==null)	return null;
		Set<String> visitedUsers = new HashSet<>();
		Map<String, Integer> courseMap = new HashMap<>();
		
		int depth = 1;
		List<String> users = new ArrayList<>();
		users.add(user);
		
		Set<String> attendedCourses = new HashSet<>(sn.getAttendedCoursesForUser(user));
		
		while(depth < 3){
			List<String> nextUserSet = new ArrayList<>();
			for(String u : users){
				// For each user, get their direct friends and courses
				for(String friend : sn.getDirectFriendsForUser(u)){
					if(!visitedUsers.contains(friend)){
						List<String> attendedCoursesByFriend = sn.getAttendedCoursesForUser(friend);
						
						for(String course : attendedCoursesByFriend){
							if(!attendedCourses.contains(course)){
								if(courseMap.containsKey(course))
									courseMap.put(course, courseMap.get(course)+1);
								else
									courseMap.put(course, 1);
							}
						}
						nextUserSet.add(friend);
					}
				}
				visitedUsers.add(u);
			}
			users = nextUserSet;
			depth++;
		}
		
		Course[] courseList = new Course[courseMap.size()];
		int i=0;
		for(String key : courseMap.keySet()){
			Course aCourse = new Course(key, courseMap.get(key));
			courseList[i] = aCourse;
			i++;
		}
		Arrays.sort(courseList);
		
		List<String> rankedCourses = new ArrayList<>();
		for(Course c : courseList)
			rankedCourses.add(c.name);
		
		return rankedCourses;
	}
	
	public static void main(String[] args) {	
		Graph sn = new Graph();
		//String[] users = {"Sam", "Bob", "Matt", "Vim", "Ubuntu"};
		sn.addFriends("Sam", Arrays.asList(new String[]{"Bob", "Vim"}));
		sn.addFriends("Bob", Arrays.asList(new String[]{"Sam", "Matt", "Ubuntu"}));
		sn.addFriends("Vim", Arrays.asList(new String[]{"Sam", "Matt", "Ubuntu"}));
		sn.addFriends("Matt", Arrays.asList(new String[]{"Bob", "Vim", "Jan"}));
		sn.addFriends("Ubuntu", Arrays.asList(new String[]{"Bob", "Vim", "Nancy", "Mamy"}));
		sn.addFriends("Mamy", Arrays.asList(new String[]{"Bob", "Ubuntu"}));
		sn.addFriends("Nancy", Arrays.asList(new String[]{"Ubuntu"}));
		sn.addFriends("Jan", Arrays.asList(new String[]{"Matt"}));
		
		sn.addCourses("Mamy", Arrays.asList(new String[]{"101", "103"}));
		sn.addCourses("Bob", Arrays.asList(new String[]{"104"}));
		sn.addCourses("Ubuntu", Arrays.asList(new String[]{"102", "105"}));
		sn.addCourses("Sam", Arrays.asList(new String[]{"101", "102"}));
		sn.addCourses("Matt", Arrays.asList(new String[]{"102"}));
		sn.addCourses("Vim", Arrays.asList(new String[]{"107"}));
		sn.addCourses("Jan", Arrays.asList(new String[]{"102", "106"}));
		sn.addCourses("Nancy", Arrays.asList(new String[]{"101", "104"}));
		
		System.out.println(sn);
		
		RecommendedCourses rc = new RecommendedCourses();
		System.out.println(rc.getRankedCourses(sn, "Mamy"));
	}
}
