package tree.autoComplete;

import java.util.ArrayList;
import java.util.List;

import datastructures.prefixTree.Node;
import datastructures.prefixTree.PrefixTree;

public class AutoComplete extends PrefixTree{
	private Node getLastMatchedNode(String input){
		return null;
	}
	
	public List<String> suggestedWords(String input){
		if(input==null || input.trim().isEmpty())	
			return new ArrayList<>();
		
		Node lastMatchedNode = getLastMatchedNode(input);
		return null;
	}
	
	public static void main(String[] args) {		

	}

}
