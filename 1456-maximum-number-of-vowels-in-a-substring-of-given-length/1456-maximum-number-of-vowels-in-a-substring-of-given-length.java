class Solution {
    private boolean isvowel(char ch){
        return(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(isvowel(s.charAt(i))){
                count++;
            }
        }
        int left = 0 ; 
        int right = k;
        int max = count;
       
        for(int j = k  ; j < s.length() ; j++){
            if(isvowel(s.charAt(j))){
                count++;
            }
            if(isvowel(s.charAt(left))){
                count--;
            }
               left++;
        
            max = Math.max(max , count);
            if(max == k) return max;

        }
        return max;
    }
}