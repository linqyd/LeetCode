public class Leetcode {
	public static void main(String[] args) {
		int n=3;
		Solution solution = new Solution();
		System.out.println(solution.countNumbersWithUniqueDigits(n));
	}
}

class Solution {
	public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 2;
        if(n==1) return 10;
        
        int[] resultTable = new int[(int) Math.pow(10, n)];
        resultTable[0] = 2;
        resultTable[1] = 10;
        resultTable[2] = resultTable[1] + 9*9;
        for (int i = 3; i < n; i++) {
        	int newComb = 9 * 9;
        	for(int j = 3; j<=i; j++)
        	{
        		if(9-j+2>1)
        			newComb *= (9-j+2);
        	}
        	if(9-i+2>1)
        		resultTable[i] = resultTable[i-1] + newComb;
        	else
        		resultTable[i] = resultTable[i-1];
		}
		
		return resultTable[n];
    }
}