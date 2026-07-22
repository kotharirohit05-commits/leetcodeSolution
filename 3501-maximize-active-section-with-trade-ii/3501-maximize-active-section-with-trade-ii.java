import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int baseOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') baseOnes++;
        }

        // Identify all blocks of '0's
        List<int[]> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                zeroBlocks.add(new int[]{start, i - 1});
            } else {
                i++;
            }
        }

        int m = zeroBlocks.size();
        List<Integer> answer = new ArrayList<>(queries.length);
        
        // No trade can be performed if there aren't at least two '0' blocks
        if (m < 2) {
            for (int k = 0; k < queries.length; k++) {
                answer.add(baseOnes);
            }
            return answer;
        }

        // fullGains[j] stores the combined length of zeroBlocks[j] and zeroBlocks[j+1]
        int[] fullGains = new int[m - 1];
        for (int j = 0; j < m - 1; j++) {
            int lenJ = zeroBlocks.get(j)[1] - zeroBlocks.get(j)[0] + 1;
            int lenJ1 = zeroBlocks.get(j + 1)[1] - zeroBlocks.get(j + 1)[0] + 1;
            fullGains[j] = lenJ + lenJ1;
        }

        // Precompute Sparse Table for RMQ on fullGains
        int maxK = (int) (Math.log(m - 1) / Math.log(2)) + 1;
        int[][] st = new int[m - 1][maxK];
        for (int j = 0; j < m - 1; j++) {
            st[j][0] = fullGains[j];
        }
        for (int k = 1; k < maxK; k++) {
            for (int idx = 0; idx + (1 << k) <= m - 1; idx++) {
                st[idx][k] = Math.max(st[idx][k - 1], st[idx + (1 << (k - 1))][k - 1]);
            }
        }

        // Arrays to perform binary search on block boundaries
        int[] starts = new int[m];
        int[] ends = new int[m];
        for (int j = 0; j < m; j++) {
            starts[j] = zeroBlocks.get(j)[0];
            ends[j] = zeroBlocks.get(j)[1];
        }

        for (int[] q : queries) {
            int li = q[0];
            int ri = q[1];
            int maxGain = 0;

            // Find range of pairs (j, j+1) where the 1-block is inside [li, ri]
            // Condition: ends[j] >= li AND starts[j+1] <= ri
            int idxStart = lowerBound(ends, li);
            int idxEnd = upperBound(starts, ri) - 2;

            if (idxStart <= idxEnd) {
                // Check boundary pairs individually since they can be cut off by li or ri
                int[] candidates = {idxStart, idxEnd};
                for (int j : candidates) {
                    if (j >= idxStart && j <= idxEnd) {
                        int zLeft = zeroBlocks.get(j)[1] - Math.max(zeroBlocks.get(j)[0], li) + 1;
                        int zRight = Math.min(zeroBlocks.get(j + 1)[1], ri) - zeroBlocks.get(j + 1)[0] + 1;
                        maxGain = Math.max(maxGain, zLeft + zRight);
                    }
                }

                // Check fully internal pairs efficiently using the Sparse Table
                if (idxStart + 1 <= idxEnd - 1) {
                    maxGain = Math.max(maxGain, queryRMQ(st, idxStart + 1, idxEnd - 1));
                }
            }

            answer.add(baseOnes + maxGain);
        }

        return answer;
    }

    private int queryRMQ(int[][] st, int L, int R) {
        if (L > R) return 0;
        int k = (int) (Math.log(R - L + 1) / Math.log(2));
        return Math.max(st[L][k], st[R - (1 << k) + 1][k]);
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
