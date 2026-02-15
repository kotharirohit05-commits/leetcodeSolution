class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int x : nums){
            map1.put(x , map1.getOrDefault(x , 0) + 1);
        }
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int k : map1.values()){
            map2.put( k , map2.getOrDefault(k , 0) + 1);
        }
        for(int x : nums){
            int freq = map1.get(x);
            if(map2.get(freq) == 1){
                return x;
            }
        }
        
        return -1;
    }
}