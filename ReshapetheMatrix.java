public class Leetcode {
	public static void main(String[] args) {
		int nums[][] = {{1,2},{3,4}};
		
		Solution solution = new Solution();
		solution.matrixReshape(nums, 1, 4);
	}
}

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
    	int len = nums[0].length;
    	int size = nums.length*len;
    	
    	if(r*c < size || (size%r != 0))
    		return nums;
    	
    	int flatten[] = new int[size];
    	
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i].length != len)
    			return nums;
    		
			for (int j = 0; j < len; j++) 
				flatten[i*len + j] = nums[i][j];
		}
    	
    	int result[][];
    	if(r*c > size && (size%r == 0))
    		result = new int[r][size/r];
    	else
    		result = new int[r][c];
    	
        int count = 0;
        
        for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = flatten[count];
				count++;
			}
		}
        
        return result;
    }
}