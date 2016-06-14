package algorithms.topncustomers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopNCustomers {

	public static List<String> findTopNCustomer(String[] names, int[] expenses){
		if(names==null || names.length==0 || expenses==null || expenses.length==0)
			return null;
		if(names.length!=expenses.length)	return null;
		
		Map<String, Integer> expenseInfo = new HashMap<>();
		for(int i=0; i<names.length; i++){
			if(expenseInfo.containsKey(names[i]))
				expenseInfo.put(names[i], expenseInfo.get(names[i])+expenses[i]);
			else
				expenseInfo.put(names[i], expenses[i]);
		}
		System.out.println(expenseInfo);
		return null;
	}
	
	public static void main(String[] args) {
		int N = 3;
		String[] names = {"bob", "sam", "smith", "alan", "sam", "sam", "kobi", "sam", "bob", "alan"};
		int[] expenses = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		System.out.println(findTopNCustomer(names, expenses));
	}

}
