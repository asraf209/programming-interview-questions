package graph.findPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<String, List<String>> graph;	
	
	public Graph(){
		graph = new HashMap<>();
	}
	
	public void addToGraph(String parent, String child){
		if(graph.containsKey(parent)){
			List<String> children = graph.get(parent);
			children.add(child);
		}
		else{
			List<String> children = new ArrayList<>();
			children.add(child);
		}
	}
	
	public List<String> getAdjacentNodes(String node){
		if(graph.containsKey(node))
			return graph.get(node);
		else
			return null;
	}
	
	public boolean isPresent(String node){
		if(graph.containsKey(node))	return true;
		else	return false;
	}
}