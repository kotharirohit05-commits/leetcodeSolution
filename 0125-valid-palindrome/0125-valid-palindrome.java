class Solution {
    
    private boolean alphanumeric(char ch){
        if(ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z'|| ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(!alphanumeric(s.charAt(start))){
                start++;
            }
            else if(!alphanumeric(s.charAt(end))){
                end--;
            }
            else{
                if((Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))){
                return false;
            }
            
            start++;
            end--;
            
            }
        }
        return true;
    }
}
