class Solution {
    
    private static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && grid[r][c] == 0) {
                    bfs(grid, r, c, rows, cols);
                }
            }
        }
        
        int closedIslandsCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    closedIslandsCount++;
                    bfs(grid, r, c, rows, cols);
                }
            }
        }
        
        return closedIslandsCount;
    }
    
    private void bfs(int[][] grid, int startR, int startC, int rows, int cols) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(startR, startC));
        grid[startR][startC] = 1; 
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            Pair cell = queue.poll();
            
            for (int[] dir : directions) {
                int nextR = cell.row + dir[0];
                int nextC = cell.col + dir[1];
                
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 0) {
                    grid[nextR][nextC] = 1; 
                    queue.offer(new Pair(nextR, nextC));
                }
            }
        }
    }
}
