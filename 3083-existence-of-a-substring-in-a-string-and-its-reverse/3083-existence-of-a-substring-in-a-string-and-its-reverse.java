class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String k = sb.reverse().toString();
        for(int i= 0 ; i < s.length() - 1 ; i++){
            String sub = s.substring(i , i + 2);
            if(k.contains(sub)) return true;
        }
        
        return false;
    }
}