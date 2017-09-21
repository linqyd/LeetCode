class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)  return -1;
        int start = 0;
        int end = nums.length-1;
        int middle = (start + end)/2;
        
        while(start <= end){
            // pivot is on the right hand side
            if(nums[middle] >= nums[start])
            {   
                if(target == nums[middle]) return middle;
                // search left part
                if(target < nums[middle] && target >= nums[start])
                    end = middle-1;
                else
                    start = middle+1;
                
                middle = (start + end)/2;
            }
            // else pivot is on the left hand side
            else
            {
                if(target == nums[middle]) return middle;
                // search right part
                if(target > nums[middle] && target <= nums[end])
                    start = middle+1;
                else
                    end = middle-1;
                
                middle = (start + end)/2;
            }
        }
        return -1;
            
    }
}