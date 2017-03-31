// basic idea is if A cannot reach C,
// then any station btw A and C cannot reach C
// suppose A -> B -> C, the total gas in B = gas remainded + gas[B] >= gas[B]

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        // TODO: int curGas(0), startPos(0), totalCost(0), totalGas(0);
        int curGas = 0;
        int startPos = 0;
        int totalCost = 0;
        int totalGas = 0;

        for(int i = 0; i < gas.size(); i++)
        {
        	totalCost += cost[i];
        	totalGas += gas[i];
        	curGas += gas[i];

        	if(curGas >= cost[i])
        	{
        		curGas -= cost[i]; 
        	}
        	else
        	{
        		curGas = 0;
        		startPos = i + 1;
        	}
        }

        if(totalGas >= totalCost)	
        	return startPos;
        else
        	return -1;
    }
};


int main(int argc, char const *argv[])
{
	// gas
	std::vector<int> v1;
	v1.push_back(4);
	// v1.push_back(2);
	// v1.push_back(3);
	// v1.push_back(100);
	// v1.push_back(1);

	// cost
	std::vector<int> v2;
	v2.push_back(5);
	// v2.push_back(1);
	// v2.push_back(5);
	// v2.push_back(6);
	// v2.push_back(10);

	Solution sol = Solution();
	int res = sol.canCompleteCircuit(v1, v2);

	cout << res << endl;

	return 0;
}

