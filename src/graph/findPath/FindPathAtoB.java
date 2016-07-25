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
	
	/**
	 * BFS algorithm using Queue. We can also use a list instead 
	 * Time: O(V+E)
	 * Space: O(V)
	 * @param g
	 * @param src
	 * @param dest
	 * @return
	 */
	public static List<String> findPath(Graph g, String src, String dest){
		if(g==null || src==null || dest==null)	return null;
		if(!g.isPresent(src) && !g.isPresent(dest))	return null;
		
		Set<String> taken = new HashSet<>();		// Track nodes that are already been takes/pushed into Queue
		Queue<String> queue = new LinkedList<>();	// Applying BFS 
		/**
		 * Map<u, v>: Node u has been reached by following a path via v
		 * This will be used for printing the path
		 */
		Map<String, String> map = new HashMap<>();		
		boolean isFound = false;
		
		queue.add(src);
		taken.add(src);
		while(!queue.isEmpty()){
			String v = queue.poll();			
			for(String u : g.getAdjacentNodes(v)){
				if(!taken.contains(u)){
					if(dest.equals(u)){			// Found destination Node
						map.put(u, v);
						isFound = true;
						break;
					}
					else{						// If not, put it in the path Map and in the Queue to explore further
						map.put(u, v);
						queue.add(u);
						taken.add(u);
					}
				}
			}
			if(isFound)		break;
			//taken.add(v);
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
		graph.addAnEdge("G", "A");
		graph.addAnEdge("A", "B");
		graph.addAnEdge("A", "C");
		graph.addAnEdge("C", "D");
		graph.addAnEdge("C", "E");
		graph.addAnEdge("D", "J");
		graph.addAnEdge("E", "K");
		graph.addAnEdge("K", "F");
		graph.addAnEdge("F", "J");
		System.out.println(graph);
		
		System.out.println("G to J: " + findPath(graph, "G", "J") + "\n");
		System.out.println("A to J: " + findPath(graph, "A", "J") + "\n");
		System.out.println("K to J: " + findPath(graph, "K", "J") + "\n");
		System.out.println("Z to J: " + findPath(graph, "Z", "J") + "\n");
		
		/*graph.addAnEdge("A", "B");
		graph.addAnEdge("A", "C");
		graph.addAnEdge("B", "E");
		graph.addAnEdge("C", "E");
		graph.addAnEdge("E", "F");
		System.out.println("A to F: " + findPath(graph, "A", "F"));*/
		
	}
}
