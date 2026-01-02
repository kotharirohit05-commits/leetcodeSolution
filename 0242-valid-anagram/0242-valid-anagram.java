class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch : s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch , 0) + 1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char ch : t.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch , 0) + 1);
        }
        boolean flag = true;
        for(char key : map1.keySet()){
            if(!map2.containsKey(key)){
                flag = false;
                break;
            }
            if(!map1.get(key).equals(map2.get(key))){
                flag = false;
                break;
            }
        }
        return flag;
        
    }
}