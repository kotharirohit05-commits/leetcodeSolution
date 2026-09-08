class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char ch: t.toCharArray()){
            freq[ch]++;
        }

        int sL = 0;
        int mL = Integer.MAX_VALUE;
        int count = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char r = s.charAt(right);
            if(freq[r] > 0){
                count++;
            }
            freq[r]--;
            while(count == t.length()){
                if(right - left + 1 < mL){
                    mL = right - left + 1;
                    sL = left;
                }

                char ch = s.charAt(left);
                freq[ch]++;
                if(freq[ch] > 0){
                    count--;
                }
                left++;
            }
        }
        return mL == Integer.MAX_VALUE ? "" : s.substring(sL, mL + sL);

    }
}