package algorithms.reverseEachWord;

public class ReverseEachWord {

	public static String reverseEachWordInSentence(String sentence){
		if(sentence==null || sentence.length()<2)
			return sentence;
		
		char[] chars = sentence.toCharArray();
		int s=0, e=0;
		
		/**
		 * Find each Word and then reverse that 
		 */
		while(e<chars.length){
			if(chars[e]==' ' || chars[e]=='\t'){
				if((e-s)>0){
					// Got a word
					reverse(chars, s, e-1);
				}
				s = e+1;
			}
			e++;
		}

		if((e-s)>0)	
			reverse(chars, s, e-1);

		return new String(chars);
	}

	private static void reverse(char[] sentence, int s, int e){
		if(sentence==null || sentence.length<2)
			return;
		
		/**
		 * Swap characters to reverse a Word
		 */
		while(s<e){
			char tmp = sentence[s];
			sentence[s] = sentence[e];
			sentence[e] = tmp;
			s++; e--;
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseEachWordInSentence("HelloWorld"));
		System.out.println(reverseEachWordInSentence("Hello World"));
		System.out.println(reverseEachWordInSentence("I 	ABC	DEF  GHR "));
		System.out.println(reverseEachWordInSentence(" ABC	DEF  GHR "));
	}

}


