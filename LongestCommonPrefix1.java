public class Leetcode {
	public static void main(String[] args) {
		String[] strs = {"hjk","hjkk","hiiiiii"};
		// i is 8
		Solution sol = new Solution();
		System.out.println(sol.longestCommonPrefix(strs));
	}
}

// by using method indexOf
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String result = strs[0];
        
        for(int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(result) !=0)
                result = result.substring(0,result.length()-1);
        
        return result;
    }
}

