public static void main(String[] args) {
	Solution solution = new Solution();
	String[] test = {"wieuh","wbsd","shdk","","xhs","xxv"};
	findWords(test);
}

class Solution {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList();

        for (int i = 0; i < words.length; i++) 
        	if(words[i].toLowerCase().matches("[qwertyuiop]*") ||
        		words[i].toLowerCase().matches("[asdfghjkl]*") ||
        		words[i].toLowerCase().matches("[zxcvbnm]*"))
        		result.add(words[i]);
        
        String[] resultInStr = new String[result.size()];
        return result.toArray(resultInStr);
    }
}