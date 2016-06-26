package graph.recommendedCourses;

import java.util.Arrays;

public class RecommendedCourses {

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
	}
}
