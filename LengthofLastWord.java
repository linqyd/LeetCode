class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        int idx = -1;
        // trim() will remove all leading and tailing space
        s = s.trim();
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == ' ')
                idx = i;

        return (s.length()-1-idx);
    }
}