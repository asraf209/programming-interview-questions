package array.pourWater;

public class PourWater {
	public static int[] pour(int[] heights, int volume, int k) {
		if (heights == null || heights.length < 1)	return heights;
		
		while (volume-- > 0) {
			int tower = getTowerAtLowerLevel(heights, k);
			heights[tower]++;
		}
		
		return heights;
	}
	
	private static int getTowerAtLowerLevel(int[] heights, int K) {
		int tower = K;
        boolean isTowerFound = false;
        
        // Search in the left terrain
        for(int i=K; i>0; i--) {
            if(heights[i-1] < heights[i]) {
                tower = i-1;
                isTowerFound = true;
            }
            else if(heights[i-1] > heights[i]) {
                break;
            }
        }
        
        if(isTowerFound) {
            return tower;
        }
        
        // Search in the right terrain
        for(int i=K; i<heights.length-1; i++) {
            if(heights[i+1] < heights[i]) {
                tower = i+1;
            }
            else if(heights[i+1] > heights[i]) {
                break;
            }
        }
        
        return tower;
	}
	
	public static void main(String[] args) {
		System.out.println(pour(new int[] {2,1,1,2,1,2,2}, 4, 3));
		System.out.println(pour(new int[] {1,2,3,4}, 2, 2));
		System.out.println(pour(new int[] {3,1,3}, 5, 1));
	}
}
