package dp.maximumProfit;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProfit {

	class Job{
		int startTime;
		int endTime;
		int profit;
		
		public Job(int startTime, int endTime, int profit) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
		
		@Override
		public String toString() {
			return "(" + startTime + "," + endTime + "," + profit +")";
		}
	}
	
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<Job> queue = new PriorityQueue<Job>(
        		new Comparator<Job>() {
        			@Override
        			public int compare(Job a, Job b) {
        				// Sort based on startTime, endTime and profit
        				if (a.startTime != b.startTime)	return a.startTime - b.startTime;
        				else if (a.endTime != b.endTime)	return a.endTime - b.endTime;
        				return a.profit - b.profit;
        			}
        		});
        
        // Populate MinHeap. 
        int maxEndTime = 0;
        for (int i=0; i<profit.length; i++) {
        	queue.add(new Job(startTime[i], endTime[i], profit[i]));
        	maxEndTime = Math.max(maxEndTime, endTime[i]);
        }
        
        int max = 0;
        int lastEndTime = 0;	// To know how long the dp[] should be
        int[] dp = new int[maxEndTime + 1];
        
        while (!queue.isEmpty()) {
        	Job job = queue.poll();
        	int startScanning = Math.min(job.startTime, lastEndTime);
        	for (int i=startScanning; i<job.endTime; i++) {
        		if (i>0) {
        			dp[i] = Math.max(dp[i], dp[i-1]);
        		}
        	}
        	
        	dp[job.endTime] = dp[job.startTime] + job.profit;
        	max = Math.max(max, dp[job.endTime]);
        	
        	lastEndTime = job.endTime;
        }
        
        return max;
    }
		
	public static void main(String[] args) {
		// Sample 1
		int[] startTime1 = {1,2,3,3};
		int[] endTime1 = {3,4,5,6};
		int[] profit1 = {50,10,40,70};
		
		MaximumProfit sol = new MaximumProfit();
		System.out.println(sol.jobScheduling(startTime1, endTime1, profit1));
		
		// Sample 2
		int[] startTime2 = {1,2,3,4,6};
		int[] endTime2 = {3,5,10,6,9};
		int[] profit2 = {20,20,100,70,60};
		
		System.out.println(sol.jobScheduling(startTime2, endTime2, profit2));
		
		// Sample 3
		int[] startTime3 = {1,1,1};
		int[] endTime3 = {2,3,4};
		int[] profit3 = {5,6,4};
		
		System.out.println(sol.jobScheduling(startTime3, endTime3, profit3));
	}

}
