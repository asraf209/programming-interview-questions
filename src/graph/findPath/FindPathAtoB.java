package graph.findPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindPathAtoB {
	
	public static List<String> findPath(Graph g, String src, String dest){
		if(g==null || src==null || dest==null)	return null;
		if(!g.isPresent(src) && !g.isPresent(dest))	return null;
		
		Set<String> visited = new HashSet<>();		
		Queue<String> queue = new LinkedList<>();
		/**
		 * Map<u, v>: Node u has been reached by following a path via v
		 * This will be used for printing the path
		 */
		Map<String, String> map = new HashMap<>();		
		boolean isFound = false;
		
		queue.add(src);
		while(!queue.isEmpty()){
			String v = queue.poll();			
			for(String u : g.getAdjacentNodes(v)){
				if(!visited.contains(u)){
					if(dest.equals(u)){
						map.put(u, v);
						isFound = true;
						break;
					}
					else{
						map.put(u, v);
						queue.add(u);						
					}
				}
			}
			if(isFound)		break;
			visited.add(v);
		}
		
		if(isFound){
			List<String> path = new ArrayList<>();
			String node = dest;
			path.add(0, node);
			node = map.get(node);
			while(!node.equals(src)){
				path.add(0, node);
				node = map.get(node);				
			}
			path.add(0, node);
			return path;
		}
		return null;
	}
	
	public static void main(String[] args) {	
		Graph graph = new Graph();
		graph.addToGraph("G", "A");
		graph.addToGraph("A", "B");
		graph.addToGraph("A", "C");
		graph.addToGraph("C", "D");
		graph.addToGraph("C", "E");
		graph.addToGraph("D", "J");
		graph.addToGraph("E", "K");
		graph.addToGraph("K", "F");
		graph.addToGraph("F", "J");
		System.out.println(graph);
		
		System.out.println("G to J: " + findPath(graph, "G", "J"));
		
	}
}
