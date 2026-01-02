class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int n : nums){
            map1.put(n , map1.getOrDefault(n , 0 ) + 1);
            if(map1.get(n) > 1){
                return n;
            }
        }
        return -1;
    }
}