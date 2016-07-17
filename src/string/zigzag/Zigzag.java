package string.zigzag;

public class Zigzag {
	public static String convert(String text, int nRows){
		if(text==null || text.trim().isEmpty() || nRows<2)	return text;
		
		StringBuffer buffer = new StringBuffer();
		int r=1;
		while(r<=nRows){
			int index = r-1;
			while(index<text.trim().length()){
				System.out.print(index);
				buffer.append(text.trim().charAt(index));
				index = index + (nRows-r) + (nRows-r);				
			}
			r++;
			System.out.println();
		}
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(convert("ABCDEFGHIJKLM", 4));

	}

}
