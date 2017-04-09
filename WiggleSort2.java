import java.util.Arrays;

public class Leetcode {

	public static void main(String[] args) {
		int[] test = {1,4,5,5,6};
		Solution solution = new Solution();
		solution.wiggleSort(test);
		
		for(int i = 0; i< solution.res.length; i++)
			System.out.print(solution.res[i] + " ");
	}
}

class Solution {	
	int[] res;
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length]; 
		for(int i = 0; i < nums.length; ++i)
			if(i%2 == 0)
				result[i] = nums[(nums.length - 1) / 2 - i/2];
			else 
				result[i] = nums[nums.length - 1 - i/2];

		for (int i = 0; i < result.length; i++)
			nums[i] = result[i];
		
		this.res = result;
    }
}