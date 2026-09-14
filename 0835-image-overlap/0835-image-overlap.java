import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> img1Ones = new ArrayList<>();
        List<int[]> img2Ones = new ArrayList<>();

        // Collect coordinates of all 1s in both matrices
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    img1Ones.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    img2Ones.add(new int[]{r, c});
                }
            }
        }

        // Map to store the frequency of each unique shift vector
        // Key represents the serialized string format: "deltaRow,deltaCol"
        Map<String, Integer> shiftCounts = new HashMap<>();
        int maxOverlap = 0;

        // Calculate shift vectors between all pairs of 1s
        for (int[] p1 : img1Ones) {
            for (int[] p2 : img2Ones) {
                int deltaRow = p2[0] - p1[0];
                int deltaCol = p2[1] - p1[1];
                
                String key = deltaRow + "," + deltaCol;
                int currentCount = shiftCounts.getOrDefault(key, 0) + 1;
                shiftCounts.put(key, currentCount);
                
                maxOverlap = Math.max(maxOverlap, currentCount);
            }
        }

        return maxOverlap;
    }
}
