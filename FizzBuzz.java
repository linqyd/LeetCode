public static void main(String[] args) {
	Solution solution = new Solution();
	solution.fizzBuzz(283);
}


class Solution {
    public List<String> fizzBuzz(int n) {
    	List<String> result = new ArrayList();
        for (int i = 1; i <= n; i++) {
        	if((i%3 == 0) && (i%5 == 0)){
        		result.add(new String("FizzBuzz"));
        		continue;
        	}

        	if(i%3 == 0){
        		result.add(new String("Fizz"));
        		continue;
        	}

        	if(i%5 == 0){
        		result.add(new String("Buzz"));
        		continue;
        	}

        	result.add(Integer.toString(i));	
        }

        return result;
    }
}