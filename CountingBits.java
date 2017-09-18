class Solution {
    public int[] countBits(int num) {
        int result[] = new int[num+1];
        int offset = 1;
        result[0] = 0;
        for(int i = 1; i < num + 1; i++){
            if(offset*2 == i)
                offset *=2;
                
            result[i] = result[i-offset] +1;
        }
        return result;
    }
}