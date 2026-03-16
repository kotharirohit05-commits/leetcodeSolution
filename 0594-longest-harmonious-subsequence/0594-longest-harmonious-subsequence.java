class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1); 
        }
        for(int k : map.keySet()){
            if(map.containsKey(k + 1)){
                int freq = map.get(k) + map.get(k+1);
                max = Math.max(max , freq);
            }
        }
        return max;
    }
}