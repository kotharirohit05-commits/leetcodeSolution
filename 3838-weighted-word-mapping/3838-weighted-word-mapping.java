class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < words.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < words[i].length() ; j++){
                int ch = (words[i].charAt(j)) - 97;
                sum += weights[ch];
            }
            int mod = sum % 26;
            int ph = 122 - mod;
            sb.append((char) ph);
            
        }
        return sb.toString();
    }
}