class Solution {
    public void nextPermutation(int[] nums) {
        int head, tail;
        if(nums.length < 2) return;
        // record the last ele of increasing subarray from tail
        int pivo = -1;
        // record the first element larger than nums[pivo-1]
        int pivo2 = -1;
        for(int i = nums.length-1; i > 0; i--)
        {
            if(nums[i]>nums[i-1]){
                pivo = i-1;
                break;
            }
        }
        if(pivo != -1){
            // find the smallest element of increasing subarray
            // that is greater than nums[pivo], and swap them
            for(int i = nums.length-1; i > pivo; i--)
            {
                if(nums[i]>nums[pivo])
                {
                    pivo2 = i;
                    int temp = nums[pivo];
                    nums[pivo] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        // maintain the tail of array as small as possible
        head = pivo+1;
        tail = nums.length-1;
        while(head<tail)
        {
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            head++;
            tail--;
        }
        
    }
}