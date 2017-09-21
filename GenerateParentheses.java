class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        solver(result, "", 0, 0, n);
        return result;
    }
    
    private void solver(List<String> result, String subStr, int open, int close, int max)
    {
        if(subStr.length() == max*2)
        {
            result.add(subStr);
            return;
        }
        // keep adding "(" to any substring
        // solver(list, "(", 1, 0, max); -> solver(list, "((", 1, 0, max); -> solver(list, "(()", 1, 0, max) etc
        if(open < max)
            solver(result, subStr+"(", open+1, close, max);
        // try to close any open parenthese
        // solver(list, "()", 1, 1, max);
        if(close < open)
            solver(result, subStr+")", open, close+1, max);
    }
}