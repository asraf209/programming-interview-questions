package datastructures.prefixTree;

import java.util.HashMap;
import java.util.Map;

public class Node {
	int prefix = 0;
	boolean isWord = false;
	Map<Character, Node> children = new HashMap<>();
}
