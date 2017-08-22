public class Leetcode {
	public static void main(String[] args) {
		int n=1;
		Solution solution = new Solution();
		System.out.println(solution.maxA(n));
	}
}

class Solution {
	public int maxA(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        
        int[][] resultTable = new int[N][4];
        // Key 1: (A)
		resultTable[0][0] = 1;
		// Key 2: (Ctrl-A)
		resultTable[0][1] = 0;
		// Key 3: (Ctrl-C)
		resultTable[0][2] = 0;
		// Key 4: (Ctrl-V)
		resultTable[0][3] = 0;
        
		resultTable[1][0] = 2;
		resultTable[1][1] = 1;
		resultTable[1][2] = 1;
		resultTable[1][3] = 0;
		
        for (int i = 2; i < resultTable.length; i++) {
			resultTable[i][0] = Math.max(resultTable[i-1][3],resultTable[i-1][0]) + 1;
			resultTable[i][1] = resultTable[i][2] = Math.max(resultTable[i-1][3],resultTable[i-1][0]);
			int max = -1;
			for (int j = 2; j < i-2; j++) 
				max = resultTable[i-j][1]*j > max ? resultTable[i-j][1]*j : max;
			
			resultTable[i][3] = max;
		}
        
		return Math.max(resultTable[N-1][0], resultTable[N-1][3]);
    }
}