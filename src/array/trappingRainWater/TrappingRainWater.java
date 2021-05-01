package array.trappingRainWater;

public class TrappingRainWater {
	public static int trap(int[] height) {
		if (height == null || height.length < 3)	return 0;
		
		int[] maxHeightOnLeft = new int[height.length];
		for(int i = 1; i < height.length; i++) {
			maxHeightOnLeft[i] = Math.max(height[i-1], maxHeightOnLeft[i-1]);
		}
		
		int[] maxHeightOnRight = new int[height.length];
		for(int i = height.length-2; i >= 0; i--) {
			maxHeightOnRight[i] = Math.max(height[i+1], maxHeightOnRight[i+1]);
		}
		
		int water = 0;
		for(int i = 0; i<height.length; i++) {
			int minHeightBetweenLeftAndRight = Math.min(maxHeightOnLeft[i], maxHeightOnRight[i]);
			int possibleTrappedWater = minHeightBetweenLeftAndRight - height[i];
			water += possibleTrappedWater > 0 ? possibleTrappedWater : 0; 
		}
		
		return water;
	}
	
	public static void main(String[] args) {
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(trap(new int[] {4,2,0,3,2,5}));
	}
}
