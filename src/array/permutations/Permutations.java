package array.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	private static void swap(int[] nums, int a, int b){
		int n = nums[a];
		nums[a] = nums[b];
		nums[b] = n;
	}
	
	private static List<List<Integer>> doPermute(int[] nums, int s, int e, List<List<Integer>> list){
		if(s==e){
			List<Integer> l = new ArrayList<>();
			for(int n : nums)	l.add(n);
			list.add(l);					
		}
		else{
			for(int i=s; i<=e; i++){
				swap(nums, s, i);
				doPermute(nums, s+1, e, list);
				swap(nums, s, i);
			}
		}
		return list;
	}
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		return doPermute(nums, 0, nums.length-1, list);		
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(permute(nums));
	}

}
