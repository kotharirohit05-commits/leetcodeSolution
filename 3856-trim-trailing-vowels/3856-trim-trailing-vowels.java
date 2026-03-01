class Solution {
    public String trimTrailingVowels(String s) {
        
        int count = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'  ||s.charAt(i) == 'o' ||s.charAt(i) == 'u'  ){
                count++;
                
            }else{
                break;
            }
        }
        return s.substring(0 , s.length() -count);
    } 
}