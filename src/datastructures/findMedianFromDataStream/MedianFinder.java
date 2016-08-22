package datastructures.findMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	int count;
	PriorityQueue<Integer> leftHeap; 
	PriorityQueue<Integer> rightHeap;
	
	public MedianFinder(){
		count = 0;
		// MAX HEAP
		leftHeap = new PriorityQueue<>(10, new Comparator<Integer>() {			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		// MIN HEAP
		rightHeap = new PriorityQueue<>(10, new Comparator<Integer>() {			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
