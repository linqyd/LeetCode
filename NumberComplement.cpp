#include <stdio.h>
#include <cmath>

class Solution {
public:
    int findComplement(int num) {
    	int rem = 0;
		int result = 0;
		int count = 0;
		int base = 0;

		while(num > 2){
			int rem = num % 2;
			num = num / 2;

			// any better solution?
			if(rem)
				base = 0;
			else
				base = 1;

			result += base * pow(2,count);
			count++;
		}

		// last bit
		if(num == 2)
		{
			base = 1;
			result += base * pow(2,count);
		}

    	return result;
    }
};



int main(int argc, char *argv[]){
	Solution* sol = new Solution();

    printf("the result is %d\n", sol->findComplement(5));
}