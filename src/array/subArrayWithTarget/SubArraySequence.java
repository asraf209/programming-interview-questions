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
	 * Trivial solution. O(n^2)	
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
	 * O(n) solution. But only works if all numbers are (+)ve	 
	 */
	SubSequenceRange findSubSequence2(int[] a, int target){
		if(a==null || a.length<1)
			return null;
		
		int s=0, e=0;
		int sum = 0;//a[s];
		while(e<a.length){
			if((sum + a[e]) == target){
				return new SubSequenceRange(s, e);
			}
			else if((sum + a[e]) < target){
				sum += a[e];
				e++;
			}
			else{				
				/*sum -= a[s];
				s++;*/
				if(sum != 0){
					sum -= a[s];
					sum += a[e];
				}				
				s++;
				e++;							
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		SubArraySequence obj = new SubArraySequence();
		int[] a = {30, 5, 16, 13, 3, 24, 19, 1, 25};
		System.out.println(obj.findSubSequence(a, 47));
		
		int[] b = {30, 5, 16, 13, 3, 24, -19, 1, 25};
		System.out.println(obj.findSubSequence(b, 9));
		
		int[] c = {3000, 5, 16, 13, 3, 24, 19, 1, 25};
		System.out.println(obj.findSubSequence2(c, 47));
		
		int[] d = {3000, 5, 16, -13, 3, -24, 19, 1, 25};
		System.out.println(obj.findSubSequence2(d, -34));
	}

}
