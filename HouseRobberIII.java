/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Leetcode {
	public static void main(String[] args) {
		TreeNode tNode = new TreeNode(3);
		tNode.left = new TreeNode(2);
		tNode.right = new TreeNode(3);
		
		tNode.left.right = new TreeNode(4);
//		tNode.right.right = new TreeNode(1);
		// 96
		// 14
		Solution solution = new Solution();
		System.out.println(solution.rob(tNode));
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
    public int rob(TreeNode root) {
    	if(root == null) return 0;
    	int result1 = 0, result2 = 0;
        int current = root.val;
    	
    	if(root.left == null && root.right == null)
    		return root.val;
        
    	if(root.left == null && root.right != null)
    	{
    		result1 = (rob(root.right.left) + rob(root.right.right)) + current;
//    		result2 = rob(root.right);
    	}
    		
    	else if(root.right == null && root.left != null)
    	{
    		result1 = (rob(root.left.left) + rob(root.left.right)) + current;
//    		result2 = rob(root.left);
    	}
    	
        // if both current.left and current right are not selected
    	else if(root.left.right==null && root.left.left!=null && 
    			root.right.right!=null && root.right.left!=null)
    		result1 = rob(root.left.left) + (rob(root.right.left) + 
    				rob(root.right.right)) + current;
    	
    	else if(root.left.right!=null && root.left.left==null && 
    			root.right.right!=null && root.right.left!=null)
    		result1 = rob(root.left.right) + (rob(root.right.left) + 
    				rob(root.right.right)) + current;
    	
    	else if(root.left.right!=null && root.left.left!=null && 
    			root.right.right==null && root.right.left!=null)
    		result1 = rob(root.left.left) + (rob(root.left.right) + 
    				rob(root.right.left)) + current;
    	
    	else if(root.left.right!=null && root.left.left!=null && 
    			root.right.right!=null && root.right.left==null)
    		result1 = rob(root.left.left) + (rob(root.left.right) + 
    				rob(root.right.right)) + current;
    	
    	else
	        result1 = (rob(root.left.left) + rob(root.left.right)) + 
	        		(rob(root.right.left) + rob(root.right.right)) + 
	        		current;
    	
	    // if current val is not selected
	    result2 = rob(root.left) + rob(root.right);
    	
    	return Math.max(result1, result2);
    }
