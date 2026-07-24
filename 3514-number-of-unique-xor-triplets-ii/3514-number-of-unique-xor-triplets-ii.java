class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }

        boolean[] hasNum = new boolean[limit];
        for (int num : nums) {
            hasNum[num] = true;
        }

        boolean[] pairXorExists = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            if (!hasNum[i]) continue;
            for (int j = 0; j < limit; j++) {
                if (!hasNum[j]) continue;
                pairXorExists[i ^ j] = true;
            }
        }

        boolean[] tripletXorExists = new boolean[limit];
        for (int pairXor = 0; pairXor < limit; pairXor++) {
            if (!pairXorExists[pairXor]) continue;
            for (int k = 0; k < limit; k++) {
                if (!hasNum[k]) continue;
                tripletXorExists[pairXor ^ k] = true;
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < limit; i++) {
            if (tripletXorExists[i]) {
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}