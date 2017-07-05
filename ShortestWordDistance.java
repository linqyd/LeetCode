public class Leetcode {
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
	}
}

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int count1 = words.length;
        int count2 = words.length;
        int result = words.length;
        
    	for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)) {
				count1 = i;
				result = Math.min(result, Math.abs(count1-count2));
			}
			
			if(words[i].equals(word2)) {
				count2 = i;
				result = Math.min(result, Math.abs(count1-count2));
			}
		}
    	
    	return result;
    }
}