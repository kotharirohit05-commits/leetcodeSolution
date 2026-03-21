class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            freq[ch]++;
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = 0;

        for(int right = 0 ; right < s.length() ; right++){
            char ch = s.charAt(right);
            if(freq[ch] > 0){
                count += 1;
            }
            freq[ch]--;
            while(count == t.length()){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    sIndex = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    count--;
                }

                left++;
                
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIndex , sIndex + minLen);

    }
}