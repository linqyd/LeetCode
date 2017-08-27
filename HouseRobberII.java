public class Leetcode {
    public static void main(String[] args) {
        int a[]= {4,1,2,7,5,3,1};
        // 96
        // 14
        Solution solution = new Solution();
        System.out.println(solution.rob(a));
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        
        int[] resultTable1 = new int[nums.length];
        int[] resultTable2 = new int[nums.length];
        
        // rob first house, cannot rob second
        resultTable1[1] = resultTable1[0] = nums[0];
        
        for (int i = 2; i < resultTable1.length-1; i++) 
            resultTable1[i] = Math.max(resultTable1[i-2] + nums[i], resultTable1[i-1]);
        // last one cannot be robbed
        resultTable1[resultTable1.length-1] = resultTable1[resultTable1.length-2];
        
        // don't rob first house
        resultTable2[0] = 0;
        // rob 1th house
        resultTable2[1] = nums[1];
        
        for (int i = 2; i < resultTable2.length; i++) 
            resultTable2[i] = Math.max(resultTable2[i-2] + nums[i], resultTable2[i-1]);
        
        return Math.max(resultTable1[nums.length-1],resultTable2[nums.length-1]);
    }
}



