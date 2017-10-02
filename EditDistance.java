class Solution {
    public int minDistance(String word1, String word2) {
        int[][] opt = new int[word1.length()+1][word2.length()+1];
        opt[0][0] = 0;
        
        for(int i = 1; i<word1.length()+1; i++)
            opt[i][0] = i;

        for(int i = 1; i<word2.length()+1; i++)
            opt[0][i] = i;
        
        for(int i = 1; i<word1.length()+1; i++)
        {
            for(int j = 1; j < word2.length()+1; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    opt[i][j] = opt[i-1][j-1];
                else 
                    opt[i][j] = Math.min(opt[i-1][j-1], Math.min(opt[i-1][j], opt[i][j-1]))+1;
            }
        }
        
        return opt[word1.length()][word2.length()];
        
//         dp[i][0] = i;
//         dp[0][j] = j;
//         dp[i][j] = dp[i - 1][j - 1], if word1[i - 1] = word2[j - 1];
//         dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1)
    }
}