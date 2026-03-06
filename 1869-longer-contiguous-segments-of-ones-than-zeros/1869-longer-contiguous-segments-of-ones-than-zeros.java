class Solution {
    public boolean checkZeroOnes(String s) {
        int longOne = 0;
        int longZero = 0;
        int max1 = 0;
        int max0 = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                longOne += 1;
                longZero = 0;
                max1 = Math.max(longOne , max1);
            }
            else{
                longZero += 1;
                longOne = 0;
                max0 = Math.max(longZero , max0);
            }
        }
        return max1 > max0;
    }
}