class Solution {

    static final long MOD = 1_000_000_007L;

    int maxDepth = 0;

    public void dfs(int node, int parent, int depth,
                    ArrayList<ArrayList<Integer>> adj) {

        maxDepth = Math.max(maxDepth, depth);

        for (int nei : adj.get(node)) {
            if (nei != parent) {
                dfs(nei, node, depth + 1, adj);
            }
        }
    }

    public long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1, 0, 0, adj);

        return (int) modPow(2, maxDepth - 1);
    }
}