package leetcode;

import java.util.Arrays;

public class Leetcode {
	public static void main(String[] args) {
//		int[] arr = {2, 6, 4, 8, 10, 9, 15, 17, 3, 5};
//		int[] arr = {2,3,3,2,4};
//		int[] arr = {2,1};
//		int[] arr = {1,1,2,3,3,3};
//		int[] arr = {1,2,3,3,3};
		int[] arr = {1,1,3,2,3,3};
//		int[] arr = {1,3,2,3,3};
		Solution solution = new Solution();
		int a = solution.findUnsortedSubarray(arr);
		System.out.println(a);
			
	}
}

class Solution {
	public int findUnsortedSubarray(int[] nums) {
		int[] sorted = nums.clone();
		Arrays.sort(sorted);
		
		int start = -1;
		int end = -1;
		for (int i = 0; i < nums.length; i++) 
			if(nums[i] != sorted[i])
				if(start == -1)
					start = i;
				else
					end = i;

		System.out.println(start + " " + end);
		
		if(start == -1) return 0;
		else return end - start + 1;
    } 
}
