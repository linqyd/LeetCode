public class Leetcode {
	public static void main(String[] args) {
		int a = 153423646;
		Solution solution = new Solution();
		System.out.println(solution.reverse(a));
	}
}

class Solution {
	public int reverse(int x) {
		boolean isNeg = false;
		if(x<0) {
			isNeg = true;
			x = 0-x;
		}
			
	    int result = 0, newResult = 0,remainder = 0;	
	    
	    while(x>0){
	     	remainder =  x % 10; 
	   		newResult = result*10+ remainder;
	   		x /= 10;
	   		// handle overflow
	   		if((newResult-remainder) / 10 != result)
	   			return 0;
	   		
	   		result = newResult;
	    }	
	    	    
	    if(isNeg) return 0-result;
	    else return result;
   }
}