package string.strstr;

public class StrStr {
	
	public static int strStr(String haystack, String needle) {
		if(haystack==null || needle==null || needle.length() > haystack.length())	return -1;
		if(needle.length()<1)   return 0;
		
		int p1=0;
		boolean found = false;
		while(p1 <= (haystack.length()-needle.length())){
			if(haystack.charAt(p1) == needle.charAt(0)){
				found = matchNeedleInHaystack(haystack, p1, needle);
				if(found)	return p1;
			}
			p1++;
		}
		return -1;
    }
	
	private static boolean matchNeedleInHaystack(String h, int s, String n){
		if(h==null || n==null || s>=h.length())	return false;
		int p2=0;
		while(p2<n.length()){
			if(h.charAt(s+p2)!=n.charAt(p2))
				return false;
			p2++;
		}
		return true;
	}
	
	// Another approach
	// O(n * m)
	public static int findNeedle(String h, String n){
		if(h==null || n==null || n.length()>h.length())		return -1;
		if(n.isEmpty())		return 0;		
		
		for(int i=0; i<=(h.length()-n.length()); i++){
			int count = 0;
			for(int j=0; j<n.length(); j++){
				if(h.charAt(i) == n.charAt(j))	count++;
				else	break;
			}
			if(count==n.length())	return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("", ""));
		System.out.println(strStr("ab", ""));
		System.out.println(strStr("ab", "b"));
		System.out.println(strStr("hellobuddy", "dd"));
		System.out.println("-----------------------");
		System.out.println(findNeedle("", ""));
		System.out.println(findNeedle("ab", ""));
		System.out.println(findNeedle("ab", "b"));
		System.out.println(findNeedle("hellobuddy", "dd"));
	}

}
