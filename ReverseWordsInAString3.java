import java.util.List;


public class Leetcode {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String testCase1 = "Let's take LeetCode contest";
		System.out.println(solution.reverseWords(testCase1));
	}
}

class Solution {
	public String reverseWords(String s) {
		String result = "";
		String[] strs = s.split(" ");
		
		for (int i = 0; i < strs.length; i++) {
			String reverseStr = "";
			
			for (int j = 0; j < strs[i].length(); j++) 
				reverseStr += strs[i].charAt(strs[i].length() - 1 - j);
			
			result += (reverseStr + " ");
		}
		return result.trim();   
    }
}