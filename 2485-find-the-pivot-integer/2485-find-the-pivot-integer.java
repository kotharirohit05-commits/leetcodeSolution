class Solution {
    public int pivotInteger(int n) {
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + i;
        }

        for (int i = 1; i <= n; i++) {
            int left = prefix[i];
            int right = prefix[n] - prefix[i - 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
