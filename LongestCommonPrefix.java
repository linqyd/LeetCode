public class Leetcode {
	public static void main(String[] args) {
		String[] strs = {"hjk","hjkk","hiiiiii"};
		// i is 8
		Solution sol = new Solution();
		System.out.println(sol.longestCommonPrefix(strs));
	}
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs.length == 0) return result.toString();
        if(strs.length == 1) return strs[0];
        
        String str1 = strs[0];
        String str2 = strs[1];
        int upperBound = str1.length() <= str2.length() ? str1.length():str2.length();
        
        for(int i = 0; i < upperBound; i++)
            if(str1.charAt(i) == str2.charAt(i)) result.append(str1.charAt(i));
            else break;
        
        for(int i = 2; i < strs.length; i++){
            if(result.length() < strs[i].length())
            	strs[i] = strs[i].substring(0, result.length());
            else
				result = new StringBuilder(result.subSequence(0, strs[i].length()));

            for(int j = 0; j < strs[i].length(); j++){
                if(result.charAt(j) != strs[i].charAt(j)) {
                    result = new StringBuilder(result.subSequence(0, j));
                    break;
                }
            }
        }
        return result.toString();
    }
}
