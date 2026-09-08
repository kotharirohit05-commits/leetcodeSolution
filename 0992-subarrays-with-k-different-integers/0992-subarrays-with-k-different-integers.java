class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        System.out.println(helper(nums, k));
        System.out.println(helper(nums, k - 1));
        return helper(nums, k) - helper(nums, k-1);
    }
    private int helper(int[] nums, int k){
        int count = 0;
        int l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < nums.length; r++){
            int x = nums[r];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0){
                    map.remove(nums[l]);
                    
                }
                l++;
                
            }
            count = count + (r - l + 1);
        }
        return count;
    }
}