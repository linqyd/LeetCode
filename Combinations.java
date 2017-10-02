class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        solver(1,k,n,new ArrayList(),result);
        return result;
    }
    
    private void solver(int idx, int k, int n, List<Integer> temp, List<List<Integer>> result)
    {
        if(k==0){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i = idx; i <= n; i++)
        {
            temp.add(i);
            solver(i+1,k-1,n,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}