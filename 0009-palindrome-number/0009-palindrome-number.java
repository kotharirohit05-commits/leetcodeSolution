class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;
        while(original > 0){
            int digit = original %10;
            reversed = (reversed * 10 )+digit;
            original /= 10;
        }
        if(x == reversed) return true;

        return false;

    }
}