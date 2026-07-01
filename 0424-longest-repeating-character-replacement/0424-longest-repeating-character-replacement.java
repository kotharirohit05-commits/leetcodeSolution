class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mF = 0;
        int mL = 0;
        int l = 0;

        for(int r = 0; r < s.length() ; r++){
            char ch = s.charAt(r);
            freq[ch - 'A']++;
            mF = Math.max(mF, freq[ch-'A']);
            while( ( r + 1 - l ) - mF > k ){
                    freq[s.charAt(l) - 'A']--;
                    l++;
            }
            mL = Math.max(mL, r - l + 1);
        }
        return mL;
    }
}