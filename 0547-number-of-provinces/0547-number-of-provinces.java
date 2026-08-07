class Solution {

    private void dfs(int node , List<List<Integer>> list, boolean[] visi){
        visi[node] = true;
        for(int x : list.get(node)){
            if(!visi[x]){
                dfs(x, list, visi);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    list.get(i).add(j);
                }
            }
        }

        boolean[] visi = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!visi[i]){
                provinces++;
                dfs(i, list, visi);
            }
        }
        return provinces;

    }
}