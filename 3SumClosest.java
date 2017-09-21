class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int low, high;
        int result = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length-2; i++)
        {
            low = i+1;
            high = nums.length-1;
            while(low<high)
            {
                int sum = nums[i] + nums[low] + nums[high];
                if(sum > target)
                    high--;
                else
                    low++;
                
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}