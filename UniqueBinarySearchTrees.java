public class Leetcode {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numTrees(0));
	}
}

class Solution {
    public int numTrees(int n) {
    	if (n==0) return 1;
        int[] opt1 = new int[n+1];
    	
    	// recurrence 
        // opt[i][n]: num of com of n element with root i
        // opt[i][n] = opt1[i-1]*opt1[n-i];
        // opt1[n]:num of comb of n element
        // opt1[n] = opt[1,n] + opt[2,n]+....+opt[n,n];
        opt1[0] = 1;
        opt1[1] = 1;
        
        for (int j = 2; j < n+1; j++) {
        	for (int k = 0; k < j; k++) {
        		opt1[j] += opt1[k] * opt1[j-(k+1)];
			}
		}
                
    	return opt1[n];
    }
}