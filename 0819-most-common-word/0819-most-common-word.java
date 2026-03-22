class Solution {
    public String mostCommonWord(String s, String[] banned) {
        s = s.toLowerCase();
           
            String[] words = s.split("[^a-zA-Z]+");
            HashMap<String,Integer> map = new HashMap<>();
            for(String word : words){
                if(word.length() == 0) continue;
                map.put(word,map.getOrDefault(word,0) + 1);
            }
            Set<String> banset = new HashSet<>();
            for(String p : banned){
                banset.add(p.toLowerCase());
            }
            String ans = "";
            int max = 0;
            for(String k : map.keySet()){
                if(!banset.contains(k) && map.get(k) > max){
                    max = map.get(k);
                    ans = k;
                }
            }
            return ans;

    }
}