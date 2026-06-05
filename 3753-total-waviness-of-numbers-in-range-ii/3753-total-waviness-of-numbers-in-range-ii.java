import java.util.Arrays;

class Solution {
    private long[][][][][] memoCount;
    private long[][][][][] memoWaviness;

    public long totalWaviness(long num1, long num2) {
        return countWaviness(num2) - countWaviness(num1 - 1);
    }

    private long countWaviness(long limit) {
        if (limit <= 0) return 0;
        
        String s = Long.toString(limit);
        int n = s.length();
        
        memoCount = new long[n][11][11][2][2];
        memoWaviness = new long[n][11][11][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    Arrays.fill(memoCount[i][j][k][0], -1);
                    Arrays.fill(memoCount[i][j][k][1], -1);
                    Arrays.fill(memoWaviness[i][j][k][0], -1);
                    Arrays.fill(memoWaviness[i][j][k][1], -1);
                }
            }
        }
        
        long[] result = solve(0, 10, 10, 0, 0, s);
        return result[1];
    }

    private long[] solve(int idx, int prev, int pprev, int isLess, int isStarted, String s) {
        if (idx == s.length()) {
            return new long[]{isStarted == 1 ? 1L : 0L, 0L};
        }

        if (memoCount[idx][prev][pprev][isLess][isStarted] != -1) {
            return new long[]{
                memoCount[idx][prev][pprev][isLess][isStarted],
                memoWaviness[idx][prev][pprev][isLess][isStarted]
            };
        }

        int limitDigit = (isLess == 1) ? 9 : (s.charAt(idx) - '0');
        long totalCount = 0;
        long totalWaviness = 0;

        for (int d = 0; d <= limitDigit; d++) {
            int nextLess = (isLess == 1 || d < (s.charAt(idx) - '0')) ? 1 : 0;

            if (isStarted == 0) {
                if (d == 0) {
                    
                    long[] res = solve(idx + 1, 10, 10, nextLess, 0, s);
                    totalCount += res[0];
                    totalWaviness += res[1];
                } else {
                    
                    long[] res = solve(idx + 1, d, 10, nextLess, 1, s);
                    totalCount += res[0];
                    totalWaviness += res[1];
                }
            } else {
                
                int isWavinessPoint = 0;
                if (pprev != 10) {
                    if ((prev > pprev && prev > d) || (prev < pprev && prev < d)) {
                        isWavinessPoint = 1;
                    }
                }

                long[] res = solve(idx + 1, d, prev, nextLess, 1, s);
                totalCount += res[0];
                totalWaviness += res[1] + (isWavinessPoint * res[0]);
            }
        }

        memoCount[idx][prev][pprev][isLess][isStarted] = totalCount;
        memoWaviness[idx][prev][pprev][isLess][isStarted] = totalWaviness;

        return new long[]{totalCount, totalWaviness};
    }
}
