class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums , k ) - atmost(nums , k - 1);
    }
    private int atmost(int[] nums , int k){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int l = 0;

        for(int i = 0  ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            
            while(map.size() > k){
                map.put(nums[l] , map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;   
            }
            count += ( i - l + 1);
        }
        return count ;
    }
}