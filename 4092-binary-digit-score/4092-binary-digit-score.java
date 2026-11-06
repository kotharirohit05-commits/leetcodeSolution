class Solution {
    public int calculateScore(int a, int b) {
        int c1 = Integer.bitCount(a);
        int c2 = Integer.bitCount(b);
        if(c1 >= c2){
            return c1 * c2;
        }else{
            return c2 / c1;
        }
    }
}