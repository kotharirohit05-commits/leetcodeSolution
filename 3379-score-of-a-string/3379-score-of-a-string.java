class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        char[] c = s.toCharArray();
        
        for(int i  = 0 ; i < s.length()-1; i++){
            sum += Math.abs(c[i] - c[i+1]);
        }
        return sum;
        
    }
}