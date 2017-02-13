#include <string>
#include <stdio.h>

using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle.length() == 0 && haystack.length() == 0)
        {
            return 0;
        }
        
        if(needle.length() > haystack.length())
        {
            return -1;
        }
        
        int i;
        int index = -1;
        for(i = 0; i < haystack.length(); i++)
        {
            if(haystack.length() - i < needle.length())
            {
                index = -1;
                break;
            }
            
            if(haystack[i] == needle[0])
            {
                index = i;
                int j;
                for(j = 1; j < needle.length(); j++)
                {
                    if(haystack[i+j] != needle[j])
                    {
                        index = -1;
                        break;
                    }
                }
                if(j == needle.length())
                {
                    return index;
                }
            }
            else{
                index = -1;
            }
        }
        
       return index;
    }
};


int main(int argc, char *argv[]){
    Solution *solution = new Solution();
    string a = "mississippi";
    string b = "issip";
    int result = solution->strStr(a,b);

    printf("the result is %d\n", result);
}
