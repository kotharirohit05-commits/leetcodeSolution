class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            HashMap<Character , Integer> map = new HashMap<>();
            for(int j = i ; j < s.length() ; j++){
                char ch = s.charAt(j);
                map.put(ch , map.getOrDefault(ch , 0) + 1);
                int zeros = map.getOrDefault('0' , 0);
                int ones = map.getOrDefault('1' , 0);
                if(zeros > k && ones > k){
                    break;
                }else{
                    count += 1;
                }
            }
        }
        return count;
    }
}