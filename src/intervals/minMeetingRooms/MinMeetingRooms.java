package intervals.minMeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

public class MinMeetingRooms {
	public static int minMeetingRooms(int[][] intervals) {
		if (intervals==null || intervals.length < 1)    return 0;

		// Sort them in ascending order, first on start and then on end
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare (int[] interval1, int[] interval2) {
				return ((interval1[0] - interval2[0])==0) ? (interval1[1] - interval2[1]) : (interval1[0] - interval2[0]);
			}
		});

		int meetingRoomCount=1;
		for (int i=1; i<intervals.length; i++) {
			if (isWithinPrevInterval(intervals[i], intervals[i-1])) {
				meetingRoomCount++;
			}
		}

		return meetingRoomCount;
	}

	private static boolean isWithinPrevInterval(int[] currentInterval, int[] prevInterval) {
		return (currentInterval[0] >= prevInterval[0]) && (currentInterval[1] < prevInterval[1]);
	}
	
	public static void main(String[] args) {
		int[][] intervals1 = {{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(intervals1));

		int[][] intervals2 = {{7,10},{2,4}};
		System.out.println(minMeetingRooms(intervals2));

		int[][] intervals3 = {{0,30},{5,10},{15,40}, {35, 40}};
		System.out.println(minMeetingRooms(intervals3));
	}

}
