package datastructures.prefixTree;

import java.util.HashMap;
import java.util.Map;

public class Node {
	int prefix = 0;
	boolean isWord = false;
	Map<Character, Node> children = new HashMap<>();
	
	public int getPrefix() {
		return prefix;
	}
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	public Map<Character, Node> getChildren() {
		return children;
	}
	public void setChildren(Map<Character, Node> children) {
		this.children = children;
	}
}
