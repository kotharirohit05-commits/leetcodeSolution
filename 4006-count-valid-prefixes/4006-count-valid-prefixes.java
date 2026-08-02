class Solution {
    public int countValidPrefixes(String s) {
        int c1 = 0;
        int c0 = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){

            

            if(s.charAt(i) == '1'){
                c1++;
            }else{
                c0++;
            }
            if(Math.abs(c1-c0) == 1 || Math.abs(c1 - c0) == 0){
                count++;
            }
        }
        return count;
    }
}