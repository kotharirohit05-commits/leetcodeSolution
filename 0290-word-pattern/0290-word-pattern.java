class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            String w = words[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(w))return false;
            }else{
            map1.put(ch,w);
            }
            if(map2.containsKey(w)){
                if(!map2.get(w).equals(ch)) return false;
            }else{
            map2.put(w,ch);
            }
        }
        return true;

    }
}