class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long CAP = 1_000_000_000_000_001L; // 1e15 + 1

        long[] len = new long[n + 1];
        len[0] = 0;

        // Compute lengths after each operation
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            long cur = len[i];

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = Math.min(CAP, cur + 1);
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, cur - 1);
            } else if (ch == '#') {
                len[i + 1] = Math.min(CAP, cur * 2);
            } else { // '%'
                len[i + 1] = cur;
            }
        }

        if (k < 0 || k >= len[n]) {
            return '.';
        }

        long pos = k;

        // Walk backwards to find the character at index k
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = len[i];

            if (ch >= 'a' && ch <= 'z') {
                if (pos == prevLen) {
                    return ch;
                }
                // otherwise pos remains unchanged
            } else if (ch == '*') {
                // Characters before the deleted one keep same indices
            } else if (ch == '#') {
                if (pos >= prevLen) {
                    pos -= prevLen;
                }
            } else { // '%'
                pos = prevLen - 1 - pos;
            }
        }

        return '.';
    }
}