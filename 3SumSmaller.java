class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int total=0;
        Arrays.sort(nums);
        int low, high;
        for(int i = 0; i < nums.length-2; i++)
        {
            low = i+1;
            high = nums.length-1;   
            while(low < high)
            {
                if(nums[i] + nums[low] + nums[high] < target)
                {   
                    // important! the low will be set to this value only once
                    total+=high-low;
                    low++;
                }
                else
                    high--;
            }
        }
        
        return total;
    }
}