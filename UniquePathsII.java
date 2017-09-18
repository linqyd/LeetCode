class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        if(x == 0) return 0;
        int y = obstacleGrid[0].length;
        int[][] result = new int[x][y];
        
        if(obstacleGrid[0][0] == 1)
            result[0][0] = 0;
        else
            result[0][0] = 1;
        
        for(int i = 1; i < x; i++)
            if(obstacleGrid[i][0] == 1)
                result[i][0] = 0;
            else result[i][0] = result[i-1][0];
        
        for(int i = 1; i < y; i++)
            if(obstacleGrid[0][i] == 1) 
                result[0][i] = 0;
            else result[0][i] = result[0][i-1];
        
        for(int i = 1; i < x; i++)
            for(int j = 1; j < y; j++)
                if(obstacleGrid[i][j] == 1)
                    result[i][j] = 0;
                else 
                    result[i][j] = result[i-1][j] + result[i][j-1];
        
        return result[x-1][y-1];
    }
}