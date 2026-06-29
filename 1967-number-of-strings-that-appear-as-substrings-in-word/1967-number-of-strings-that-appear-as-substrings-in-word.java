class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(int i = 0; i < patterns.length; i++){
            String s = patterns[i];
            int start = 0;
            if(word.contains(s.substring(start))){
                count++;
            }
        }
        return count;
    }
}