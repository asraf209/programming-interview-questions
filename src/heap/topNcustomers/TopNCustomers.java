package heap.topNcustomers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * We will be using HashMap and Heap of size N to solve this problem.
 * 	1. Sum up expenses, made by individual customer
 * 	2. Maintain a MinHeap of size N
 * 
 * @author asraful
 *
 */
public class TopNCustomers {

	public static Object[] findTopNCustomer(String[] names, int[] expenses, int N){
		if(names==null || names.length==0 || expenses==null || expenses.length==0)
			return null;
		if(names.length!=expenses.length)	return null;
		
		/**
		 * Sum up expenses, made by individual customer
		 */
		Map<String, Integer> expenseInfo = new HashMap<>();
		for(int i=0; i<names.length; i++){
			if(expenseInfo.containsKey(names[i]))
				expenseInfo.put(names[i], expenseInfo.get(names[i])+expenses[i]);
			else
				expenseInfo.put(names[i], expenses[i]);
		}		
		
		/**
		 * We are using MinHeap. Because it helps us to remove the smaller expenses.
		 * Ultimately leaving the larger values in the list
		 */
		PriorityQueue<Entry<String, Integer>> heap = new PriorityQueue<>(N, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		/**
		 * Maintain the Heap size to N
		 */
		for(Entry<String, Integer> customer : expenseInfo.entrySet()){
			if(heap.size()<N)	heap.offer(customer);
			else{
				if(customer.getValue() > heap.peek().getValue()){
					heap.poll();
					heap.offer(customer);
				}
			}		
		}		
		
		return heap.toArray();
	}
	
	public static void main(String[] args) {
		int N = 2;
		/**
		 * bob = 1000
		 * sam = 70
		 * smith = 300
		 * alan = 1100
		 * kobi = 1300
		 */
		String[] names = {"bob", "sam", "smith", "alan", "sam", "kobi", "bob", "alan", "kobi"};
		int[] expenses = {100, 200, 300, 400, 500, 700, 900, 700, 600};
				
		Object[] retMap = findTopNCustomer(names, expenses, N);
		System.out.println("Top " + N + ": ");
		for(Object item : retMap){
			System.out.println(item);
		}
	}

}
