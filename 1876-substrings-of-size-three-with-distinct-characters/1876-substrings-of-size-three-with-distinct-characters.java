class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int left = 0;
        int[] freq = new int[26];

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq[ch - 'a']++;

            if (r - left + 1 > 3) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }
            if (r - left + 1 == 3) {
                if (isunq(freq)) {
                    count++;
                }
            }

        }

        return count;
    }

    private boolean isunq(int[] freq) {
        int subcount = 0;
        for (int k : freq) {
            if (k > 0) {
                subcount++;
            }
        }
        return subcount == 3;
    }
}