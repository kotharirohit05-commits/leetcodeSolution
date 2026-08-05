class Solution {

    private boolean isValid(String su) {

        int l = 0;
        int r = su.length() - 1;


        while (l <= r) {

            if (su.charAt(l) != su.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        String ans = "";
        
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isValid(substring) && substring.length() > ans.length())  {
                    ans = substring;
                }
            }
        }

        return ans;
    }
}