import java.io.*;
import java.util.*;

public static void main(String[] args) {
	Solution solution = new Solution();
	solution.reverseString("hello");
}


class Solution {
    public String reverseString(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s);
		stringBuilder = stringBuilder.reverse();       
		return stringBuilder.toString();
    }
}