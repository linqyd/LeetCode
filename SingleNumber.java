class Solution {
    public int singleNumber(int[] nums) {
        // XOR is associative
        int result = 0;
        for(int i = 0; i < nums.length; i++)
            result ^= nums[i];
        
        return result;
    }
}