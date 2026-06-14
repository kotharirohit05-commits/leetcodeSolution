class Solution {
    public boolean checkGoodInteger(int n) {
        int digSum =0;
        int sqSum = 0;
        while(n > 0){
            int dig = n % 10;
            digSum += dig;
            sqSum += dig * dig;
            n /= 10;
        }
        if(sqSum - digSum >= 50){
            return true;
        }
        return false;
    }
}