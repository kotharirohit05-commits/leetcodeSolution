class Solution {

    private boolean bfs(int node , int[] v, List<List<Integer>> adj){
        v[node] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int next = queue.peek();
            queue.remove();
            for(int p : adj.get(next)){
                if(v[p] == -1){
                    v[p] = 1 - v[next];
                    queue.add(p);
                }else if(v[p] == v[next]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int x : graph[i]) {
                adj.get(i).add(x);
            }
        }

        int[] v = new int[n];
        Arrays.fill(v , -1);
        for(int i = 0; i < n; i++){
            if(v[i] == -1){
               if(bfs(i, v, adj) == false) return false;
            }
        }
        return true;

    }
}