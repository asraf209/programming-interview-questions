package intervals.employeeFreeTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
	
	public static List<Interval> employeeFreeTime(List<List<Interval>> employeeSchedules) {
		List<Interval> freeTimes = new ArrayList<>();
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(
				new Comparator<Interval>() {
					@Override
					public int compare(Interval o1, Interval o2) {
						// 0->equal, 1->greater, -1->smaller
						return (o1.start - o2.start == 0) ? (o1.end - o2.end) : (o1.start - o2.start);
					}
				});
		
		// MinHeap will keep all the intervals in sorted order
		employeeSchedules.forEach(schedules -> schedules.forEach(schedule -> minHeap.add(schedule)));
		
		if(minHeap.size() < 2)	return freeTimes;
		Interval interval = minHeap.poll();
		while (!minHeap.isEmpty()) {
			Interval pop = minHeap.poll();
			if (pop.start <= interval.end) {
				interval = new Interval(interval.start, Math.max(interval.end, pop.end));	// Sample case: (1, 10), (2, 7)
			}
			else {
				Interval gap = new Interval(interval.end, pop.start);
				freeTimes.add(gap);
				interval = pop;
			}
		}
		
		return freeTimes;
    }
	
	public static void printFreeTimes(List<Interval> freeTimes) {
		
	}
	
	public static void main(String[] args) {
		// Sample 1
		int[][][] input1 = {{{1,2},{5,6}},{{1,3}},{{4,10}}};
		List<List<Interval>> employeeSchedules1 = new ArrayList<>();
		for (int[][] eachSchedule : input1) {
			List<Interval> list = new ArrayList<>();
			for(int[] aSchedule : eachSchedule) {
				Interval newInterval = new Interval(aSchedule[0], aSchedule[1]);
				list.add(newInterval);
			}
			employeeSchedules1.add(list);
		}
		
		List<Interval> freeTimes1 = employeeFreeTime(employeeSchedules1);
		freeTimes1.forEach(freeTime -> System.out.println(freeTime));
		
		System.out.println();
		
		// Sample 2
		int[][][] input2 = {{{1,3},{6,7}},{{2,4}},{{2,5},{9,12}}};
		List<List<Interval>> employeeSchedules2= new ArrayList<>();
		for (int[][] eachSchedule : input2) {
			List<Interval> list = new ArrayList<>();
			for(int[] aSchedule : eachSchedule) {
				Interval newInterval = new Interval(aSchedule[0], aSchedule[1]);
				list.add(newInterval);
			}
			employeeSchedules2.add(list);
		}
		
		List<Interval> freeTimes2 = employeeFreeTime(employeeSchedules2);
		freeTimes2.forEach(freeTime -> System.out.println(freeTime));
				
		System.out.println();
		
		// Sample 3
		int[][][] input3 = {{{7,24},{29,33},{45,57},{66,69},{94,99}},{{6,24},{43,49},{56,59},{61,75},{80,81}},{{5,16},{18,26},{33,36},{39,57},{65,74}},{{9,16},{27,35},{40,55},{68,71},{78,81}},{{0,25},{29,31},{40,47},{57,87},{91,94}}};
		List<List<Interval>> employeeSchedules3= new ArrayList<>();
		for (int[][] eachSchedule : input3) {
			List<Interval> list = new ArrayList<>();
			for(int[] aSchedule : eachSchedule) {
				Interval newInterval = new Interval(aSchedule[0], aSchedule[1]);
				list.add(newInterval);
			}
			employeeSchedules3.add(list);
		}
		
		List<Interval> freeTimes3 = employeeFreeTime(employeeSchedules3);
		freeTimes3.forEach(freeTime -> System.out.println(freeTime));
	}

}
