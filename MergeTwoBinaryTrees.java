public class Leetcode {
	public static void main(String[] args) {
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		
		Solution solution = new Solution();
		TreeNode a = solution.mergeTrees(root1, root2);
		System.out.println(a.val + " " + a.left.val + " " + a.right.val);
		
	}
}

/**
 * Definition for a binary tree node.
 **/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	// base case
    	if(t1 == null)	return t2;
    	if(t2 == null)	return t1;
    	
    	int t1Val,t2Val;
    	
    	t1Val = t1.val;
    	t2Val = t2.val;
    		
    	int rootVal = t1Val + t2Val;	
    	
		TreeNode result = new TreeNode(rootVal);
		
		result.left = mergeTrees(t1.left, t2.left);
		result.right = mergeTrees(t1.right, t2.right);
		
    	return result;
    }
}