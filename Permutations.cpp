#include <iostream> 
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int> > permute(vector<int>& nums) {
    	solver(0, nums);
    	return result;
    }

    void solver(int head, vector<int> nums){

    	if(head == nums.size() -1 )
    	{
    		result.push_back(nums);
     	}
    	else
    	{
	    	for (int i = head; i < nums.size(); ++i)
	        {
	        	swap(nums, head, i);
	        	solver(head+1, nums);
	        	// reorder
	        	swap(nums, head, i);
	        }
	    }
    } 

    vector<vector<int> > result;

    void swap(vector<int>& nums, int a, int b)
    {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }

};

int main(int argc, char const *argv[])
{
	vector<int> v;
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);

	Solution sol = Solution();
	vector< vector<int> > res = sol.permute(v);

	for (int i = 0; i < res.size(); ++i)
	{
		for (int j = 0; j < res[i].size() ; ++j)
		{
			cout << res[i][j];
		}
		cout << "\n" << endl;
	}

	return 0;
}