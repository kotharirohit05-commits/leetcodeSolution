class Solution {
    int min = Integer.MAX_VALUE;

    public void dfs(int i, boolean[] visi, List<int[]>[] graph) {
        visi[i] = true;

        for (int[] next : graph[i]) {
            int adj = next[0];
            int weight = next[1];
            min = Math.min(min, weight);
            if (!visi[adj]) {
                dfs(adj, visi, graph);
            }
        }
    }

    public int minScore(int n, int[][] roads) {

        List<int[]>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
        }
        boolean[] visi = new boolean[n+1];

        dfs(1, visi, graph);
        return min;

    }
}