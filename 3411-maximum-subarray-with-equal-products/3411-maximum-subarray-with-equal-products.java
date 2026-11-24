class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 2; // Any subarray of length 2 always satisfies prod == lcm * gcd

        for (int i = 0; i < n; i++) {
            int currProd = 1;
            int currGcd = 0;
            int currLcm = 1;

            for (int j = i; j < n; j++) {
                currProd *= nums[j];
                currGcd = gcd(currGcd, nums[j]);
                currLcm = lcm(currLcm, nums[j]);

                // Max possible lcm(1..10) * max(1..10) = 2520 * 10 = 25200
                // Stop early to prevent integer overflow
                if (currProd > 25200) {
                    break;
                }

                if (currProd == currLcm * currGcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
