class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int l = 0 , r = 0 , ml = 0;
        while(r < n ){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ml = Math.max(ml,r-l +1);
            r++;
        }
        return ml;
    }
}