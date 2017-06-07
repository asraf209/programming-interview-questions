package datastructures.heapusingqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
	
	public static void makeMinHeap(int[] a, int SIZE){		
		/**
		 *  SIZE - initial size, which can be extended further if we add more items
		 *  You can also create a Queue without specifying SIZE and Comparator.
		 *  It will create an Queue with 11 size and will work as MinHeap by default
		 *  PriorityQueue<Integer> minHeap = new PriorityQueue<>()
		 *  
		 *  Complexity: O(log n), same as regular Heap if you make out of an Array
		 */
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(SIZE, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2; 
			}
		});
		
		/**
		 * You can call both add() and offer() method. There is no basic difference between them. Actually, add() directly
		 * call offer() in PriorityQueue API. 
		 * 
		 * But for AbstractQueue, there is a difference. There add() returns an exception if for some reason it is unable
		 * to insert the element. offer() does not return any exception there. So its a good practice to use add() all time
		 */
		for(int n : a){
			minHeap.offer(n);
		}
		
		System.out.println(minHeap);
	}
	
	public static void makeMaxHeap(int[] a, int SIZE){
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(SIZE, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; 
			}
		});
		
		for(int n : a){
			maxHeap.offer(n);
		}
		
		System.out.println(maxHeap);
	}
	
	public static void main(String[] args) {	
		int SIZE = 10;
		int[] a = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		makeMinHeap(a, SIZE);
		makeMaxHeap(a, SIZE);
	}

}
