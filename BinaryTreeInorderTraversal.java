import java.util.ArrayList;
import java.util.List;

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
	
		Solution solution = new Solution();
		List<Integer> result = solution.inorderTraversal(root1);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " -> ");
		}
	}
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
    	if(root.left==null && root.right==null){
    		result.add(root.val);
    		return result;
    	}
    	List<Integer> left = inorderTraversal(root.left);
    	List<Integer> right = inorderTraversal(root.right);
    	result.addAll(left);
    	result.add(root.val);
    	result.addAll(right);
    	
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
