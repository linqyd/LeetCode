public class Leetcode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(-3);
//		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(-2);
//		root.left = left;
		root.right = right;
		Solution solution = new Solution();
		if(solution.hasPathSum(root, -5))
			System.out.println("true");
		else 
			System.out.println("false");
		
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
    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null) return false;
    	
        if(root.left == null && root.right == null) 
        	if(root.val == sum)	return true;
        	else return false;
        
        if(root.left != null)
        	if(hasPathSum(root.left, sum-root.val))	return true;
        
        if(root.right !=null) 
			return hasPathSum(root.right, sum-root.val);
			    
    	return false;
    }
}