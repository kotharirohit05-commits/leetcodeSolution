class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0 , nums , ans );
        return ans;
    }
    private void helper(int ind , int[] nums , List<List<Integer>> ans ){
        if(ind == nums.length){
            List<Integer>current = new ArrayList<>();
            for(int i = 0  ; i < nums.length ; i++){
                current.add(nums[i]);
            }
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = ind ; i < nums.length ; i++){
            swap(i , ind , nums);
            helper(ind + 1 , nums , ans);
            swap(i , ind , nums);
        }
    }
    private void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}