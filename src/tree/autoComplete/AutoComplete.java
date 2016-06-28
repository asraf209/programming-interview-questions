package tree.autoComplete;

import java.util.ArrayList;
import java.util.List;

import datastructures.prefixTree.Node;
import datastructures.prefixTree.PrefixTree;

public class AutoComplete extends PrefixTree{
	
	private Node getLastMatchedNode(String input){
		if(input==null || input.trim().isEmpty())
			return null;
		
		Node current = root;	// Root of the prefix tree
		for(char ch : input.trim().toUpperCase().toCharArray()){
			if(current.getChildren().containsKey(ch))
				current = current.getChildren().get(ch);
			else
				return null;
		}
		
		return current;
	}
	
	private void printAllWords(Node node, String word){
		if(node.getChildren()==null || node.isWord())
			System.out.println(word);
		else{
			for(char ch : node.getChildren().keySet()){
				word = word + ch;
				node = node.getChildren().get(ch);
				printAllWords(node, word);
			}
		}
	}
	
	public void suggestedWords(String input){
		if(input==null || input.trim().isEmpty())	return;
		
		Node lastMatchedNode = getLastMatchedNode(input);
		if(lastMatchedNode!=null){
			printAllWords(lastMatchedNode, input.trim().toUpperCase());
		}
				
	}
	
	public static void main(String[] args) {		
		String[] dict = {"Kushtia", "Dhaka", "Dhamrai", "Kumar"};
		AutoComplete obj = new AutoComplete();
		for(String str : dict)
			obj.insert(str);
		obj.suggestedWords("ku");
	}

}
