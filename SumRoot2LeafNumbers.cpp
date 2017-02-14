#include <stddef.h>

struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    int sumNumbers(TreeNode* root) {
       return sum(root, 0);
    }

    int sum(TreeNode* n, int s){
		if (n == NULL) 
			return 0;
	
		if (n->right == NULL && n->left == NULL) return s * 10 + n->val;
		{
			int result = sum(n->left, s * 10 + n->val) + sum(n->right, s * 10 + n->val);
			return result;
		}
	}
};

int main(int argc, char *argv[])
 	{
 		
    }

/**
 * 	convert string to number
 * 	a = 0
	foreach digit in string
	do
   		a = 10 * a + digit
	end
 */
