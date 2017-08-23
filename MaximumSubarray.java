package leetcode;

import java.util.Arrays;

public class Leetcode {
    public static void main(String[] args) {
        int[] nums = {-1,7,-2,-3,6};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int result = solver(nums);
        return result;
    }
    
    int solver(int[] subArray){
        if(subArray.length == 1) return subArray[0];
        if(subArray.length == 0) return 0;
        if(subArray.length == 2) return Math.max(Math.max(subArray[0], subArray[1]), 
                subArray[0]+subArray[1]);
        
        int pivo = subArray.length/2;
        int sum1 = 0, sum2 = 0;

        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        
        for (int i = pivo; i < subArray.length; i++) {
            sum1 += subArray[i];
            rightSum = rightSum < sum1 ? sum1: rightSum;
            
        }
        
        for (int i = pivo-1; i >= 0; i--) {
            sum2 += subArray[i];
            leftSum = leftSum < sum2 ? sum2: leftSum;
        }
            
        int max1 = solver(Arrays.copyOfRange(subArray, 0, subArray.length/2));
        int max2 = solver(Arrays.copyOfRange(subArray, subArray.length/2, subArray.length));
        
        return Math.max(Math.max(max1,max2), leftSum+rightSum);
    }
}