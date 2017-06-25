package leetcode;

import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		
	}
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();
	 
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();
	 
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
    	return solver(nestedList, 0);
    }
    
    int solver(List<NestedInteger> nestedList, int lvl){
    	if(nestedList.isEmpty())
    		return 0;
    	
    	int result = 0;
    	for (int i = 0; i < nestedList.size(); i++) {
    		NestedInteger cur = nestedList.get(i);
			if(cur.isInteger())
				result += cur.getInteger() * lvl;
			else
				result += solver(cur.getList(), lvl+1);
		}
    	
    	return result;
    }
}