class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        if (totalSum % 3 != 0) return false;

        int target = totalSum / 3;
        int currentSum = 0;
        int partsFound = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];

            if (currentSum == target) {
                partsFound++;
                currentSum = 0;

                if (partsFound == 2) {
                    return true; 
                }
            }
        }

        return false;
    }
}
