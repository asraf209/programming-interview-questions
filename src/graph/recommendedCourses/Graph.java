package graph.recommendedCourses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<String, List<String>> users;		// Users with their direct friends
	Map<String, List<String>> courses;		// Courses taken by an User
	
	public Graph(){
		users 	= new HashMap<>();
		courses = new HashMap<>();
	}			
	
	public void addFriends(String user, List<String> newFriends){
		if(users.containsKey(user)){
			List<String> friends = users.get(user);
			friends.addAll(newFriends);
			users.put(user, friends);
		}
		else{
			users.put(user, newFriends);			
		}
	}
	
	public List<String> getDirectFriendsForUser(String user){
		if(users.containsKey(user))
			return users.get(user);
		else
			return null;
	}
	
	public void addCourses(String user, List<String> newCourses){
		if(users.containsKey(user)){
			if(courses.containsKey(user)){
				List<String> attendedCourses = courses.get(user);
				attendedCourses.addAll(newCourses);
				courses.put(user, attendedCourses);
			}
			else{
				courses.put(user, newCourses);
			}
		}
	}
	
	public List<String> getAttendedCoursesForUser(String user){
		if(users.containsKey(user))
			return courses.get(user);
		else
			return null;
	}

	@Override
	public String toString() {
		return "Graph [users=" + users + ", \n courses=" + courses + "]";
	}
	
}