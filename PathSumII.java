import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		TreeNode left = new TreeNode(6);
		left.left = new TreeNode(-2);
		
		TreeNode right = new TreeNode(-2);
		right.right = new TreeNode(8);
		right.left = new TreeNode(6);
		root.left = left;
		root.right = right;
		Solution solution = new Solution();
		List<List<Integer>> res = solution.pathSum(root, 1);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " -> ");
			}
			System.out.println(" ");
		}
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

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<>();
    	
        if(root == null) return result;
        // base case
        if(root.left == null && root.right == null)	{
        	if (root.val == sum) {
        		List<Integer> subResult = new ArrayList<>();
        		subResult.add(root.val);
        		result.add(subResult);
        	} 
			return result;
        }
        
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        
    	if(root.left != null) {
    		left = pathSum(root.left, sum-root.val);
    		if(left!=null)
	    		for (int i = 0; i < left.size(); i++) {
					left.get(i).add(0,root.val);
					result.add(left.get(i));
	    		}
    	}
    	
    	if(root.right != null) {
    		right = pathSum(root.right, sum-root.val);
    		if(right != null)
	    		for (int i = 0; i < right.size(); i++) {
					right.get(i).add(0,root.val);
					result.add(right.get(i));
	    		}
    	}
    	return result;
    }
}   