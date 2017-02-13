#include <vector> 
#include <iostream> 
#include <iterator> 


using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	vector<int> result(2);
       	// mark another adding num
       	int i;

       	for (size_t j = 0; j < nums.size(); ++j)
       	{
       		i = target - nums[j];

   			for (size_t k = j+1; k < nums.size(); ++k)
   			{
   				if (nums[k] == i)
   				{
   					result[0] = j;
   					result[1] = k;
   					return result;
   				}
   			}
       	}
    }
};

int main(int argc, char *argv[])
 	{
 		Solution *solution = new Solution();
    	int target = 9;
    	vector<int> nums;
    	nums.push_back(2);
    	nums.push_back(7);
    	nums.push_back(11);
    	nums.push_back(15);

    	vector<int> result = solution->twoSum(nums,target);

    	copy(result.begin(), result.end(), ostream_iterator<int> (cout, "\n"));  
    }