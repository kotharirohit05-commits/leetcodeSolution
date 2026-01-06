class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        
        int count = 0;
        for(char ch : s.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch , 0) + 1);
            count += 1;
        }
        ArrayList<Character> list = new ArrayList<>(map1.keySet());
        Collections.sort(list , (a,b) -> map1.get(b) - map1.get(a));

        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            int freq = map1.get(ch);
            for(int i = 0 ; i < freq ; i++){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}