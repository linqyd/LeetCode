public class Leetcode {
	public static void main(String[] args) {
		int n = 1,k = 1;
		Solution solution = new Solution();
		System.out.println(solution.numWays(n, k));
	}
}

class Solution {
public int numWays(int n, int k) {
		if(n == 0) return 0;
		if(n == 1) return k;
	
		int sameColor = k;
		int diffColor = k * (k-1);
		
		for (int i = 2; i < n; i++) {
			int preDiff = diffColor;
			// i-1 and i have diff color
			diffColor = (diffColor + sameColor) * (k-1);
			// i-1 and i have same color
			sameColor = preDiff;	
		}
     	
		return diffColor+sameColor;
    }
}