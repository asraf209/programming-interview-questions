package string.reverseWords;

public class ReverseWordsInAString {
	
	public static String reverseWords(String s) {
        String[] words = s.split("\\s+");   // Regular expression. Split on one or more whitespaces
        StringBuilder sb = new StringBuilder();
        
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]).append(" ");
        }
        
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  Bob    Loves  Alice   "));
		System.out.println(reverseWords("Alice does not even like bob"));
	}

}
