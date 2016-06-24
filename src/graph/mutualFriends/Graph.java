package graph.mutualFriends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<String, List<String>> map;	
	
	public Graph(){
		map = new HashMap<>();
	}
	
	public void addAFriend(String user, String aFriend){
		List<String> children;
		if(map.containsKey(user)){
			children = map.get(user);
			children.add(aFriend);
		}
		else{
			children = new ArrayList<>();
			children.add(aFriend);			
		}
		map.put(user, children);
	}
	
	public void addFriends(String user, String[] friends){
		List<String> children;
		if(map.containsKey(user))
			children = map.get(user);
		else
			children = new ArrayList<>();				
		
		for(String aFriend : friends)
			children.add(aFriend);
		
		map.put(user, children);
	}
	
	public List<String> getAllFriends(String user){
		if(map.containsKey(user))
			return map.get(user);
		else
			return new ArrayList<>();
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