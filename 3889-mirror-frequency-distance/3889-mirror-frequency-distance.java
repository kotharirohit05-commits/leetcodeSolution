class Solution {
    public int mirrorFrequency(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashSet<Character> visited = new HashSet<>();

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(visited.contains(c) ) continue;
            char mirror;
            if(c >= 'a' && c <= 'z'){
                mirror = ((char) ('a' + 'z' - c));
            }
            else{
                mirror = ((char) ('0' + '9' - c));
            }
            ans += Math.abs(map.getOrDefault(c,0) - map.getOrDefault(mirror , 0));

            visited.add(c);
            visited.add(mirror);
        }
        return ans;

    }
}

// for(int i = 0 ; i < s.length() ; i++){
//             char c = s.charAt(i);
//             if(c >= 'a' && c <= 'z'){
//                 sb.append((char) 'a' + 'z' - c);
//             }
//             if(c >= '0' && c <= '9'){
//                 sb.append((char) '0' + '9' - c );
//             }
//         }