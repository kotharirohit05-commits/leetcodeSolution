class Solution {

    class Pair{
        int first;
        int second;
        char third;
        Pair(int first, int second, char third){
            this.first = first;
            this.second = second;
            this.third = third;
    
        }
    }

    public int[] lastVisitedCell(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        char ch = grid[0][0];
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visi = new boolean[n][m];

        queue.add(new Pair(0,0,ch));
        visi[0][0] = true;

        while(!queue.isEmpty()){
            int cr = queue.peek().first;
            int cc = queue.peek().second;
            char currchar = queue.peek().third;
            
            queue.remove();

            int nr = 0;
            int nc = 0;

            if(currchar == 'R'){

                nr = cr + 0;
                nc = cc + 1;

            }else if(currchar == 'L'){

                nr = cr + 0;
                nc = cc - 1;

            }else if(currchar == 'U'){

                nr = cr - 1;
                nc = cc + 0;

            }else{

                nr = cr + 1;
                nc = cc + 0;

            }
            if(nr >= n || nr < 0 || nc < 0 || nc >= m){
                return new int[]{cr, cc};
            }
            if(visi[nr][nc]){
                return new int[]{cr,cc};
            }
            if(!visi[nr][nc]){
                visi[nr][nc] = true;
                queue.add(new Pair(nr,nc,grid[nr][nc]));
            }
            
            
        }

        return new int[]{-1,-1};
    }
}