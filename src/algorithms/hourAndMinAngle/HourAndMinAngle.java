package algorithms.hourAndMinAngle;

public class HourAndMinAngle {

	/**
	 * Calculate the rate of change per minute for both the Hour and Minute hand
	 * Convert Hour to Minute and calculate total distance passed from 0 in degree
	 * Calculate total distance passed from 0 in degree for Minute hand
	 * Return the difference
	 */
	static double findAngle(int hour, int minute){
		if(hour<0 || hour>23 || minute<0 || minute>59)
			return -1;
		
		double rateOfChangePerMinuteForHourHand 	= 360.00/(12*60);	// 0.5 degree
		double rateOfChangePerMinuteForMinuteHand 	= 360.00/60;		// 6 degree
		
		int totalMinutesOfChangeForHourHand = (hour * 60) + minute;
		double totalChangesInDegreeForHourHand 		= rateOfChangePerMinuteForHourHand * totalMinutesOfChangeForHourHand;		
		double totalChangesInDegreeForMinuteHand 	= rateOfChangePerMinuteForMinuteHand * minute;
		
		double diffInDegrees = Math.abs(totalChangesInDegreeForHourHand - totalChangesInDegreeForMinuteHand);
		if(diffInDegrees >180)
			return Math.abs(360.0 - diffInDegrees);
		
		return diffInDegrees;
	}
	
	public static void main(String[] args) {
		System.out.println(findAngle(15, 00));
		System.out.println(findAngle(6, 00));
		System.out.println(findAngle(10, 10));
		System.out.println(findAngle(20, 20));
		System.out.println(findAngle(10, 30));
	}

}
