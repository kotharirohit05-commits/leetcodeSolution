class Solution {
    public boolean canConstruct(String rn, String mg) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch : rn.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch , 0 ) + 1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char ch : mg.toCharArray()){
            map2.put(ch , map2.getOrDefault(ch , 0 ) + 1);
        }
        boolean flag = true;
        for(char key : map1.keySet()){
            if(!map2.containsKey(key)){
                flag = false;
                break;
            }
            if(map2.get(key) < (map1.get(key))){
                flag = false;
                break;
            }
        }
        return flag;
    }
}