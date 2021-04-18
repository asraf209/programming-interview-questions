package datastructures.bashCmdProcessor;

import java.util.HashMap;
import java.util.Map;

class Node {
	String name;
	boolean isDirectory;
	Node parent;
	Map<String, Node> child;
	// String path; // Optional path property to reduce cost on computing pwd.
	
	public Node(String name, boolean isDirectory, Node parent) {
		this.name = name;
		this.isDirectory = isDirectory;
		this.parent = parent;
		this.child = new HashMap<>();
	}
	
	public Node(String name, boolean isDirectory) {
		this(name, isDirectory, null /*parent*/);
	}
}
