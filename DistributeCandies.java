public static void main(String[] args) {
	Solution solution = new Solution();
	int[] test = {1,1,1,1,1,2};
	solution.distributeCandies(test);
}

class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> result = new HashMap();
        for (int i = 0; i < candies.length; i++) {
        	if(	!result.containsKey(candies[i]))
        		result.put(candies[i],1);
        }

        int typeCount = result.size();
        
        if(typeCount > candies.length/2)
        	return candies.length/2;
        else
        	return typeCount;
    }
}