#include <unordered_map>
#include <vector>
#include <iostream>

using namespace std;

// @author Sylvia
// Complexity: Time O(N) Space: O(N)
// Description: numbers from nums1 and nums2 as keys of 
// hashmap count1 and count2
// interate hashmap count1 to see if current key is also in count2
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    	unordered_map<int, int> count1, count2;
    	vector<int> result;

    	for (int i = 0; i < nums1.size(); ++i)
    		count1.insert(make_pair(nums1[i], 1));

    	for (int i = 0; i < nums2.size(); ++i)
    		count2.insert(make_pair(nums2[i],1));

    	for (auto it = count1.begin(); it != count1.end(); ++it)
    		if(count2.find((int) it->first) != count1.end())
    			result.push_back((int) it->first);

    	return result;
    }
};

int main(int argc, char const *argv[])
{
	// compile with g++ -std=c++11
	std::vector<int> nums1 = {1,2,2,1};
	std::vector<int> nums2 = {2,2};

	Solution sol = Solution();
	std::vector<int> result = sol.intersection(nums1,nums2);
	for (int i = 0; i < result.size(); ++i)
		cout << result[i] << " ";

	return 0;
}