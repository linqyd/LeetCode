public class Leetcode {
	public static void main(String[] args) {
		
		// floor
		String test	= "81018"; 
		Solution solution = new Solution();
		
		if(solution.isStrobogrammatic(test))
			System.out.println("1");
		else {
			System.out.println("0");
		}
	}
}

class Solution {
    public boolean isStrobogrammatic(String num) {
    	int pivo = num.length()/2 - 1;
    	
    	if(num.length() % 2 != 0){
    		char current = num.charAt((num.length()-1)/2);	
			if(current != '1' && current != '8' && current != '0')
				return false;
			else 
				num = num.substring(0, pivo+1) + num.substring(pivo+2);
    	}
    	
    	for (int i = 0; i <= pivo; i++) {
			char left = num.charAt(pivo - i);
			char right = num.charAt(pivo + i + 1);
			
			if(left != '1' && left != '6' && left != '9' && left != '8' && left != '0')
				return false;
			
			if(right != '1' && right != '6' && right != '9' && right != '8' && right != '0')
				return false;
			
			if((left == '1' && right != '1') || (left == '6' && right != '9')
				|| (left == '8' && right != '8') || (left == '9' && right != '6')
				|| (left == '0' && right != '0'))
				return false;
		}
    	return true;
    }
}