class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        for(int i = 0 ; i < s.length() ; i++){
            num = num ^ ( 1 << i);
        }
        return num;
    }
}