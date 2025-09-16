class Solution {
    
    private boolean isAlphanumeric(char ch) {
        if ((ch >= '0' && ch <= '9') || 
            (ch >= 'a' && ch <= 'z') || 
            (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!isAlphanumeric(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlphanumeric(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
