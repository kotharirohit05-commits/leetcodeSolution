class Solution {
    public int centeredSubarrays(int[] nums) {
        int count = 0;

        for(int i = 0 ; i < nums.length  ; i++){
            int sum = 0;
            HashMap<Integer,Integer> map= new HashMap<>();
            for(int j = i  ; j < nums.length ; j++){
                sum += nums[j];
                map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);
                if( map.containsKey(sum)){
                    count += 1;
                }
            }
        }
        return count;
    }
}