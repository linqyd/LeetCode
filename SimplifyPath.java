class Solution {
    public String simplifyPath(String path) {        
        List<String> stack = new ArrayList();
        
        String[] paths = path.split("/");
        for(int i = 0; i < paths.length; i++)
            if(paths[i].equals("..")) {
                if(!stack.isEmpty())
                    stack.remove(stack.size()-1);
            }
            else if(paths[i].equals(".") || paths[i].equals(""))
                continue;
            else
                stack.add(paths[i]);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++)
        {
            sb.append("/");
            sb.append(stack.get(i));
        }

        return (sb.length() == 0) ? "/" : sb.toString();
    }
}