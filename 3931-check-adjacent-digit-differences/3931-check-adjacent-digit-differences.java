class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i = 0 ; i < s.length() - 1 ; i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            int first = ch1 - '0';
            int second = ch2 - '0';
            if(Math.abs(second - first) > 2){
                return false;
            }
        }
        return true;
    }
}