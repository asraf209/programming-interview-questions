package graph.shortestPath;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathAtoB {
	
	class NodeDistance{
		String vertex;
		int distance;
		
		public NodeDistance(String vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}
	
	/**
	 * BFS algorithm using Queue
	 */
	public int getShortestPath(Graph g, String src, String dest){
		int shortestDistance = -1;
		if(g==null || src==null || dest==null)	return shortestDistance;
		if(!g.isPresent(src) && !g.isPresent(dest))	return shortestDistance;
		
		Set<String> taken = new HashSet<>();		// Track nodes that are already been takes/pushed into Queue
		Queue<NodeDistance> queue = new LinkedList<>();	// Applying BFS 
		queue.add(new NodeDistance(src, 0 /*distance*/));
		taken.add(src);
		while(!queue.isEmpty()){
			NodeDistance v = queue.poll();			
			for(String u : g.getAdjacentNodes(v.vertex)){
				if(!taken.contains(u)){
					if(dest.equals(u)){			// Found destination Node
						int distance = v.distance + 1;
						shortestDistance = Math.min(distance, shortestDistance);
					}
					else{						// If not, put it in the Queue to explore further
						queue.add(new NodeDistance(u, v.distance + 1));
						taken.add(u);
					}
				}
			}
		}
		
		return shortestDistance;
	}
	
	public static void main(String[] args) {	
		Graph graph = new Graph();
		graph.addAnEdge("c", "d");
		graph.addAnEdge("c", "b");
		graph.addAnEdge("d", "e");
		graph.addAnEdge("e", "f");
		graph.addAnEdge("e", "j");
		graph.addAnEdge("f", "g");
		graph.addAnEdge("g", "h");
		graph.addAnEdge("g", "k");
		graph.addAnEdge("h", "i");
		graph.addAnEdge("i", "h");
		System.out.println(graph);
		
		System.out.println("a to b: " + new ShortestPathAtoB().getShortestPath(graph, "a", "b") + "\n");
	}
}
