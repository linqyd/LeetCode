class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        int low, high;
        Arrays.sort(nums);
        // first ele
        for(int i = 0; i < nums.length-3; i++)
        {
            // skip the same element
            if(i > 0 && nums[i] == nums[i-1]) continue;
            // second ele
            for(int j = i+1; j < nums.length-2; j++)
            {
                // skip the same element
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                low = j + 1;
                high = nums.length-1;
                
                while(low<high){
                    if(nums[i] + nums[j] + nums[low] + nums[high] == target){
                        // important! Arrays.asList(), return a List not an array
                        result.add(Arrays.asList(nums[i], nums[j],nums[low],nums[high]));
                        high--;
                        low++;
                        while(low < high && nums[low-1]==nums[low]) low++;
                        while(low < high && nums[high+1]==nums[high]) high--;
                    }
                    else if(nums[i] + nums[j] + nums[low] + nums[high] < target)
                        low++;
                    else
                        high--;
                }
            }
            
        }
        
        return result;
    }
}