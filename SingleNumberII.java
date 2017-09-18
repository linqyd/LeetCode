class Solution {
    public int singleNumber(int[] nums) {
        // cannot determine the base case
        if(nums.length == 0) return -1;
        // c1  c2  in  c1  c2
        // 0   0   0   0   0
        // 0   0   1   1   0
        // 1   0   1   0   1
        // 0   1   1   0   0
        // 1   0   0   1   0
        // 0   1   0   0   1
               
        int count1 = 0, count2 = 0, mask = 0;
        for(int i = 0; i < nums.length; i++){
            count2 ^= (count1&nums[i]);
            count1 ^= nums[i];
            mask = ~(count1&count2);
            count1 &= mask;
            count2 &= mask;
        }
        
        return count1;
    }
}