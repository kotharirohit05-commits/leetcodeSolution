class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        String ans = "";

        for(int i = 0 ; i < n ; i++){
            String word = "";
            while(i < n && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
            if(!word.equals("")){
                ans = word +" "+ ans;
            }
        }
        return ans.trim();
    }
}