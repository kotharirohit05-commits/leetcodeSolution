class Solution {

    private int dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        int count = 1;
        for(int nei : adj.get(node)){
            if(!vis[nei]){
                count += dfs(nei, adj, vis);
            }
        }
        return count;
    }


    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];
            for(int j =0; j < n; j++){

                if(i == j) continue;

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                
                long dx = x2 - x1;
                long dy = y2 - y1;
                long distsq = dx * dx + (dy * dy);
                long distr = r * r;
                if(distsq <= distr){
                    list.get(i).add(j);
                }

            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            boolean[] vis = new boolean[n];

            ans = Math.max(ans, dfs(i, list, vis));
        }

        return ans;

    }
}