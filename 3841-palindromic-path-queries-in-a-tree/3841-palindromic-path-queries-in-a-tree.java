import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] parent, depth, heavy, head, pos;
    private int curPos;
    private int[] segTree;
    private int[] nodeMask;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // Initialize adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // Initialize HLD structures
        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        Arrays.fill(heavy, -1);
        head = new int[n];
        pos = new int[n];
        curPos = 0;

        // Step 1: Compute sub-tree sizes, heavy children, and depths
        dfs(0, -1, 0);

        // Step 2: Flatten tree into segments using Heavy-Light Decomposition chains
        decompose(0, 0);

        // Step 3: Build Segment Tree over the flattened HLD indices
        segTree = new int[4 * n];
        nodeMask = new int[n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            nodeMask[i] = 1 << (chars[i] - 'a');
            updateSegTree(1, 0, n - 1, pos[i], nodeMask[i]);
        }

        List<Boolean> answer = new ArrayList<>();

        // Step 4: Process Queries
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                nodeMask[u] = 1 << (c - 'a');
                updateSegTree(1, 0, n - 1, pos[u], nodeMask[u]);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int pathMask = queryPath(u, v, n);
                // Can form a palindrome if at most one bit is set to 1
                boolean isPal = (pathMask == 0) || ((pathMask & (pathMask - 1)) == 0);
                answer.add(isPal);
            }
        }

        return answer;
    }

    private int dfs(int v, int p, int d) {
        parent[v] = p;
        depth[v] = d;
        int size = 1;
        int maxChildSize = 0;
        for (int c : adj[v]) {
            if (c != p) {
                int childSize = dfs(c, v, d + 1);
                size += childSize;
                if (childSize > maxChildSize) {
                    maxChildSize = childSize;
                    heavy[v] = c;
                }
            }
        }
        return size;
    }

    private void decompose(int v, int h) {
        head[v] = h;
        pos[v] = curPos++;
        if (heavy[v] != -1) {
            decompose(heavy[v], h);
        }
        for (int c : adj[v]) {
            if (c != parent[v] && c != heavy[v]) {
                decompose(c, c);
            }
        }
    }

    private void updateSegTree(int treeIdx, int low, int high, int idx, int val) {
        if (low == high) {
            segTree[treeIdx] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (idx <= mid) {
            updateSegTree(2 * treeIdx, low, mid, idx, val);
        } else {
            updateSegTree(2 * treeIdx + 1, mid + 1, high, idx, val);
        }
        segTree[treeIdx] = segTree[2 * treeIdx] ^ segTree[2 * treeIdx + 1];
    }

    private int querySegTree(int treeIdx, int low, int high, int ql, int qr) {
        if (ql > high || qr < low) return 0;
        if (ql <= low && qr >= high) return segTree[treeIdx];
        int mid = low + (high - low) / 2;
        return querySegTree(2 * treeIdx, low, mid, ql, qr) ^ 
               querySegTree(2 * treeIdx + 1, mid + 1, high, ql, qr);
    }

    private int queryPath(int u, int v, int n) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] > depth[head[v]]) {
                int temp = u; u = v; v = temp; // Swap u and v
            }
            res ^= querySegTree(1, 0, n - 1, pos[head[v]], pos[v]);
            v = parent[head[v]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp; // Swap u and v
        }
        res ^= querySegTree(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}
