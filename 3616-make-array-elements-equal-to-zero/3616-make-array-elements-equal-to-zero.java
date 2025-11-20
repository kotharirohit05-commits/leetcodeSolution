class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try starting left
                if (simulate(nums, i, -1)) ans++;

                // Try starting right
                if (simulate(nums, i, 1)) ans++;
            }
        }

        return ans;
    }

    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();  // copy array
        int curr = start;
        int d = dir; // direction: -1 = left, 1 = right

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += d;
            } else {
                arr[curr]--;
                d = -d;      // reverse direction
                curr += d;
            }
        }

        // Check if all values became zero
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }
}
