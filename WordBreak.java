class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean result[] = new boolean[s.length()+1];
        result[0] = true;
        for(int i = 1; i < s.length()+1; i++)
        {
            for(int j = 0; j < i; j++)
            {
               if(result[j] && wordDict.contains(s.substring(j,i))){
                   result[i] = true;
                   break;
               } 
            }
        }
        
        return result[s.length()];
    }
}