import java.util.ArrayList;
import java.util.List;

public class Leetcode {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(-3);
//		TreeNode left1 = new TreeNode(6);
//		left1.left = new TreeNode(-2);
//		left1.left.right = new TreeNode(17);
//		left1.left.left = new TreeNode(20);
		
//		TreeNode right1 = new TreeNode(-2);
//		right1.right = new TreeNode(8);
//		right1.left = new TreeNode(6);
//		right1.left.left = new TreeNode(10);
//		right1.left.left.left = new TreeNode(39);
		
//		root1.left = left1;
//		root1.right = right1;
		
		BSTIterator bstIterator = new BSTIterator(root1);
		while (bstIterator.hasNext()) {
			bstIterator.next();
		}
		System.out.println(" ");
		System.out.println("finish");
	}
}

class BSTIterator {
	private List<TreeNode> path;
    public BSTIterator(TreeNode root) {
    	this.path = buildPath(root);
    }

    private List<TreeNode> buildPath(TreeNode root){
    	List<TreeNode> path = new ArrayList<>();
    	if(root == null) return path;
    	if (root.left != null) 
			path.addAll(buildPath(root.left));

    	path.add(root);
    	return path;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	if(!this.path.isEmpty()) return true;
    	return false;
    }

    /** @return the next smallest number */
    public int next() {
    	List<TreeNode> rightPath;
    	TreeNode current = this.path.get(0);
    	this.path.remove(0);
    	
    	if(current.right != null){
    		rightPath = buildPath(current.right);
    		rightPath.addAll(this.path);
	    	this.path = rightPath;	
    	}
        return current.val;
    }
}

/**
 * Definition for binary tree
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */