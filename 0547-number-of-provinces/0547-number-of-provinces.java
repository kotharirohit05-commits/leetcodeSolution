class Solution {
    public void dfs(int n, boolean[] visited, List<List<Integer>> list){
        visited[n] = true;
        for(int x : list.get(n)){
            if(!visited[x]){
                dfs(x, visited, list);
            }
        }
    }




    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(isConnected[i][j] == 1 && i != j)
                list.get(i).add(j);
            }
        }
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, visited, list);
            }
        }
        return provinces;
    }
}