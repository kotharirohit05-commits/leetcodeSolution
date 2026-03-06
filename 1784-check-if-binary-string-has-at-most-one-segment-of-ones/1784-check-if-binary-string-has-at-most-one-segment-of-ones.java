class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        int n = s.length();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                count++;
            }
            else{
                if(count >=1 && s.charAt(i) == '1'){
                    return false;
                }
            }
        }
        return true;
    }
}