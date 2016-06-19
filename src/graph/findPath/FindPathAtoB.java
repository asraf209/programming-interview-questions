package graph.findPath;

public class FindPathAtoB {
	
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
	}
}
