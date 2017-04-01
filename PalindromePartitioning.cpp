#include <stdio.h> 
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
	vector< vector<string> > partition(string s){
		// use to store current result set
		vector<vector<string> > curResult;
		// use to store the result from recursive call
		vector<vector<string> > childResult;
		string currentSubStr;
    	string restSubStr;

        for (int i = 0; i < s.length(); ++i)
        {
        	currentSubStr = s.substr(0,i+1);
        	restSubStr = s.substr(i+1);

        	if(isPalidrome(currentSubStr)){
        		// base case
        		if(currentSubStr.size() == s.size())
        		{
                    vector<string> temp;
                    temp.push_back(currentSubStr);
                    curResult.push_back(temp);
        			return curResult;
        		}

        		childResult = partition(restSubStr);
        		
        		// add current sub string to result set
        		// TODO: can we use something like 'map' in functional programming?
        		for (int j = 0; j < childResult.size() ; ++j)
        		{
        			childResult[j].insert(childResult[j].begin(),currentSubStr);
        			curResult.push_back(childResult[j]);
        		}

        	}
        	else
        		continue;

        }

        return curResult;
	}

    	
    // test pass
    bool isPalidrome(string str)
    {
		for (int i = 0; i < str.length() / 2 ; ++i)
			if(str.at(i) != str.at(str.length()-1-i))
				return false;
		
		return true;
	}

};

int main(int argc, char const *argv[])
{
	string str = "acc";
	string str1 = "aab";
	string str2 = "abba";

	Solution* sol = new Solution();

	vector< vector<string> > result = sol->partition(str2);

	for (int i = 0; i < result.size(); ++i)
	{
		for (int j = 0; j < result[i].size(); ++j)
		{
			std::cout << result[i][j] << "\n";
		}
		printf("%s\n", "--");
	}

	return 0;
}