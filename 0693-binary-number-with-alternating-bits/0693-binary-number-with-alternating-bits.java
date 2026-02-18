class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        boolean flag = true;
        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(i-1)){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}