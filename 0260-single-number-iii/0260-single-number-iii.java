class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0 ;
        for(int i : nums){
            xor = xor ^ i ;
        }
        long n = (xor & xor - 1) ^ xor;
        int b1 = 0;
        int b2 = 0;
        for(int i : nums){
            if((i & n) != 0){
                b1 = b1 ^ i;
            }else{
                b2 = b2 ^ i;
            }
        }
        return new int[] {b1,b2};

    }
}