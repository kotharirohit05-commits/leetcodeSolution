class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int left = 0;
        int count = 0;
        int zeros = 0;
        int ones = 0;
        
        for(int r = 0 ; r < s.length() ; r++){
            char ch = s.charAt(r);
            if(ch == '0') zeros++;
            else ones++;

            while(zeros > k && ones > k){
                if(s.charAt(left) == '0') zeros--;
                else ones--;
                left++;
            }
            count += (r - left + 1);
        }
        return count;
    }
}