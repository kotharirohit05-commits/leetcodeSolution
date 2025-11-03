class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int count = 0;
        while(ans != 0){
            if(ans % 2 == 1){
                count += 1;
            }
            ans /= 2;
            
        }
        return count ;
    }
}