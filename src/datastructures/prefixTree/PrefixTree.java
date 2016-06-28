package datastructures.prefixTree;

public class PrefixTree {	
	
	Node root = new Node();
	
	public boolean isPresent(String word){
		if(word==null || word.trim().isEmpty())	return false;
		
		Node current = root;
		for(char ch : word.trim().toUpperCase().toCharArray()){
			if(current.children.containsKey(ch))
				current = current.children.get(ch);			
			else 
				return false;
		}
		return current.isWord;
	}
	
	public void insert(String word){
		if(word==null || word.trim().isEmpty())	return;
		if(isPresent(word))	return;
		
		Node current = root;
		for(char ch : word.trim().toUpperCase().toCharArray()){
			if(current.children.containsKey(ch)){
				Node child = current.children.get(ch);
				child.prefix++;
				current.children.put(ch, child);
				current = child;
			}
			else{
				Node child = new Node();
				child.prefix++;
				current.children.put(ch, child);
				current = child;
			}
			
		}
		current.isWord = true;
	}
	
	public void remove(String word){
		if(word==null || word.trim().isEmpty())	return;
		if(!isPresent(word))	return;
		
		Node current = root;
		for(char ch : word.trim().toUpperCase().toCharArray()){
			Node child = current.children.get(ch);
			if(child.prefix > 1)
				child.prefix--;
			else{
				current.children.remove(ch);
				return;
			}
			current = child;
		}
		current.isWord = false;
	}
		
}
