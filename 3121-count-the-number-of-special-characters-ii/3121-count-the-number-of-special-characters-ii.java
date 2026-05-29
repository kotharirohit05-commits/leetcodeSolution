class Solution {
    public int numberOfSpecialChars(String word) {
        int[] big = new int[26];
        int[] small = new int[26];
        int count = 0;

        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if( ch >= 'A' && ch <= 'Z'){
                big[ch - 'A'] = i+ 1; 
                }
            else{
                if(big[ch - 'a'] > 0){
                    small[ch - 'a'] = -1;
                }else if( small[ch - 'a'] != -1){
                    small[ch - 'a'] = 1;
                }
            } 
        }
        
        for(int i = 0 ; i < 26 ; i++){
            
            if(small[i] == 1 && big[i] > 0){
                count++;
            }
        }
        
        return count;
    }
}