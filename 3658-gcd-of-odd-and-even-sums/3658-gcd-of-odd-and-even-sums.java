class Solution {
    public int gcdOfOddEvenSums(int n) {
       
        
        int so = n*n;
        int se = n*(n+1);
        int k = Math.max(so,se);
        int m = Math.min(so,se);
        for(int i = m; i>=1 ; i-- ){
            if(k%i==0 && m%i==0){
                return i;
            }
        }
        return 1;
            
    }
}