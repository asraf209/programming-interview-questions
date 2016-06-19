package graph.findPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<String, List<String>> map;	
	
	public Graph(){
		map = new HashMap<>();
	}
	
	public void addAnEdge(String parent, String child){
		List<String> children;
		if(map.containsKey(parent)){
			children = map.get(parent);
			children.add(child);
		}
		else{
			children = new ArrayList<>();
			children.add(child);			
		}
		map.put(parent, children);
	}
	
	public List<String> getAdjacentNodes(String node){
		if(map.containsKey(node))
			return map.get(node);
		else
			return new ArrayList<>();
	}
	
	public boolean isPresent(String node){
		if(map.containsKey(node))	return true;
		else	return false;
	}

	@Override
	public String toString() {
		return "Graph [map=" + map + "]";
	}
}