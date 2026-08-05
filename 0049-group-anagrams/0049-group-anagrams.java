class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String word = strs[i];
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String sorted = new String(w);
            if(map.containsKey(sorted)){
                map.get(sorted).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sorted, list);
            }
            

        }

        List<List<String>> ans = new ArrayList<>();
        for(List<String> i: map.values()){
            ans.add(i);
        }
        return ans;


    }
}