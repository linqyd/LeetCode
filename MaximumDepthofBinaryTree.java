public class Leetcode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
		TreeNode left = new TreeNode(6);
		left.left = new TreeNode(-2);
		
		TreeNode right = new TreeNode(-2);
		right.right = new TreeNode(8);
		right.left = new TreeNode(6);
		right.left.left = new TreeNode(10);
		
		root.left = left;
		root.right = right;
		Solution solution = new Solution();
		System.out.println(solution.maxDepth(root));
		
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
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;     
    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}