class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        HashSet<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        int count = 0;
        int ans = 0;

        for(int i = 0 ;  i < words.length ; i++){
            String s = words[i];
            boolean isValid = true;
            for(char c : s.toCharArray()){
                if(!set.contains(c)){
                    isValid = false;
                    break;
                }
                
            }
            if(isValid) count++;
        }
        return count;

    }
}