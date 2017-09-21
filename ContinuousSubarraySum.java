class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        //  remainder index
        Map<Integer,Integer> history = new HashMap();
        history.put(0,-1);
        int sum = 0;
        // if any prev index j has same remainder, 
        // the sum between j+1 and i must be multiple of k.  
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(k!=0){
                int remainder = sum % k;
                if(history.containsKey(remainder) && i>0)
                    return true;
                else
                    history.put(remainder, i);
            }
        }
        
        if(k==0)
            if(nums.length > 1 && sum == 0)
                return true;
            else
                return false;
        
        return false;
    }
}