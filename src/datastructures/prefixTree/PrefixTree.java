package datastructures.prefixTree;

import java.util.Map;
import java.util.HashMap;

public class PrefixTree {	
	class Node{
		int prefix = 0;
		boolean isWord = false;
		Map<Character, Node> children = new HashMap<>();
	}
	
	Node root = new Node();
}
