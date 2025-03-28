package array.subArrayWithTarget;

public class SubArraySequence {

	class SubSequenceRange{
		int start;
		int end;
		
		public SubSequenceRange(int s, int e){
			this.start = s;
			this.end = e;
		}
		
		@Override
		public String toString(){
			return "(" + start + ", " + end + ")";
		}
	}
	
	/**
	 * Trivial solution, works for both (+)ve and (-)ve numbers
	 * Consider each subarray one by one and compute sum to check with target value 
	 * O(n^2)	
	 */
	SubSequenceRange findSubSequence(int[] a, int target){
		if(a==null || a.length<1)
			return null;
		
		for(int i=0; i<a.length; i++){
			int sum = 0;
			for(int j=i; j<a.length; j++){
				sum += a[j];
				if(sum==target){
					return new SubSequenceRange(i, j);
				}
			}
		}
		
		return null;
	}
		
	/**
	 * Efficient one, works for only (+)ve numbers
	 * Sliding window solution
	 * O(n)
	 */
	SubSequenceRange findSubSequence21(int[] a, int target){
		if(a==null || a.length<1)
			return null;
		
		int s=0, e=0;
		int sum = 0;
		while(s<=e && e<a.length){				
			if((sum + a[e]) == target){
				return new SubSequenceRange(s, e);
			}
			else if((sum + a[e]) < target){
				sum += a[e];
				e++;
			}
			else{
				if(sum != 0 && s<e){
					sum -= a[s];
					s++;				
				}				
				else{
					s++;
					e++;
				}										
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		SubArraySequence obj = new SubArraySequence();
		int[] a = {30, 5, 16, 13, 3, 24, 19, 1, 25};
		System.out.println(obj.findSubSequence(a, 47));	// returns 4-7
		
		int[] b = {30, 5, 16, 13, 3, 24, -19, 1, 25};
		System.out.println(obj.findSubSequence(b, 9));
		
		int[] c = {3000, 5, 16, 13, 3, 24, 19, 1, 25};
		System.out.println(obj.findSubSequence21(c, 47));
				
		int[] e = {15, 2, 4, 8, 9, 5, 10, 23};	
		System.out.println(obj.findSubSequence21(e, 23));	// returns 1-4

		int[] f = {1, 3, 1, 4, 23};
		System.out.println(obj.findSubSequence21(f, 8));
	}

}
