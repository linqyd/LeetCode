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
		System.out.println(solution.invertTree(root));
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode temp = root.left;
    	root.left = invertTree(root.right);
    	root.right = invertTree(temp);
    	return root;
    }
}