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

    public int minimumEffortPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(0, 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {

            Pair current = pq.remove();

            int d = current.dist;
            int r = current.row;
            int c = current.col;

            if (r == n - 1 && c == m - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m) {

                    int currentDiff =
                        Math.abs(grid[r][c] - grid[nr][nc]);

                    int neweffort =
                        Math.max(currentDiff, d);

                    if (neweffort < dist[nr][nc]) {

                        dist[nr][nc] = neweffort;

                        pq.add(
                            new Pair(neweffort, nr, nc)
                        );
                    }
                }
            }
        }

        return 0;
    }
}