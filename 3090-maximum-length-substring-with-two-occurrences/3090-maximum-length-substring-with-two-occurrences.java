class Solution {
    public int maximumLengthSubstring(String s) {
        
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ml = 0;

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 2){
                char ch2 = s.charAt(l);
                map.put(ch2, map.get(ch2) - 1);
                l++;
            }


            ml = Math.max(ml, r - l + 1);
            
        }
        return ml;

    }
}