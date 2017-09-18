class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        int min; 
        List<List<Integer>> result = new ArrayList();
        List<Integer> firstLine = new ArrayList();
        firstLine.add(triangle.get(0).get(0));
        result.add(firstLine);
        
        for(int i = 1; i < triangle.size(); i++)
        {
            for(int j = 0; j < triangle.get(i).size();j++)
            {
                if(j == 0) {
                    List<Integer> temp = new ArrayList();
                    temp.add(result.get(i-1).get(j)+triangle.get(i).get(j));
                    result.add(temp);
                }
                else if(j == triangle.get(i).size()-1)
                    result.get(i).add(result.get(i-1).get(j-1)+triangle.get(i).get(j));
                else 
                    result.get(i).add(Math.min(result.get(i-1).get(j-1), 
                                        result.get(i-1).get(j))+triangle.get(i).get(j)); 
            }
        }
        
        min = result.get(triangle.size()-1).get(0);
    
        for(int i = 1; i < triangle.get(triangle.size()-1).size(); i++)
            min = Math.min(min,result.get(triangle.size()-1).get(i));
        
        return min;
    }
}