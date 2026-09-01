import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startRow = -1, startCol = -1;
        List<int[]> litterList = new ArrayList<>();
        
        // Find 'S' and all 'L' positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (ch == 'L') {
                    litterList.add(new int[]{i, j});
                }
            }
        }
        
        int k = litterList.size();
        int targetMask = (1 << k) - 1;
        
        // Map litter coordinates to their corresponding index bit
        int[][] litterIdx = new int[m][n];
        for (int[] row : litterIdx) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < k; i++) {
            int[] pos = litterList.get(i);
            litterIdx[pos[0]][pos[1]] = i;
        }
        
        // 4D Visited array: [row][col][mask][energy]
        boolean[][][][] visited = new boolean[m][n][1 << k][energy + 1];
        
        // Queue for BFS stores arrays of: {row, col, mask, current_energy, moves}
        Queue<int[]> queue = new LinkedList<>();
        
        // Initial setup at 'S'
        int initialMask = 0;
        // Check if 'S' itself is a litter cell (not possible per description, but safe)
        if (litterIdx[startRow][startCol] != -1) {
            initialMask |= (1 << litterIdx[startRow][startCol]);
        }
        
        if (initialMask == targetMask) {
            return 0; // No litter to collect
        }
        
        queue.offer(new int[]{startRow, startCol, initialMask, energy, 0});
        visited[startRow][startCol][initialMask][energy] = true;
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int eng = curr[3];
            int moves = curr[4];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                
                // Out of bounds check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                
                char cell = classroom[nr].charAt(nc);
                // Obstacle check
                if (cell == 'X') continue;
                
                // Energy consumption
                int nextEng = eng - 1;
                if (nextEng < 0) continue;
                
                // Handle properties of the new cell
                int nextMask = mask;
                if (cell == 'R') {
                    nextEng = energy; // Reset energy to full capacity
                } else if (cell == 'L') {
                    int idx = litterIdx[nr][nc];
                    if (idx != -1) {
                        nextMask |= (1 << idx);
                    }
                }
                
                // If all litter is collected, return the total moves instantly
                if (nextMask == targetMask) {
                    return moves + 1;
                }
                
                // If state hasn't been visited with this energy, visit it
                if (!visited[nr][nc][nextMask][nextEng]) {
                    visited[nr][nc][nextMask][nextEng] = true;
                    queue.offer(new int[]{nr, nc, nextMask, nextEng, moves + 1});
                }
            }
        }
        
        return -1;
    }
}
