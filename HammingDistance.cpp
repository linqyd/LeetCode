#include <stdio.h>

class Solution {
public:
    int hammingDistance(int x, int y) {

        int result = x ^ y;
        int c = 0;
        for (c =0; result; result >>= 1) 
        	c += result & 1; 
    	
    	return c;
    }
};

int main(int argc, char *argv[]){
	Solution* sol = new Solution();

    printf("the result is %d\n", sol->hammingDistance(100,20));
}

