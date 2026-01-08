class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxv = 0;
        int maxc = 0;
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            char ch = (char) (i + 'a');
            if(isvowel(ch)){
                maxv = Math.max(freq[i] , maxv);
            }else{
                maxc = Math.max(freq[i] , maxc);
            }
        }
        return maxc+maxv;
    }
    private boolean isvowel(char c){
        return c =='a' || c == 'e' || c == 'i' || c=='o' || c == 'u';
    }
}