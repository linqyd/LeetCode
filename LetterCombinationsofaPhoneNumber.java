class Solution {
    public List<String> letterCombinations(String digits) {
        String[] IntCharMap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0) return result;
        result.add("");
        
        for(int i = 0; i < digits.length(); i++)
        {
            int inx = Character.getNumericValue(digits.charAt(i));
            String str = IntCharMap[inx];
            // only process the prefix has same length with counter i
            while(result.get(0).length() == i){
                String current = result.get(0);
                for(int k = 0; k < str.length(); k++)
                {
                    String temp = current;
                    // String.concat will return a new String
                    temp = temp.concat(Character.toString(str.charAt(k)));
                    result.add(result.size(),temp);
                }
                result.remove(0);
            }
        }
        
        return result;
    }
}