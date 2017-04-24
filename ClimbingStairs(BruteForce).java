package leetcode;

public class Leetcode {

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.climbStairs(10)
		System.out.println(solution.result);
	}
}

class Solution {
	int result;

	public int climbStairs(int n) {
		solver(n, 1);
		solver(n, 2);
		return this.result;
	}

	void solver(int n, int step) {
		if (n > step) {
			solver(n - step, 1);
			solver(n - step, 2);
		} else if (n == step) 
			this.result++;
	}
}
