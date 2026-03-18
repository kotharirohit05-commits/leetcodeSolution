class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        int count  = 0;
        int distinct = set.size();

        for(int i = 0 ; i < nums.length ; i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j = i ; j < nums.length ; j++){
                map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);

                if(map.size() == distinct){
                    count += nums.length - j;
                    break;
                }
            }
        }
        return count;
    }
}