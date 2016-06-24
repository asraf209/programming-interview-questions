package graph.mutualFriends;

public class FindMutualFriends {
		
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
	}
}
