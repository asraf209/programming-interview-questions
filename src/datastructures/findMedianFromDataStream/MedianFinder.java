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
	
	public void addNum(int n){
		if(count==0 || n<=leftHeap.peek()){
			leftHeap.offer(n);
			count++;
			if(count%2==0){
				rightHeap.offer(leftHeap.poll());
			}
		}
		else{
			rightHeap.offer(n);
			count++;
			if(count%2!=0){
				leftHeap.offer(rightHeap.poll());
			}
		}
	}
	
	public double findMedian(){
		if(count%2==0){
			double median = (leftHeap.peek() + rightHeap.peek()) / 2;
			return median;
		}
		
		return leftHeap.peek(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
