#include <iostream>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) 
        	return false;

        int sum = 0;
     	int copy = x;
        while(copy > 0)
        {
        	sum = (10 * sum) + (copy % 10);
        	copy /= 10;
        }

        bool res = sum == x? true: false;
        return res;
    }
};

int main(int argc, char const *argv[])
{
	Solution sol = Solution();
	cout << sol.isPalindrome(111) << endl;
	return 0;
}