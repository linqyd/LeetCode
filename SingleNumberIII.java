class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for(int i = 0; i < nums.length; i++)
        {
            xorResult ^= nums[i];
        }
        // find any bit has been set to 1 in result;
        xorResult &= -xorResult;
        
        int[] result = {0,0}; 
        for(int i = 0; i < nums.length; i++)
        {
            // divide the numbers into two groups, one is set the specific bit, the rest is not
            // two number must belong to different groups.
            if((nums[i]&xorResult) ==0)
                result[0] ^= nums[i];
            else
                result[1] ^= nums[i];
        }
        return result;
    }
}