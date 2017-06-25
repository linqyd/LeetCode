package leetcode;

import java.util.Arrays;

public class Leetcode {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		Solution solution = new Solution();
		solution.arrayPairSum(nums);
	}
}

class Solution {
    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	int result = 0;
    	
    	for (int i = 0; i < nums.length; i+=2)
    		result += nums[i];
			
    	return result;
    }
}