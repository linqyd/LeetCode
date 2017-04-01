#include <stdio.h> 
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    vector< vector<string> > partition(string s){
        vector< vector<string> > list;
        vector<string> tempList;
        backtrack(list, tempList, s, 0);
        return list;      
    }

    void backtrack(vector<vector<string> >& list, 
        vector<string>& tempList, string s, int start)
    {
        // base case
        if(start == s.size())
            list.push_back(tempList);
        else{
            for (int i = start; i < s.size(); ++i)
            {
                if(isPalidrome(s,start,i)){
                    // add new substr into the templist
                    // NOTE: substr in cpp and java are different!
                    tempList.push_back(s.substr(start,i+1-start));

                    backtrack(list,tempList, s, i+1);

                    // delete the element added in before recursion
                    // restore the templist as before this loop
                    tempList.pop_back();
                }
            }
        }
    }

    // test pass
    bool isPalidrome(string s, int low, int high)
    {
        while(low<high)
            if(s.at(low++) != s.at(high--))
                return false;
        return true;
    }

};

int main(int argc, char const *argv[])
{
    string str = "acc";
    string str1 = "aab";
    string str2 = "abbbba";

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