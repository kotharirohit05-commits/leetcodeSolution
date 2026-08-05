class Solution {

    private void dfs(int node, List<List<Integer>> adj, boolean[] suspicious) {

        suspicious[node] = true;

        for (int nei : adj.get(node)) {
            if (!suspicious[nei]) {
                dfs(nei, adj, suspicious);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Build graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Mark all suspicious methods
        boolean[] suspicious = new boolean[n];
        dfs(k, adj, suspicious);

        // Check if any outside method invokes a suspicious method
        for (int[] edge : invocations) {

            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {

                // Cannot remove anything
                List<Integer> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }

                return ans;
            }
        }

        // Remove suspicious methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}