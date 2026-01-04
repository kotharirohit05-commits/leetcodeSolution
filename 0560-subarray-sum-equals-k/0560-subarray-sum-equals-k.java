class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int result = 0;
        int prefixsum = 0;
        for(int n : nums){
            prefixsum += n;
            if(map.containsKey(prefixsum - k)){
                result += map.get(prefixsum - k);
            }
            map.put(prefixsum , map.getOrDefault(prefixsum , 0) + 1);
        }
    return result;
    }
}