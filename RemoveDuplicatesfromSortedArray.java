class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 1;
        for(int i = 1; i < nums.length;i++)
            if(nums[i] == nums[i-1]) continue;
            else {
                result++;
                nums[result-1] = nums[i];       
            }
        
        return result;
    }
}