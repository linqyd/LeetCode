public class Leetcode {
	public static void main(String[] args) {
		int[][] costs = {{2,1,4},{2,5,3},{2,6,3},{5,6,4}};
		Solution solution = new Solution();
		System.out.println(solution.minCost(costs));
	}
}

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0) return 0;
        
    	int[][] opt = new int[costs.length][3];
    	opt[0][0] = costs[0][0];
    	opt[0][1] = costs[0][1];
    	opt[0][2] = costs[0][2];
    	
    	// for ith house in color c1, the cost of painting i-1th house is optimal
    	for (int i = 1; i < costs.length; i++) {
    		// i is in red
    		opt[i][0] = Math.min(opt[i-1][1] + costs[i][0], opt[i-1][2] + costs[i][0]);
    		// i is in blue
    		opt[i][1] = Math.min(opt[i-1][0] + costs[i][1], opt[i-1][2] + costs[i][1]);
    		// i is in green
    		opt[i][2] = Math.min(opt[i-1][0] + costs[i][2], opt[i-1][1] + costs[i][2]);
		}
    	
    	return Math.min(opt[costs.length-1][0], 
    			Math.min(opt[costs.length-1][1], opt[costs.length-1][2]));
    }
}