public class Leetcode {
	public static void main(String[] args) {
		String str = new String("    2147483648");
		// i is 8
		Solution sol = new Solution();
		System.out.println(sol.myAtoi(str));
	}
}

class Solution {
    public int myAtoi(String str) {
    	int result = 0;
    	boolean isStart = false;
    	int sign = 1;
    	
        for (int i = 0; i < str.length(); i++) {
        	// 48 - 57 0-9
        	if(str.charAt(i) == '-' && !isStart) {
        		sign = -1;
        		isStart = true;
        		continue;
        	}
            if(str.charAt(i) == '+' && !isStart) {
        		isStart = true;
        		continue;
        	}
        	
        	if(str.charAt(i) == 32 && !isStart) continue;
			if((str.charAt(i) < 48 || str.charAt(i) > 57) && !isStart) return 0;
            if((str.charAt(i) < 48 || str.charAt(i) > 57)  && isStart) return sign*result;
			else {
				isStart = true;
				int temp = result * 10 + (str.charAt(i)-48);
				// boundary check
				if((temp-(str.charAt(i)-48))/10 != result 
						|| (temp>0 && result<0) || (temp<0 && result>0)) {
					if(sign == 1)   return Integer.MAX_VALUE;
					else            return Integer.MIN_VALUE;
				}
//				if((temp>0 && result<0) || (temp<0 && result>0)) {
//					if(sign == 1)   return Integer.MAX_VALUE;
//					else            return Integer.MIN_VALUE;
//				}
				else result = temp;
			}
		}
        System.out.println("sign " + sign);
        return sign*result;
    }
}
