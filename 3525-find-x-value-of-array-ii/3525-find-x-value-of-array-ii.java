class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.prod = 1;
            this.cnt = new int[k];
        }
    }

    private int n;
    private int k;
    private Node[] tree;

    private void merge(Node res, Node left, Node right) {
        res.prod = (left.prod * right.prod) % k;
        
        // Copy left counts
        for (int rem = 0; rem < k; ++rem) {
            res.cnt[rem] = left.cnt[rem];
        }
        
        // Add right counts shifted by the total product of the left child
        for (int rem = 0; rem < k; ++rem) {
            int targetRem = (left.prod * rem) % k;
            res.cnt[targetRem] += right.cnt[rem];
        }
    }

    private void build(int[] nums, int node, int start, int end) {
        tree[node] = new Node(k);
        if (start == end) {
            int val = nums[start] % k;
            tree[node].prod = val;
            tree[node].cnt[val] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, 2 * node, start, mid);
        build(nums, 2 * node + 1, mid + 1, end);
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            java.util.Arrays.fill(tree[node].cnt, 0);
            int v = val % k;
            tree[node].prod = v;
            tree[node].cnt[v] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        if (r <= mid) {
            return query(2 * node, start, mid, l, r);
        }
        if (l > mid) {
            return query(2 * node + 1, mid + 1, end, l, r);
        }
        Node leftRes = query(2 * node, start, mid, l, r);
        Node rightRes = query(2 * node + 1, mid + 1, end, l, r);
        Node res = new Node(k);
        merge(res, leftRes, rightRes);
        return res;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];
        
        build(nums, 1, 0, n - 1);
        
        int q = queries.length;
        int[] result = new int[q];
        
        for (int i = 0; i < q; ++i) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            update(1, 0, n - 1, index, value);
            Node resNode = query(1, 0, n - 1, start, n - 1);
            result[i] = resNode.cnt[x];
        }
        
        return result;
    }
}
