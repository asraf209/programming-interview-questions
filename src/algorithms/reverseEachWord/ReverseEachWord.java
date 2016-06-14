package algorithms.reverseEachWord;



public class ReverseEachWord {

	private static void reverse(char[] sentence, int s, int e){
		if(sentence==null || sentence.length<2)
			return;

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

	}

}


