package intervals.meetingScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
	
	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
		Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
		
		List<Integer> res = new ArrayList<Integer>();
		int p1=0, p2=0;
		while (p1 < slots1.length && p2 < slots2.length) {
			int[] slot1 = slots1[p1];
			int[] slot2 = slots2[p2];
			
			// Skip smaller slots
			if (slotDuration(slot1) < duration) {
				p1++;
				continue;
			}
			if (slotDuration(slot2) < duration) {
				p2++;
				continue;
			}
			
			// Find a common slot. Or skip the one which is ending frist
			int start = Math.max(slot1[0], slot2[0]);
			int end = Math.min(slot1[1], slot2[1]);
			if ((end - start) >= duration) {
				res.add(start);
				res.add(start + duration);
				break;
			}
			else if (slot1[1] < slot2[1])	p1++;
			else	p2++;
		}
		
		return res;
    }
	
	private static int slotDuration(int[] slot) {
		return slot[1] - slot[0];
	}
	
	public static void main(String[] args) {
		// Sample 1
		int[][] slots11 = {{10,50},{60,120},{140,210}};
		int[][] slots12 = {{0,15},{60,70}};
		int duration1 = 8;
		
		List<Integer> minAvailableDuration1 = minAvailableDuration(slots11, slots12, duration1);
		System.out.print("(");
		minAvailableDuration1.forEach(freeTime -> System.out.print(freeTime + ","));
		System.out.print(")");
		
		System.out.println();
		
		// Sample 2
		int[][] slots21 = {{10,50},{60,120},{140,210}};
		int[][] slots22 = {{0,15},{60,70}};
		int duration2 = 12;
				
		List<Integer> minAvailableDuration2 = minAvailableDuration(slots21, slots22, duration2);
		System.out.print("(");
		minAvailableDuration2.forEach(freeTime -> System.out.print(freeTime + ","));
		System.out.print(")");
				
		System.out.println();
	}
}
