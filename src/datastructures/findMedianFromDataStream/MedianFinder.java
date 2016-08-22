package datastructures.findMedianFromDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

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
	
	/**
	 * After adding to the left, if count becomes even, then remove top element from left and add it to right
	 * Similarly, after adding to the right, if count becomes odd, then remove top element from right and add it to left
	 * 
	 * Complexity O(logN)
	 */
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
		System.out.println("Count: " + count + ", " + leftHeap.peek() + ", " + rightHeap.peek());
		if(count%2==0){
			double median = (leftHeap.peek() + rightHeap.peek()) / 2.0;
			return median;
		}
		
		return leftHeap.peek(); 
	}
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String input = scanner.nextLine();
			if("q".equals(input))	break;
			int n = Integer.parseInt(input);
			mf.addNum(n);
			System.out.println(mf.findMedian());
		}
		scanner.close();
	}

}
