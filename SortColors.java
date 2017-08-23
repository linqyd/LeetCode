public class Leetcode {
	public static void main(String[] args) {
		int[] nums = {2,1,2,1,0,2};
		Solution solution = new Solution();
		solution.sortColors(nums);
	}
}

class Solution {
    public void sortColors(int[] nums) {
    	int i=0,j=0,k=0;
    	
        for (int a = 0; a < nums.length; a++) {
			if(nums[a] == 0)
				i++;
			if(nums[a] == 1)
				j++;
			if(nums[a] == 2)
				k++;
		}
        
        for(int a = 0; a < nums.length; a++){
        	if(a<i)
        		nums[a] = 0;
        	if(a>=i && a < i+j)
        		nums[a] = 1;
        	if(a>=i+j)
        		nums[a] = 2;
//        	System.out.println(nums[a]);
        }
    }
}