package leetcode;

public class Leetcode {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.climbStairs(10));
	}
}

class Solution {
	int[][] resultArray;
	
	public int climbStairs(int n) {
		resultArray = new int[3][n+1];
		return solver(n, 1) + solver(n, 2);
	}

	int solver(int n, int step) {
		if (n > step) {
			int sub1, sub2;
			
			int result1 = this.resultArray[1][n-step];
			if( result1 > 0)
				sub1 = result1;
			else
				sub1 = solver(n - step, 1);
			
			int result2 = this.resultArray[2][n-step];
			if( result2 > 0)
				sub2 = result2;
			else
				sub2 = solver(n - step, 2);	
			
			this.resultArray[step][n] = sub1 + sub2;
			return this.resultArray[step][n];

		} // base case
		else if (n == step) 
		{
			this.resultArray[step][n] = 1;
			return 1;
		}
		else {
			return 0;
		}
	}
}