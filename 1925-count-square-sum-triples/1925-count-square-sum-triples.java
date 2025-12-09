class Solution {
    public int countTriples(int n) {
        int count = 0;
       for(int i = 1 ; i < n; i++){
        for(int j = i + 1 ; j < n ; j++){
            int sq = i*i + j*j;
            int c = (int)Math.sqrt(sq);
            if(c <= n && c*c == sq)
            count += 2;
        }
       } 
       
       return count;
    }

}