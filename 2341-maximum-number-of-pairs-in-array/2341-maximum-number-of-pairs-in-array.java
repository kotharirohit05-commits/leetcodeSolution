class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        int pairs = 0;
        int leftover = 0;
        for(int i : map.keySet()){
            int freq = map.get(i);
             pairs += freq / 2;
             leftover += freq % 2; 
        }
        return new int[]{pairs,leftover};
    }
}