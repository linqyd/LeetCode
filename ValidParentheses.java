class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return false;
        List<Character> result = new ArrayList();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                result.add(s.charAt(i));
            else
            {
                if(result.size() == 0) return false;
                
                if((s.charAt(i) == ')' && result.get(result.size()-1) == '(') 
                   || (s.charAt(i) == '}' && result.get(result.size()-1) == '{') 
                   || (s.charAt(i) == ']' && result.get(result.size()-1) == '[') 
                  )
                    result.remove(result.size()-1);
                else
                    return false;
            }
        }
        
        if(result.size() == 0) return true;
        else return false;
    }
}