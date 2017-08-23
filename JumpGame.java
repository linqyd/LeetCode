public class Leetcode {
	public static void main(String[] args) {
		int[] nums = {3,2,1,0,4};
		Solution solution = new Solution();
		System.out.println(solution.canJump(nums));
	}
}

class Solution {
    public boolean canJump(int[] nums) {
    	int range = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if(i>range) return false;
			range = Math.max(i + nums[i],range);
		}
    	
    	return true;
    }
}