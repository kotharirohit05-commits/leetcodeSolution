class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> ans = new HashSet<>();
        for(int i = 0 ;i < nums.length ; i++){
            ans.add(nums[i]);
        }
        while(ans.contains(original)){
            original *= 2;
        }
        return original;
    }
}