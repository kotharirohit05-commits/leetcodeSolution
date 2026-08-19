import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store only rows that have reserved seats
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (!map.containsKey(row)) {
                map.put(row, new HashSet<>());
            }

            map.get(row).add(col);
        }

        // Initially assume every row can fit 2 families
        int ans = n * 2;

        // Check only rows having reserved seats
        for (int row : map.keySet()) {

            boolean left = true;   // 2,3,4,5
            boolean middle = true; // 4,5,6,7
            boolean right = true;  // 6,7,8,9

            HashSet<Integer> seats = map.get(row);

            // Check left group
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                }
            }

            // Check middle group
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                }
            }

            // Check right group
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                }
            }

            // We initially counted 2 families for this row.
            // Now adjust it.
            if (left && right) {
                // Can actually fit 2, so no change
            }
            else if (left || middle || right) {
                // Can fit only 1 instead of 2
                ans--;
            }
            else {
                // Cannot fit any
                ans -= 2;
            }
        }

        return ans;
    }
}