import java.util.*;

class Solution {
    // Helper to safely add an element to a frequency map
    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    // Helper to safely remove an element from a frequency map
    private void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    private void balance(TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right, 
                         long[] state, int x) {
        // state[0] = leftSize, state[1] = rightSize, state[2] = leftSum, state[3] = rightSum
        
        // 1. Fix any out-of-order inversions between left and right sets
        while (state[0] > 0 && state[1] > 0 && left.lastKey() > right.firstKey()) {
            int maxLeft = left.lastKey();
            int minRight = right.firstKey();
            
            remove(left, maxLeft);
            state[2] -= maxLeft;
            state[0]--;
            
            add(right, maxLeft);
            state[3] += maxLeft;
            state[1]++;
            
            remove(right, minRight);
            state[3] -= minRight;
            state[1]--;
            
            add(left, minRight);
            state[2] += minRight;
            state[0]++;
        }

        int targetLeftSize = (x + 1) / 2;
        
        // 2. Adjust sizes to meet the target median positioning
        while (state[0] > targetLeftSize) {
            int maxLeft = left.lastKey();
            remove(left, maxLeft);
            state[2] -= maxLeft;
            state[0]--;
            
            add(right, maxLeft);
            state[3] += maxLeft;
            state[1]++;
        }
        
        while (state[0] < targetLeftSize && state[1] > 0) {
            int minRight = right.firstKey();
            remove(right, minRight);
            state[3] -= minRight;
            state[1]--;
            
            add(left, minRight);
            state[2] += minRight;
            state[0]++;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        
        // state representation: [leftSize, rightSize, leftSum, rightSum]
        long[] state = new long[4];
        
        // Initialize the first window of size x
        for (int i = 0; i < x; i++) {
            int val = nums[i];
            if (state[0] == 0 || val <= left.lastKey()) {
                add(left, val);
                state[2] += val;
                state[0]++;
            } else {
                add(right, val);
                state[3] += val;
                state[1]++;
            }
            balance(left, right, state, x);
        }
        
        long median = left.lastKey();
        cost[0] = (state[0] * median - state[2]) + (state[3] - state[1] * median);
        
        // Slide the window across the remaining elements
        for (int i = 1; i <= n - x; i++) {
            int outVal = nums[i - 1];
            if (left.containsKey(outVal)) {
                remove(left, outVal);
                state[2] -= outVal;
                state[0]--;
            } else {
                remove(right, outVal);
                state[3] -= outVal;
                state[1]--;
            }
            
            int inVal = nums[i + x - 1];
            if (state[0] == 0 || inVal <= left.lastKey()) {
                add(left, inVal);
                state[2] += inVal;
                state[0]++;
            } else {
                add(right, inVal);
                state[3] += inVal;
                state[1]++;
            }
            
            balance(left, right, state, x);
            
            median = left.lastKey();
            cost[i] = (state[0] * median - state[2]) + (state[3] - state[1] * median);
        }
        
        // Dynamic Programming Setup
        long INF = 1_000_000_000_000_000L; 
        long[][] dp = new long[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0; 
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + cost[i - x]);
                }
            }
        }
        
        return dp[n][k];
    }
}
