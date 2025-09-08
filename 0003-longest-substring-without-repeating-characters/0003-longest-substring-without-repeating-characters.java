class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , right = 0 , maxl = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while(right < n){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxl = Math.max(maxl , right - left + 1);
            right++;
        }
        return maxl;

    }
}