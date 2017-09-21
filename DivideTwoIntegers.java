class Solution {
    public int divide(int dividend, int divisor) {
        // consider overflow
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) 
            return Integer.MAX_VALUE;
        long ldividend = Math.abs((long) dividend);
	    long ldivisor = Math.abs((long) divisor);
        // corner case
        if ((dividend == 0) || (ldividend < ldivisor))	return 0;
        int result;
        // only if sign is different
        int sign = ((dividend<0) ^ (divisor<0)) ? -1:1;
        
	    long lresult = solver(ldividend, ldivisor);
        
        if(lresult >  Integer.MAX_VALUE)
            result = (sign==1) ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        else
            result = sign * ((int) lresult);
        
        return result;
    }
    
    private long solver(long dividend, long divisor)
    {
        // recursion base case
        if(dividend < divisor)
            return 0;
        long multiple = 1;
        long sum = divisor;
        while(sum*2 <= dividend)
        {
            sum *= 2;
            multiple+=multiple;
        }
        // if the gap between dividend-sum can be divided by divisor
        return multiple+solver(dividend-sum, divisor);
    }
}