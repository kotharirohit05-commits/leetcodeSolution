class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int diff = 0;

        for (int i = 0; i < n1; i++) {
            int low = i;
            int high = n2 - 1;
            int kkk = bs(low, high, i, nums1, nums2);
            diff = Math.max(kkk - i, diff);
        }
        return diff;

    }

    private int bs(int l, int h, int p, int[] nums1, int[] nums2) {
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums2[mid] >= nums1[p]) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            } 

        }
        return ans;

    }
}