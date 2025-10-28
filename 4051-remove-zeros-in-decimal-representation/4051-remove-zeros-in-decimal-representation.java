class Solution {
    public long removeZeros(long n) {
        String s = Long.toString(n);
        StringBuilder b = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '0'){
                b.append(s.charAt(i));
            }
        }
        
        return Long.parseLong(b.toString());
    }
}