class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] res = new String[words.length];
        for(String i : words){
            int n = i.length();
            int pos = i.charAt(n - 1) - '0';
            res[pos - 1] = i.substring(0 , n - 1);
        }
        return String.join(" ", res);

    }
}