class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String , Integer> map = new HashMap<>();
        String[] parts1 = s1.split(" ");
        String[] parts2 = s2.split(" ");
        for(String words : parts1){
            map.put(words , map.getOrDefault(words , 0) + 1);
        }
        for(String words : parts2){
            map.put(words , map.getOrDefault(words , 0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                ans.add(key);
            }
        }

        
        return ans.toArray(new String[0]);
    }
}