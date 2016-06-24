package graph.mutualFriends;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
	Map<String, Set<String>> map;	
	
	public Graph(){
		map = new HashMap<>();
	}
		
	public void addFriends(String user, String[] friends){
		Set<String> friendsList;
		if(map.containsKey(user))
			friendsList = map.get(user);
		else
			friendsList = new HashSet<>();				
		
		Collections.addAll(friendsList, friends);
		
		map.put(user, friendsList);
	}
	
	public Set<String> getAllFriends(String user){
		if(map.containsKey(user))
			return map.get(user);
		else
			return new HashSet<>();
	}
	
	public boolean isPresent(String user){
		if(map.containsKey(user))	return true;
		else	return false;
	}

	@Override
	public String toString() {
		return "Graph [map=" + map + "]";
	}
}