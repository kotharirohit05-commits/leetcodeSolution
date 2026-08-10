class Solution {

    class Pair {
        int dist;
        int row;
        int col;

        Pair(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }


        if (n == 1) {
            return 1;
        }

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        
        dist[0][0] = 1;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(1, 0, 0));

        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {

            Pair current = queue.remove();

            int d = current.dist;
            int r = current.row;
            int c = current.col;

            for (int i = 0; i < 8; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    d + 1 < dist[nr][nc]) {

                    dist[nr][nc] = d + 1;


                    if (nr == n - 1 && nc == n - 1) {
                        return d + 1;
                    }

                    queue.add(new Pair(d + 1, nr, nc));
                }
            }
        }

        return -1;
    }
}