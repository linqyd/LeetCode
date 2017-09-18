class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int result = 0;
        
        while(first != last) {
            result = Math.max(result,Math.min(height[first],height[last])*(last-first));
            if(height[first]<height[last])
                first++;
            else
                last--;            
        }       
        
       return result; 
    }
}