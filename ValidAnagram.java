import java.util.Arrays;

public class Leetcode {

	public static void main(String[] args) {
		
	}
}

class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length())
    		return false;
    	
    	char[] s2= s.toCharArray();
    	char[] t2 = t.toCharArray();
    	Arrays.sort(s2);
    	Arrays.sort(t2);
    	 	
    	for (int i = 0; i < s2.length; i++) 
			if(s2[i] != t2[i])
				return false;
    	
		return true;
    }
}