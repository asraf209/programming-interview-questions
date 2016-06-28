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
	
	private void listAllWords(Node node, String word, List<String> allWords){
		if(node.getChildren()==null)
			allWords.add(word);
		else{
			if(node.isWord())
				allWords.add(word);
			
			for(char ch : node.getChildren().keySet()){
				word = word + ch;
				Node u = node.getChildren().get(ch);
				listAllWords(u, word, allWords);
				word = word.substring(0, word.length()-1);
			}
		}
	}
	
	public void suggestedWords(String input){
		if(input==null || input.trim().isEmpty())	return;
		
		Node lastMatchedNode = getLastMatchedNode(input);
		if(lastMatchedNode!=null){
			List<String> suggestedWords = new ArrayList<>();
			listAllWords(lastMatchedNode, input.trim().toUpperCase(), suggestedWords);
			System.out.println(suggestedWords);
		}
				
	}
	
	public static void main(String[] args) {		
		String[] dict = {"Kushtia", "Dhaka", "Dhamrai", "Kumar", "DhakaMan"};
		AutoComplete obj = new AutoComplete();
		for(String str : dict)
			obj.insert(str);
		
		obj.suggestedWords("dh");
		obj.suggestedWords("kum");
	}

}
