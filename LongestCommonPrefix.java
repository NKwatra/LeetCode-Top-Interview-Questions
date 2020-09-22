class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        String prefix = findPrefix(strs[0], strs[1]);
        for(int i = 2; i < strs.length; i++)
        {
            prefix = findPrefix(strs[i], prefix);
            if(prefix.length() == 0)
                return "";
        }
        
        return prefix;
    }
    
    
    public String findPrefix(String s1, String s2)
    {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s1.length() && j < s2.length())
        {
            if(s1.charAt(i) != s2.charAt(j))
                break;
            
            sb.append(s1.charAt(i));
            
            i++;
            j++;
        }
        
        return sb.toString();
    }
}
