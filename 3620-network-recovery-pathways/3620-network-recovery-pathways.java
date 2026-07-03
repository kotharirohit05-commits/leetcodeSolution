class Solution {

    List<int[]>[] graph;
    int[] topo;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
            indegree[v]++;

            low = Math.min(low, w);
            high = Math.max(high, w);
        }

        // No edges
        if (edges.length == 0)
            return -1;

        // Topological Sort
        Queue<Integer> q = new ArrayDeque<>();
        topo = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] nei : graph[u]) {
                if (--indegree[nei[0]] == 0)
                    q.offer(nei[0]);
            }
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(mid, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int limit, boolean[] online, long k) {

        int n = online.length;

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int w = edge[1];

                if (w < limit)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }

        return dist[n - 1] <= k;
    }
}