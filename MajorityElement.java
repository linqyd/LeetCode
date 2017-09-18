class Solution {
    public int majorityElement(int[] nums) {
        int mar = nums[0];
        int count = 1;
        for(int i= 1; i< nums.length; i++)
        {
            if(nums[i] != mar)
                count--;
            else
                count++;
            
            if(count == 0){
                mar = nums[i];
                count = 1;
            }
        }
        
        return mar;
    }
}