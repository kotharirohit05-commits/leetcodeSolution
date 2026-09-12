import java.util.*;

class Solution {
    // A helper class to represent an interval along with its original index
    private static class Interval {
        int l, r, weight, id;
        
        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    // A helper class to hold the DP state results
    private static class Result {
        long weight;
        int[] selected;

        Result(long weight, int[] selected) {
            this.weight = weight;
            this.selected = selected;
        }

        // Returns true if 'this' is strictly better than 'other'
        boolean isBetterThan(Result other) {
            if (this.weight != other.weight) {
                return this.weight > other.weight; // Maximize weight
            }
            // If weights are equal, choose the lexicographically smaller index array
            for (int i = 0; i < this.selected.length; i++) {
                if (this.selected[i] != other.selected[i]) {
                    return this.selected[i] < other.selected[i];
                }
            }
            return false;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> curr = intervalsList.get(i);
            intervals[i] = new Interval(curr.get(0), curr.get(1), curr.get(2), i);
        }
        
        // Sort intervals primarily by start time (l)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.l, b.l));
        
        // memo[i][quota] stores the best Result from interval i to n-1 with 'quota' choices left
        Result[][] memo = new Result[n][5];
        
        return dp(0, 4, intervals, memo).selected;
    }

    private Result dp(int i, int quota, Interval[] intervals, Result[][] memo) {
        // Base cases
        if (i == intervals.length || quota == 0) {
            return new Result(0, new int[0]);
        }
        
        if (memo[i][quota] != null) {
            return memo[i][quota];
        }

        // Option 1: Skip the current interval
        Result best = dp(i + 1, quota, intervals, memo);

        // Option 2: Pick the current interval
        int nextIdx = binarySearch(intervals, intervals[i].r);
        Result nextResult = dp(nextIdx, quota - 1, intervals, memo);
        
        long pickWeight = intervals[i].weight + nextResult.weight;
        
        // Build and sort the new array of selected indices
        int[] pickSelected = new int[nextResult.selected.length + 1];
        pickSelected[0] = intervals[i].id;
        System.arraycopy(nextResult.selected, 0, pickSelected, 1, nextResult.selected.length);
        Arrays.sort(pickSelected); // Ensure it is sorted for lexicographical comparison

        Result pickResult = new Result(pickWeight, pickSelected);

        // Compare Option 1 and Option 2
        if (pickResult.isBetterThan(best)) {
            best = pickResult;
        }

        memo[i][quota] = best;
        return best;
    }

    // Finds the first interval that starts strictly after the current interval ends (l > r)
    private int binarySearch(Interval[] intervals, int targetR) {
        int low = 0, high = intervals.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (intervals[mid].l > targetR) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
