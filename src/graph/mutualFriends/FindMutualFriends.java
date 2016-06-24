package graph.mutualFriends;

import java.util.ArrayList;
import java.util.List;

public class FindMutualFriends {
	
	public static List<String> findMutualFriends(Graph g, String user1, String user2){
		if(user1==null || user2==null)	return null;		
		List<String> mutualFriends = new ArrayList<>();
		
		/**
		 * If user2 is in the friendslist of user1's friends they they are mutual
		 */
		for(String friend : g.getAllFriends(user1)){
			if(g.getAllFriends(friend).contains(user2))
				mutualFriends.add(friend);
		}
		
		return mutualFriends;
	}
	
	public static void main(String[] args) {	
		Graph fb = new Graph();
		fb.addFriends("G", new String[]{"A"});
		fb.addFriends("A", new String[]{"G", "B", "C"});
		fb.addFriends("B", new String[]{"A", "E"});
		fb.addFriends("C", new String[]{"A", "E", "D"});
		fb.addFriends("E", new String[]{"K", "B", "C"});
		fb.addFriends("D", new String[]{"C", "J"});
		fb.addFriends("K", new String[]{"E", "F"});
		fb.addFriends("F", new String[]{"K", "J"});
		fb.addFriends("J", new String[]{"D", "F"});
		System.out.println(fb);
		
		System.out.println(findMutualFriends(fb, "A", "B"));
		System.out.println(findMutualFriends(fb, "A", "E"));
		System.out.println(findMutualFriends(fb, "C", "K"));
		System.out.println(findMutualFriends(fb, "A", "J"));
	}
}
