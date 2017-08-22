public class Leetcode {
	public static void main(String[] args) {
		int[] grid = {2,1,1,2};
		Solution solution = new Solution();
		System.out.println(solution.rob(grid));
	}
}

class Solution {
	public int rob(int[] nums) {
		if(nums.length<1) return 0;
		if(nums.length==1) return nums[0];
		if(nums.length==2) return Math.max(nums[0], nums[1]);
		
	    int[] resultTable = new int[nums.length]; 
	    resultTable[0] = nums[0];
	    resultTable[1] = Math.max(nums[0], nums[1]);
	    
	    for (int i = 2; i < resultTable.length; i++) 
	    	resultTable[i] = Math.max(resultTable[i-2] + nums[i], resultTable[i-1]);
		
		return resultTable[nums.length-1];
	}
}