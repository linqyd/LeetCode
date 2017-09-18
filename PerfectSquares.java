class Solution {
    public int numSquares(int n) {
        if(n<2) return 1;
        
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        
        for(int i = 2; i < n+1; i++)
            result[i] = Integer.MAX_VALUE;
            
        for(int i = 2; i < n+1 ; i++)
            for(int j = 1; j*j <= i; j++)
                result[i] = Math.min(result[i], result[i-j*j]+1);
         
        return result[n];
    }
}