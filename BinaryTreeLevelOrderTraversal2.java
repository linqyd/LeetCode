
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Solution1 solution1 = new Solution1();
		
		List<List<Integer>> result = new ArrayList<>();
		result = solution1.levelOrderBottom(root);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println(" ");
		}
		
	}
}

class Solution1 {
	private List<List<Integer>> result;
	
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		this.result = new ArrayList<>();
		if(root == null)
			return result;
		else
			recersion(root, 0);
		// reverse the result
		Collections.reverse(result);
		return result;   
	 }
	 
	 void recersion(TreeNode root, int level) {
		 if(this.result.size() > level)
			 this.result.get(level).add(root.val);
		 else {
			 List<Integer> temp = new ArrayList<>();
			 temp.add(root.val);
			 this.result.add(level, temp);
		 }
		 
		 if(root.left != null)
			 recersion(root.left, level+1);
		 
		 if(root.right != null)
			 recersion(root.right, level+1);
	 }
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
