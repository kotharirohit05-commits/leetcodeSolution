class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , nums , ans , current);
        return ans;
    }
    private void helper(int ind , int[] nums ,List<List<Integer>> ans , List<Integer> current ){
        ans.add(new ArrayList<>(current));
        for(int i = ind ; i < nums.length ; i++){
            if(i > ind && nums[i] == nums[i-1])continue;
            current.add(nums[i]);
            helper(i + 1 , nums , ans , current);
            current.remove(current.size() - 1);
        }
    }
}