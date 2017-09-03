public class Leetcode {
	public static void main(String[] args) {
		String str = new String("abcdefghhhhh");
		// i is 8
		Solution sol = new Solution();
		System.out.println(sol.convert(str, 3));
	}
}

/**
 * 0 6 1 5 7 2 4 8 3 9
 * 
 * 1 7 2 6 8 3 5 9 4 10
 * 
 * 2*numRows-2 = 6
 */

class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		
		StringBuilder result = new StringBuilder();
		
		int numCols = ((s.length()/(2*numRows-2)+1) * (numRows-1));
		System.out.println(numCols);
		char[][] charList = new char[numCols][numRows];
		
		for (int i = 0; i < s.length(); i++) {
			int qoat = (i + 1) / (2 * numRows - 2); // 0
			int remainder = (i + 1) % (2 * numRows - 2); // 4 % (2*3-2) = 0
			
			if(remainder == 0) {
				remainder = (2 * numRows - 2);
				qoat--;
			}
			
			if (remainder <= numRows) 
				charList[qoat*(numRows-1)][remainder-1] = s.charAt(i);
			else {
				int rowOffset = remainder - numRows;
				charList[qoat*(numRows-1)+rowOffset][numRows-1-rowOffset] = s.charAt(i);
			}
		}

		for (int j = 0; j < numRows; j++){
			for (int i = 0; i < numCols; i++){ 
				if (charList[i][j] == 0)
				{
					System.out.print("-");
					continue;
				}
				else{
					System.out.print(charList[i][j]);
					result.append(charList[i][j]);
				}
			}
			
			System.out.println(" ");
		}
		
		return result.toString();
	}
}