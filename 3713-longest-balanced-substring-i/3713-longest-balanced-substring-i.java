class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            HashMap<Character , Integer> map = new HashMap<>();
            for(int j = i ; j < s.length() ; j++){
                map.put(s.charAt(j) , map.getOrDefault(s.charAt(j) , 0) + 1);
            
            if(isBalanced(map)){
                max = Math.max(max , j-i+1);
            }
            }
        }
        return max;
    }
    private boolean isBalanced(HashMap<Character , Integer> map){
        int freq = -1;
        for(int count : map.values()){
            if(freq == -1){
                freq = count;
            }else if(freq != count){
                return false;
            }
        }
            return true;

    }
}