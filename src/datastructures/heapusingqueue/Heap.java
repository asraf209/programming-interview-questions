package datastructures.heapusingqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
	public static void makeMinHeap(int[] a, int SIZE){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(SIZE, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2; 
			}
		});
		
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
