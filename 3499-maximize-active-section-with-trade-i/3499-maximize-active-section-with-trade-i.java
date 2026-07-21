class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
         int n = s.length();

        // Count current active sections ('1')
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        // Augmented string
        String t = "1" + s + "1";

        // Run-length encoding
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> lens = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char c = t.charAt(i);
            int j = i;
            while (j < t.length() && t.charAt(j) == c) j++;
            chars.add(c);
            lens.add(j - i);
            i = j;
        }

        int bestGain = 0;

        // Interior '1' blocks (surrounded by '0's)
        for (int k = 1; k < chars.size() - 1; k++) {
            if (chars.get(k) == '1'
                    && chars.get(k - 1) == '0'
                    && chars.get(k + 1) == '0') {
                bestGain = Math.max(bestGain,
                        lens.get(k - 1) + lens.get(k + 1));
            }
        }

        return ones + bestGain;
    }
}