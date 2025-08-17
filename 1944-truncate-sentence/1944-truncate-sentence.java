class Solution {
    public String truncateSentence(String s, int k) {
        String[] part = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < k ;i++){
            result.append(part[i]);
            result.append(" ");
        }
        return result.toString().trim();
    }
}