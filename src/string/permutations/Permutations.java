package string.permutations;

public class Permutations {
	
	private static void swap(char[] str, int a, int b){
		char c = str[a];
		str[a] = str[b];
		str[b] = c;
	}
	
	public static void permute(char[] str, int s, int e){
		if(s==e){
			System.out.println(new String(str));			
		}
		else{
			for(int i=s; i<=e; i++){
				swap(str, s, i);
				permute(str, s+1, e);
				swap(str, s, i);	// Bring-back the char to be used again
			}
		}
	}
	
	public static void printAllPermutations(String s){
		char[] str = s.toCharArray();
		permute(str, 0, str.length-1);
		System.out.println("\n");
	}
	
	public static void main(String[] args) {		
		String s = "ABC";
		printAllPermutations(s);				
	}

}
