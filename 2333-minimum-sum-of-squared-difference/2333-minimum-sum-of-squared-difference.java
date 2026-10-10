class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[100001];

        for(int i = 0; i < n; i++){
            int d = Math.abs(nums1[i] - nums2[i]);
            diff[d]++;
        }

        long k = (long)k1 + k2;

        long ans = 0;
        
        for(int i = 100000 ; i > 0 && k > 0; i--){
            
            if(diff[i] == 0) continue;
            long min = Math.min((long)diff[i], k);
            diff[i]     -= min;
            diff[i - 1] += min;
            k -= min;

        }

        for(int i = 0; i < 100001; i++){
            
            ans += (long)diff[i] * Math.pow(i, 2);
        }
        
        return ans;

    }
}