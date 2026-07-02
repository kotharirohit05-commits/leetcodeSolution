class Solution {
    class Pair {
        int first;
        int second;
        int health;
        Pair(int first, int second, int health) {
            this.first = first;
            this.second = second;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0) return false;

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(0, 0, startHealth));
        int[] dr = { 0, -1, 1, 0 };
        int[] dc = { 1, 0, 0, -1 };

        while (!queue.isEmpty()) {
            int r = queue.peek().first;
            int c = queue.peek().second;
            int currhealth = queue.peek().health;
            queue.remove();
            if(r == n-1 && c == m-1)return true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr <  0 || nr >= n || nc < 0 || nc >= m )continue;

                int newH = currhealth - grid.get(nr).get(nc);

                if(newH <= 0) continue;

                if(newH > best[nr][nc]){
                    best[nr][nc] = newH;
                    queue.add(new Pair(nr,nc,newH));
                }
                
            }
        }
        return false;

    }
}