class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        for(int i = 0 ;  i < s.length() ; i++){
            n = n ^ (1 << i);
            
        }
        return n ;
    }
}