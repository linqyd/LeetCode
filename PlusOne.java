class Solution {
    public int[] plusOne(int[] digits) {
        int[] result;
        if(digits.length == 1 && digits[0] == 9) { 
            int[] temp = {1,0};
            return temp;
        }
        int carry = 0;
        if(digits[digits.length-1] + 1 > 9) {
            carry = 1;
            digits[digits.length-1] = 0;
        }
        else
            digits[digits.length-1] += 1;
        
        for(int i = digits.length-2; i > 0; i--)
        {
            if(digits[i]+carry > 9) {
                carry = 1;
                digits[i] = 0;
            }
            else{
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }
        
        if(digits[0] + carry > 9)
        {   
            digits[0] = 0;
            result = new int[digits.length+1];
            result[0] = 1;
            for(int i = 1; i < digits.length+1;i++)
                result[i] = digits[i-1];
        }
        else
        {
            digits[0] += carry;
            result = digits;
        }
        return result;
    }
}

// better solution
// public int[] plusOne(int[] digits) {
        
//     int n = digits.length;
//     for(int i=n-1; i>=0; i--) {
//         if(digits[i] < 9) {
//             digits[i]++;
//             return digits;
//         }
        
//         digits[i] = 0;
//     }
    
//     int[] newNumber = new int [n+1];
//     newNumber[0] = 1;
    
//     return newNumber;
// }
