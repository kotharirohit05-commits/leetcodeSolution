
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int divisibleIslandCount = 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
              
                if (grid[r][c] > 0) {
                    long islandSum = 0; 
                    Queue<int[]> queue = new LinkedList<>();
                    
                    queue.offer(new int[]{r, c});
                    islandSum += grid[r][c];
                    grid[r][c] = 0; 
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int currR = curr[0];
                        int currC = curr[1];
                        
                        for (int[] dir : directions) {
                            int nr = currR + dir[0];
                            int nc = currC + dir[1];
                            
                            
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                islandSum += grid[nr][nc];
                                grid[nr][nc] = 0; 
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                
                    if (islandSum % k == 0) {
                        divisibleIslandCount++;
                    }
                }
            }
        }
        
        return divisibleIslandCount;
    }
}
