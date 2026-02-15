class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        for(String word : words){
            if(word.length() >= k){
                String prefix = word.substring(0,k);
                map.put(prefix , map.getOrDefault(prefix , 0) + 1);
            }
        }
        int group = 0 ;
        for(String x : map.keySet()){
            int freq = map.get(x);
            if(freq >= 2){
                group++;
            }
        }
        return group;
    }
}