class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        helper(0 , nums , curr , ans , freq);
        return ans;
    }
    private void helper(int ind , int[] nums ,List<Integer> curr, List<List<Integer>> ans, boolean[] freq ){
        if(ind == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(!freq[i]){
                curr.add(nums[i]);
                freq[i] = true;
                helper(ind + 1 , nums , curr , ans , freq);
                curr.remove(curr.size() - 1);
                freq[i] = false;
            }
        }
    }
}