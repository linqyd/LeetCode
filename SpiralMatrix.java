class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if(matrix.length == 0) return result;
        // 0:right 1:down 2:left 3:up
        int direction = 0;
        int i = 0, j = 0;
        int rightUpper = matrix[0].length, rightLower = matrix.length, leftUpper = 1, leftLower = 0;
        
        for(int k = 0; k < matrix.length * matrix[0].length; k++)
        {
            result.add(matrix[i][j]);
            if(direction == 0 && j < rightUpper){
                // result.add(matrix[i][j]);
                if(j==rightUpper-1){
                    direction++;
                    i++;
                    rightUpper--;
                }
                else
                    j++;
                continue;
            } 
            
            if(direction == 1 && i < rightLower){
                // result.add(matrix[i][j]);
                if(i==rightLower-1){
                    direction++;
                    j--;
                    rightLower--;
                }
                else
                    i++;
                continue;
            }
            
            if(direction == 2 && j >= leftLower){
                // result.add(matrix[i][j]);
                if(j==leftLower){
                    direction++;
                    i--;
                    leftLower++;
                }
                else
                    j--;
                continue;
            }
            
            if(direction == 3 && i >= leftUpper){
                // result.add(matrix[i][j]);
                if(i==leftUpper){
                    System.out.println();
                    direction = 0;
                    j++;
                    leftUpper++;
                }
                else
                    i--;
                continue;
            }   
        }
        
      return result;  
    }
}