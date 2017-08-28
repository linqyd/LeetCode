public class Leetcode {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(-3);
		TreeNode left1 = new TreeNode(6);
		left1.left = new TreeNode(-2);
		
		TreeNode right1 = new TreeNode(-2);
		right1.right = new TreeNode(8);
		right1.left = new TreeNode(6);
		right1.left.left = new TreeNode(10);
		
		root1.left = left1;
		root1.right = right1;
		
		TreeNode root2 = new TreeNode(-3);
		TreeNode left2 = new TreeNode(6);
		left2.left = new TreeNode(-2);
		
		TreeNode right2 = new TreeNode(-2);
		right2.right = new TreeNode(8);
		right2.left = new TreeNode(6);
		right2.left.left = new TreeNode(10);
		
		root2.left = left2;
		root2.right = right2;
		
		Solution solution = new Solution();
		if(solution.isSameTree(root1,root2))
			System.out.println("1");
		else 
			System.out.println("2");
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        
    	boolean result = (p.val == q.val)? true:false;
    	return result && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}