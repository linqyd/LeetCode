import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<TreeNode> result = solution.generateTrees(3);
	}
}
class Solution {
    public List<TreeNode> generateTrees(int n) {
    	return solver(1, n);
    }

    List<TreeNode> solver(int base, int n) {
    	List<TreeNode> result = new ArrayList<>();	
    	if(n==1) result.add(new TreeNode(base));
    		
    	for (int i = 1; i < n + 1; i++) {
    		List<TreeNode> left = solver(base, i-1);
    		List<TreeNode> right = solver(base + i, n - i);
    		
    		if(left.isEmpty())
    			for (int j = 0; j < right.size(); j++) {
					TreeNode root = new TreeNode(base + i-1);
					root.right = right.get(j);
					result.add(root);
				}
    		
    		if(right.isEmpty())
				for (int j = 0; j < left.size(); j++) {
					TreeNode root = new TreeNode(base + i-1);
					root.left = left.get(j);
					result.add(root);
				}
    		
    		for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode root = new TreeNode(base + i-1);
					root.left = left.get(j);
					root.right = right.get(k);
					result.add(root);
				}
			}
		}
    	
    	return result;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}