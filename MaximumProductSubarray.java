class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length < 1) return 0;
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {   
            // negative number makes the max to min, min to max
            if(nums[i] < 0)
            {
                int temp = max;
                max = min;
                min = temp;
            }
                
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            
            result = Math.max(result, max);
        }
        
        return result;
    }
}