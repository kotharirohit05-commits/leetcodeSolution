class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word , map.getOrDefault(word , 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list , (a,b) -> { 
            if(!map.get(a).equals(map.get(b))) return map.get(b) - map.get(a);
        else return a.compareTo(b);
        });

    for(String s : map.keySet()){
            int z = map.get(s);
            if(z == k){
                list.add(s);
            }
        }
        return list.subList(0,k);
    }
}