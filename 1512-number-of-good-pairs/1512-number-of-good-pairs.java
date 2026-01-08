class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        int count = 0;
        for(int k : map.keySet()){
            int freq = map.get(k);
            count += freq * (freq-1) / 2;
        }
        return count;
    }
}