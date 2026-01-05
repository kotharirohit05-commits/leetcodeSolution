class Solution {
    public long maxMatrixSum(int[][] matrix) {

        int n = matrix.length;
        long sum = 0;                      
        int minAbs = Integer.MAX_VALUE;
        int negCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                if (val < 0) negCount++;
                sum += Math.abs(val);       
                minAbs = Math.min(minAbs, Math.abs(val));
            }
        }

        if (negCount % 2 == 0) return sum;
        return sum - 2L * minAbs;          
    }
}
