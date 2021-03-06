package heap.topk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TopK {
	
	public static List<Integer> findTopKElements(int[] nums, int k){
		if(nums==null || nums.length < 1 || k > nums.length)	return null;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int n : nums){
			if(map.containsKey(n))
				map.put(n, map.get(n)+1);
			else
				map.put(n, 1);
		}
		
		// MAX_HEAP
		PriorityQueue<Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {			
				return o2.getValue() - o1.getValue();
			}			
		});
		
		for(Entry<Integer, Integer> entry : map.entrySet()){
			queue.offer(entry);
		}
		System.out.println(queue);
		
		if(k > queue.size())	return null;
		
		List<Integer> retList = new ArrayList<>();
		int count=0;
		while(count<k && !queue.isEmpty()){
			retList.add(queue.poll().getKey());			
			count++;
		}
				
		return retList;
	}
	
	public static void main(String[] args) {		
		int[] nums1 = {2,2,1,1,1,1,3};
		int k = 2;
		System.out.println(findTopKElements(nums1, k));
		
		int[] nums2 = {4,1,-1,2,-1,2,3};
		k = 2;
		System.out.println(findTopKElements(nums2, k));
	}
}
