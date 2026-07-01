class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ps = 0;
        int count =0;
        map.put(0,1);

        for(int n : nums){
            ps += n;
            int diff = ps - k;
            if(map.containsKey(diff)){
            count += map.get(diff);
            }
            map.put(ps, map.getOrDefault(ps,0) + 1);

        }
        return count;
    }
}