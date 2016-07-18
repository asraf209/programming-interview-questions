package string.zigzag;

public class Zigzag {
	
	public static String zigzagConvertion(String text, int nRows){
		if(text==null || text.trim().isEmpty() || nRows<2)	return text;
		
		StringBuffer buffer = new StringBuffer();
		for(int r=0; r<nRows; r++){			
			int i = r;
			int count = 1;
			while(i<text.length()){				
				buffer.append(text.charAt(i));	
				/**
				 * For the 1st and last row, index of next element is 2*(lastRow-firstRow)
				 */
				if(r==0 || r==nRows-1)			
					i = i + 2*(nRows-1);
				/**
				 * For others, find distance from current position to the next boundary row(1st/last). 
				 * Count is actually used here to compute that boundary index
				 */
				else{
					i = i + 2*(count*(nRows-1) - i);
					count++;
				}
			}
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(zigzagConvertion("PAYPALISHIRING", 3));
		System.out.println(zigzagConvertion("PAYPALISHIRING", 4));
	}

}
