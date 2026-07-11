class Solution {
    int nodes;
    int edge;
    private void dfs(int i, boolean[] visited, List<Integer>[] graph ){
        visited[i] = true;
        edge += graph[i].size();
        nodes++;
        for(int x : graph[i]){
            if(!visited[x])
            dfs(x, visited, graph);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] x : edges){
            int u = x[0];
            int v = x[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int ans = 0;
        int count = 0;

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                nodes = 0;
                edge = 0;
                dfs(i, visited, graph);
                edge /= 2;
                if(edge == nodes * (nodes - 1) / 2){
                    ans++;
                }
            }

        }
        return ans;
        
        
    }
}