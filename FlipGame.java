import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		String string = "+++++++";
		Solution solution = new Solution();
		solution.generatePossibleNextMoves(string);
		
	}
}

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        // try for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
        for (int i = 1; i < s.length(); i++) 
			if(s.charAt(i-1) == '+' && s.charAt(i) == '+')
				results.add(s.substring(0,i-1) + "--" + s.substring(i+1, s.length()));
		
        return results;
    }
}