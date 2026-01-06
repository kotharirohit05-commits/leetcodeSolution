class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String , Integer> map1 = new HashMap<>();
        HashMap<String , Integer> map2 = new HashMap<>();
        for(String word : words1){
            map1.put(word , map1.getOrDefault(word , 0 ) + 1 );
        }
        for(String wds : words2){
            map2.put(wds , map2.getOrDefault(wds , 0 ) + 1 );
        }
        int count = 0;
        for(String k : map1.keySet()){
            if((map1.get(k) == 1 ) && map2.containsKey(k) && map2.get(k) == 1) count += 1;
        }
        return count;
    }
}